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
import javax.persistence.Column;
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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magasin.findAll", query = "SELECT m FROM Magasin m"),
    @NamedQuery(name = "Magasin.findByIdMagasin", query = "SELECT m FROM Magasin m WHERE m.idMagasin = :idMagasin"),
    @NamedQuery(name = "Magasin.findByCode", query = "SELECT m FROM Magasin m WHERE m.code = :code"),
    @NamedQuery(name = "Magasin.findByIntitule", query = "SELECT m FROM Magasin m WHERE m.intitule = :intitule"),
    @NamedQuery(name = "Magasin.findByDescription", query = "SELECT m FROM Magasin m WHERE m.description = :description")})
public class Magasin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_magasin")
    private Integer idMagasin;
    @Size(max = 254)
    private String code;
    @Size(max = 254)
    private String intitule;
    @Size(max = 254)
    private String description;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Societe idSociete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMagasin", fetch = FetchType.LAZY)
    private List<Etagere> etagereList;

    public Magasin() {
    }

    public Magasin(Integer idMagasin) {
        this.idMagasin = idMagasin;
    }

    public Integer getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(Integer idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Societe getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Societe idSociete) {
        this.idSociete = idSociete;
    }

    @XmlTransient
    public List<Etagere> getEtagereList() {
        return etagereList;
    }

    public void setEtagereList(List<Etagere> etagereList) {
        this.etagereList = etagereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMagasin != null ? idMagasin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magasin)) {
            return false;
        }
        Magasin other = (Magasin) object;
        if ((this.idMagasin == null && other.idMagasin != null) || (this.idMagasin != null && !this.idMagasin.equals(other.idMagasin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Magasin[ idMagasin=" + idMagasin + " ]";
    }
    
}
