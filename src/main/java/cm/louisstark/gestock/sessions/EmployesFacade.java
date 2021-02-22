/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.sessions;

import cm.louisstark.gestock.entities.Employes;
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
public class EmployesFacade extends AbstractFacade<Employes> implements EmployesFacadeLocal {

    @PersistenceContext(unitName = "cm.louisstark_geStock_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployesFacade() {
        super(Employes.class);
    }

    @Override
    public int nextId() {
        Query q = em.createQuery("SELECT MAX(e.idEmploye) FROM Employes e");
        try {
            return (Integer)q.getResultList().get(0) + 1;
        } catch (Exception e) {
        }
       return 1;
    }

    @Override
    public List<Employes> findAllBy_societe(Societe sct) {
        Query q = em.createQuery("SELECT e FROM Employes e WHERE e.idSociete.idSociete = :id_s ORDER BY e.dateEnregistrement");
        q.setParameter("id_s", sct.getIdSociete());
        return q.getResultList();
    }
    
}
