/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.CommandeClient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface CommandeClientFacadeLocal {

    void create(CommandeClient commandeClient);

    void edit(CommandeClient commandeClient);

    void remove(CommandeClient commandeClient);

    CommandeClient find(Object id);

    List<CommandeClient> findAll();

    List<CommandeClient> findRange(int[] range);

    int count();
    
}
