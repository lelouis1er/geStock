/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.approvisionnement;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.OperationCaisse;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractApprovisionnementController extends SuperController {

    List<ArticleLiv> old_list = new ArrayList<>();
    List<Article> list_selected_articles = new ArrayList<>();

    public List<Article> getList_selected_articles() {
        return list_selected_articles;
    }

    public void setList_selected_articles(List<Article> list_selected_articles) {
        this.list_selected_articles = list_selected_articles;
    }

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Livraison) {
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
    public void define_list_fournisseurs() {
        try {
            if (sessionManager.is_employee()) {
                list_fournisseurs = fournisseurFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
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
    public void define_list_livraisons() {
        try {
            if (sessionManager.is_employee()) {
                list_livraisons = livraisonFacadeLocal.findAllBy_session(sessionManager.getCycleEntreprise());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepareCreate() {

        mode = "Create";
        try {
            livraison = new Livraison(0);
            fournisseur = new Fournisseur(0);
            operationCaisse = new OperationCaisse(0l);

            list_articlesLiv.clear();
            list_selected_articles.clear();

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (livraison != null) {

                client = new Client(0);
                list_articlesLiv = articleLivFacadeLocal.findAllBy_societe_livraison(sessionManager.get_user_enterprise(), livraison);
                old_list = articleLivFacadeLocal.findAllBy_societe_livraison(sessionManager.get_user_enterprise(), livraison);
                list_selected_articles.clear();
                
                if (!list_articlesLiv.isEmpty()) {
                    for (ArticleLiv a : list_articlesLiv) {
                        list_selected_articles.add(a.getIdArticle());
                    }
                }

                operationCaisse = operationCaisseFacadeLocal.findBy_livraison(livraison);
                if (livraison.getIdFournisseur() != null) {
                    fournisseur = livraison.getIdFournisseur();
                } else {
                    fournisseur = new Fournisseur();
                }

                PrimeFaces.current().executeScript("PF('CreateDialog').show()");

            }

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void prepareAddArticle() {
        
        PrimeFaces.current().executeScript("PF('AddArticleDialog').show()");
    }

    public void prepareAddArticles() {
        if (livraison != null) {
            if (livraison.getIdLivraison() == null || livraison.getIdLivraison() == 0) {

                PrimeFaces.current().executeScript("PF('AddArticleDialog').show()");
            }
        }
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

            articleLiv.setPuAchat(calculMontantArticleLiv(articleLiv));

        } catch (Exception e) {
        }
    }

    public Double calculMontantCommande(Livraison l) {
        Double result = 0d;
        try {
            List<ArticleLiv> _temp = articleLivFacadeLocal.findAllBy_societe_livraison(sessionManager.get_user_enterprise(), l);
            for (ArticleLiv a : _temp) {
                result += a.getQte() * a.getIdArticle().getPrixVente();
            }
        } catch (Exception e) {
        }
        return result;
    }

    public Double calculTotalCommande() {
        Double result = 0d;
        try {
            for (ArticleLiv a : list_articlesLiv) {
                result += a.getQte() * a.getPuAchat();
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

    public Double calculMontantArticleLiv(ArticleLiv a) {
        try {
            return a.getPuAchat() * a.getQte();
        } catch (Exception e) {
        }
        return 0d;
    }

    public Double calculMontantArticle_(ArticleLiv a) {
        try {
            return a.getIdArticle().getPrixVente() * a.getQte();
        } catch (Exception e) {
        }
        return 0d;
    }

    public int exist_in_list(ArticleLiv a) {
        for (int i = 0; i < list_articlesLiv.size(); i++) {
            if (list_articlesLiv.get(i).getIdArticle().getIdArticle().equals(a.getIdArticle().getIdArticle())) {
                return i;
            }
        }
        return -1;
    }

    public int exist_in_selected_list(Article a) {
        for (int i = 0; i < list_selected_articles.size(); i++) {
            if (list_selected_articles.get(i).getIdArticle().equals(a.getIdArticle())) {
                return i;
            }
        }
        return -1;
    }

    public int exist_in_oldlist(ArticleLiv a) {
        for (int i = 0; i < old_list.size(); i++) {
            if (old_list.get(i).getIdArticle().getIdArticle().equals(a.getIdArticle().getIdArticle())) {
                return i;
            }
        }
        return -1;
    }

    public String format_numCmd(Integer i) {
        String result = i.toString();
        while (result.length() < 8) {
            result = "0" + result;
        }
        return result;
    }

}
