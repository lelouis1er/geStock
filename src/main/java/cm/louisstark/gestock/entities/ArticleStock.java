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
@Table(name = "article_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleStock.findAll", query = "SELECT a FROM ArticleStock a"),
    @NamedQuery(name = "ArticleStock.findByIdArticlestock", query = "SELECT a FROM ArticleStock a WHERE a.idArticlestock = :idArticlestock"),
    @NamedQuery(name = "ArticleStock.findByQteStock", query = "SELECT a FROM ArticleStock a WHERE a.qteStock = :qteStock"),
    @NamedQuery(name = "ArticleStock.findByPrixAchat", query = "SELECT a FROM ArticleStock a WHERE a.prixAchat = :prixAchat"),
    @NamedQuery(name = "ArticleStock.findByDescription", query = "SELECT a FROM ArticleStock a WHERE a.description = :description")})
public class ArticleStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articlestock")
    private Long idArticlestock;
    @Column(name = "qte_stock")
    private Integer qteStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix_achat")
    private Double prixAchat;
    @Size(max = 254)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticlestock", fetch = FetchType.LAZY)
    private List<AchatArticle> achatArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticlestock", fetch = FetchType.LAZY)
    private List<ArticlesCommandeClient> articlesCommandeClientList;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_article_liv", referencedColumnName = "id_article_liv")
    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleLiv idArticleLiv;
    @JoinColumn(name = "id_etagere", referencedColumnName = "id_etagere")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Etagere idEtagere;

    public ArticleStock() {
    }

    public ArticleStock(Long idArticlestock) {
        this.idArticlestock = idArticlestock;
    }

    public Long getIdArticlestock() {
        return idArticlestock;
    }

    public void setIdArticlestock(Long idArticlestock) {
        this.idArticlestock = idArticlestock;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    public Double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<AchatArticle> getAchatArticleList() {
        return achatArticleList;
    }

    public void setAchatArticleList(List<AchatArticle> achatArticleList) {
        this.achatArticleList = achatArticleList;
    }

    @XmlTransient
    public List<ArticlesCommandeClient> getArticlesCommandeClientList() {
        return articlesCommandeClientList;
    }

    public void setArticlesCommandeClientList(List<ArticlesCommandeClient> articlesCommandeClientList) {
        this.articlesCommandeClientList = articlesCommandeClientList;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public ArticleLiv getIdArticleLiv() {
        return idArticleLiv;
    }

    public void setIdArticleLiv(ArticleLiv idArticleLiv) {
        this.idArticleLiv = idArticleLiv;
    }

    public Etagere getIdEtagere() {
        return idEtagere;
    }

    public void setIdEtagere(Etagere idEtagere) {
        this.idEtagere = idEtagere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticlestock != null ? idArticlestock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleStock)) {
            return false;
        }
        ArticleStock other = (ArticleStock) object;
        if ((this.idArticlestock == null && other.idArticlestock != null) || (this.idArticlestock != null && !this.idArticlestock.equals(other.idArticlestock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.ArticleStock[ idArticlestock=" + idArticlestock + " ]";
    }
    
}
