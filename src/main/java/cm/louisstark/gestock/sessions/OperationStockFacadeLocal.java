/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.OperationStock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface OperationStockFacadeLocal {

    void create(OperationStock operationStock);

    void edit(OperationStock operationStock);

    void remove(OperationStock operationStock);

    OperationStock find(Object id);

    List<OperationStock> findAll();

    List<OperationStock> findRange(int[] range);

    int count();
    
    long nextId();
    
}
