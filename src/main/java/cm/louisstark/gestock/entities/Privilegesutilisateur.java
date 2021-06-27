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
    @NamedQuery(name = "Privilegesutilisateur.findAll", query = "SELECT p FROM Privilegesutilisateur p"),
    @NamedQuery(name = "Privilegesutilisateur.findByIdprivilege", query = "SELECT p FROM Privilegesutilisateur p WHERE p.idprivilege = :idprivilege"),
    @NamedQuery(name = "Privilegesutilisateur.findByNom", query = "SELECT p FROM Privilegesutilisateur p WHERE p.nom = :nom"),
    @NamedQuery(name = "Privilegesutilisateur.findByDescription", query = "SELECT p FROM Privilegesutilisateur p WHERE p.description = :description"),
    @NamedQuery(name = "Privilegesutilisateur.findByNiveau", query = "SELECT p FROM Privilegesutilisateur p WHERE p.niveau = :niveau")})
public class Privilegesutilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idprivilege;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String description;
    private Integer niveau;
    @JoinColumn(name = "idmenu", referencedColumnName = "idmenu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu idmenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprivilege", fetch = FetchType.LAZY)
    private List<Restrictionprivilege> restrictionprivilegeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprivilege", fetch = FetchType.LAZY)
    private List<Roleprivilege> roleprivilegeList;

    public Privilegesutilisateur() {
    }

    public Privilegesutilisateur(Integer idprivilege) {
        this.idprivilege = idprivilege;
    }

    public Integer getIdprivilege() {
        return idprivilege;
    }

    public void setIdprivilege(Integer idprivilege) {
        this.idprivilege = idprivilege;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Menu getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Menu idmenu) {
        this.idmenu = idmenu;
    }

    @XmlTransient
    public List<Restrictionprivilege> getRestrictionprivilegeList() {
        return restrictionprivilegeList;
    }

    public void setRestrictionprivilegeList(List<Restrictionprivilege> restrictionprivilegeList) {
        this.restrictionprivilegeList = restrictionprivilegeList;
    }

    @XmlTransient
    public List<Roleprivilege> getRoleprivilegeList() {
        return roleprivilegeList;
    }

    public void setRoleprivilegeList(List<Roleprivilege> roleprivilegeList) {
        this.roleprivilegeList = roleprivilegeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprivilege != null ? idprivilege.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegesutilisateur)) {
            return false;
        }
        Privilegesutilisateur other = (Privilegesutilisateur) object;
        if ((this.idprivilege == null && other.idprivilege != null) || (this.idprivilege != null && !this.idprivilege.equals(other.idprivilege))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Privilegesutilisateur[ idprivilege=" + idprivilege + " ]";
    }
    
}
