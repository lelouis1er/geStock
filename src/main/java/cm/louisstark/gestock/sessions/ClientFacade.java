/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Client;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public List<Client> findAllBy_societe(Societe sct) {
        Query q = em.createQuery("SELECT c FROM Client c WHERE c.idSociete.idSociete = :id_s");
        q.setParameter("id_s", sct.getIdSociete());
        return q.getResultList();
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(c.idClient) FROM Client c");
        try {
            return (Integer) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1;
    }
    
    
}
