/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.utilitaires;

import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.sessions.MenuFacadeLocal;
import cm.louisstark.gestock.sessions.MouchardFacadeLocal;
import cm.louisstark.gestock.sessions.RestrictionprivilegeFacadeLocal;
import cm.louisstark.gestock.sessions.RoleprivilegeFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "manageBean")
@SessionScoped
public class SessionManagerImpl implements SessionManager, Serializable {

    @EJB
    protected RoleprivilegeFacadeLocal roleprivilegeFacadeLocal;

    @EJB
    protected RestrictionprivilegeFacadeLocal restrictionprivilegeFacadeLocal;

    @EJB
    protected MouchardFacadeLocal mouchardFacadeLocal;

    @EJB
    protected MenuFacadeLocal menuFacadeLocal;

    @Override
    public FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    @Override
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) getContext().getExternalContext().getRequest();
    }

    @Override
    public HttpSession getSession() {
        return (HttpSession) getRequest().getSession();
    }

    @Override
    public Utilisateur getSessionUser() {
        return (Utilisateur) getSession().getAttribute("user");
    }

    @Override
    public void setSessionUser(Utilisateur user) {
        (getSession()).setAttribute("user", user);
    }

    @Override
    public Employes getEmployeUser() {
        Utilisateur user = getSessionUser();
        if (user.getIdEmploye() != null) {
            return user.getIdEmploye();
        }
        return null;
    }

    @Override
    public String getSessionLoginUser() {
        return getSessionUser().getLogin();
    }

    @Override
    public void logout() {
        getSession().setAttribute("user", null);
        getSession().setAttribute("cycle", null);
    }

    @Override
    public Roleutilisateur getSessionRoleUser() {
        return getSessionUser().getIdrole();
    }

    @Override
    public List<Roleprivilege> getAllUserRolePrivileges() {
        return roleprivilegeFacadeLocal.findAll_by_RoleUtilisateur(getSessionRoleUser());
    }

    @Override
    public List<Restrictionprivilege> getAllUserRestrictions() {
        return restrictionprivilegeFacadeLocal.findAll_by_Utilisateur(getSessionUser());
    }

    @Override
    public boolean user_have_access() {
        if (getSessionRoleUser().getCoderole().equals("su")) {
            return true;
        }
        try {
            HttpServletRequest request = getRequest();
            String uri = request.getRequestURI();
            //System.out.println("Uri : " + uri);
            for (Restrictionprivilege r : getAllUserRestrictions()) {
                if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                    return r.getRestrictup();
                }
            }
            for (Roleprivilege r : getAllUserRolePrivileges()) {
                if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean user_can_create() {
        if (getSessionRoleUser().getCoderole().equals("su")) {
            return true;
        }
        HttpServletRequest request = getRequest();
        String uri = request.getRequestURI();
        for (Restrictionprivilege r : getAllUserRestrictions()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getRestrictup()) {
                    if (r.getCancreate()) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        for (Roleprivilege r : getAllUserRolePrivileges()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getCancreate()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean user_can_update() {
        if (getSessionRoleUser().getCoderole().equals("su")) {
            return true;
        }
        HttpServletRequest request = getRequest();
        String uri = request.getRequestURI();
        for (Restrictionprivilege r : getAllUserRestrictions()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getRestrictup()) {
                    if (r.getCanupdate()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (Roleprivilege r : getAllUserRolePrivileges()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getCanupdate()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean user_can_delete() {
        if (getSessionRoleUser().getCoderole().equals("su")) {
            return true;
        }
        HttpServletRequest request = getRequest();
        String uri = request.getRequestURI();

        for (Restrictionprivilege r : getAllUserRestrictions()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getRestrictup()) {
                    if (r.getCandelete()) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        for (Roleprivilege r : getAllUserRolePrivileges()) {
            if (uri.equals(r.getIdprivilege().getIdmenu().getRessource())) {
                if (r.getCandelete()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Mouchard> getUserLogedActivity() {
        return mouchardFacadeLocal.findAll_by_user(getSessionUser());
    }

    @Override
    public List<Mouchard> getUserActivity(Utilisateur u) {
        return mouchardFacadeLocal.findAll_by_user(u);
    }

    @Override
    public List<Mouchard> getAllActivity() throws Exception {
        if ("su".equals(getSessionRoleUser().getCoderole().trim())) {
            return mouchardFacadeLocal.findAllRange();
        }
        throw new Exception("Vous n'avez pas d'autorisation pour effectuer cette operation !");
    }

    @Override
    public List<Menu> getAllmenu() {
        return menuFacadeLocal.findAll();
    }

    @Override
    public boolean is_employee() {
        return getSessionUser().getIdEmploye() != null;
    }

    @Override
    public Societe get_user_enterprise() {
        try {
            if (!is_employee()) {
                return null;
            }
            return getSessionUser().getIdEmploye().getIdSociete();
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
        return null;
    }

    @Override
    public Session getCycleEntreprise() {
        if (!is_employee()) {
            return null;
        }
        return (Session) getSession().getAttribute("cycle");
    }

    @Override
    public void setCycleEntreprise(Session session) {
        if (!is_employee()) {
            return;
        }
        getSession().setAttribute("cycle", session);
    }

}
