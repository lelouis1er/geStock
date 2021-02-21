/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Magasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface MagasinFacadeLocal {

    void create(Magasin magasin);

    void edit(Magasin magasin);

    void remove(Magasin magasin);

    Magasin find(Object id);

    List<Magasin> findAll();

    List<Magasin> findRange(int[] range);

    int count();
    
}
