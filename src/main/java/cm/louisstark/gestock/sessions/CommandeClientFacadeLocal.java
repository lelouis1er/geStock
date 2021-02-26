/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Societe;
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
    
    List<CommandeClient> findAll(boolean value);
    
    List<CommandeClient> findAllBy_societe(Societe s, boolean value);
    
    List<CommandeClient> findAllBy_client(Client c, boolean value);

    List<CommandeClient> findRange(int[] range);

    int count();
    
    long nextId();
    
}
