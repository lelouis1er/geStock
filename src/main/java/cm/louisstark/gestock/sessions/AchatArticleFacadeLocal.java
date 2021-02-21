/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.AchatArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface AchatArticleFacadeLocal {

    void create(AchatArticle achatArticle);

    void edit(AchatArticle achatArticle);

    void remove(AchatArticle achatArticle);

    AchatArticle find(Object id);

    List<AchatArticle> findAll();

    List<AchatArticle> findRange(int[] range);

    int count();
    
}
