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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PACO PC
 */
@Entity
@Table(name = "categorie_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorieArticle.findAll", query = "SELECT c FROM CategorieArticle c"),
    @NamedQuery(name = "CategorieArticle.findByIdCategorie", query = "SELECT c FROM CategorieArticle c WHERE c.idCategorie = :idCategorie"),
    @NamedQuery(name = "CategorieArticle.findByNom", query = "SELECT c FROM CategorieArticle c WHERE c.nom = :nom"),
    @NamedQuery(name = "CategorieArticle.findByDescription", query = "SELECT c FROM CategorieArticle c WHERE c.description = :description")})
public class CategorieArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categorie")
    private Integer idCategorie;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategorie", fetch = FetchType.LAZY)
    private List<TypeArticle> typeArticleList;

    public CategorieArticle() {
    }

    public CategorieArticle(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
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

    @XmlTransient
    public List<TypeArticle> getTypeArticleList() {
        return typeArticleList;
    }

    public void setTypeArticleList(List<TypeArticle> typeArticleList) {
        this.typeArticleList = typeArticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieArticle)) {
            return false;
        }
        CategorieArticle other = (CategorieArticle) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.CategorieArticle[ idCategorie=" + idCategorie + " ]";
    }
    
}
