/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.StockArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface StockArticleFacadeLocal {

    void create(StockArticle stockArticle);

    void edit(StockArticle stockArticle);

    void remove(StockArticle stockArticle);

    StockArticle find(Object id);

    List<StockArticle> findAll();

    List<StockArticle> findRange(int[] range);

    int count();
    
}
