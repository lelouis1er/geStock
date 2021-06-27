/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.TypeOperationStock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PACO PC
 */
@Local
public interface TypeOperationStockFacadeLocal {

    void create(TypeOperationStock typeOperationStock);

    void edit(TypeOperationStock typeOperationStock);

    void remove(TypeOperationStock typeOperationStock);

    TypeOperationStock find(Object id);

    List<TypeOperationStock> findAll();

    List<TypeOperationStock> findRange(int[] range);

    int count();
    
}
