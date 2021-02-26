/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.application.categories;

import cm.louisstark.gestock.entities.CategorieArticle;
import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "categorieArticleController")
@ViewScoped
public class CategorieArticleController extends AbstractCategorieArticleController implements Serializable{

    /**
     * Creates a new instance of MenuController
     */
    public CategorieArticleController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
               
                categorieArticle.setIdCategorie(categorieArticleFacadeLocal.nextId());
                categorieArticleFacadeLocal.create(categorieArticle);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les categories d'article. -- Categorie: " + categorieArticle.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                
            } else {
                if (categorieArticle.getIdCategorie()!= null && categorieArticle.getIdCategorie() != 0) {
                   
                    categorieArticleFacadeLocal.edit(categorieArticle);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les categories d'article. -- Categorie: " + categorieArticle.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de categorie à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (categorieArticle.getIdCategorie() != null && categorieArticle.getIdCategorie() != 0) {
                
                categorieArticleFacadeLocal.remove(categorieArticle);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les categories d'article. -- Categorie: " + categorieArticle.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                categorieArticle = new CategorieArticle(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de categorie à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
