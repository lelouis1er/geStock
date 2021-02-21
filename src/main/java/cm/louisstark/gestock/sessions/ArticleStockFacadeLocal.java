/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticleStock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ArticleStockFacadeLocal {

    void create(ArticleStock articleStock);

    void edit(ArticleStock articleStock);

    void remove(ArticleStock articleStock);

    ArticleStock find(Object id);

    List<ArticleStock> findAll();

    List<ArticleStock> findRange(int[] range);

    int count();
    
}
