/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ArticlesCommandeClientFacadeLocal {

    void create(ArticlesCommandeClient arcticlesCommandeClient);

    void edit(ArticlesCommandeClient arcticlesCommandeClient);

    void remove(ArticlesCommandeClient arcticlesCommandeClient);

    ArticlesCommandeClient find(Object id);

    List<ArticlesCommandeClient> findAll();

    List<ArticlesCommandeClient> findRange(int[] range);

    int count();
    
}
