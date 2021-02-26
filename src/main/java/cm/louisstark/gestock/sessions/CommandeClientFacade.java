/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.CommandeClient;
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
public class CommandeClientFacade extends AbstractFacade<CommandeClient> implements CommandeClientFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeClientFacade() {
        super(CommandeClient.class);
    }

    @Override
    public List<CommandeClient> findAllBy_societe(Societe s, boolean v) {
        Query q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.idClient.idSociete.idSociete = :id_s AND c.supprime = :val");
        if (v == false) {
            q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.idClient.idSociete.idSociete = :id_s AND c.supprime = :val OR c.supprime IS NULL");
        }
        q.setParameter("id_s", s.getIdSociete());
        q.setParameter("val", v);
        return q.getResultList();
    }

    @Override
    public List<CommandeClient> findAllBy_client(Client c, boolean v) {
        Query q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.idClient.idClient = :id_c AND c.supprime = :val");
        if (v == false) {
            q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.idClient.idClient = :id_c AND c.supprime = :val OR c.supprime IS NULL");
        }
        q.setParameter("id_c", c.getIdClient());
        q.setParameter("val", v);
        return q.getResultList();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(c.idCommande) FROM CommandeClient c");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public List<CommandeClient> findAll(boolean bln) {
        Query q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.supprime = :val");
        if (bln == false) {
            q = em.createQuery("SELECT c FROM CommandeClient c WHERE c.supprime = :val OR c.supprime IS NULL ");
        }
        q.setParameter("val", bln);
        return q.getResultList();
    }
    
}
