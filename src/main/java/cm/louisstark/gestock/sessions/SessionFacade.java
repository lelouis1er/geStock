/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Session;
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
public class SessionFacade extends AbstractFacade<Session> implements SessionFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionFacade() {
        super(Session.class);
    }

    @Override
    public List<Session> findAllBy_societe(Societe sct) {
        Query q = em.createQuery("SELECT s FROM Session s WHERE s.idSociete.idSociete = :id_s ORDER BY s.dateDebut");
        q.setParameter("id_s", sct.getIdSociete());
        return q.getResultList();
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(s.idSession) FROM Session s");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }
    
}
