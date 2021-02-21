/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.entreprise.employes;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.RoleEmploye;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractEmployesController extends SuperController {

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Employes) {
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
    public void define_list_adresse() {
        try {
            list_adresses = adresseFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_societes() {
        try {
            list_societe = societeFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_roleEmployes() {
        
       try{
           list_employes = employesFacadeLocal.findAll();
           
       }catch(Exception e){
           
       }
    }

    @Override
    public void define_list_Employes() {
        try{
           list_employes = employesFacadeLocal.findAll();
           
       }catch(Exception e){
           
       } 
    }
    
    

    

    public void prepareCreate() {

        mode = "Create";
        try {
            employe = new Employes(0);
            adresse = new Adresse(0);
            societe = new Societe(0);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (employe.getIdadresse() != null) {
                adresse = employe.getIdadresse();
            } else {
                adresse = new Adresse(0);
            }
           
            if (employe.getIdRoleEmploye()!= null) {
                roleEmploye = employe.getIdRoleEmploye();
            } else {
                roleEmploye = new RoleEmploye(0);
            }
            
            

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
