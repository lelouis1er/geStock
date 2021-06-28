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
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findByIdSession", query = "SELECT s FROM Session s WHERE s.idSession = :idSession"),
    @NamedQuery(name = "Session.findByNom", query = "SELECT s FROM Session s WHERE s.nom = :nom"),
    @NamedQuery(name = "Session.findByDateDebut", query = "SELECT s FROM Session s WHERE s.dateDebut = :dateDebut"),
    @NamedQuery(name = "Session.findByDateFin", query = "SELECT s FROM Session s WHERE s.dateFin = :dateFin")})
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_session")
    private Integer idSession;
    @Size(max = 254)
    private String nom;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Societe idSociete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession", fetch = FetchType.LAZY)
    private List<OperationCaisse> operationCaisseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession", fetch = FetchType.LAZY)
    private List<OperationStock> operationStockList;
    @OneToMany(mappedBy = "idSession", fetch = FetchType.LAZY)
    private List<Livraison> livraisonList;

    public Session() {
    }

    public Session(Integer idSession) {
        this.idSession = idSession;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Societe getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Societe idSociete) {
        this.idSociete = idSociete;
    }

    @XmlTransient
    public List<OperationCaisse> getOperationCaisseList() {
        return operationCaisseList;
    }

    public void setOperationCaisseList(List<OperationCaisse> operationCaisseList) {
        this.operationCaisseList = operationCaisseList;
    }

    @XmlTransient
    public List<OperationStock> getOperationStockList() {
        return operationStockList;
    }

    public void setOperationStockList(List<OperationStock> operationStockList) {
        this.operationStockList = operationStockList;
    }

    @XmlTransient
    public List<Livraison> getLivraisonList() {
        return livraisonList;
    }

    public void setLivraisonList(List<Livraison> livraisonList) {
        this.livraisonList = livraisonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSession != null ? idSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.idSession == null && other.idSession != null) || (this.idSession != null && !this.idSession.equals(other.idSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Session[ idSession=" + idSession + " ]";
    }
    
}
