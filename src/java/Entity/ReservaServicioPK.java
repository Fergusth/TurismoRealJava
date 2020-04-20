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
public class ReservaServicioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RESERVA_ID_RESERVA")
    private short reservaIdReserva;
    @Basic(optional = false)
    @Column(name = "SERVICIO_EXTRA_ID")
    private short servicioExtraId;

    public ReservaServicioPK() {
    }

    public ReservaServicioPK(short reservaIdReserva, short servicioExtraId) {
        this.reservaIdReserva = reservaIdReserva;
        this.servicioExtraId = servicioExtraId;
    }

    public short getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(short reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    public short getServicioExtraId() {
        return servicioExtraId;
    }

    public void setServicioExtraId(short servicioExtraId) {
        this.servicioExtraId = servicioExtraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reservaIdReserva;
        hash += (int) servicioExtraId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaServicioPK)) {
            return false;
        }
        ReservaServicioPK other = (ReservaServicioPK) object;
        if (this.reservaIdReserva != other.reservaIdReserva) {
            return false;
        }
        if (this.servicioExtraId != other.servicioExtraId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaServicioPK[ reservaIdReserva=" + reservaIdReserva + ", servicioExtraId=" + servicioExtraId + " ]";
    }
    
}
