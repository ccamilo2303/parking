/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parking.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camilo
 */
@Entity
@Table(name = "Espacios_parqueadero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espaciosparqueadero.findAll", query = "SELECT e FROM Espaciosparqueadero e")
    , @NamedQuery(name = "Espaciosparqueadero.findByIdEspacio", query = "SELECT e FROM Espaciosparqueadero e WHERE e.idEspacio = :idEspacio")
    , @NamedQuery(name = "Espaciosparqueadero.findByFechaIngreso", query = "SELECT e FROM Espaciosparqueadero e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Espaciosparqueadero.findByFechaSalida", query = "SELECT e FROM Espaciosparqueadero e WHERE e.fechaSalida = :fechaSalida")})
public class Espaciosparqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_espacio")
    private Integer idEspacio;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIME)
    private Date fechaIngreso;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIME)
    private Date fechaSalida;
    @JoinTable(name = "Espacios_Vehiculo", joinColumns = {
        @JoinColumn(name = "id_espacio", referencedColumnName = "id_espacio")}, inverseJoinColumns = {
        @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")})
    @ManyToMany
    private Collection<Vehiculos> vehiculosCollection;
    @JoinColumns({
        @JoinColumn(name = "id_parqueadero", referencedColumnName = "id_parqueadero")
        , @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private Parqueaderos parqueaderos;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tiposvehiculo idTipo;

    public Espaciosparqueadero() {
    }

    public Espaciosparqueadero(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }

    public Integer getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public Collection<Vehiculos> getVehiculosCollection() {
        return vehiculosCollection;
    }

    public void setVehiculosCollection(Collection<Vehiculos> vehiculosCollection) {
        this.vehiculosCollection = vehiculosCollection;
    }

    public Parqueaderos getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(Parqueaderos parqueaderos) {
        this.parqueaderos = parqueaderos;
    }

    public Tiposvehiculo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tiposvehiculo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspacio != null ? idEspacio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espaciosparqueadero)) {
            return false;
        }
        Espaciosparqueadero other = (Espaciosparqueadero) object;
        if ((this.idEspacio == null && other.idEspacio != null) || (this.idEspacio != null && !this.idEspacio.equals(other.idEspacio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.Espaciosparqueadero[ idEspacio=" + idEspacio + " ]";
    }
    
}
