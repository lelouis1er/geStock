/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.OperationStock;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Louis Stark
 */
@Stateless
public class OperationStockFacade extends AbstractFacade<OperationStock> implements OperationStockFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationStockFacade() {
        super(OperationStock.class);
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(o.idOperation) FROM OperationStock o");
        try {
            return (Long) q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
        return 1l;
    }
    
}
