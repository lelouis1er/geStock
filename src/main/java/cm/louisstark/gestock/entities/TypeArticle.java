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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Louis Stark
 */
@Entity
@Table(name = "type_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeArticle.findAll", query = "SELECT t FROM TypeArticle t"),
    @NamedQuery(name = "TypeArticle.findByIdType", query = "SELECT t FROM TypeArticle t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeArticle.findByNom", query = "SELECT t FROM TypeArticle t WHERE t.nom = :nom"),
    @NamedQuery(name = "TypeArticle.findByDescription", query = "SELECT t FROM TypeArticle t WHERE t.description = :description")})
public class TypeArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_type")
    private Integer idType;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String description;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategorieArticle idCategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType", fetch = FetchType.LAZY)
    private List<Article> articleList;

    public TypeArticle() {
    }

    public TypeArticle(Integer idType) {
        this.idType = idType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
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

    public CategorieArticle getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(CategorieArticle idCategorie) {
        this.idCategorie = idCategorie;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeArticle)) {
            return false;
        }
        TypeArticle other = (TypeArticle) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.TypeArticle[ idType=" + idType + " ]";
    }
    
}
