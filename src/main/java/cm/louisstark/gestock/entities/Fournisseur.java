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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIdFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idFournisseur = :idFournisseur"),
    @NamedQuery(name = "Fournisseur.findByNiu", query = "SELECT f FROM Fournisseur f WHERE f.niu = :niu"),
    @NamedQuery(name = "Fournisseur.findByRaisonSociale", query = "SELECT f FROM Fournisseur f WHERE f.raisonSociale = :raisonSociale"),
    @NamedQuery(name = "Fournisseur.findByTel", query = "SELECT f FROM Fournisseur f WHERE f.tel = :tel"),
    @NamedQuery(name = "Fournisseur.findByBp", query = "SELECT f FROM Fournisseur f WHERE f.bp = :bp"),
    @NamedQuery(name = "Fournisseur.findByEmail", query = "SELECT f FROM Fournisseur f WHERE f.email = :email"),
    @NamedQuery(name = "Fournisseur.findBySiteWeb", query = "SELECT f FROM Fournisseur f WHERE f.siteWeb = :siteWeb")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fournisseur")
    private Integer idFournisseur;
    @Size(max = 254)
    private String niu;
    @Size(max = 254)
    @Column(name = "raison_sociale")
    private String raisonSociale;
    @Size(max = 254)
    private String tel;
    @Size(max = 254)
    private String bp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    private String email;
    @Size(max = 254)
    @Column(name = "site_web")
    private String siteWeb;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Societe idSociete;
    @OneToMany(mappedBy = "idFournisseur", fetch = FetchType.LAZY)
    private List<Commande> commandeList;
    @OneToMany(mappedBy = "idFournisseur", fetch = FetchType.LAZY)
    private List<Livraison> livraisonList;

    public Fournisseur() {
    }

    public Fournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNiu() {
        return niu;
    }

    public void setNiu(String niu) {
        this.niu = niu;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    public Societe getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Societe idSociete) {
        this.idSociete = idSociete;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
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
        hash += (idFournisseur != null ? idFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idFournisseur == null && other.idFournisseur != null) || (this.idFournisseur != null && !this.idFournisseur.equals(other.idFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Fournisseur[ idFournisseur=" + idFournisseur + " ]";
    }
    
}
