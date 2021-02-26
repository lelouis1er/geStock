/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.commandes_client;

import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.OperationCaisse;
import cm.louisstark.gestock.entities.OperationStock;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "commandeClientController")
@ViewScoped
public class CommandeClientController extends AbstractCommandeClientController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public CommandeClientController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                if (commandeClient.getIntitule() == null || commandeClient.getIntitule().trim().isEmpty()) {
                    throw new Exception("Vous devez remplir l'intitulé");
                }

                if (list_articlesCommandeClients.isEmpty()) {
                    throw new Exception("Cette commande ne contient aucun article !!");
                }

                client = clientFacadeLocal.find(client.getIdClient());
                if (client != null) {

                    commandeClient.setIdClient(client);
                    commandeClient.setDateCommande(new Date());
                    commandeClient.setSupprime(false);
                    commandeClient.setLivree(false);
                    commandeClient.setIdCommande(commandeClientFacadeLocal.nextId());
                    commandeClient.setNumCmd(format_numCmd(commandeClient.getIdCommande()));

                    ut.begin();

                    commandeClientFacadeLocal.create(commandeClient);

                    for (ArticlesCommandeClient a : list_articlesCommandeClients) {
                        a.setIdCommande(commandeClient);
                        a.setIdArticleCommandeclient(articlesCommandeClientFacadeLocal.nextId());

                        articlesCommandeClientFacadeLocal.create(a);
                    }

                    ut.commit();

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les commandes client. -- Commande: " + commandeClient.getIntitule(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                } else {
                    client = new Client(0);
                    throw new Exception("Vous devez choisir le client");
                }

            } else {
                if (commandeClient.getIdCommande() != null && commandeClient.getIdCommande() != 0) {

                    if (commandeClient.getIntitule() == null || commandeClient.getIntitule().trim().isEmpty()) {
                        throw new Exception("Vous devez remplir l'intitulé");
                    }

                    if (list_articlesCommandeClients.isEmpty()) {
                        throw new Exception("Cette commande ne contient aucun article !!");
                    }

                    client = clientFacadeLocal.find(client.getIdClient());
                    if (client != null) {

                        int index;
                        for (ArticlesCommandeClient a : list_articlesCommandeClients) {
                            index = exist_in_oldlist(a);
                            if (index == -1) {
                                a.setIdCommande(commandeClient);
                                a.setIdArticleCommandeclient(articlesCommandeClientFacadeLocal.nextId());
                                articlesCommandeClientFacadeLocal.create(a);
                            } else {
                                if (!Objects.equals(old_list.get(index).getQte(), a.getQte())) {
                                    articlesCommandeClientFacadeLocal.edit(a);
                                }
                                old_list.remove(index);
                            }
                        }

                        for (ArticlesCommandeClient a : old_list) {
                            articlesCommandeClientFacadeLocal.remove(a);
                        }

                    } else {
                        client = new Client(0);
                        throw new Exception("Vous devez choisir le client");
                    }

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les commandes client. -- Commande: " + commandeClient.getIntitule(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de commande à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (commandeClient.getIdCommande() != null && commandeClient.getIdCommande() != 0) {

                if (commandeClient.getLivree() != true) {
                    commandeClient.setSupprime(true);

                    commandeClientFacadeLocal.edit(commandeClient);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les commandes client. -- Commande: " + commandeClient.getIntitule(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Suppression éffectué !");

                    commandeClient = new CommandeClient(0l);
                } else {
                    Utilitaires.addErrorMessage("Erreur", "Impossible de supprimer car la commande est déjà livrée");
                }

            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de commande à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void addArticle() {
        try {

            if (article.getIdArticle() == null || article.getIdArticle() == 0l) {
                throw new Exception("Vous devez selectioner un article");
            }

            articlesCommandeClient.setIdArticle(article);
            articlesCommandeClient.setMontant(calculMontantArticle(article, articlesCommandeClient.getQte()));

            int index = exist_in_list(articlesCommandeClient);
            if (index == -1) {
                list_articlesCommandeClients.add(articlesCommandeClient);
            } else {
                list_articlesCommandeClients.get(index).setQte(list_articlesCommandeClients.get(index).getQte() + articlesCommandeClient.getQte());
                list_articlesCommandeClients.get(index).setMontant(calculMontantArticle(article, list_articlesCommandeClients.get(index).getQte()));
            }

            PrimeFaces.current().executeScript("PF('AddArticleDialog').hide()");

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void remove_on(int index) {
        try {
            list_articlesCommandeClients.remove(index);
        } catch (Exception e) {
        }
    }

    public void livree() {
        try {
            if (commandeClient.getIdCommande() != null && commandeClient.getIdCommande() != 0) {

                operationCaisse = new OperationCaisse();
                operationCaisse.setIdSession(sessionManager.getCycleEntreprise());
                operationCaisse.setIdOperation(operationCaisseFacadeLocal.nextId());
                operationCaisse.setIdEmploye(sessionManager.getEmployeUser());

                operationCaisseFacadeLocal.create(operationCaisse);

                commandeClient.setIdOperation(operationCaisse);
                commandeClient.setLivree(true);
                commandeClient.setDateLiv(new Date());

                for (ArticlesCommandeClient a : list_articlesCommandeClients) {
                    operationStock = new OperationStock();
                    operationStock.setIdArticle(a.getIdArticle());
                    operationStock.setEntree(false);
                    operationStock.setIdOperation(operationStockFacadeLocal.nextId());

                    operationStockFacadeLocal.create(operationStock);

                    a.setIdOperation(operationStock);

                    articlesCommandeClientFacadeLocal.edit(a);
                }

                commandeClientFacadeLocal.edit(commandeClient);

                Utilitaires.saveActivity(mouchardFacadeLocal, "commandes client livrée. -- Commande: " + commandeClient.getIntitule(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Commande livrée !");

                commandeClient = new CommandeClient(0l);

            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de commande à supprimer");
            }
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void print_facture() {
        try {

            if (commandeClient.getIdCommande() != null && commandeClient.getIdCommande() != 0) {
                System.out.println("printing liste absences....");

                jasper_path = src_path + "bon_commande_client.jasper";
                file_name = "Facture_" + commandeClient.getIdCommande();
                SUBREPORT_PATH = FacesContext.getCurrentInstance().getExternalContext().getRealPath(sub_path);
               
                param = new HashMap();
                param.put("id_commande", commandeClient.getIdCommande());
                param.put("SUBREPORT_DIR", SUBREPORT_PATH);

                System.out.println("param: " + param);

                printer.export_pdf(jasper_path, param, file_name);

                Utilitaires.addSuccessMessage("Impression terminée !");
                System.out.println("printing finish....");

            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
