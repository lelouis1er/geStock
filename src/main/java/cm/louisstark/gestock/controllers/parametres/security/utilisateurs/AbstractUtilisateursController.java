/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers.parametres.security.utilisateurs;

import cm.louisstark.gestock.controllers.SuperController;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Louis Stark
 */
public abstract class AbstractUtilisateursController extends SuperController {

    protected List<Privilegesutilisateur> list_selectedPrivileges = new ArrayList<>();
    protected List<Restrictionprivilege> list_restrictionprivileges_for_delete = new ArrayList<>();

    protected DualListModel<Privilegesutilisateur> dual_list_priv = new DualListModel<>();

    @Override
    public void define_create_update_delete_details(Object o) {
        try {
            if (o != null && o instanceof Utilisateur) {
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
    public void define_list_roleutilisateur() {
        try {
            list_roleutilisateurs = roleutilisateurFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_utilisateurs() {
        try {
            list_utilisateurs = utilisateurFacadeLocal.findAll_(false);
        } catch (Exception e) {
        }
    }

    @Override
    public void define_list_Employes() {
        try {
            list_employes = employesFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public void prepareCreate() {

        mode = "Create";
        try {
            utilisateur = new Utilisateur();
            roleutilisateur = new Roleutilisateur(0);
            employe = new Employes(0);
            
            list_privilegesutilisateurs = privilegesutilisateurFacadeLocal.findAll();
            list_roleprivileges.clear();
            list_selectedPrivileges.clear();
            list_restrictionprivileges_for_delete.clear();

            PrimeFaces.current().executeScript("PF('CreateDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void prepareAddPrivilege() {
        try {
            list_selectedPrivileges.clear();
            int index;
            for (Roleprivilege r : list_roleprivileges) {
                index = position_of(r.getIdprivilege());
                list_selectedPrivileges.add(r.getIdprivilege());
                if (index != -1) {
                    list_privilegesutilisateurs.remove(index);
                }
            }
            for (Restrictionprivilege r : list_restrictionprivileges_for_delete) {
                list_privilegesutilisateurs.add(r.getIdprivilege());
            }
            list_restrictionprivileges_for_delete.clear();
            
            dual_list_priv.setTarget(list_selectedPrivileges);
            dual_list_priv.setSource(list_privilegesutilisateurs);

            PrimeFaces.current().executeScript("PF('ChoixPrivilegesDialog').show()");
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public void prepareEdit() {

        mode = "Edit";
        try {
            if (utilisateur != null && utilisateur.getIdutilisateur() != null && utilisateur.getIdutilisateur()!= 0) {
                
                if (utilisateur.getIdrole() != null) {
                    roleutilisateur = utilisateur.getIdrole();
                } else {
                    roleutilisateur = new Roleutilisateur(0);
                }
                
                if (utilisateur.getIdEmploye() != null) {
                    employe = utilisateur.getIdEmploye();
                } else {
                    employe = new Employes(0);
                }
                
                list_privilegesutilisateurs = privilegesutilisateurFacadeLocal.findAll();
                list_restrictionprivileges = restrictionprivilegeFacadeLocal.findAll_by_Utilisateur(utilisateur);
                list_restrictionprivileges_for_delete.clear();

                PrimeFaces.current().executeScript("PF('CreateDialog').show()");
            }
        } catch (Exception e) {
            Utilitaires.addErrorMessage(e, "Message : " + e.getMessage());
        }
    }

    public int has_selected(Privilegesutilisateur p) {
        for (int i = 0; i < list_selectedPrivileges.size(); i++) {
            if (list_selectedPrivileges.get(i).getIdprivilege().equals(p.getIdprivilege())) {
                return i;
            }
        }
        return -1;
    }
    
    public int position_of (Privilegesutilisateur p) {
        for (int i = 0; i < list_privilegesutilisateurs.size(); i++) {
            if (list_privilegesutilisateurs.get(i).getIdprivilege().equals(p.getIdprivilege())) {
                return i;
            }
        }
        return -1;
    }

    public Restrictionprivilege verifie_exist(Restrictionprivilege r) {
        try {
            return restrictionprivilegeFacadeLocal.findAll_by_utilisateur_privilegeutilisateur(r.getIdutilisateur(), r.getIdprivilege());
        } catch (Exception e) {
        }
        return null;
    }

    public List<Privilegesutilisateur> getList_selectedPrivileges() {
        return list_selectedPrivileges;
    }

    public void setList_selectedPrivileges(List<Privilegesutilisateur> list_selectedPrivileges) {
        this.list_selectedPrivileges = list_selectedPrivileges;
    }

    public DualListModel<Privilegesutilisateur> getDual_list_priv() {
        return dual_list_priv;
    }

    public void setDual_list_priv(DualListModel<Privilegesutilisateur> dual_list_priv) {
        this.dual_list_priv = dual_list_priv;
    }

}
