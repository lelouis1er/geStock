/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.application.types;

import cm.louisstark.gestock.entities.TypeArticle;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "typeArticleController")
@ViewScoped
public class TypeArticleController extends AbstractTypeArticleController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public TypeArticleController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                categorieArticle = categorieArticleFacadeLocal.find(categorieArticle.getIdCategorie());
                if (categorieArticle != null) {
                    typeArticle.setIdCategorie(categorieArticle);
                    typeArticle.setIdType(typeArticleFacadeLocal.nextId());

                    typeArticleFacadeLocal.create(typeArticle);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les types d'article. -- Type: " + typeArticle.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                } else {
                    Utilitaires.addErrorMessage("Attention : ", "Vous devez sélectionner une catégorie");
                }

            } else {
                if (typeArticle.getIdType() != null && typeArticle.getIdType() != 0) {
                    categorieArticle = categorieArticleFacadeLocal.find(categorieArticle.getIdCategorie());
                    if (categorieArticle != null) {
                        typeArticle.setIdCategorie(categorieArticle);
                        
                        typeArticleFacadeLocal.edit(typeArticle);

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les types d'article. -- Type: " + typeArticle.getNom(), sessionManager.getSessionUser());
                        Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                        PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                    } else {
                        Utilitaires.addErrorMessage("Attention : ", "Vous devez sélectionner une catégorie");
                    }

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de type à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (typeArticle.getIdType() != null && typeArticle.getIdType() != 0) {

                typeArticleFacadeLocal.remove(typeArticle);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les types d'article. -- Type: " + typeArticle.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                typeArticle = new TypeArticle(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de categorie à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
