/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface RoleprivilegeFacadeLocal {

    void create(Roleprivilege roleprivilege);

    void edit(Roleprivilege roleprivilege);

    void remove(Roleprivilege roleprivilege);

    Roleprivilege find(Object id);
    
    Roleprivilege findAll_by_roleutilisateur_privilegeutilisateur(Roleutilisateur r, Privilegesutilisateur p);

    List<Roleprivilege> findAll();
    
    List<Roleprivilege> findAll_by_RoleUtilisateur(Roleutilisateur r);

    List<Roleprivilege> findRange(int[] range);

    int count();
    
    int nextId();
    
}
