/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Roleutilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface RoleutilisateurFacadeLocal {

    void create(Roleutilisateur roleutilisateur);

    void edit(Roleutilisateur roleutilisateur);

    void remove(Roleutilisateur roleutilisateur);

    Roleutilisateur find(Object id);

    List<Roleutilisateur> findAll();

    List<Roleutilisateur> findRange(int[] range);

    int count();
    
    int nextId();
    
}
