/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers;

import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "appController")
@SessionScoped
public final class AppController extends SuperController implements Serializable {

    protected Boolean dark_mode = false;

    public AppController() {
        //prepareChooseCycle();
    }

    ///////////////////////////////  GETTERS AND SETTERS  ///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean getDark_mode() {
        return dark_mode;
    }

    public void setDark_mode(Boolean dark_mode) {
        this.dark_mode = dark_mode;
    }

    @Override
    public void define_create_update_delete_details(Object o) {
    }

    @Override
    public void define_list_sessions() {
        try {
            if (!sessionManager.is_employee()) {
                list_sessions.clear();
                return;
            }
            list_sessions = sessionFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
        } catch (Exception e) {
        }
    }

    public void prepareChooseCycle() {
        try {
            if (!sessionManager.is_employee()) {
                throw new Exception("Compte non valide pour choisir un cycle");
            }
            session = new Session(0);
            PrimeFaces.current().executeScript("PF('ChooseCycle').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public boolean must_choose_session() {
        try {
            if (sessionManager.is_employee() && sessionManager.getCycleEntreprise() == null) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void change_cycle() {
        try {
            if (!sessionManager.is_employee()) {
                throw new Exception("Compte non valide pour choisir un cycle");
            }
            session = sessionFacadeLocal.find(session.getIdSession());
            if (session != null) {
                sessionManager.setCycleEntreprise(session);
                PrimeFaces.current().executeScript("PF('ChooseCycle').show()");
            } else {
                session = new Session(0);
                Utilitaires.addErrorMessage("Esseur : ", "Session Non existante !");
            }
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void logout() {
        System.out.println("Déconnexion de l'utilisateur....");
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.sendRedirect(request.getContextPath() + "/login.xhtml?logout");
        } catch (IOException e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }
}
