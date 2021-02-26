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
 * @author Louis Stark
 */
@Entity
@Table(name = "stock_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockArticle.findAll", query = "SELECT s FROM StockArticle s"),
    @NamedQuery(name = "StockArticle.findByIdArticlestock", query = "SELECT s FROM StockArticle s WHERE s.idArticlestock = :idArticlestock"),
    @NamedQuery(name = "StockArticle.findByQteStock", query = "SELECT s FROM StockArticle s WHERE s.qteStock = :qteStock")})
public class StockArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articlestock")
    private Long idArticlestock;
    @Column(name = "qte_stock")
    private Integer qteStock;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article idArticle;
    @JoinColumn(name = "id_etagere", referencedColumnName = "id_etagere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Etagere idEtagere;

    public StockArticle() {
    }

    public StockArticle(Long idArticlestock) {
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

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
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
        if (!(object instanceof StockArticle)) {
            return false;
        }
        StockArticle other = (StockArticle) object;
        if ((this.idArticlestock == null && other.idArticlestock != null) || (this.idArticlestock != null && !this.idArticlestock.equals(other.idArticlestock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.StockArticle[ idArticlestock=" + idArticlestock + " ]";
    }
    
}
