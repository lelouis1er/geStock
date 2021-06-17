/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.approvisionnements.approvisionnement;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ViewScoped
@ManagedBean(name = "approvisionnementController")
public class ApprovisionnementController extends AbstractApprovisionnementController implements Serializable {

    /**
     * Creates a new instance of ApprovisionnementController
     */
    public ApprovisionnementController() {
    }

    public void saveAddArticle() {
        try {
            list_selectedArticles = dualList_articles.getTarget();
            // on retire dab ce qui n'est pas sélectionné
            int index;
            for (ArticleLiv al : list_articlesLiv) {
                index = article_are_selected(al.getIdArticle());
                if (index == -1) {
                    list_articlesLiv.remove(index);
                }
            }

            // on ajoute les article selectionnés
            ArticleLiv al;
            for (Article a : list_selectedArticles) {
                if (exist_in_listArticle_liv(a) == -1) {
                    al = new ArticleLiv();
                    al.setIdArticle(a);
                    al.setQte(1);
                    al.setPuAchat(a.getPrixVente());

                    list_articlesLiv.add(al);
                }
            }
            System.out.println("liste: " + list_articlesLiv);
            Utilitaires.addSuccessMessage("Articles ajouté à la liste");
            PrimeFaces.current().executeScript("PF('AddArticleDialog').hide()");
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message: " + e.getMessage());
        }
        update_list();
    }

    public void removeArticleLiv(int index) {
        try {
            list_articlesLiv.remove(index);
        } catch (Exception e) {
        }
    }

    public double calculTotalLiv() {
        Double result = 0d;
        for (int i = 0; i <= list_articlesLiv.size(); i++) {
            result += calculTotal_on_ligne(i);
        }
        return result;
    }

    public double calculTotal_on_ligne(int index) {
        Double result = 0d;
        try {
            ArticleLiv a = list_articlesLiv.get(index);
            result = a.getPuAchat() * a.getQte();
        } catch (Exception e) {
        }
        return result;
    }

    public void save() {

    }

    public void delete() {

    }

}
