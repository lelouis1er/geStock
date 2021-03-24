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
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractApprovisionnementController extends SuperController {

    protected List<Article> list_selectedArticles = new ArrayList<>();

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
        try {
            if (livraison.getIdLivraison() != null && livraison.getIdLivraison() != 0) {
                list_articlesLiv = articleLivFacadeLocal.findAllBy_societe_livraison(sessionManager.get_user_enterprise(), livraison);
            }
        } catch (Exception e) {
        }
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

            livraison = new Livraison();
            commande = new Commande(0);
            list_articlesLiv.clear();
            fournisseur = new Fournisseur();
            list_selectedArticles.clear();

            dualListModel.setSource(this.getList_articles());
            dualListModel.setTarget(list_selectedArticles);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");

        } catch (Exception e) {
        }
    }

    public void prepareEdit() {
        try {
            mode = "Edit";

            if (livraison != null) {
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

                dualListModel.setSource(this.getList_articles());

                PrimeFaces.current().executeScript("PF('ApprovisionnementDialog').show()");
            }

        } catch (Exception e) {
        }
    }

    public void prepareAddArticle() {
        try {
            charge_selected_acticles();
            dualListModel.setTarget(list_selectedArticles);

            PrimeFaces.current().executeScript("PF('AddArticleDialog').show()");

        } catch (Exception e) {
        }
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
