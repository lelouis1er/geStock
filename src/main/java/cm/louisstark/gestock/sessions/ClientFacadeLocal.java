/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.Societe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();
    
    List<Client> findAllBy_societe(Societe s);

    List<Client> findRange(int[] range);

    int count();
    
    int nextId();
    
}
