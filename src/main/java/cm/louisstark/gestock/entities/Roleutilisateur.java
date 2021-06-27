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
    @NamedQuery(name = "Roleutilisateur.findAll", query = "SELECT r FROM Roleutilisateur r"),
    @NamedQuery(name = "Roleutilisateur.findByIdrole", query = "SELECT r FROM Roleutilisateur r WHERE r.idrole = :idrole"),
    @NamedQuery(name = "Roleutilisateur.findByNomrole", query = "SELECT r FROM Roleutilisateur r WHERE r.nomrole = :nomrole"),
    @NamedQuery(name = "Roleutilisateur.findByCoderole", query = "SELECT r FROM Roleutilisateur r WHERE r.coderole = :coderole")})
public class Roleutilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idrole;
    @Size(max = 254)
    private String nomrole;
    @Size(max = 254)
    private String coderole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrole", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrole", fetch = FetchType.LAZY)
    private List<Roleprivilege> roleprivilegeList;

    public Roleutilisateur() {
    }

    public Roleutilisateur(Integer idrole) {
        this.idrole = idrole;
    }

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
    }

    public String getNomrole() {
        return nomrole;
    }

    public void setNomrole(String nomrole) {
        this.nomrole = nomrole;
    }

    public String getCoderole() {
        return coderole;
    }

    public void setCoderole(String coderole) {
        this.coderole = coderole;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
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
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleutilisateur)) {
            return false;
        }
        Roleutilisateur other = (Roleutilisateur) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Roleutilisateur[ idrole=" + idrole + " ]";
    }
    
}
