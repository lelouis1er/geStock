/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface PrivilegesutilisateurFacadeLocal {

    void create(Privilegesutilisateur privilegesutilisateur);

    void edit(Privilegesutilisateur privilegesutilisateur);

    void remove(Privilegesutilisateur privilegesutilisateur);

    Privilegesutilisateur find(Object id);

    List<Privilegesutilisateur> findAll();

    List<Privilegesutilisateur> findRange(int[] range);

    int count();
    
    int nextId();
    
}
