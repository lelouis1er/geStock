/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.entreprise.sessions;

import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "sessionController")
@ViewScoped
public class SessionController extends AbstractSessionController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public SessionController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                societe = societeFacadeLocal.find(societe.getIdSociete());
                if (societe == null) {
                    societe = new Societe(0);
                    throw new Exception("Entreprise non valide");
                }
                session.setIdSociete(societe);
                session.setDateDebut(format.parse(date_debut));
                session.setDateFin(format.parse(date_fin));
                session.setIdSession(sessionFacadeLocal.nextId());

                sessionFacadeLocal.create(session);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une nouvelle session. -- Session: " + session.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                
            } else {
                if (mode.equals("Edit")) {
                    if (session.getIdSession() != null && session.getIdSession() != 0) {

                        societe = societeFacadeLocal.find(societe.getIdSociete());
                        if (societe == null) {
                            societe = new Societe(0);
                            throw new Exception("Entreprise non valide");
                        }
                        session.setIdSociete(societe);
                        session.setDateDebut(format.parse(date_debut));
                        session.setDateFin(format.parse(date_fin));
                        
                        sessionFacadeLocal.edit(session);

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour des informations de la session. -- Session: " + session.getNom(), sessionManager.getSessionUser());
                        Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                        PrimeFaces.current().executeScript("PF('CreateDialog').hide()");
                        
                    } else {
                        Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de menu à modifier");
                    }
                } else {
                    Utilitaires.addErrorMessage("Erreur : ", "Mode non pris en charge !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (session.getIdSession() != null && session.getIdSession() != 0) {

                sessionFacadeLocal.remove(session);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression de la Session. -- Session : " + session.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                session = new Session(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné l'employé à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
