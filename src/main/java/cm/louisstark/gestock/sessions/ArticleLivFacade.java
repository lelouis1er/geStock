/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Societe;
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
public class ArticleLivFacade extends AbstractFacade<ArticleLiv> implements ArticleLivFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleLivFacade() {
        super(ArticleLiv.class);
    }

    @Override
    public List<ArticleLiv> findAllBy_societe_livraison(Societe sct, Livraison lvrsn) {
        Query q = em.createQuery("SELECT a FROM ArticleLiv a WHERE a.idOperation.idArticle.idSociete.idSociete = :id_s AND a.idLivraison.idLivraison = :id_l ORDER BY a.idOperation.idArticle.nom ASC");
        try {
            q.setParameter("id_s", sct.getIdSociete());
            q.setParameter("id_l", lvrsn.getIdLivraison());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(a.idArticleLiv) FROM ArticleLiv a");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }
    
}
