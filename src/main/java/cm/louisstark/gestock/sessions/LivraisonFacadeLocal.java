/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface LivraisonFacadeLocal {

    void create(Livraison livraison);

    void edit(Livraison livraison);

    void remove(Livraison livraison);

    Livraison find(Object id);

    List<Livraison> findAll();

    List<Livraison> findAllBy_session(Session s);

    List<Livraison> findRange(int[] range);

    int count();
    
    long nextId();
    
}
