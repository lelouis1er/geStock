/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Commande;
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
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    @Override
    public List<Commande> findAllBy_session(Session sn) {
        Query q = em.createQuery("SELECT c FROM Commande c WHERE c.idOperation.idSession.idSession = :id_s ORDER BY c.dateEnregistrement DESC");
        try {
            q.setParameter("id_s", sn.getIdSession());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(c.idCommande) FROM Commande c");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public List<Commande> findAllBy_session_non_effectue(Session sn) {
        Query q = em.createQuery("SELECT c FROM Commande c WHERE c.idOperation.idSession.idSession = :id_s AND c. ORDER BY c.dateEnregistrement DESC");
        try {
            q.setParameter("id_s", sn.getIdSession());
            return q.getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
    
    
    
}
