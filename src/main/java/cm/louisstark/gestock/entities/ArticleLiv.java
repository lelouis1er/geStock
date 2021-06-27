/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PACO PC
 */
@Entity
@Table(name = "article_liv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleLiv.findAll", query = "SELECT a FROM ArticleLiv a"),
    @NamedQuery(name = "ArticleLiv.findByIdArticleLiv", query = "SELECT a FROM ArticleLiv a WHERE a.idArticleLiv = :idArticleLiv"),
    @NamedQuery(name = "ArticleLiv.findByQte", query = "SELECT a FROM ArticleLiv a WHERE a.qte = :qte"),
    @NamedQuery(name = "ArticleLiv.findByPuAchat", query = "SELECT a FROM ArticleLiv a WHERE a.puAchat = :puAchat"),
    @NamedQuery(name = "ArticleLiv.findByEndomage", query = "SELECT a FROM ArticleLiv a WHERE a.endomage = :endomage")})
public class ArticleLiv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article_liv")
    private Long idArticleLiv;
    private Integer qte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pu_achat")
    private Double puAchat;
    private Boolean endomage;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_livraison", referencedColumnName = "id_livraison")
    @ManyToOne(fetch = FetchType.LAZY)
    private Livraison idLivraison;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationStock idOperation;
    @OneToMany(mappedBy = "idArticleLiv", fetch = FetchType.LAZY)
    private List<RetourArticleLiv> retourArticleLivList;

    public ArticleLiv() {
    }

    public ArticleLiv(Long idArticleLiv) {
        this.idArticleLiv = idArticleLiv;
    }

    public Long getIdArticleLiv() {
        return idArticleLiv;
    }

    public void setIdArticleLiv(Long idArticleLiv) {
        this.idArticleLiv = idArticleLiv;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Double getPuAchat() {
        return puAchat;
    }

    public void setPuAchat(Double puAchat) {
        this.puAchat = puAchat;
    }

    public Boolean getEndomage() {
        return endomage;
    }

    public void setEndomage(Boolean endomage) {
        this.endomage = endomage;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Livraison getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Livraison idLivraison) {
        this.idLivraison = idLivraison;
    }

    public OperationStock getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(OperationStock idOperation) {
        this.idOperation = idOperation;
    }

    @XmlTransient
    public List<RetourArticleLiv> getRetourArticleLivList() {
        return retourArticleLivList;
    }

    public void setRetourArticleLivList(List<RetourArticleLiv> retourArticleLivList) {
        this.retourArticleLivList = retourArticleLivList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticleLiv != null ? idArticleLiv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleLiv)) {
            return false;
        }
        ArticleLiv other = (ArticleLiv) object;
        if ((this.idArticleLiv == null && other.idArticleLiv != null) || (this.idArticleLiv != null && !this.idArticleLiv.equals(other.idArticleLiv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.ArticleLiv[ idArticleLiv=" + idArticleLiv + " ]";
    }
    
}
