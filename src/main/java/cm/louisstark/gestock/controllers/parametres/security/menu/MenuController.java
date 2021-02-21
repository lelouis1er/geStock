/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.security.menu;

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
@ManagedBean(name = "menuController")
@ViewScoped
public class MenuController extends AbstractMenuController implements Serializable{

    /**
     * Creates a new instance of MenuController
     */
    public MenuController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
                selected_menu = menuFacadeLocal.find(selected_menu.getIdmenu());
                menu.setMenIdmenu(selected_menu);
                menu.setIdmenu(menuFacadeLocal.nextId());

                menuFacadeLocal.create(menu);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les menus. -- Menu: " + menu.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                if (selected_menu == null) {
                    selected_menu = new Menu(0);
                }

            } else {
                if (menu.getIdmenu() != null && menu.getIdmenu() != 0) {
                    selected_menu = menuFacadeLocal.find(selected_menu.getIdmenu());
                    menu.setMenIdmenu(selected_menu);

                    menuFacadeLocal.edit(menu);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les menus. -- Menu: " + menu.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                    if (selected_menu == null) {
                        selected_menu = new Menu(0);
                    }

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de menu à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (menu.getIdmenu() != null && menu.getIdmenu() != 0) {
                
                menuFacadeLocal.remove(menu);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les menus. -- Menu: " + menu.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                menu = new Menu(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de menu à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
