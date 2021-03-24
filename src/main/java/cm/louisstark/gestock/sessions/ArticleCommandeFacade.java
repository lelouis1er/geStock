/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.Commande;
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
public class ArticleCommandeFacade extends AbstractFacade<ArticleCommande> implements ArticleCommandeFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleCommandeFacade() {
        super(ArticleCommande.class);
    }

    @Override
    public List<ArticleCommande> findAllBy_societe_commande(Societe sct, Commande cmnd) {
        Query q = em.createQuery("SELECT a FROM ArticleCommande a WHERE a.idArticle.idSociete.idSociete = :id_s AND a.idCommande.idCommande = :id_c ORDER BY a.idArticle.nom");
        try {
            q.setParameter("id_s", sct.getIdSociete());
            q.setParameter("id_c", cmnd.getIdCommande());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(a.idArticleCommande) FROM ArticleCommande a");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }

}
