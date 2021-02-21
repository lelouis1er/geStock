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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleprivilege.findAll", query = "SELECT r FROM Roleprivilege r"),
    @NamedQuery(name = "Roleprivilege.findByIdroleprivilege", query = "SELECT r FROM Roleprivilege r WHERE r.idroleprivilege = :idroleprivilege"),
    @NamedQuery(name = "Roleprivilege.findByCancreate", query = "SELECT r FROM Roleprivilege r WHERE r.cancreate = :cancreate"),
    @NamedQuery(name = "Roleprivilege.findByCanupdate", query = "SELECT r FROM Roleprivilege r WHERE r.canupdate = :canupdate"),
    @NamedQuery(name = "Roleprivilege.findByCandelete", query = "SELECT r FROM Roleprivilege r WHERE r.candelete = :candelete")})
public class Roleprivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idroleprivilege;
    private Boolean cancreate;
    private Boolean canupdate;
    private Boolean candelete;
    @JoinColumn(name = "idprivilege", referencedColumnName = "idprivilege")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Privilegesutilisateur idprivilege;
    @JoinColumn(name = "idrole", referencedColumnName = "idrole")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roleutilisateur idrole;

    public Roleprivilege() {
    }

    public Roleprivilege(Integer idroleprivilege) {
        this.idroleprivilege = idroleprivilege;
    }

    public Integer getIdroleprivilege() {
        return idroleprivilege;
    }

    public void setIdroleprivilege(Integer idroleprivilege) {
        this.idroleprivilege = idroleprivilege;
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

    public Roleutilisateur getIdrole() {
        return idrole;
    }

    public void setIdrole(Roleutilisateur idrole) {
        this.idrole = idrole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroleprivilege != null ? idroleprivilege.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleprivilege)) {
            return false;
        }
        Roleprivilege other = (Roleprivilege) object;
        if ((this.idroleprivilege == null && other.idroleprivilege != null) || (this.idroleprivilege != null && !this.idroleprivilege.equals(other.idroleprivilege))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.Roleprivilege[ idroleprivilege=" + idroleprivilege + " ]";
    }
    
}
