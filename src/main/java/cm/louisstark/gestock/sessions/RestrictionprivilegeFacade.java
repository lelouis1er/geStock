/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Restrictionprivilege;
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
public class RestrictionprivilegeFacade extends AbstractFacade<Restrictionprivilege> implements RestrictionprivilegeFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestrictionprivilegeFacade() {
        super(Restrictionprivilege.class);
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(r.idrestriction) FROM Restrictionprivilege r");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public List<Restrictionprivilege> findAll_by_Utilisateur(Utilisateur u) {
        Query q = em.createQuery("SELECT r FROM Restrictionprivilege r WHERE r.idutilisateur.idutilisateur = :id_user");
        q.setParameter("id_user", u.getIdutilisateur());
        return q.getResultList();
    }

    @Override
    public Restrictionprivilege findAll_by_utilisateur_privilegeutilisateur(Utilisateur u, Privilegesutilisateur p) {
        Query q = em.createQuery("SELECT r FROM Restrictionprivilege r WHERE r.idutilisateur.idutilisateur = :id_user AND r.idprivilege.idprivilege = :id_p");
        q.setParameter("id_user", u.getIdutilisateur());
        q.setParameter("id_p", p.getIdprivilege());
        try {
            return (Restrictionprivilege) q.getResultList().get(0);
        } catch (Exception e) {
        }
        return null;
    }
}
