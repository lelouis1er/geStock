/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByDescription", query = "SELECT u FROM Utilisateur u WHERE u.description = :description"),
    @NamedQuery(name = "Utilisateur.findByActif", query = "SELECT u FROM Utilisateur u WHERE u.actif = :actif"),
    @NamedQuery(name = "Utilisateur.findByDeleted", query = "SELECT u FROM Utilisateur u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "Utilisateur.findByPhoto", query = "SELECT u FROM Utilisateur u WHERE u.photo = :photo"),
    @NamedQuery(name = "Utilisateur.findByDatecreation", query = "SELECT u FROM Utilisateur u WHERE u.datecreation = :datecreation"),
    @NamedQuery(name = "Utilisateur.findByDatedelete", query = "SELECT u FROM Utilisateur u WHERE u.datedelete = :datedelete"),
    @NamedQuery(name = "Utilisateur.findByDatedesactivation", query = "SELECT u FROM Utilisateur u WHERE u.datedesactivation = :datedesactivation"),
    @NamedQuery(name = "Utilisateur.findByDateactivation", query = "SELECT u FROM Utilisateur u WHERE u.dateactivation = :dateactivation")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idutilisateur;
    @Size(max = 254)
    private String login;
    @Size(max = 254)
    private String password;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String description;
    private Boolean actif;
    private Boolean deleted;
    @Size(max = 254)
    private String photo;
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Temporal(TemporalType.DATE)
    private Date datedelete;
    @Temporal(TemporalType.DATE)
    private Date datedesactivation;
    @Temporal(TemporalType.DATE)
    private Date dateactivation;
    @JoinColumn(name = "id_employe", referencedColumnName = "id_employe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employes idEmploye;
    @JoinColumn(name = "idrole", referencedColumnName = "idrole")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roleutilisateur idrole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur", fetch = FetchType.LAZY)
    private List<Restrictionprivilege> restrictionprivilegeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur", fetch = FetchType.LAZY)
    private List<Mouchard> mouchardList;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatedelete() {
        return datedelete;
    }

    public void setDatedelete(Date datedelete) {
        this.datedelete = datedelete;
    }

    public Date getDatedesactivation() {
        return datedesactivation;
    }

    public void setDatedesactivation(Date datedesactivation) {
        this.datedesactivation = datedesactivation;
    }

    public Date getDateactivation() {
        return dateactivation;
    }

    public void setDateactivation(Date dateactivation) {
        this.dateactivation = dateactivation;
    }

    public Employes getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Employes idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Roleutilisateur getIdrole() {
        return idrole;
    }

    public void setIdrole(Roleutilisateur idrole) {
        this.idrole = idrole;
    }

    @XmlTransient
    public List<Restrictionprivilege> getRestrictionprivilegeList() {
        return restrictionprivilegeList;
    }

    public void setRestrictionprivilegeList(List<Restrictionprivilege> restrictionprivilegeList) {
        this.restrictionprivilegeList = restrictionprivilegeList;
    }

    @XmlTransient
    public List<Mouchard> getMouchardList() {
        return mouchardList;
    }

    public void setMouchardList(List<Mouchard> mouchardList) {
        this.mouchardList = mouchardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }
    
}
