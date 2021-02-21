/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);
    
    Utilisateur login(String login, String password);
    
    Utilisateur findByLoginPasswd(String login, String passwdHash);
    
    Utilisateur findByLogin(String login) throws Exception;

    List<Utilisateur> findAll();
    
    List<Utilisateur> findByActif(boolean b);
    
    List<Utilisateur> findAll_(boolean s);

    List<Utilisateur> findRange(int[] range);

    int count();
    
    int nextId();
    
}
