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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Louis Stark
 */
@Entity
@Table(name = "role_employe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleEmploye.findAll", query = "SELECT r FROM RoleEmploye r"),
    @NamedQuery(name = "RoleEmploye.findByIdRoleEmploye", query = "SELECT r FROM RoleEmploye r WHERE r.idRoleEmploye = :idRoleEmploye"),
    @NamedQuery(name = "RoleEmploye.findByNom", query = "SELECT r FROM RoleEmploye r WHERE r.nom = :nom")})
public class RoleEmploye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_role_employe")
    private Integer idRoleEmploye;
    private Integer nom;
    @OneToMany(mappedBy = "idRoleEmploye", fetch = FetchType.LAZY)
    private List<Employes> employesList;

    public RoleEmploye() {
    }

    public RoleEmploye(Integer idRoleEmploye) {
        this.idRoleEmploye = idRoleEmploye;
    }

    public Integer getIdRoleEmploye() {
        return idRoleEmploye;
    }

    public void setIdRoleEmploye(Integer idRoleEmploye) {
        this.idRoleEmploye = idRoleEmploye;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Employes> getEmployesList() {
        return employesList;
    }

    public void setEmployesList(List<Employes> employesList) {
        this.employesList = employesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoleEmploye != null ? idRoleEmploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleEmploye)) {
            return false;
        }
        RoleEmploye other = (RoleEmploye) object;
        if ((this.idRoleEmploye == null && other.idRoleEmploye != null) || (this.idRoleEmploye != null && !this.idRoleEmploye.equals(other.idRoleEmploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.RoleEmploye[ idRoleEmploye=" + idRoleEmploye + " ]";
    }
    
}
