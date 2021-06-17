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
    @NamedQuery(name = "Quartier.findAll", query = "SELECT q FROM Quartier q"),
    @NamedQuery(name = "Quartier.findByIdquartier", query = "SELECT q FROM Quartier q WHERE q.idquartier = :idquartier"),
    @NamedQuery(name = "Quartier.findByNom", query = "SELECT q FROM Quartier q WHERE q.nom = :nom")})
public class Quartier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idquartier;
    @Size(max = 254)
    private String nom;
    @JoinColumn(name = "idville", referencedColumnName = "idville")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ville idville;
    @OneToMany(mappedBy = "idquartier", fetch = FetchType.LAZY)
    private List<Adresse> adresseList;

    public Quartier() {
    }

    public Quartier(Integer idquartier) {
        this.idquartier = idquartier;
    }

    public Integer getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(Integer idquartier) {
        this.idquartier = idquartier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getIdville() {
        return idville;
    }

    public void setIdville(Ville idville) {
        this.idville = idville;
    }

    @XmlTransient
    public List<Adresse> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<Adresse> adresseList) {
        this.adresseList = adresseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquartier != null ? idquartier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartier)) {
            return false;
        }
        Quartier other = (Quartier) object;
        if ((this.idquartier == null && other.idquartier != null) || (this.idquartier != null && !this.idquartier.equals(other.idquartier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Quartier[ idquartier=" + idquartier + " ]";
    }
    
}
