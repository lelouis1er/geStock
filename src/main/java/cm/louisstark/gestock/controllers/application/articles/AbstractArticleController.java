/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.articles;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.TypeArticle;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractArticleController extends SuperController {

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Article) {
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
    public void define_list_categoriesArticle() {
        try {
            list_categoriesArticles = categorieArticleFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_typeArticles() {
        try {
            list_typeArticles = typeArticleFacadeLocal.findAll();
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

    public void prepareCreate() {

        mode = "Create";
        try {
            typeArticle = new TypeArticle(0);
            article = new Article(0l);
            article.setPrixVente(0d);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (article != null) {

                if (article.getIdType() != null) {
                    typeArticle = article.getIdType();
                } else {
                    typeArticle = new TypeArticle(0);
                }

                PrimeFaces.current().executeScript("PF('CreateDialog').show()");
            }

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
