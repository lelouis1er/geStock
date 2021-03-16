/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Session;
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
public class LivraisonFacade extends AbstractFacade<Livraison> implements LivraisonFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonFacade() {
        super(Livraison.class);
    }

    @Override
    public List<Livraison> findAllBy_session(Session sn) {
        Query q = em.createQuery("SELECT l FROM Livraison l WHERE l.idOperation.idSession.idSession = :id_s");
        try {
            q.setParameter("id_s", sn.getIdSession());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(l.idLivraison) FROM Livraison l");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }
    
}
