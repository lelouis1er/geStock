/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Societe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface EmployesFacadeLocal {

    void create(Employes employes);

    void edit(Employes employes);

    void remove(Employes employes);

    Employes find(Object id);

    List<Employes> findAll();
    
    List<Employes> findAllBy_societe(Societe s);

    List<Employes> findRange(int[] range);

    int count();
    
    int nextId();
    
}
