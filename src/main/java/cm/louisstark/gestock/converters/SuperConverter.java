/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.converters;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.sessions.ArticleFacadeLocal;
import cm.louisstark.gestock.sessions.PrivilegesutilisateurFacadeLocal;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

/**
 *
 * @author Louis Stark
 */
@ManagedBean
@Named(value = "superConverter")
public class SuperConverter {
    
    @ManagedProperty (value = "#{manageBean}")
    protected SessionManagerImpl sessionManager;

    @EJB
    protected PrivilegesutilisateurFacadeLocal privilegesutilisateurFacadeLocal;
    protected List<Privilegesutilisateur> list_privilegesutilisateur = new ArrayList<>();
    
    @EJB
    protected ArticleFacadeLocal articleFacadeLocal;
    protected List<Article> list_articles = new ArrayList<>();

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PostConstruct
    private void init() {
        list_privilegesutilisateur = privilegesutilisateurFacadeLocal.findAll();
        list_articles = articleFacadeLocal.findAllBy_societe(sessionManager.get_user_enterprise());
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

    public Article find_article_InList(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Pas d'id fournie");
        }
        for (Article item : list_articles) {
            if (item.getIdArticle().equals(id)) {
                return item;
            }
        }
        return null;
    }

}
