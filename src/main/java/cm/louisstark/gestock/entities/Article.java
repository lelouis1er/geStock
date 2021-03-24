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
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Article.findByCodeArticle", query = "SELECT a FROM Article a WHERE a.codeArticle = :codeArticle"),
    @NamedQuery(name = "Article.findByNom", query = "SELECT a FROM Article a WHERE a.nom = :nom"),
    @NamedQuery(name = "Article.findByCarateristiques", query = "SELECT a FROM Article a WHERE a.carateristiques = :carateristiques"),
    @NamedQuery(name = "Article.findByPrixVente", query = "SELECT a FROM Article a WHERE a.prixVente = :prixVente"),
    @NamedQuery(name = "Article.findByQteAlert", query = "SELECT a FROM Article a WHERE a.qteAlert = :qteAlert")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article")
    private Long idArticle;
    @Size(max = 254)
    @Column(name = "code_article")
    private String codeArticle;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String carateristiques;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix_vente")
    private Double prixVente;
    @Column(name = "qte_alert")
    private Integer qteAlert;
    @OneToMany(mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<OperationStock> operationStockList;
    @OneToMany(mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<AchatArticle> achatArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<ArticleLiv> articleLivList;
    @OneToMany(mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<ArticlesCommandeClient> articlesCommandeClientList;
    @OneToMany(mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<StockArticle> stockArticleList;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Societe idSociete;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeArticle idType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle", fetch = FetchType.LAZY)
    private List<ArticleCommande> articleCommandeList;

    public Article() {
    }

    public Article(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCarateristiques() {
        return carateristiques;
    }

    public void setCarateristiques(String carateristiques) {
        this.carateristiques = carateristiques;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Integer getQteAlert() {
        return qteAlert;
    }

    public void setQteAlert(Integer qteAlert) {
        this.qteAlert = qteAlert;
    }

    @XmlTransient
    public List<OperationStock> getOperationStockList() {
        return operationStockList;
    }

    public void setOperationStockList(List<OperationStock> operationStockList) {
        this.operationStockList = operationStockList;
    }

    @XmlTransient
    public List<AchatArticle> getAchatArticleList() {
        return achatArticleList;
    }

    public void setAchatArticleList(List<AchatArticle> achatArticleList) {
        this.achatArticleList = achatArticleList;
    }

    @XmlTransient
    public List<ArticleLiv> getArticleLivList() {
        return articleLivList;
    }

    public void setArticleLivList(List<ArticleLiv> articleLivList) {
        this.articleLivList = articleLivList;
    }

    @XmlTransient
    public List<ArticlesCommandeClient> getArticlesCommandeClientList() {
        return articlesCommandeClientList;
    }

    public void setArticlesCommandeClientList(List<ArticlesCommandeClient> articlesCommandeClientList) {
        this.articlesCommandeClientList = articlesCommandeClientList;
    }

    @XmlTransient
    public List<StockArticle> getStockArticleList() {
        return stockArticleList;
    }

    public void setStockArticleList(List<StockArticle> stockArticleList) {
        this.stockArticleList = stockArticleList;
    }

    public Societe getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Societe idSociete) {
        this.idSociete = idSociete;
    }

    public TypeArticle getIdType() {
        return idType;
    }

    public void setIdType(TypeArticle idType) {
        this.idType = idType;
    }

    @XmlTransient
    public List<ArticleCommande> getArticleCommandeList() {
        return articleCommandeList;
    }

    public void setArticleCommandeList(List<ArticleCommande> articleCommandeList) {
        this.articleCommandeList = articleCommandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Article[ idArticle=" + idArticle + " ]";
    }
    
}
