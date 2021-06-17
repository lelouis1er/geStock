/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "operation_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperationStock.findAll", query = "SELECT o FROM OperationStock o"),
    @NamedQuery(name = "OperationStock.findByIdOperation", query = "SELECT o FROM OperationStock o WHERE o.idOperation = :idOperation"),
    @NamedQuery(name = "OperationStock.findByDescription", query = "SELECT o FROM OperationStock o WHERE o.description = :description"),
    @NamedQuery(name = "OperationStock.findByQte", query = "SELECT o FROM OperationStock o WHERE o.qte = :qte"),
    @NamedQuery(name = "OperationStock.findByEntree", query = "SELECT o FROM OperationStock o WHERE o.entree = :entree"),
    @NamedQuery(name = "OperationStock.findByDateOperation", query = "SELECT o FROM OperationStock o WHERE o.dateOperation = :dateOperation")})
public class OperationStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_operation")
    private Long idOperation;
    @Size(max = 254)
    private String description;
    private Integer qte;
    private Boolean entree;
    @Column(name = "date_operation")
    @Temporal(TemporalType.DATE)
    private Date dateOperation;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_session", referencedColumnName = "id_session")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Session idSession;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeOperationStock idType;
    @OneToMany(mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<AchatArticle> achatArticleList;
    @OneToMany(mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<ArticleLiv> articleLivList;
    @OneToMany(mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<ArticlesCommandeClient> articlesCommandeClientList;

    public OperationStock() {
    }

    public OperationStock(Long idOperation) {
        this.idOperation = idOperation;
    }

    public Long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Long idOperation) {
        this.idOperation = idOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Boolean getEntree() {
        return entree;
    }

    public void setEntree(Boolean entree) {
        this.entree = entree;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    public TypeOperationStock getIdType() {
        return idType;
    }

    public void setIdType(TypeOperationStock idType) {
        this.idType = idType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationStock)) {
            return false;
        }
        OperationStock other = (OperationStock) object;
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.OperationStock[ idOperation=" + idOperation + " ]";
    }
    
}
