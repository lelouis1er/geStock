/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.OperationCaisse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Louis Stark
 */
@Stateless
public class OperationCaisseFacade extends AbstractFacade<OperationCaisse> implements OperationCaisseFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationCaisseFacade() {
        super(OperationCaisse.class);
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(o.idOperation) FROM OperationCaisse o");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1l;
    }

    @Override
    public OperationCaisse findBy_commandeClient(CommandeClient c) {
        Query q = em.createQuery("SELECT o FROM OperationCaisse o WHERE o.idOperation = :id_o");
        try {
            q.setParameter("id_o", c.getIdOperation().getIdOperation());
            return (OperationCaisse) q.getResultList().get(0);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public OperationCaisse findBy_livraison(Livraison lvrsn) {
        Query q = em.createQuery("SELECT o FROM OperationCaisse o WHERE o.idOperation = :id_o");
        try {
            q.setParameter("id_o", lvrsn.getIdOperation().getIdOperation());
            return (OperationCaisse) q.getResultList().get(0);
        } catch (Exception e) {
        }
        return null;
    }
    
}
