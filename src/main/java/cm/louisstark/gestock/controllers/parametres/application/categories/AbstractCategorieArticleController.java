/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.application.categories;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.CategorieArticle;
import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractCategorieArticleController extends SuperController {

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof CategorieArticle) {
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

    public void prepareCreate() {

        mode = "Create";
        try {
            categorieArticle = new CategorieArticle(0);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (categorieArticle != null) {
                PrimeFaces.current().executeScript("PF('CreateDialog').show()");
            }

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
