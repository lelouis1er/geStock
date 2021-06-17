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
@Table(name = "achat_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AchatArticle.findAll", query = "SELECT a FROM AchatArticle a"),
    @NamedQuery(name = "AchatArticle.findByIdAchatartice", query = "SELECT a FROM AchatArticle a WHERE a.idAchatartice = :idAchatartice"),
    @NamedQuery(name = "AchatArticle.findByQte", query = "SELECT a FROM AchatArticle a WHERE a.qte = :qte")})
public class AchatArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_achatartice")
    private Long idAchatartice;
    private Integer qte;
    @JoinColumn(name = "id_achat", referencedColumnName = "id_achat")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Achats idAchat;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationStock idOperation;

    public AchatArticle() {
    }

    public AchatArticle(Long idAchatartice) {
        this.idAchatartice = idAchatartice;
    }

    public Long getIdAchatartice() {
        return idAchatartice;
    }

    public void setIdAchatartice(Long idAchatartice) {
        this.idAchatartice = idAchatartice;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Achats getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(Achats idAchat) {
        this.idAchat = idAchat;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
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
        hash += (idAchatartice != null ? idAchatartice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AchatArticle)) {
            return false;
        }
        AchatArticle other = (AchatArticle) object;
        if ((this.idAchatartice == null && other.idAchatartice != null) || (this.idAchatartice != null && !this.idAchatartice.equals(other.idAchatartice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.AchatArticle[ idAchatartice=" + idAchatartice + " ]";
    }
    
}
