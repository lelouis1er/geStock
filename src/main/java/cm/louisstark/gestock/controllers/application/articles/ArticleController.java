/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.articles;

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
@ManagedBean(name = "articleController")
@ViewScoped
public class ArticleController extends AbstractArticleController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public ArticleController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
                if (!sessionManager.user_can_create()) {
                    throw new Exception("Vous n'avez pas le droit d'efectuer cette action");
                }

                typeArticle = typeArticleFacadeLocal.find(typeArticle.getIdType());
                if (typeArticle != null) {
                    article.setIdType(typeArticle);
                    article.setIdSociete(sessionManager.get_user_enterprise());
                    article.setIdArticle(articleFacadeLocal.nextId());

                    articleFacadeLocal.create(article);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les articles. -- Article: " + article.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                } else {
                    Utilitaires.addErrorMessage("Attention : ", "Vous devez sélectionner un type");
                }

            } else {
                if ("Edit".equals(mode)) {
                    if (!sessionManager.user_can_update()) {
                        throw new Exception("Vous n'avez pas le droit d'efectuer cette action");
                    }

                    if (article.getIdArticle() != null && article.getIdArticle() != 0) {
                        typeArticle = typeArticleFacadeLocal.find(typeArticle.getIdType());
                        if (typeArticle != null) {
                            article.setIdType(typeArticle);

                            articleFacadeLocal.edit(article);

                            Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les articles. -- Article: " + article.getNom(), sessionManager.getSessionUser());
                            Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                            PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                        } else {
                            Utilitaires.addErrorMessage("Attention : ", "Vous devez sélectionner un type");
                        }

                    } else {
                        Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de article à modifier");
                    }
                } else {
                    Utilitaires.addErrorMessage("Erreur", "Mode non reconnu !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (!sessionManager.user_can_delete()) {
                throw new Exception("Vous n'avez pas le droit d'efectuer cette action");
            }

            if (article.getIdArticle() != null && article.getIdArticle() != 0) {

                articleFacadeLocal.remove(article);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les articles. -- Article: " + article.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                typeArticle = new TypeArticle(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné d'article à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
