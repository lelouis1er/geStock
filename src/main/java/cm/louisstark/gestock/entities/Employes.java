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
import javax.persistence.Column;
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
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employes.findAll", query = "SELECT e FROM Employes e"),
    @NamedQuery(name = "Employes.findByIdEmploye", query = "SELECT e FROM Employes e WHERE e.idEmploye = :idEmploye"),
    @NamedQuery(name = "Employes.findByMatricule", query = "SELECT e FROM Employes e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Employes.findByNom", query = "SELECT e FROM Employes e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employes.findByPrenom", query = "SELECT e FROM Employes e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employes.findByTel", query = "SELECT e FROM Employes e WHERE e.tel = :tel"),
    @NamedQuery(name = "Employes.findByEmail", query = "SELECT e FROM Employes e WHERE e.email = :email"),
    @NamedQuery(name = "Employes.findByDateEnregistrement", query = "SELECT e FROM Employes e WHERE e.dateEnregistrement = :dateEnregistrement")})
public class Employes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_employe")
    private Integer idEmploye;
    @Size(max = 254)
    private String matricule;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String prenom;
    @Size(max = 254)
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    private String email;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @OneToMany(mappedBy = "idEmploye", fetch = FetchType.LAZY)
    private List<OperationCaisse> operationCaisseList;
    @OneToMany(mappedBy = "idEmploye", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;
    @JoinColumn(name = "id_role_employe", referencedColumnName = "id_role_employe")
    @ManyToOne(fetch = FetchType.LAZY)
    private RoleEmploye idRoleEmploye;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Societe idSociete;

    public Employes() {
    }

    public Employes(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Integer getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    @XmlTransient
    public List<OperationCaisse> getOperationCaisseList() {
        return operationCaisseList;
    }

    public void setOperationCaisseList(List<OperationCaisse> operationCaisseList) {
        this.operationCaisseList = operationCaisseList;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    public RoleEmploye getIdRoleEmploye() {
        return idRoleEmploye;
    }

    public void setIdRoleEmploye(RoleEmploye idRoleEmploye) {
        this.idRoleEmploye = idRoleEmploye;
    }

    public Societe getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Societe idSociete) {
        this.idSociete = idSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmploye != null ? idEmploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employes)) {
            return false;
        }
        Employes other = (Employes) object;
        if ((this.idEmploye == null && other.idEmploye != null) || (this.idEmploye != null && !this.idEmploye.equals(other.idEmploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Employes[ idEmploye=" + idEmploye + " ]";
    }
    
}
