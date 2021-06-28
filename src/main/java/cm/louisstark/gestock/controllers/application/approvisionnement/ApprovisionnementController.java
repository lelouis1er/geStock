/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.approvisionnement;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.OperationCaisse;
import cm.louisstark.gestock.entities.OperationStock;
import cm.louisstark.gestock.entities.TypeOperation;
import cm.louisstark.gestock.entities.TypeOperationStock;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "approvisionnementController")
@ViewScoped
public class ApprovisionnementController extends AbstractApprovisionnementController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public ApprovisionnementController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                if (livraison.getLibelle() == null || livraison.getLibelle().trim().isEmpty()) {
                    throw new Exception("Vous devez remplir le Libellé");
                }

                if (list_articlesLiv.isEmpty()) {
                    throw new Exception("Cette commande ne contient aucun article !!");
                }

                Date d = new Date();

                
                fournisseur = fournisseurFacadeLocal.find(fournisseur.getIdFournisseur());
                if (fournisseur != null) {
                    livraison.setIdFournisseur(fournisseur);
                }

                livraison.setDateEnregistrement(d);
                livraison.setLivree(false);
                livraison.setSupprime(false);
                livraison.setCoutTotal(calculTotalCommande());
                livraison.setIdSession(sessionManager.getCycleEntreprise());
                livraison.setIdLivraison(livraisonFacadeLocal.nextId());
                livraison.setNumeroRef(format_numCmd(livraison.getIdLivraison()));

                //ut.begin();

                livraisonFacadeLocal.create(livraison);

                for (ArticleLiv a : list_articlesLiv) {

                    a.setIdLivraison(livraison);
                    a.setIdArticleLiv(articleLivFacadeLocal.nextId());

                    articleLivFacadeLocal.create(a);
                    
                }

                //ut.commit();

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les approvisionnements [Statut: en Attente] . -- Approvisionnement: " + livraison.getLibelle(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");

            } else {
                if (livraison.getIdLivraison() != null && livraison.getIdLivraison() != 0) {

                    if (livraison.getLibelle() == null || livraison.getLibelle().trim().isEmpty()) {
                        throw new Exception("Vous devez remplir l'intitulé");
                    }

                    if (list_articlesLiv.isEmpty()) {
                        throw new Exception("Cette commande ne contient aucun article !!");
                    }

                    fournisseur = fournisseurFacadeLocal.find(fournisseur.getIdFournisseur());
                    if (fournisseur != null) {
                        livraison.setIdFournisseur(fournisseur);
                    }
                    livraison.setCoutTotal(calculTotalCommande());

                    int index;
                    for (ArticleLiv a : list_articlesLiv) {
                        index = exist_in_oldlist(a);
                        if (index == -1) {
                            a.setIdLivraison(livraison);
                            a.setIdArticleLiv(articleLivFacadeLocal.nextId());
                            articleLivFacadeLocal.create(a);
                        } else {
                            if (!Objects.equals(old_list.get(index).getQte(), a.getQte())) {
                                System.out.println("Article en cours : " + a.getIdArticle().getNom());
                                articleLivFacadeLocal.edit(a);
                            }
                            old_list.remove(index);
                        }
                    }

                    for (ArticleLiv a : old_list) {
                        articleLivFacadeLocal.remove(a);
                    }

                    livraisonFacadeLocal.edit(livraison);
                    
                    
                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les Approvisionnements [Statut: en Attente]. -- Commande: " + livraison.getLibelle(), sessionManager.getSessionUser());
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
            if (livraison != null && livraison.getIdLivraison() != null && livraison.getIdLivraison() != 0) {

                if (livraison.getLivree() != true) {
                    livraison.setSupprime(true);

                    livraisonFacadeLocal.edit(livraison);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les Approvisionnements. -- Commande: " + livraison.getLibelle(), sessionManager.getSessionUser());
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

    public void addArticles() {
        try {

            if (list_selected_articles.isEmpty()) {
                throw new Exception("Vous devez selectioner un article");
            }

            ArticleLiv al;
            list_articlesLiv.clear();
            
            if (!old_list.isEmpty()) {
                int index ;
                for (ArticleLiv a : old_list) {
                    index = exist_in_selected_list(a.getIdArticle());
                    if (index != -1) {
                        list_articlesLiv.add(a);
                        list_selected_articles.remove(index);
                    }
                }
            }

            for (Article a : list_selected_articles) {
                al = new ArticleLiv();
                al.setIdArticle(a);
                al.setPuAchat(a.getPrixAchat());
                al.setQte(1);
                
                list_articlesLiv.add(al);
            }

            PrimeFaces.current().executeScript("PF('AddArticleDialog').hide()");

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void remove_on(int index) {
        try {
            list_articlesLiv.remove(index);
            list_selected_articles.remove(index);
        } catch (Exception e) {
        }
    }

    public void livree() {
        try {
            if (livraison.getIdLivraison() != null && livraison.getIdLivraison() != 0 && livraison.getLibelle() != null && !"".equals(livraison.getLibelle().trim())) {

                TypeOperation t2 = typeOperationFacadeLocal.find(2);
                TypeOperationStock t1 = typeOperationStockFacadeLocal.find(1);
                Date d = new Date();

                operationCaisse = new OperationCaisse();
                operationCaisse.setDateOperation(d);
                operationCaisse.setIdEmploye(sessionManager.getEmployeUser());
                operationCaisse.setIdSession(sessionManager.getCycleEntreprise());
                operationCaisse.setIdType(t2);
                operationCaisse.setIntitule(t2.getNom() + " : " + livraison.getLibelle());
                operationCaisse.setMontant(calculTotalCommande());
                operationCaisse.setIdOperation(operationCaisseFacadeLocal.nextId());

                operationCaisseFacadeLocal.create(operationCaisse);


                livraison.setIdOperation(operationCaisse);
                livraison.setLivree(true);
                livraison.setDateLivraison(new Date());
                livraison.setHeureLivraison(d);

                for (ArticleLiv a : list_articlesLiv) {
                    operationStock = new OperationStock();
                    operationStock.setDateOperation(d);
                    operationStock.setEntree(true);
                    operationStock.setDescription("Entrée : " + a.getIdArticle().getNom());
                    operationStock.setIdArticle(a.getIdArticle());
                    operationStock.setIdSession(sessionManager.getCycleEntreprise());
                    operationStock.setQte(a.getQte());
                    operationStock.setIdType(t1);
                    operationStock.setIdOperation(operationStockFacadeLocal.nextId());

                    operationStockFacadeLocal.create(operationStock);

                    a.setIdOperation(operationStock);

                    articleLivFacadeLocal.edit(a);
                }

                livraisonFacadeLocal.edit(livraison);

                Utilitaires.saveActivity(mouchardFacadeLocal, "commandes de marchandise livrée. -- Approvisionnement : " + livraison.getLibelle(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Commande livrée !");

                commandeClient = new CommandeClient(0l);

            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de commande à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void print_facture() {
        try {

            if (commandeClient.getIdCommande() != null && commandeClient.getIdCommande() != 0) {
                System.out.println("printing liste absences....");

                /*
                jasper_path = src_path + "bon_commande_client.jasper";
                file_name = "Facture_" + commandeClient.getIdCommande();
                SUBREPORT_PATH = FacesContext.getCurrentInstance().getExternalContext().getRealPath(sub_path);

                param = new HashMap();
                param.put("id_commande", commandeClient.getIdCommande());
                param.put("SUBREPORT_DIR", SUBREPORT_PATH);

                System.out.println("param: " + param);

                printer.export_pdf(jasper_path, param, file_name);
                */
                Utilitaires.addSuccessMessage("Impression terminée !");
                System.out.println("printing finish....");

            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
