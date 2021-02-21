/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.TypeClient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface TypeClientFacadeLocal {

    void create(TypeClient typeClient);

    void edit(TypeClient typeClient);

    void remove(TypeClient typeClient);

    TypeClient find(Object id);

    List<TypeClient> findAll();

    List<TypeClient> findRange(int[] range);

    int count();
    
}
