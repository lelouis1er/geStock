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
 * @author PACO PC
 */
@Entity
@Table(name = "articles_commande_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticlesCommandeClient.findAll", query = "SELECT a FROM ArticlesCommandeClient a"),
    @NamedQuery(name = "ArticlesCommandeClient.findByIdArticleCommandeclient", query = "SELECT a FROM ArticlesCommandeClient a WHERE a.idArticleCommandeclient = :idArticleCommandeclient"),
    @NamedQuery(name = "ArticlesCommandeClient.findByQte", query = "SELECT a FROM ArticlesCommandeClient a WHERE a.qte = :qte"),
    @NamedQuery(name = "ArticlesCommandeClient.findByMontant", query = "SELECT a FROM ArticlesCommandeClient a WHERE a.montant = :montant")})
public class ArticlesCommandeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article_commandeclient")
    private Long idArticleCommandeclient;
    private Integer qte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double montant;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(fetch = FetchType.LAZY)
    private CommandeClient idCommande;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationStock idOperation;

    public ArticlesCommandeClient() {
    }

    public ArticlesCommandeClient(Long idArticleCommandeclient) {
        this.idArticleCommandeclient = idArticleCommandeclient;
    }

    public Long getIdArticleCommandeclient() {
        return idArticleCommandeclient;
    }

    public void setIdArticleCommandeclient(Long idArticleCommandeclient) {
        this.idArticleCommandeclient = idArticleCommandeclient;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public CommandeClient getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(CommandeClient idCommande) {
        this.idCommande = idCommande;
    }

    public OperationStock getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(OperationStock idOperation) {
        this.idOperation = idOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticleCommandeclient != null ? idArticleCommandeclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticlesCommandeClient)) {
            return false;
        }
        ArticlesCommandeClient other = (ArticlesCommandeClient) object;
        if ((this.idArticleCommandeclient == null && other.idArticleCommandeclient != null) || (this.idArticleCommandeclient != null && !this.idArticleCommandeclient.equals(other.idArticleCommandeclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.ArticlesCommandeClient[ idArticleCommandeclient=" + idArticleCommandeclient + " ]";
    }
    
}
