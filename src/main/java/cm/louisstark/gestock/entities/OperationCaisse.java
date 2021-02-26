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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Louis Stark
 */
@Entity
@Table(name = "operation_caisse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperationCaisse.findAll", query = "SELECT o FROM OperationCaisse o"),
    @NamedQuery(name = "OperationCaisse.findByIdOperation", query = "SELECT o FROM OperationCaisse o WHERE o.idOperation = :idOperation"),
    @NamedQuery(name = "OperationCaisse.findByIntitule", query = "SELECT o FROM OperationCaisse o WHERE o.intitule = :intitule")})
public class OperationCaisse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_operation")
    private Long idOperation;
    @Size(max = 254)
    private String intitule;
    @OneToMany(mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<CommandeClient> commandeClientList;
    @JoinColumn(name = "id_employe", referencedColumnName = "id_employe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employes idEmploye;
    @JoinColumn(name = "id_session", referencedColumnName = "id_session")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Session idSession;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private TypeOperation idType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<Commande> commandeList;
    @OneToMany(mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<Achats> achatsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperation", fetch = FetchType.LAZY)
    private List<Livraison> livraisonList;

    public OperationCaisse() {
    }

    public OperationCaisse(Long idOperation) {
        this.idOperation = idOperation;
    }

    public Long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Long idOperation) {
        this.idOperation = idOperation;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @XmlTransient
    public List<CommandeClient> getCommandeClientList() {
        return commandeClientList;
    }

    public void setCommandeClientList(List<CommandeClient> commandeClientList) {
        this.commandeClientList = commandeClientList;
    }

    public Employes getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Employes idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    public TypeOperation getIdType() {
        return idType;
    }

    public void setIdType(TypeOperation idType) {
        this.idType = idType;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    @XmlTransient
    public List<Achats> getAchatsList() {
        return achatsList;
    }

    public void setAchatsList(List<Achats> achatsList) {
        this.achatsList = achatsList;
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
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationCaisse)) {
            return false;
        }
        OperationCaisse other = (OperationCaisse) object;
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.OperationCaisse[ idOperation=" + idOperation + " ]";
    }
    
}
