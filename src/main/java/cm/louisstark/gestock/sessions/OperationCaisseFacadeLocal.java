/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.OperationCaisse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface OperationCaisseFacadeLocal {

    void create(OperationCaisse operation);

    void edit(OperationCaisse operation);

    void remove(OperationCaisse operation);

    OperationCaisse find(Object id);
    
    OperationCaisse findBy_commandeClient(CommandeClient c);

    List<OperationCaisse> findAll();

    List<OperationCaisse> findRange(int[] range);

    int count();
    
    long nextId();
    
}
