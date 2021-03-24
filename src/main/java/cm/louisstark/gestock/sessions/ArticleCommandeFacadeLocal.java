/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.Societe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ArticleCommandeFacadeLocal {

    void create(ArticleCommande articleCommade);

    void edit(ArticleCommande articleCommade);

    void remove(ArticleCommande articleCommade);

    ArticleCommande find(Object id);

    List<ArticleCommande> findAll();
    
    List<ArticleCommande> findAllBy_societe_commande(Societe s, Commande c);

    List<ArticleCommande> findRange(int[] range);

    int count();
    
    long nextId();
    
}
