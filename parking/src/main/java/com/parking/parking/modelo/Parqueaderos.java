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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Parqueaderos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueaderos.findAll", query = "SELECT p FROM Parqueaderos p")
    , @NamedQuery(name = "Parqueaderos.findByIdParqueadero", query = "SELECT p FROM Parqueaderos p WHERE p.parqueaderosPK.idParqueadero = :idParqueadero")
    , @NamedQuery(name = "Parqueaderos.findByIdUsuario", query = "SELECT p FROM Parqueaderos p WHERE p.parqueaderosPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Parqueaderos.findByNombre", query = "SELECT p FROM Parqueaderos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Parqueaderos.findByDireccion", query = "SELECT p FROM Parqueaderos p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Parqueaderos.findByTelefono", query = "SELECT p FROM Parqueaderos p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Parqueaderos.findByEmail", query = "SELECT p FROM Parqueaderos p WHERE p.email = :email")})
public class Parqueaderos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParqueaderosPK parqueaderosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderos")
    private Collection<Espaciosparqueadero> espaciosparqueaderoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderos")
    private Collection<Facturacion> facturacionCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Parqueaderos() {
    }

    public Parqueaderos(ParqueaderosPK parqueaderosPK) {
        this.parqueaderosPK = parqueaderosPK;
    }

    public Parqueaderos(ParqueaderosPK parqueaderosPK, String nombre, String direccion, String telefono) {
        this.parqueaderosPK = parqueaderosPK;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Parqueaderos(int idParqueadero, int idUsuario) {
        this.parqueaderosPK = new ParqueaderosPK(idParqueadero, idUsuario);
    }

    public ParqueaderosPK getParqueaderosPK() {
        return parqueaderosPK;
    }

    public void setParqueaderosPK(ParqueaderosPK parqueaderosPK) {
        this.parqueaderosPK = parqueaderosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Espaciosparqueadero> getEspaciosparqueaderoCollection() {
        return espaciosparqueaderoCollection;
    }

    public void setEspaciosparqueaderoCollection(Collection<Espaciosparqueadero> espaciosparqueaderoCollection) {
        this.espaciosparqueaderoCollection = espaciosparqueaderoCollection;
    }

    @XmlTransient
    public Collection<Facturacion> getFacturacionCollection() {
        return facturacionCollection;
    }

    public void setFacturacionCollection(Collection<Facturacion> facturacionCollection) {
        this.facturacionCollection = facturacionCollection;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parqueaderosPK != null ? parqueaderosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueaderos)) {
            return false;
        }
        Parqueaderos other = (Parqueaderos) object;
        if ((this.parqueaderosPK == null && other.parqueaderosPK != null) || (this.parqueaderosPK != null && !this.parqueaderosPK.equals(other.parqueaderosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.Parqueaderos[ parqueaderosPK=" + parqueaderosPK + " ]";
    }
    
}
