/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parking.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo
 */
@Entity
@Table(name = "Facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacion.findAll", query = "SELECT f FROM Facturacion f")
    , @NamedQuery(name = "Facturacion.findByIdUsuario", query = "SELECT f FROM Facturacion f WHERE f.facturacionPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Facturacion.findByIdParqueadero", query = "SELECT f FROM Facturacion f WHERE f.facturacionPK.idParqueadero = :idParqueadero")
    , @NamedQuery(name = "Facturacion.findByIdVehiculo", query = "SELECT f FROM Facturacion f WHERE f.facturacionPK.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Facturacion.findByFechaInicio", query = "SELECT f FROM Facturacion f WHERE f.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Facturacion.findByFechaSalida", query = "SELECT f FROM Facturacion f WHERE f.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Facturacion.findByValorNeto", query = "SELECT f FROM Facturacion f WHERE f.valorNeto = :valorNeto")
    , @NamedQuery(name = "Facturacion.findByValorIva", query = "SELECT f FROM Facturacion f WHERE f.valorIva = :valorIva")
    , @NamedQuery(name = "Facturacion.findByValorTotal", query = "SELECT f FROM Facturacion f WHERE f.valorTotal = :valorTotal")
    , @NamedQuery(name = "Facturacion.findByFechaSistema", query = "SELECT f FROM Facturacion f WHERE f.fechaSistema = :fechaSistema")})
public class Facturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturacionPK facturacionPK;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIME)
    private Date fechaInicio;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIME)
    private Date fechaSalida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_neto")
    private BigDecimal valorNeto;
    @Column(name = "valor_iva")
    private BigDecimal valorIva;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "fecha_sistema")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSistema;
    @JoinColumns({
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
        , @JoinColumn(name = "id_parqueadero", referencedColumnName = "id_parqueadero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Parqueaderos parqueaderos;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehiculos vehiculos;

    public Facturacion() {
    }

    public Facturacion(FacturacionPK facturacionPK) {
        this.facturacionPK = facturacionPK;
    }

    public Facturacion(int idUsuario, int idParqueadero, String idVehiculo) {
        this.facturacionPK = new FacturacionPK(idUsuario, idParqueadero, idVehiculo);
    }

    public FacturacionPK getFacturacionPK() {
        return facturacionPK;
    }

    public void setFacturacionPK(FacturacionPK facturacionPK) {
        this.facturacionPK = facturacionPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(BigDecimal valorNeto) {
        this.valorNeto = valorNeto;
    }

    public BigDecimal getValorIva() {
        return valorIva;
    }

    public void setValorIva(BigDecimal valorIva) {
        this.valorIva = valorIva;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public Parqueaderos getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(Parqueaderos parqueaderos) {
        this.parqueaderos = parqueaderos;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturacionPK != null ? facturacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacion)) {
            return false;
        }
        Facturacion other = (Facturacion) object;
        if ((this.facturacionPK == null && other.facturacionPK != null) || (this.facturacionPK != null && !this.facturacionPK.equals(other.facturacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.Facturacion[ facturacionPK=" + facturacionPK + " ]";
    }
    
}
