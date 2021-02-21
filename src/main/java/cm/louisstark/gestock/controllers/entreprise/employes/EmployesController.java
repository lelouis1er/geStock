/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.entreprise.employes;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.RoleEmploye;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.sessions.SocieteFacadeLocal;
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
@ManagedBean(name = "employesController")
@ViewScoped
public class EmployesController extends AbstractEmployesController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public EmployesController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
                adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                employe.setIdadresse(adresse);

                roleEmploye = roleEmployeFacadeLocal.find(roleEmploye.getIdRoleEmploye());
                employe.setIdRoleEmploye(roleEmploye);

                societe = societeFacadeLocal.find(societe.getIdSociete());
                if (societe == null) {
                    societe = new Societe(0);
                    throw new Exception("Entreprise non valide");
                }
                employe.setIdSociete(societe);
                employe.setDateEnregistrement(new Date());
                employe.setIdEmploye(employesFacadeLocal.nextId());
                employesFacadeLocal.create(employe);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'un nouvel employe. -- Employes: " + employe.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                if (adresse == null) {
                    adresse = new Adresse(0);
                }
                if (roleEmploye == null) {
                    roleEmploye = new RoleEmploye(0);
                }

            } else {
                if (societe.getIdSociete() != null && societe.getIdSociete() != 0) {
                    adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                    employe.setIdadresse(adresse);

                    roleEmploye = roleEmployeFacadeLocal.find(roleEmploye.getIdRoleEmploye());
                    employe.setIdRoleEmploye(roleEmploye);

                    societe = societeFacadeLocal.find(societe.getIdSociete());
                    if (societe == null) {
                        societe = new Societe(0);
                        throw new Exception("Entreprise non valide");
                    }
                    employe.setIdSociete(societe);
                    employesFacadeLocal.edit(employe);

                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour des informations de l'employe. -- Employes: " + employe.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                    if (adresse == null) {
                        adresse = new Adresse(0);
                    }
                    if (roleEmploye == null) {
                        roleEmploye = new RoleEmploye(0);
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
            if (employe.getIdEmploye()!= null && employe.getIdEmploye()!= 0) {

                employesFacadeLocal.remove(employe);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression de l'employe. -- Employe : " + employe.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                employe = new Employes(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné l'employé à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
