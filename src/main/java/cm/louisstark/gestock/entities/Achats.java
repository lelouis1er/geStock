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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Achats.findAll", query = "SELECT a FROM Achats a"),
    @NamedQuery(name = "Achats.findByIdAchat", query = "SELECT a FROM Achats a WHERE a.idAchat = :idAchat"),
    @NamedQuery(name = "Achats.findByNumFacture", query = "SELECT a FROM Achats a WHERE a.numFacture = :numFacture"),
    @NamedQuery(name = "Achats.findByDateAchat", query = "SELECT a FROM Achats a WHERE a.dateAchat = :dateAchat"),
    @NamedQuery(name = "Achats.findByNomClient", query = "SELECT a FROM Achats a WHERE a.nomClient = :nomClient")})
public class Achats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_achat")
    private Long idAchat;
    @Size(max = 254)
    @Column(name = "num_facture")
    private String numFacture;
    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @Size(max = 254)
    @Column(name = "nom_client")
    private String nomClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAchat", fetch = FetchType.LAZY)
    private List<AchatArticle> achatArticleList;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private Operation idOperation;

    public Achats() {
    }

    public Achats(Long idAchat) {
        this.idAchat = idAchat;
    }

    public Long getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(Long idAchat) {
        this.idAchat = idAchat;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @XmlTransient
    public List<AchatArticle> getAchatArticleList() {
        return achatArticleList;
    }

    public void setAchatArticleList(List<AchatArticle> achatArticleList) {
        this.achatArticleList = achatArticleList;
    }

    public Operation getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Operation idOperation) {
        this.idOperation = idOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAchat != null ? idAchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achats)) {
            return false;
        }
        Achats other = (Achats) object;
        if ((this.idAchat == null && other.idAchat != null) || (this.idAchat != null && !this.idAchat.equals(other.idAchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Achats[ idAchat=" + idAchat + " ]";
    }
    
}
