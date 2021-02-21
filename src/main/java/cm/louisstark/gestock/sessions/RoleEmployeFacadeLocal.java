/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.RoleEmploye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface RoleEmployeFacadeLocal {

    void create(RoleEmploye roleEmploye);

    void edit(RoleEmploye roleEmploye);

    void remove(RoleEmploye roleEmploye);

    RoleEmploye find(Object id);

    List<RoleEmploye> findAll();

    List<RoleEmploye> findRange(int[] range);

    int count();
    
}
