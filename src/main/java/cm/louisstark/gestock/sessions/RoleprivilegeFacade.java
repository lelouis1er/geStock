/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
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
public class RoleprivilegeFacade extends AbstractFacade<Roleprivilege> implements RoleprivilegeFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleprivilegeFacade() {
        super(Roleprivilege.class);
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(r.idroleprivilege) FROM Roleprivilege r");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public List<Roleprivilege> findAll_by_RoleUtilisateur(Roleutilisateur r) {
        Query q = em.createQuery("SELECT r FROM Roleprivilege r WHERE r.idrole.idrole = :idrole");
        q.setParameter("idrole", r.getIdrole());
        return q.getResultList();
    }

    @Override
    public Roleprivilege findAll_by_roleutilisateur_privilegeutilisateur(Roleutilisateur r, Privilegesutilisateur p) {
        Query q = em.createQuery("SELECT r FROM Roleprivilege r WHERE r.idrole.idrole = :idrole AND r.idprivilege.idprivilege = :id_p");
        q.setParameter("idrole", r.getIdrole());
        q.setParameter("id_p", p.getIdprivilege());
        try {
            return (Roleprivilege) q.getResultList().get(0);
        } catch (Exception e) {
        }
        return null;
    }
}
