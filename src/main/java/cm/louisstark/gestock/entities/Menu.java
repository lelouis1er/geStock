/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu"),
    @NamedQuery(name = "Menu.findByNom", query = "SELECT m FROM Menu m WHERE m.nom = :nom"),
    @NamedQuery(name = "Menu.findByRessource", query = "SELECT m FROM Menu m WHERE m.ressource = :ressource")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idmenu;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String ressource;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmenu", fetch = FetchType.LAZY)
    private List<Privilegesutilisateur> privilegesutilisateurList;
    @OneToMany(mappedBy = "menIdmenu", fetch = FetchType.LAZY)
    private List<Menu> menuList;
    @JoinColumn(name = "men_idmenu", referencedColumnName = "idmenu")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menIdmenu;

    public Menu() {
    }

    public Menu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRessource() {
        return ressource;
    }

    public void setRessource(String ressource) {
        this.ressource = ressource;
    }

    @XmlTransient
    public List<Privilegesutilisateur> getPrivilegesutilisateurList() {
        return privilegesutilisateurList;
    }

    public void setPrivilegesutilisateurList(List<Privilegesutilisateur> privilegesutilisateurList) {
        this.privilegesutilisateurList = privilegesutilisateurList;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenIdmenu() {
        return menIdmenu;
    }

    public void setMenIdmenu(Menu menIdmenu) {
        this.menIdmenu = menIdmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Menu[ idmenu=" + idmenu + " ]";
    }
    
}
