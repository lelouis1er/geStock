/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.CategorieArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface CategorieArticleFacadeLocal {

    void create(CategorieArticle categorieArticle);

    void edit(CategorieArticle categorieArticle);

    void remove(CategorieArticle categorieArticle);

    CategorieArticle find(Object id);

    List<CategorieArticle> findAll();

    List<CategorieArticle> findRange(int[] range);

    int count();
    
    int nextId();
}
