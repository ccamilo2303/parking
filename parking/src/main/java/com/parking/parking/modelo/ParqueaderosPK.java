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

/**
 *
 * @author Camilo
 */
@Embeddable
public class ParqueaderosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parqueadero")
    private int idParqueadero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ParqueaderosPK() {
    }

    public ParqueaderosPK(int idParqueadero, int idUsuario) {
        this.idParqueadero = idParqueadero;
        this.idUsuario = idUsuario;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idParqueadero;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParqueaderosPK)) {
            return false;
        }
        ParqueaderosPK other = (ParqueaderosPK) object;
        if (this.idParqueadero != other.idParqueadero) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parking.parking.modelo.ParqueaderosPK[ idParqueadero=" + idParqueadero + ", idUsuario=" + idUsuario + " ]";
    }
    
}
