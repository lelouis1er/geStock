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
 * @author PACO PC
 */
@Entity
@Table(name = "commande_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandeClient.findAll", query = "SELECT c FROM CommandeClient c"),
    @NamedQuery(name = "CommandeClient.findByIdCommande", query = "SELECT c FROM CommandeClient c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "CommandeClient.findByDateCommande", query = "SELECT c FROM CommandeClient c WHERE c.dateCommande = :dateCommande"),
    @NamedQuery(name = "CommandeClient.findByIntitule", query = "SELECT c FROM CommandeClient c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "CommandeClient.findByDescription", query = "SELECT c FROM CommandeClient c WHERE c.description = :description"),
    @NamedQuery(name = "CommandeClient.findByDateLiv", query = "SELECT c FROM CommandeClient c WHERE c.dateLiv = :dateLiv"),
    @NamedQuery(name = "CommandeClient.findBySupprime", query = "SELECT c FROM CommandeClient c WHERE c.supprime = :supprime"),
    @NamedQuery(name = "CommandeClient.findByLivree", query = "SELECT c FROM CommandeClient c WHERE c.livree = :livree"),
    @NamedQuery(name = "CommandeClient.findByNumcmd", query = "SELECT c FROM CommandeClient c WHERE c.numcmd = :numcmd")})
public class CommandeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_commande")
    private Long idCommande;
    @Column(name = "date_commande")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Size(max = 254)
    private String intitule;
    @Size(max = 254)
    private String description;
    @Column(name = "date_liv")
    @Temporal(TemporalType.DATE)
    private Date dateLiv;
    private Boolean supprime;
    private Boolean livree;
    @Size(max = 254)
    private String numcmd;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationCaisse idOperation;
    @OneToMany(mappedBy = "idCommande", fetch = FetchType.LAZY)
    private List<ArticlesCommandeClient> articlesCommandeClientList;

    public CommandeClient() {
    }

    public CommandeClient(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateLiv() {
        return dateLiv;
    }

    public void setDateLiv(Date dateLiv) {
        this.dateLiv = dateLiv;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Boolean getLivree() {
        return livree;
    }

    public void setLivree(Boolean livree) {
        this.livree = livree;
    }

    public String getNumcmd() {
        return numcmd;
    }

    public void setNumcmd(String numcmd) {
        this.numcmd = numcmd;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public OperationCaisse getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(OperationCaisse idOperation) {
        this.idOperation = idOperation;
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
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeClient)) {
            return false;
        }
        CommandeClient other = (CommandeClient) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.CommandeClient[ idCommande=" + idCommande + " ]";
    }
    
}
