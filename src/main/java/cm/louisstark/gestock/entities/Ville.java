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
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"),
    @NamedQuery(name = "Ville.findByIdville", query = "SELECT v FROM Ville v WHERE v.idville = :idville"),
    @NamedQuery(name = "Ville.findByNom", query = "SELECT v FROM Ville v WHERE v.nom = :nom")})
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idville;
    @Size(max = 254)
    private String nom;
    @OneToMany(mappedBy = "idville", fetch = FetchType.LAZY)
    private List<Quartier> quartierList;
    @JoinColumn(name = "idpays", referencedColumnName = "idpays")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pays idpays;
    @JoinColumn(name = "idregion", referencedColumnName = "idregion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Region idregion;

    public Ville() {
    }

    public Ville(Integer idville) {
        this.idville = idville;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Quartier> getQuartierList() {
        return quartierList;
    }

    public void setQuartierList(List<Quartier> quartierList) {
        this.quartierList = quartierList;
    }

    public Pays getIdpays() {
        return idpays;
    }

    public void setIdpays(Pays idpays) {
        this.idpays = idpays;
    }

    public Region getIdregion() {
        return idregion;
    }

    public void setIdregion(Region idregion) {
        this.idregion = idregion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idville != null ? idville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idville == null && other.idville != null) || (this.idville != null && !this.idville.equals(other.idville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Ville[ idville=" + idville + " ]";
    }
    
}
