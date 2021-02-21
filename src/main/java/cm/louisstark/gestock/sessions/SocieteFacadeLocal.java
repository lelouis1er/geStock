/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Societe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface SocieteFacadeLocal {

    void create(Societe societe);

    void edit(Societe societe);

    void remove(Societe societe);

    Societe find(Object id);

    List<Societe> findAll();

    List<Societe> findRange(int[] range);

    int count();
    
}
