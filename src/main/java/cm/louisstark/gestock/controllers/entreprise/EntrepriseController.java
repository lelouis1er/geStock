/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.entreprise;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "entrepriseController")
@ViewScoped
public class EntrepriseController extends AbstractEntrepriseController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public EntrepriseController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {
                adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                societe.setIdadresse(adresse);

                societe.setIdSociete(societeFacadeLocal.nextId());
                societe.setDateEnregistrement(new Date());
                societe.setDateCreation(format.parse(date_creation));

                societeFacadeLocal.create(societe);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une Nouvelle Entreprise. -- Entreprise: " + societe.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                if (adresse == null) {
                    adresse = new Adresse(0);
                }

            } else {
                if (mode.equals("Edit")) {
                    if (societe.getIdSociete() != null && societe.getIdSociete() != 0) {
                        adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                        societe.setIdadresse(adresse);

                        societeFacadeLocal.edit(societe);

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour des informations de l'entreprise. -- Entreprise: " + societe.getNom(), sessionManager.getSessionUser());
                        Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                        PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                        if (adresse == null) {
                            adresse = new Adresse(0);
                        }

                    } else {
                        Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de menu à modifier");
                    }
                } else {
                    Utilitaires.addErrorMessage("Erreur : ", "mode non pris en charge !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (societe.getIdSociete() != null && societe.getIdSociete() != 0) {

                societeFacadeLocal.remove(societe);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression de l'entreprise. -- Entreprise : " + societe.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                societe = new Societe(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné l'entreprise à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
