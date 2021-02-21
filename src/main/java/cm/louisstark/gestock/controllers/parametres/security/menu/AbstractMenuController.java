/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.security.menu;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractMenuController extends SuperController {

    protected Menu selected_menu = new Menu(0);

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Menu) {
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
    public void define_list_menus() {
        try {
            list_menus = menuFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public void prepareCreate() {

        mode = "Create";
        try {
            menu = new Menu(0);
            selected_menu = new Menu(0);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (menu.getMenIdmenu() != null) {
                selected_menu = menu.getMenIdmenu();
            } else {
                selected_menu = new Menu(0);
            }

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public Menu getSelected_menu() {
        return selected_menu;
    }

    public void setSelected_menu(Menu selected_menu) {
        this.selected_menu = selected_menu;
    }

}
