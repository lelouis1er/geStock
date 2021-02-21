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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Louis Stark
 */
@Entity
@Table(name = "retour_article_liv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetourArticleLiv.findAll", query = "SELECT r FROM RetourArticleLiv r"),
    @NamedQuery(name = "RetourArticleLiv.findByIdRetour", query = "SELECT r FROM RetourArticleLiv r WHERE r.idRetour = :idRetour"),
    @NamedQuery(name = "RetourArticleLiv.findByMotif", query = "SELECT r FROM RetourArticleLiv r WHERE r.motif = :motif"),
    @NamedQuery(name = "RetourArticleLiv.findByRetourne", query = "SELECT r FROM RetourArticleLiv r WHERE r.retourne = :retourne")})
public class RetourArticleLiv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_retour")
    private Integer idRetour;
    @Size(max = 254)
    private String motif;
    private Boolean retourne;
    @JoinColumn(name = "id_article_liv", referencedColumnName = "id_article_liv")
    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleLiv idArticleLiv;

    public RetourArticleLiv() {
    }

    public RetourArticleLiv(Integer idRetour) {
        this.idRetour = idRetour;
    }

    public Integer getIdRetour() {
        return idRetour;
    }

    public void setIdRetour(Integer idRetour) {
        this.idRetour = idRetour;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Boolean getRetourne() {
        return retourne;
    }

    public void setRetourne(Boolean retourne) {
        this.retourne = retourne;
    }

    public ArticleLiv getIdArticleLiv() {
        return idArticleLiv;
    }

    public void setIdArticleLiv(ArticleLiv idArticleLiv) {
        this.idArticleLiv = idArticleLiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetour != null ? idRetour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetourArticleLiv)) {
            return false;
        }
        RetourArticleLiv other = (RetourArticleLiv) object;
        if ((this.idRetour == null && other.idRetour != null) || (this.idRetour != null && !this.idRetour.equals(other.idRetour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.RetourArticleLiv[ idRetour=" + idRetour + " ]";
    }
    
}
