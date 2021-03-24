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
@Table(name = "type_operation_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOperationStock.findAll", query = "SELECT t FROM TypeOperationStock t"),
    @NamedQuery(name = "TypeOperationStock.findByIdType", query = "SELECT t FROM TypeOperationStock t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeOperationStock.findByNom", query = "SELECT t FROM TypeOperationStock t WHERE t.nom = :nom")})
public class TypeOperationStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_type")
    private Integer idType;
    @Size(max = 254)
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType", fetch = FetchType.LAZY)
    private List<OperationStock> operationStockList;

    public TypeOperationStock() {
    }

    public TypeOperationStock(Integer idType) {
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
    public List<OperationStock> getOperationStockList() {
        return operationStockList;
    }

    public void setOperationStockList(List<OperationStock> operationStockList) {
        this.operationStockList = operationStockList;
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
        if (!(object instanceof TypeOperationStock)) {
            return false;
        }
        TypeOperationStock other = (TypeOperationStock) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.louisstark.gestock.entities.TypeOperationStock[ idType=" + idType + " ]";
    }
    
}
