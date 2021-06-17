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
 * @author pc
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Societe.findAll", query = "SELECT s FROM Societe s"),
    @NamedQuery(name = "Societe.findByIdSociete", query = "SELECT s FROM Societe s WHERE s.idSociete = :idSociete"),
    @NamedQuery(name = "Societe.findByNom", query = "SELECT s FROM Societe s WHERE s.nom = :nom"),
    @NamedQuery(name = "Societe.findByCode", query = "SELECT s FROM Societe s WHERE s.code = :code"),
    @NamedQuery(name = "Societe.findByDescription", query = "SELECT s FROM Societe s WHERE s.description = :description"),
    @NamedQuery(name = "Societe.findByTelephone", query = "SELECT s FROM Societe s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "Societe.findBySiteweb", query = "SELECT s FROM Societe s WHERE s.siteweb = :siteweb"),
    @NamedQuery(name = "Societe.findByEmail", query = "SELECT s FROM Societe s WHERE s.email = :email"),
    @NamedQuery(name = "Societe.findByDateCreation", query = "SELECT s FROM Societe s WHERE s.dateCreation = :dateCreation"),
    @NamedQuery(name = "Societe.findByDateEnregistrement", query = "SELECT s FROM Societe s WHERE s.dateEnregistrement = :dateEnregistrement")})
public class Societe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_societe")
    private Integer idSociete;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String code;
    @Size(max = 254)
    private String description;
    @Size(max = 254)
    private String telephone;
    @Size(max = 254)
    private String siteweb;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    private String email;
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Session> sessionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Magasin> magasinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Client> clientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Employes> employesList;
    @OneToMany(mappedBy = "idSociete", fetch = FetchType.LAZY)
    private List<Article> articleList;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;

    public Societe() {
    }

    public Societe(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    @XmlTransient
    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    @XmlTransient
    public List<Fournisseur> getFournisseurList() {
        return fournisseurList;
    }

    public void setFournisseurList(List<Fournisseur> fournisseurList) {
        this.fournisseurList = fournisseurList;
    }

    @XmlTransient
    public List<Magasin> getMagasinList() {
        return magasinList;
    }

    public void setMagasinList(List<Magasin> magasinList) {
        this.magasinList = magasinList;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @XmlTransient
    public List<Employes> getEmployesList() {
        return employesList;
    }

    public void setEmployesList(List<Employes> employesList) {
        this.employesList = employesList;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSociete != null ? idSociete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Societe)) {
            return false;
        }
        Societe other = (Societe) object;
        if ((this.idSociete == null && other.idSociete != null) || (this.idSociete != null && !this.idSociete.equals(other.idSociete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Societe[ idSociete=" + idSociete + " ]";
    }
    
}
