/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gerald
 */
@Embeddable
public class TransportePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CONDUCTOR_DNI")
    private String conductorDni;
    @Basic(optional = false)
    @Column(name = "VEHICULO_PATENTE")
    private String vehiculoPatente;
    @Basic(optional = false)
    @Column(name = "SERVICIO_TRANSPORTE_ID")
    private short servicioTransporteId;

    public TransportePK() {
    }

    public TransportePK(String conductorDni, String vehiculoPatente, short servicioTransporteId) {
        this.conductorDni = conductorDni;
        this.vehiculoPatente = vehiculoPatente;
        this.servicioTransporteId = servicioTransporteId;
    }

    public String getConductorDni() {
        return conductorDni;
    }

    public void setConductorDni(String conductorDni) {
        this.conductorDni = conductorDni;
    }

    public String getVehiculoPatente() {
        return vehiculoPatente;
    }

    public void setVehiculoPatente(String vehiculoPatente) {
        this.vehiculoPatente = vehiculoPatente;
    }

    public short getServicioTransporteId() {
        return servicioTransporteId;
    }

    public void setServicioTransporteId(short servicioTransporteId) {
        this.servicioTransporteId = servicioTransporteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conductorDni != null ? conductorDni.hashCode() : 0);
        hash += (vehiculoPatente != null ? vehiculoPatente.hashCode() : 0);
        hash += (int) servicioTransporteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportePK)) {
            return false;
        }
        TransportePK other = (TransportePK) object;
        if ((this.conductorDni == null && other.conductorDni != null) || (this.conductorDni != null && !this.conductorDni.equals(other.conductorDni))) {
            return false;
        }
        if ((this.vehiculoPatente == null && other.vehiculoPatente != null) || (this.vehiculoPatente != null && !this.vehiculoPatente.equals(other.vehiculoPatente))) {
            return false;
        }
        if (this.servicioTransporteId != other.servicioTransporteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransportePK[ conductorDni=" + conductorDni + ", vehiculoPatente=" + vehiculoPatente + ", servicioTransporteId=" + servicioTransporteId + " ]";
    }
    
}
