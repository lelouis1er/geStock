/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.approvisionnements.approvisionnement;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Livraison;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractApprovisionnementController extends SuperController{
    
    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Livraison) {
                modifier = sessionManager.user_can_update();
                supprimer = sessionManager.user_can_delete();
            } else {
                modifier = supprimer = false;
            }
        } catch (Exception e) {
            modifier = supprimer = details = false;
        }
    }

    @Override
    public void define_list_commandes() {
        try {
            list_commandes = commandeFacadeLocal.findAllBy_session(sessionManager.getCycleEntreprise());
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_livraisons() {
        try {
            list_livraisons = livraisonFacadeLocal.findAllBy_session(sessionManager.getCycleEntreprise());
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_Articles() {
        try {
            list_articles = articleFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
        } catch (Exception e) {
        }
    }
    
    
    
    
}
