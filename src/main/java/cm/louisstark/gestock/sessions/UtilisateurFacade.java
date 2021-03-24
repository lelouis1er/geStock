/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

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
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    @Override
    public Utilisateur findByLoginPasswd(String login, String passwdHash) {
        try {
            Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login AND u.password=:passwd");
            query.setParameter("login", login);
            query.setParameter("passwd", passwdHash);
            List list = query.getResultList();
            if (list.get(0) != null) {
                return (Utilisateur) list.get(0);
            }
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(u.idutilisateur) FROM Utilisateur u");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception ex) {
        }
        return 1;
    }

    @Override
    public List<Utilisateur> findByActif(boolean b) {
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.actif = :val");
        q.setParameter("val", b);
        return q.getResultList();
    }

    @Override
    public Utilisateur login(String login, String password) {
        Query query = em.createQuery("SELECT u FROM Utilisateur U WHERE u.login=:login AND u.password=:password");
        query.setParameter("login", login).setParameter("password", password);
        try {
            return (Utilisateur) query.getResultList().get(0);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Utilisateur findByLogin(String login) throws Exception{
        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login");
        try {
            query.setParameter("login", login);
            return (Utilisateur) query.getResultList().get(0);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Utilisateur> findAll_(boolean s) {
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.deleted = :val");
        q.setParameter("val", s);
        return q.getResultList();
    }

}
