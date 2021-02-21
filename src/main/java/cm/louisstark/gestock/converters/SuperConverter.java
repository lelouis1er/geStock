/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.converters;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.sessions.PrivilegesutilisateurFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Louis Stark
 */
@ManagedBean
@Named(value = "superConverter")
public class SuperConverter {

    @EJB
    protected PrivilegesutilisateurFacadeLocal privilegesutilisateurFacadeLocal;
    protected List<Privilegesutilisateur> list_privilegesutilisateur = new ArrayList<>();

    @PostConstruct
    private void init() {
        list_privilegesutilisateur = privilegesutilisateurFacadeLocal.findAll();
    }

    public SuperConverter() {
    }

    public Privilegesutilisateur find_privilegeInList(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Pas d'id fournie");
        }
        for (Privilegesutilisateur item : list_privilegesutilisateur) {
            if (item.getIdprivilege().equals(id)) {
                return item;
            }
        }
        return null;
    }

}
