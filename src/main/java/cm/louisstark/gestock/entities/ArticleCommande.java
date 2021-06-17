/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "article_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleCommande.findAll", query = "SELECT a FROM ArticleCommande a"),
    @NamedQuery(name = "ArticleCommande.findByIdArticleCommande", query = "SELECT a FROM ArticleCommande a WHERE a.idArticleCommande = :idArticleCommande"),
    @NamedQuery(name = "ArticleCommande.findByQte", query = "SELECT a FROM ArticleCommande a WHERE a.qte = :qte")})
public class ArticleCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article_commande")
    private Long idArticleCommande;
    private Integer qte;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Commande idCommande;

    public ArticleCommande() {
    }

    public ArticleCommande(Long idArticleCommande) {
        this.idArticleCommande = idArticleCommande;
    }

    public Long getIdArticleCommande() {
        return idArticleCommande;
    }

    public void setIdArticleCommande(Long idArticleCommande) {
        this.idArticleCommande = idArticleCommande;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticleCommande != null ? idArticleCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommande)) {
            return false;
        }
        ArticleCommande other = (ArticleCommande) object;
        if ((this.idArticleCommande == null && other.idArticleCommande != null) || (this.idArticleCommande != null && !this.idArticleCommande.equals(other.idArticleCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.ArticleCommande[ idArticleCommande=" + idArticleCommande + " ]";
    }
    
}
