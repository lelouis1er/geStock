/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticleLiv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ArticleLivFacadeLocal {

    void create(ArticleLiv articleLiv);

    void edit(ArticleLiv articleLiv);

    void remove(ArticleLiv articleLiv);

    ArticleLiv find(Object id);

    List<ArticleLiv> findAll();

    List<ArticleLiv> findRange(int[] range);

    int count();
    
}