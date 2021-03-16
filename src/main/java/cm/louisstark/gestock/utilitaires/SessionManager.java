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
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface SessionManager{

    FacesContext getContext();
    
    HttpServletRequest getRequest();
    
    HttpSession getSession();
    
    Utilisateur getSessionUser();
    
    Employes getEmployeUser();
    
    void setSessionUser(Utilisateur user);
    
    String getSessionLoginUser();
    
    void logout();
    
    Roleutilisateur getSessionRoleUser();
    
    List<Roleprivilege> getAllUserRolePrivileges();
    
    List<Restrictionprivilege> getAllUserRestrictions();
    
    boolean user_have_access();
    
    boolean user_can_create();
    
    boolean user_can_update();
    
    boolean user_can_delete();
    
    boolean is_employee ();
    
    Societe get_user_enterprise();
    
    Societe user_entreprise(Utilisateur u);
    
    String userEntrepriseName (Utilisateur u);
    
    Session getCycleEntreprise();
    
    void setCycleEntreprise(Session session);
    
    List<Mouchard> getUserLogedActivity();
    
    List<Mouchard> getUserActivity(Utilisateur u);
    
    List<Mouchard> getAllActivity() throws Exception;
    
    List<Menu> getAllmenu();
    
    boolean is_su ();
    
    int nbreSociete ();
    
    int nbreUtilisateurs();
    
}
