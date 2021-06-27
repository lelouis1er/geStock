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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PACO PC
 */
@Entity
@Table(name = "type_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeClient.findAll", query = "SELECT t FROM TypeClient t"),
    @NamedQuery(name = "TypeClient.findByIdType", query = "SELECT t FROM TypeClient t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeClient.findByNom", query = "SELECT t FROM TypeClient t WHERE t.nom = :nom")})
public class TypeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_type")
    private Integer idType;
    @Size(max = 254)
    private String nom;
    @OneToMany(mappedBy = "idType", fetch = FetchType.LAZY)
    private List<Client> clientList;

    public TypeClient() {
    }

    public TypeClient(Integer idType) {
        this.idType = idType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeClient)) {
            return false;
        }
        TypeClient other = (TypeClient) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.TypeClient[ idType=" + idType + " ]";
    }
    
}
