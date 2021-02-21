/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Utilisateur;
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
public class MouchardFacade extends AbstractFacade<Mouchard> implements MouchardFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MouchardFacade() {
        super(Mouchard.class);
    }

    @Override
    public List<Mouchard> findAllRange() {
        Query q = em.createQuery("SELECT m FROM Mouchard m ORDER BY m.dateoperation, m.heureoperation DESC");
        return q.getResultList();
    }

    @Override
    public List<Mouchard> findAll_by_user(Utilisateur u) {
        Query q = em.createQuery("SELECT m FROM Mouchard m WHERE m.idutilisateur.idutilisateur = :id_u ORDER BY m.dateoperation, m.heureoperation DESC");
        q.setParameter("id_u", u.getIdutilisateur());
        return q.getResultList();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(m.idmouchard) FROM Mouchard m");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1l;
    }

}
