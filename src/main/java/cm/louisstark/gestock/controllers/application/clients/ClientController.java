/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.application.clients;

import cm.louisstark.gestock.entities.TypeArticle;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "clientController")
@ViewScoped
public class ClientController extends AbstractClientController implements Serializable {

    /**
     * Creates a new instance of MenuController
     */
    public ClientController() {
    }

    public void save() {
        try {

            if (mode.equals("Create")) {

                typeClient = typeClientFacadeLocal.find(typeClient.getIdType());
                if (typeClient != null) {
                    client.setIdType(typeClient);
                }

                adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                if (adresse != null) {
                    client.setIdadresse(adresse);
                }

                client.setIdSociete(sessionManager.get_user_enterprise());
                client.setIdClient(clientFacadeLocal.nextId());
                
                clientFacadeLocal.create(client);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Enregistrement d'une entrée dans les clients. -- Client: " + client.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Enregistrement éffectué !");

                PrimeFaces.current().executeScript("PF('CreateDialog').hide()");

            } else {
                if (client.getIdClient() != null && client.getIdClient() != 0) {
                    typeClient = typeClientFacadeLocal.find(typeClient.getIdType());
                    if (typeClient != null) {
                        client.setIdType(typeClient);
                    }

                    adresse = adresseFacadeLocal.find(adresse.getIdadresse());
                    if (adresse != null) {
                        client.setIdadresse(adresse);
                    }

                    clientFacadeLocal.edit(client);
                    
                    Utilitaires.saveActivity(mouchardFacadeLocal, "Mise a jour d'une entrée dans les clients. -- Client: " + client.getNom(), sessionManager.getSessionUser());
                    Utilitaires.addSuccessMessage("Mise a jour éffectué !");

                    PrimeFaces.current().executeScript("PF('CreateDialog').hide()");

                } else {
                    Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de client à modifier");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            if (client.getIdClient() != null && client.getIdClient() != 0) {

                clientFacadeLocal.remove(client);

                Utilitaires.saveActivity(mouchardFacadeLocal, "Suppression d'une entrée dans les clients. -- Client: " + client.getNom(), sessionManager.getSessionUser());
                Utilitaires.addSuccessMessage("Suppression éffectué !");

                typeArticle = new TypeArticle(0);
            } else {
                Utilitaires.addErrorMessage("Erreur", "Vous n'avez pas sélectionné de client à supprimer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

}
