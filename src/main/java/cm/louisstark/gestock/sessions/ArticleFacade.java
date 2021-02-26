/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.Societe;
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
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }

    @Override
    public List<Article> findAllBy_societe(Societe sct) {
        Query q = em.createQuery("SELECT a FROM Article a WHERE a.idSociete.idSociete = :id_s ORDER BY a.nom");
        q.setParameter("id_s", sct.getIdSociete());
        return q.getResultList();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(a.idArticle) FROM Article a");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }
    
    
    
}
