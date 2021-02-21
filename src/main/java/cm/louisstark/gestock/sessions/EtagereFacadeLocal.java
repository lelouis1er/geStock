/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Etagere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface EtagereFacadeLocal {

    void create(Etagere etagere);

    void edit(Etagere etagere);

    void remove(Etagere etagere);

    Etagere find(Object id);

    List<Etagere> findAll();

    List<Etagere> findRange(int[] range);

    int count();
    
}
