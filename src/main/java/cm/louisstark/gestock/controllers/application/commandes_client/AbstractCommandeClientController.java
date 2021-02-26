/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.commandes_client;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.OperationCaisse;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractCommandeClientController extends SuperController {
    
    List<ArticlesCommandeClient> old_list = new ArrayList<>();

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof CommandeClient) {
                modifier = sessionManager.user_can_update();
                supprimer = sessionManager.user_can_delete();
            } else {
                modifier = supprimer = false;
            }
        } catch (Exception e) {
            modifier = supprimer = details = false;
        }
    }

    @Override
    public void define_list_clients() {
        try {
            if (sessionManager.is_employee()) {
                list_clients = clientFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_Articles() {
        try {
            if (sessionManager.is_employee()) {
                list_articles = articleFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_commandesClient() {
        try {
            if (sessionManager.is_employee()) {
                if (client.getIdClient() != null && client.getIdClient() != 0) {
                    list_commandeClients = commandeClientFacadeLocal.findAllBy_client(client, false);
                } else {
                    list_commandeClients = commandeClientFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise(), false);
                }
            }
        } catch (Exception e) {
        }
    }

    public void prepareCreate() {

        mode = "Create";
        try {
            commandeClient = new CommandeClient(0l);
            client = new Client(0);
            operationCaisse = new OperationCaisse(0l);
            list_articlesCommandeClients.clear();

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (commandeClient != null) {

                client = new Client(0);
                list_articlesCommandeClients = articlesCommandeClientFacadeLocal.findAllBy_commandeClient(commandeClient);
                old_list = articlesCommandeClientFacadeLocal.findAllBy_commandeClient(commandeClient);
                operationCaisse = operationCaisseFacadeLocal.findBy_commandeClient(commandeClient);

                if (commandeClient.getIdClient() != null) {
                    client = commandeClient.getIdClient();
                }

                PrimeFaces.current().executeScript("PF('CreateDialog').show()");

            }

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void prepareAddArticle() {
        article = new Article(0l);
        articlesCommandeClient = new ArticlesCommandeClient(0l);
        articlesCommandeClient.setQte(1);

        PrimeFaces.current().executeScript("PF('AddArticleDialog').show()");
    }

    public void updateData() {
        try {
            article = articleFacadeLocal.find(article.getIdArticle());
            if (article != null) {
                articlesCommandeClient.setMontant(calculMontantArticle(article, articlesCommandeClient.getQte()));
            } else {
                article = new Article(0l);
                articlesCommandeClient.setMontant(0d);
            }
            articlesCommandeClient.setIdArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData_() {
        try {

            articlesCommandeClient.setMontant(calculMontantArticle(articlesCommandeClient.getIdArticle(), articlesCommandeClient.getQte()));

        } catch (Exception e) {
        }
    }

    public Double calculMontantCommande(CommandeClient c) {
        Double result = 0d;
        try {
            List<ArticlesCommandeClient> _temp = articlesCommandeClientFacadeLocal.findAllBy_commandeClient(c);
            for (ArticlesCommandeClient a : _temp) {
                result += a.getQte() * a.getIdArticle().getPrixVente();
            }
        } catch (Exception e) {
        }
        return result;
    }

    public Double calculTotaltCommande() {
        Double result = 0d;
        try {
            for (ArticlesCommandeClient a : list_articlesCommandeClients) {
                result += a.getQte() * a.getIdArticle().getPrixVente();
            }
        } catch (Exception e) {
        }
        return result;
    }

    public Double calculMontantArticle(Article a, int qte) {
        try {
            return a.getPrixVente() * qte;
        } catch (Exception e) {
        }
        return 0d;
    }

    public Double calculMontantArticle_(ArticlesCommandeClient a) {
        try {
            return a.getIdArticle().getPrixVente() * a.getQte();
        } catch (Exception e) {
        }
        return 0d;
    }

    public int exist_in_list (ArticlesCommandeClient a) {
        for (int i = 0 ; i < list_articlesCommandeClients.size(); i++) {
            if (list_articlesCommandeClients.get(i).getIdArticle().getIdArticle().equals(a.getIdArticle().getIdArticle())) {
                return i;
            }
        }
        return -1;
    }
    
    public int exist_in_oldlist (ArticlesCommandeClient a) {
        for (int i = 0 ; i < old_list.size(); i++) {
            if (old_list.get(i).getIdArticle().getIdArticle().equals(a.getIdArticle().getIdArticle())) {
                return i;
            }
        }
        return -1;
    }
    
    public String format_numCmd(Long i) {
        String result = i.toString();
        while (result.length() < 8) {
            result = "0" + result;
        }
        return result;
    }
    
}
