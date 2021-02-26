/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.Societe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface SessionFacadeLocal {

    void create(Session session);

    void edit(Session session);

    void remove(Session session);

    Session find(Object id);

    List<Session> findAll();
    
    List<Session> findAllBy_societe(Societe s);

    List<Session> findRange(int[] range);

    int count();
    
    int nextId();
    
}
