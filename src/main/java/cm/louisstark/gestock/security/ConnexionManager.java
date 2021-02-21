/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.security;

import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.sessions.MouchardFacadeLocal;
import cm.louisstark.gestock.sessions.UtilisateurFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "connexionManager")
@SessionScoped
public class ConnexionManager implements Serializable {

    @EJB
    protected UtilisateurFacadeLocal utilisateurFacadeLocal;
    protected Utilisateur utilisateur = new Utilisateur();

    @EJB
    protected MouchardFacadeLocal mouchardFacadeLocal;
    
    @ManagedProperty(value = "#{manageBean}")
    protected SessionManagerImpl sessionManager;

    public ConnexionManager() {
    }

    public void login() throws IOException {
        System.out.println("======== Connexion =============================");
        try {
            if (utilisateur.getLogin() != null && utilisateur.getPassword() != null) {
                System.out.println("donnees du formulaire reçu");
                
                Utilisateur u = utilisateurFacadeLocal.findByLogin(utilisateur.getLogin());

                if (u != null) {

                    if (Security.compare(utilisateur.getPassword(), u.getPassword())) {
                        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                        HttpSession session = request.getSession();
                        sessionManager.setSessionUser(u);

                        utilisateur.setPassword("");
                        System.out.println("-- Session cree ");

                        Utilitaires.saveActivity(mouchardFacadeLocal, "Connexion de l'utilisateur " + u.getNom() + "(" + u.getLogin() + ")", sessionManager.getSessionUser());
                        String sc = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                        if (session.getAttribute("last-page") != null) {
                            response.sendRedirect((String) session.getAttribute("last-page"));
                        } else {
                            response.sendRedirect(sc + "/index.xhtml");
                        }
                    } else {
                        System.out.println("Nom d'utilisateur ou mot de passe incorrect !!!");
                        Utilitaires.addErrorMessage("ERREUR : ", "Mot de passe incorrect !!!");
                    }

                } else {
                    System.out.println("Nom d'utilisateur ou mot de passe incorrect !!!");
                    Utilitaires.addErrorMessage("ERREUR : ", "Nom d'utilisateur incorrect !!!");
                }

            } else {
                System.err.println("Aucune donnée reçu !!");
                Utilitaires.addErrorMessage("ERREUR", "Aucune donnée reçu !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void saisi() {
    }

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
