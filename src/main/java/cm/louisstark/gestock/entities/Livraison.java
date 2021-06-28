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
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findByIdLivraison", query = "SELECT l FROM Livraison l WHERE l.idLivraison = :idLivraison"),
    @NamedQuery(name = "Livraison.findByNumeroRef", query = "SELECT l FROM Livraison l WHERE l.numeroRef = :numeroRef"),
    @NamedQuery(name = "Livraison.findByDateEnregistrement", query = "SELECT l FROM Livraison l WHERE l.dateEnregistrement = :dateEnregistrement"),
    @NamedQuery(name = "Livraison.findByLibelle", query = "SELECT l FROM Livraison l WHERE l.libelle = :libelle"),
    @NamedQuery(name = "Livraison.findByCoutTotal", query = "SELECT l FROM Livraison l WHERE l.coutTotal = :coutTotal"),
    @NamedQuery(name = "Livraison.findByLivree", query = "SELECT l FROM Livraison l WHERE l.livree = :livree"),
    @NamedQuery(name = "Livraison.findBySupprime", query = "SELECT l FROM Livraison l WHERE l.supprime = :supprime"),
    @NamedQuery(name = "Livraison.findByDateLivraison", query = "SELECT l FROM Livraison l WHERE l.dateLivraison = :dateLivraison"),
    @NamedQuery(name = "Livraison.findByHeureLivraison", query = "SELECT l FROM Livraison l WHERE l.heureLivraison = :heureLivraison")})
public class Livraison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_livraison")
    private Integer idLivraison;
    @Size(max = 254)
    @Column(name = "numero_ref")
    private String numeroRef;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @Size(max = 254)
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout_total")
    private Double coutTotal;
    private Boolean livree;
    private Boolean supprime;
    @Column(name = "date_livraison")
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    @Column(name = "heure_livraison")
    @Temporal(TemporalType.TIME)
    private Date heureLivraison;
    @OneToMany(mappedBy = "idLivraison", fetch = FetchType.LAZY)
    private List<ArticleLiv> articleLivList;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(fetch = FetchType.LAZY)
    private Commande idCommande;
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id_fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur idFournisseur;
    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationCaisse idOperation;
    @JoinColumn(name = "id_session", referencedColumnName = "id_session")
    @ManyToOne(fetch = FetchType.LAZY)
    private Session idSession;

    public Livraison() {
    }

    public Livraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Integer getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public String getNumeroRef() {
        return numeroRef;
    }

    public void setNumeroRef(String numeroRef) {
        this.numeroRef = numeroRef;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(Double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public Boolean getLivree() {
        return livree;
    }

    public void setLivree(Boolean livree) {
        this.livree = livree;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Date getHeureLivraison() {
        return heureLivraison;
    }

    public void setHeureLivraison(Date heureLivraison) {
        this.heureLivraison = heureLivraison;
    }

    @XmlTransient
    public List<ArticleLiv> getArticleLivList() {
        return articleLivList;
    }

    public void setArticleLivList(List<ArticleLiv> articleLivList) {
        this.articleLivList = articleLivList;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Fournisseur getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Fournisseur idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public OperationCaisse getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(OperationCaisse idOperation) {
        this.idOperation = idOperation;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivraison != null ? idLivraison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idLivraison == null && other.idLivraison != null) || (this.idLivraison != null && !this.idLivraison.equals(other.idLivraison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Livraison[ idLivraison=" + idLivraison + " ]";
    }
    
}
