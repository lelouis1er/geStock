/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.security.utilisateurs;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.security.Security;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "utilisateursController")
@ViewScoped
public class UtilisateursController extends AbstractUtilisateursController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public UtilisateursController() {

    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                roleutilisateur = roleutilisateurFacadeLocal.find(roleutilisateur.getIdrole());
                if (roleutilisateur != null) {
                    ut.begin();

                    utilisateur.setIdrole(roleutilisateur);
                    utilisateur.setPassword(Security.crypte(utilisateur.getPassword()));
                    utilisateur.setDatecreation(new Date());
                    utilisateur.setActif(true);
                    utilisateur.setDeleted(false);
                    utilisateur.setIdutilisateur(utilisateurFacadeLocal.nextId());
                    utilisateurFacadeLocal.create(utilisateur);

                    save_add_privileges();

                    ut.commit();

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les utilisateur. -- Utilisateur : " + utilisateur.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                } else {
                    Utilitaires.addErrorMessage("Erreur : ", "Vous devez définir un rôle utilisateur");
                }

            } else {
                if (mode.equals("Edit")) {
                    if (roleutilisateur != null && roleutilisateur.getIdrole() != null && roleutilisateur.getIdrole() != 0) {
                        
                        utilisateur.setIdrole(roleutilisateur);
                        utilisateurFacadeLocal.edit(utilisateur);

                        save_edit_privileges();

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les utilisateurs. -- Utilisateur: " + utilisateur.getNom(), sessionManager.getSessionUser());
                        Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                        PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                    } else {
                        Utilitaires.addErrorMessage("Erreur", "Vous devez définir un rôle utilisateur");
                    }

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Mode non supporté !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void addPrivileges() {
        try {

            list_restrictionprivileges_for_delete.clear();
            list_selectedPrivileges = dual_list_priv.getTarget();
            int index;
            for (int i = 0; i < list_restrictionprivileges.size(); i++) {
                index = has_selected(list_restrictionprivileges.get(i).getIdprivilege());
                if (index == -1) { // n'existe pas dans la liste des privileges sélectionné on le met en attent de suppression
                    list_restrictionprivileges_for_delete.add(list_restrictionprivileges.get(i));
                    list_restrictionprivileges.remove(i);
                } else {
                    list_selectedPrivileges.remove(i);
                }
            }
            Restrictionprivilege rp;
            for (Privilegesutilisateur p : list_selectedPrivileges) {
                rp = new Restrictionprivilege();
                rp.setIdprivilege(p);
                rp.setRestrictup(false);
                rp.setCancreate(false);
                rp.setCandelete(false);
                rp.setCanupdate(false);

                list_restrictionprivileges.add(rp);
            }

            PrimeFaces.current().executeScript("PF('ChoixPrivilegesDialog').hide()");

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void save_add_privileges() throws Exception {
        try {
            if (utilisateur != null && utilisateur.getIdutilisateur() != null && utilisateur.getIdutilisateur() != 0) {

                for (Restrictionprivilege r : list_restrictionprivileges) {
                    r.setIdutilisateur(utilisateur);
                    r.setIdrestriction(restrictionprivilegeFacadeLocal.nextId());

                    restrictionprivilegeFacadeLocal.create(r);
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void save_edit_privileges() throws Exception {
        try {
            if (utilisateur != null && utilisateur.getIdutilisateur() != null && utilisateur.getIdutilisateur() != 0) {
                Restrictionprivilege temp;
                for (Restrictionprivilege r : list_restrictionprivileges) {
                    temp = verifie_exist(r);
                    if (temp != null) {
                        if (r.getIdrestriction() != null) {
                            restrictionprivilegeFacadeLocal.edit(r);
                        }
                    } else {
                        r.setIdutilisateur(utilisateur);
                        r.setIdrestriction(restrictionprivilegeFacadeLocal.nextId());
                        restrictionprivilegeFacadeLocal.create(r);
                    }
                }
                for (Restrictionprivilege r : list_restrictionprivileges_for_delete) {
                    if (r.getIdrestriction() != null) {
                        restrictionprivilegeFacadeLocal.remove(r);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete() {
        try {
            if (utilisateur.getIdutilisateur() != null && utilisateur.getIdutilisateur() != 0) {
                
                utilisateur.setDeleted(true);
                utilisateurFacadeLocal.edit(utilisateur);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les utilisateur. -- Utilisateur: " + utilisateur.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                utilisateur = new Utilisateur(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné l'utilisateur à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
