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
    @NamedQuery(name = "Etagere.findAll", query = "SELECT e FROM Etagere e"),
    @NamedQuery(name = "Etagere.findByIdEtagere", query = "SELECT e FROM Etagere e WHERE e.idEtagere = :idEtagere"),
    @NamedQuery(name = "Etagere.findByNom", query = "SELECT e FROM Etagere e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etagere.findByDescrption", query = "SELECT e FROM Etagere e WHERE e.descrption = :descrption"),
    @NamedQuery(name = "Etagere.findByNumRange", query = "SELECT e FROM Etagere e WHERE e.numRange = :numRange")})
public class Etagere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_etagere")
    private Integer idEtagere;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String descrption;
    @Column(name = "num_range")
    private Integer numRange;
    @JoinColumn(name = "id_magasin", referencedColumnName = "id_magasin")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Magasin idMagasin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtagere", fetch = FetchType.LAZY)
    private List<ArticleStock> articleStockList;

    public Etagere() {
    }

    public Etagere(Integer idEtagere) {
        this.idEtagere = idEtagere;
    }

    public Integer getIdEtagere() {
        return idEtagere;
    }

    public void setIdEtagere(Integer idEtagere) {
        this.idEtagere = idEtagere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Integer getNumRange() {
        return numRange;
    }

    public void setNumRange(Integer numRange) {
        this.numRange = numRange;
    }

    public Magasin getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(Magasin idMagasin) {
        this.idMagasin = idMagasin;
    }

    @XmlTransient
    public List<ArticleStock> getArticleStockList() {
        return articleStockList;
    }

    public void setArticleStockList(List<ArticleStock> articleStockList) {
        this.articleStockList = articleStockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtagere != null ? idEtagere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etagere)) {
            return false;
        }
        Etagere other = (Etagere) object;
        if ((this.idEtagere == null && other.idEtagere != null) || (this.idEtagere != null && !this.idEtagere.equals(other.idEtagere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Etagere[ idEtagere=" + idEtagere + " ]";
    }
    
}
