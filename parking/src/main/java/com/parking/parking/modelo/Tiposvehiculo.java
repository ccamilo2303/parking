/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parking.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Camilo
 */
@Entity
@Table(name = "Tipos_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposvehiculo.findAll", query = "SELECT t FROM Tiposvehiculo t")
    , @NamedQuery(name = "Tiposvehiculo.findByIdTipo", query = "SELECT t FROM Tiposvehiculo t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "Tiposvehiculo.findByDescripcion", query = "SELECT t FROM Tiposvehiculo t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tiposvehiculo.findByTarifaXMinuto", query = "SELECT t FROM Tiposvehiculo t WHERE t.tarifaXMinuto = :tarifaXMinuto")})
public class Tiposvehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tarifa_x_minuto")
    private Integer tarifaXMinuto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<Espaciosparqueadero> espaciosparqueaderoCollection;

    public Tiposvehiculo() {
    }

    public Tiposvehiculo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Tiposvehiculo(Integer idTipo, String descripcion) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTarifaXMinuto() {
        return tarifaXMinuto;
    }

    public void setTarifaXMinuto(Integer tarifaXMinuto) {
        this.tarifaXMinuto = tarifaXMinuto;
    }

    @XmlTransient
    public Collection<Espaciosparqueadero> getEspaciosparqueaderoCollection() {
        return espaciosparqueaderoCollection;
    }

    public void setEspaciosparqueaderoCollection(Collection<Espaciosparqueadero> espaciosparqueaderoCollection) {
        this.espaciosparqueaderoCollection = espaciosparqueaderoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposvehiculo)) {
            return false;
        }
        Tiposvehiculo other = (Tiposvehiculo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.Tiposvehiculo[ idTipo=" + idTipo + " ]";
    }
    
}
