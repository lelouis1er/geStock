/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restrictionprivilege.findAll", query = "SELECT r FROM Restrictionprivilege r"),
    @NamedQuery(name = "Restrictionprivilege.findByIdrestriction", query = "SELECT r FROM Restrictionprivilege r WHERE r.idrestriction = :idrestriction"),
    @NamedQuery(name = "Restrictionprivilege.findByRestrictup", query = "SELECT r FROM Restrictionprivilege r WHERE r.restrictup = :restrictup"),
    @NamedQuery(name = "Restrictionprivilege.findByCancreate", query = "SELECT r FROM Restrictionprivilege r WHERE r.cancreate = :cancreate"),
    @NamedQuery(name = "Restrictionprivilege.findByCanupdate", query = "SELECT r FROM Restrictionprivilege r WHERE r.canupdate = :canupdate"),
    @NamedQuery(name = "Restrictionprivilege.findByCandelete", query = "SELECT r FROM Restrictionprivilege r WHERE r.candelete = :candelete")})
public class Restrictionprivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idrestriction;
    private Boolean restrictup;
    private Boolean cancreate;
    private Boolean canupdate;
    private Boolean candelete;
    @JoinColumn(name = "idprivilege", referencedColumnName = "idprivilege")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Privilegesutilisateur idprivilege;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilisateur idutilisateur;

    public Restrictionprivilege() {
    }

    public Restrictionprivilege(Integer idrestriction) {
        this.idrestriction = idrestriction;
    }

    public Integer getIdrestriction() {
        return idrestriction;
    }

    public void setIdrestriction(Integer idrestriction) {
        this.idrestriction = idrestriction;
    }

    public Boolean getRestrictup() {
        return restrictup;
    }

    public void setRestrictup(Boolean restrictup) {
        this.restrictup = restrictup;
    }

    public Boolean getCancreate() {
        return cancreate;
    }

    public void setCancreate(Boolean cancreate) {
        this.cancreate = cancreate;
    }

    public Boolean getCanupdate() {
        return canupdate;
    }

    public void setCanupdate(Boolean canupdate) {
        this.canupdate = canupdate;
    }

    public Boolean getCandelete() {
        return candelete;
    }

    public void setCandelete(Boolean candelete) {
        this.candelete = candelete;
    }

    public Privilegesutilisateur getIdprivilege() {
        return idprivilege;
    }

    public void setIdprivilege(Privilegesutilisateur idprivilege) {
        this.idprivilege = idprivilege;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrestriction != null ? idrestriction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restrictionprivilege)) {
            return false;
        }
        Restrictionprivilege other = (Restrictionprivilege) object;
        if ((this.idrestriction == null && other.idrestriction != null) || (this.idrestriction != null && !this.idrestriction.equals(other.idrestriction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Restrictionprivilege[ idrestriction=" + idrestriction + " ]";
    }
    
}
