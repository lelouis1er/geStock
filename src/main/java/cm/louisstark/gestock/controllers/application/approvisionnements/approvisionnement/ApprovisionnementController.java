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

/**
 *
 * @author Louis Stark
 */
@ViewScoped
@ManagedBean(name = "approvisionnementController")
public class ApprovisionnementController extends AbstractApprovisionnementController implements Serializable{

    /**
     * Creates a new instance of ApprovisionnementController
     */
    public ApprovisionnementController() {
    }
    
    public void saveAddArticle () {
        try {
            list_selectedArticles = dualListModel.getTarget();
            // on retire dab ce qui n'est pas sélectionné
            int index = 0;
            for (ArticleLiv al : list_articlesLiv){
                article_are_selected(al.getIdArticle());
                if (index == -1) {
                    list_articlesLiv.remove(index);
                }
            }
            
            // on ajoute les article selectionnés
            ArticleLiv al;
            for (Article a : list_selectedArticles) {
                if (exist_in_listArticle_liv(a) != -1) {
                    al = new ArticleLiv();
                    al.setIdArticle(a);
                    al.setQte(1);
                    al.setPuAchat(0d);
                    
                    list_articlesLiv.add(al);
                }
            }
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message: " + e.getMessage());
        }
    }
    
    public void removeArticleLiv (int index) {
        list_articlesLiv.remove(index);
    }
    
    public double calculTotalLiv() {
        Double result = 0d;
        
        return result;
    }
    
    public void save () {
        
    }
    
    public void delete () {
        
    }
    
}
