/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parking.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Camilo
 */
@Embeddable
public class FacturacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parqueadero")
    private int idParqueadero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_vehiculo")
    private String idVehiculo;

    public FacturacionPK() {
    }

    public FacturacionPK(int idUsuario, int idParqueadero, String idVehiculo) {
        this.idUsuario = idUsuario;
        this.idParqueadero = idParqueadero;
        this.idVehiculo = idVehiculo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idParqueadero;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturacionPK)) {
            return false;
        }
        FacturacionPK other = (FacturacionPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idParqueadero != other.idParqueadero) {
            return false;
        }
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.FacturacionPK[ idUsuario=" + idUsuario + ", idParqueadero=" + idParqueadero + ", idVehiculo=" + idVehiculo + " ]";
    }
    
}
