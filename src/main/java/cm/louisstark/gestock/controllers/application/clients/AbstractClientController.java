/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.clients;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.TypeClient;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractClientController extends SuperController {

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Client) {
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
    public void define_list_clients() {
        try {
            if (sessionManager.is_employee()) {
                list_clients = clientFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
            }
        } catch (Exception e) {
        }
    }

    public void prepareCreate() {

        mode = "Create";
        try {
            client = new Client(0);
            adresse = new Adresse(0);
            typeClient = new TypeClient(0);

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }

    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (client != null) {
                adresse = new Adresse(0);
                typeClient = new TypeClient(0);
                
                if (client.getIdadresse() != null) {
                    adresse = client.getIdadresse();
                }
                
                if (client.getIdType() != null) {
                    typeClient = client.getIdType();
                }

                PrimeFaces.current().executeScript("PF('CreateDialog').show()");
            }

        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
