/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.approvisionnements.approvisionnement;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractApprovisionnementController extends SuperController {

    protected List<Article> list_selectedArticles = new ArrayList<>();

    public List<Article> getList_selectedArticles() {
        return list_selectedArticles;
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
    public void define_list_commandes() {
        try {
            list_commandes = commandeFacadeLocal.findAllBy_session(sessionManager.getCycleEntreprise());
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_livraisons() {
        try {
            list_livraisons = livraisonFacadeLocal.findAllBy_session(sessionManager.getCycleEntreprise());
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_Articles() {
        try {
            list_articles = articleFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_ArticlesLiv() {
        
    }

    @Override
    public void define_list_fournisseurs() {
        try {
            list_fournisseurs = fournisseurFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
        } catch (Exception e) {
        }
    }

    public void prepareApprovisionnement() {
        try {
            mode = "Approvisionner";

            dualList_articles = new DualListModel<>();
            livraison = new Livraison();
            commande = new Commande(0);
            list_articlesLiv.clear();
            fournisseur = new Fournisseur();
            list_selectedArticles.clear();

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, e.getMessage());
        }
    }

    public void prepareEdit() {
        try {
            mode = "Edit";

            if (livraison != null) {
                dualList_articles = new DualListModel<>();
                list_articlesLiv = articleLivFacadeLocal.findAllBy_societe_livraison(societe, livraison);
                if (livraison.getIdCommande() != null) {
                    commande = livraison.getIdCommande();
                    list_articlescommande = articleCommandeFacadeLocal.findAllBy_societe_commande(sessionManager.get_user_enterprise(), commande);
                    charge_list_article_with_cmd();
                } else {
                    commande = new Commande(0);
                    list_articlescommande.clear();
                }

                if (livraison.getIdFournisseur() != null) {
                    fournisseur = livraison.getIdFournisseur();
                }

                PrimeFaces.current().executeScript("PF('ApprovisionnementDialog').show()");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, e.getMessage());
        }
    }

    public void prepareAddArticle() {
        try {
            charge_selected_acticles();

            int index;
            for (Article a : getList_articles()) {
                index = exist_in_listArticle_liv(a);
                if (index != -1) {
                    list_articles.remove(a);
                }
            }

            dualList_articles.setSource(list_articles);
            dualList_articles.setTarget(list_selectedArticles);

            PrimeFaces.current().executeScript("PF('AddArticleDialog').show()");

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message: " + e.getMessage());
        }
    }

    public void update_list() {
        System.out.println("list article liv" + list_articlesLiv);
    }

    public void charge_list_article_with_cmd() {
        try {
            list_articlesLiv.clear();
            if (!list_articlescommande.isEmpty()) {
                ArticleLiv al;
                for (ArticleCommande a : list_articlescommande) {
                    al = new ArticleLiv();
                    al.setIdArticle(a.getIdArticle());
                    al.setQte(a.getQte());

                    list_articlesLiv.add(al);
                }
            }
        } catch (Exception e) {
        }
    }

    public void charge_selected_acticles() {
        try {
            list_selectedArticles.clear();
            if (!list_articlesLiv.isEmpty()) {
                for (ArticleLiv a : list_articlesLiv) {
                    list_selectedArticles.add(a.getIdArticle());
                }
            }
        } catch (Exception e) {
        }
    }

    public int exist_in_listArticle_liv(Article a) {
        int index = -1;
        for (int i = 0; i < list_articlesLiv.size(); i++) {
            if (list_articlesLiv.get(i).getIdArticle().getIdArticle().equals(a.getIdArticle())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int article_are_selected(Article a) {
        int index = -1;
        for (int i = 0; i < list_selectedArticles.size(); i++) {
            if (list_selectedArticles.get(i).getIdArticle().equals(a.getIdArticle())) {
                index = i;
                break;
            }
        }
        return index;
    }

}
