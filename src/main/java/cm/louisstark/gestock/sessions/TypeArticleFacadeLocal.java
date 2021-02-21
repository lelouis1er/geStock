/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.TypeArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface TypeArticleFacadeLocal {

    void create(TypeArticle typeArticle);

    void edit(TypeArticle typeArticle);

    void remove(TypeArticle typeArticle);

    TypeArticle find(Object id);

    List<TypeArticle> findAll();

    List<TypeArticle> findRange(int[] range);

    int count();
    
}
