/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.entreprise.sessions;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.text.SimpleDateFormat;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractSessionController extends SuperController {
    protected String date_debut = "", date_fin = "";
    protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Session) {
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
    public void define_list_societes() {
        try {
            list_societe = societeFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_sessions() {
        try {
            if (societe != null && societe.getIdSociete() != null && societe.getIdSociete() != 0) {
                list_sessions = sessionFacadeLocal.findAllBy_societe(societe);
            } else {
                list_sessions = sessionFacadeLocal.findAll();
            }
        } catch (Exception e) {
        }
    }


    public void prepareCreate() {
        mode = "Create";
        try {
            session = new Session(0);
            societe = new Societe(0);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            
            if (session.getIdSociete() != null) {
                societe = session.getIdSociete();
            } else {
                societe = new Societe(0);
            }
            
            date_debut = format.format(session.getDateDebut());
            date_fin = format.format(session.getDateFin());

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

}
