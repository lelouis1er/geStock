/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.utilitaires;

import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.sessions.MouchardFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public class Utilitaires {

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if ((msg != null) && (msg.length() > 0)) {
            addErrorMessage(ex.getMessage(), msg);
        } else {
            addErrorMessage(defaultMsg, "");
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message, "");
        }
    }

    public static void addErrorMessage(String msg, String details) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, details); 
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        PrimeFaces.current().ajax().update(":growl");
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        PrimeFaces.current().ajax().update(":growl");
    }

    public static void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        PrimeFaces.current().ajax().update(":growl");
    }

    public static void addFatalErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        PrimeFaces.current().ajax().update(":growl");
    }

    public static void saveActivity(MouchardFacadeLocal facade, String activite, Utilisateur user) {
        try {
            Mouchard activites = new Mouchard();
            activites.setDateOperation(new Date());
            activites.setHeureOperation(new Date());
            activites.setIdutilisateur(user);
            activites.setDescription(activite);
            activites.setIdMouchard(facade.nextId());
            
            facade.create(activites);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
