/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface RestrictionprivilegeFacadeLocal {

    void create(Restrictionprivilege restrictionprivilege);

    void edit(Restrictionprivilege restrictionprivilege);

    void remove(Restrictionprivilege restrictionprivilege);

    Restrictionprivilege find(Object id);
    
    Restrictionprivilege findAll_by_utilisateur_privilegeutilisateur(Utilisateur u, Privilegesutilisateur p);

    List<Restrictionprivilege> findAll();
    
    List<Restrictionprivilege> findAll_by_Utilisateur(Utilisateur u);

    List<Restrictionprivilege> findRange(int[] range);

    int count();
    
    int nextId();
    
}
