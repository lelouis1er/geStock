/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface MouchardFacadeLocal {

    void create(Mouchard mouchard);

    void edit(Mouchard mouchard);

    void remove(Mouchard mouchard);

    Mouchard find(Object id);

    List<Mouchard> findAll();
    
    List<Mouchard> findAllRange();
    
    List<Mouchard> findAll_by_user(Utilisateur u);

    List<Mouchard> findRange(int[] range);

    int count();
    
    long nextId();
    
}
