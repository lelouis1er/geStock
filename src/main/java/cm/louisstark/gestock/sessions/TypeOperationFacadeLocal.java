/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.TypeOperation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface TypeOperationFacadeLocal {

    void create(TypeOperation typeOperation);

    void edit(TypeOperation typeOperation);

    void remove(TypeOperation typeOperation);

    TypeOperation find(Object id);

    List<TypeOperation> findAll();

    List<TypeOperation> findRange(int[] range);

    int count();
    
}
