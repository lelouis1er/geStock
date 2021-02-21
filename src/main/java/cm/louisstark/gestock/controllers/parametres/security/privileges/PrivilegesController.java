/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.security.privileges;

import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "privilegesController")
@ViewScoped
public class PrivilegesController extends AbstractPrivilegesController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public PrivilegesController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
                menu = menuFacadeLocal.find(menu.getIdmenu());

                if (menu != null) {

                    privilegesutilisateur.setIdmenu(menu);
                    privilegesutilisateur.setIdprivilege(privilegesutilisateurFacadeLocal.nextId());

                    privilegesutilisateurFacadeLocal.create(privilegesutilisateur);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les Privileges utilisateur. -- Privilege : " + privilegesutilisateur.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                } else {
                    menu = new Menu(0);
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de menu à affecter au privileges");
                }

            } else {
                if (privilegesutilisateur.getIdprivilege() != null && privilegesutilisateur.getIdprivilege() != 0) {
                    menu = menuFacadeLocal.find(menu.getIdmenu());
                    if (menu != null) {

                        privilegesutilisateur.setIdmenu(menu);
                        
                        privilegesutilisateurFacadeLocal.edit(privilegesutilisateur);

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les Privileges utilisateur. -- Privilege: " + privilegesutilisateur.getNom(), sessionManager.getSessionUser());
                        Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                        PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                    } else {
                        Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné le menu ");
                    }

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné le privileges à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (privilegesutilisateur.getIdprivilege() != null && privilegesutilisateur.getIdprivilege() != 0) {

                privilegesutilisateurFacadeLocal.remove(privilegesutilisateur);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les Privileges utilisateur. -- Privilege: " + privilegesutilisateur.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                privilegesutilisateur = new Privilegesutilisateur(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné le privilège à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
