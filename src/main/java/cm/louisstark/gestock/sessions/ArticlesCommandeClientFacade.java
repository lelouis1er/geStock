/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.CommandeClient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Louis Stark
 */
@Stateless
public class ArticlesCommandeClientFacade extends AbstractFacade<ArticlesCommandeClient> implements ArticlesCommandeClientFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticlesCommandeClientFacade() {
        super(ArticlesCommandeClient.class);
    }

    @Override
    public List<ArticlesCommandeClient> findAllBy_commandeClient(CommandeClient c) {
        Query q = em.createQuery("SELECT a FROM ArticlesCommandeClient a WHERE a.idCommande.idCommande = :id_c");
        try {
            q.setParameter("id_c", c.getIdCommande());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(a.idArticleCommandeclient) FROM ArticlesCommandeClient a");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1l;
    }

}
