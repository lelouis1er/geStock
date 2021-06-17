/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author pc
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdadresse", query = "SELECT a FROM Adresse a WHERE a.idadresse = :idadresse"),
    @NamedQuery(name = "Adresse.findByAutredescription", query = "SELECT a FROM Adresse a WHERE a.autredescription = :autredescription")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idadresse;
    @Size(max = 254)
    private String autredescription;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurList;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Client> clientList;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Employes> employesList;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Societe> societeList;
    @JoinColumn(name = "idquartier", referencedColumnName = "idquartier")
    @ManyToOne(fetch = FetchType.LAZY)
    private Quartier idquartier;

    public Adresse() {
    }

    public Adresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public Integer getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public String getAutredescription() {
        return autredescription;
    }

    public void setAutredescription(String autredescription) {
        this.autredescription = autredescription;
    }

    @XmlTransient
    public List<Fournisseur> getFournisseurList() {
        return fournisseurList;
    }

    public void setFournisseurList(List<Fournisseur> fournisseurList) {
        this.fournisseurList = fournisseurList;
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
    public List<Societe> getSocieteList() {
        return societeList;
    }

    public void setSocieteList(List<Societe> societeList) {
        this.societeList = societeList;
    }

    public Quartier getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(Quartier idquartier) {
        this.idquartier = idquartier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadresse != null ? idadresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idadresse == null && other.idadresse != null) || (this.idadresse != null && !this.idadresse.equals(other.idadresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Adresse[ idadresse=" + idadresse + " ]";
    }
    
}
