/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.RetourArticleLiv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface RetourArticleLivFacadeLocal {

    void create(RetourArticleLiv retourArticleLiv);

    void edit(RetourArticleLiv retourArticleLiv);

    void remove(RetourArticleLiv retourArticleLiv);

    RetourArticleLiv find(Object id);

    List<RetourArticleLiv> findAll();

    List<RetourArticleLiv> findRange(int[] range);

    int count();
    
}
