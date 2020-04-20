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
public class ReservaTransportePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RESERVA_ID_RESERVA")
    private short reservaIdReserva;
    @Basic(optional = false)
    @Column(name = "SERVICIO_TRANSPORTE_ID")
    private short servicioTransporteId;

    public ReservaTransportePK() {
    }

    public ReservaTransportePK(short reservaIdReserva, short servicioTransporteId) {
        this.reservaIdReserva = reservaIdReserva;
        this.servicioTransporteId = servicioTransporteId;
    }

    public short getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(short reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
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
        hash += (int) reservaIdReserva;
        hash += (int) servicioTransporteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTransportePK)) {
            return false;
        }
        ReservaTransportePK other = (ReservaTransportePK) object;
        if (this.reservaIdReserva != other.reservaIdReserva) {
            return false;
        }
        if (this.servicioTransporteId != other.servicioTransporteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaTransportePK[ reservaIdReserva=" + reservaIdReserva + ", servicioTransporteId=" + servicioTransporteId + " ]";
    }
    
}
