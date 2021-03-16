/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface CommandeFacadeLocal {

    void create(Commande commande);

    void edit(Commande commande);

    void remove(Commande commande);

    Commande find(Object id);

    List<Commande> findAll();
    
    List<Commande> findAllBy_session(Session s);
    
    List<Commande> findAllBy_session_non_effectue(Session s);

    List<Commande> findRange(int[] range);

    int count();
    
    int nextId();
    
}
