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
public class ReservaTourPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RESERVA_ID_RESERVA")
    private short reservaIdReserva;
    @Basic(optional = false)
    @Column(name = "SERVICIO_TOURS_ID_TOUR")
    private short servicioToursIdTour;

    public ReservaTourPK() {
    }

    public ReservaTourPK(short reservaIdReserva, short servicioToursIdTour) {
        this.reservaIdReserva = reservaIdReserva;
        this.servicioToursIdTour = servicioToursIdTour;
    }

    public short getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(short reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    public short getServicioToursIdTour() {
        return servicioToursIdTour;
    }

    public void setServicioToursIdTour(short servicioToursIdTour) {
        this.servicioToursIdTour = servicioToursIdTour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reservaIdReserva;
        hash += (int) servicioToursIdTour;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTourPK)) {
            return false;
        }
        ReservaTourPK other = (ReservaTourPK) object;
        if (this.reservaIdReserva != other.reservaIdReserva) {
            return false;
        }
        if (this.servicioToursIdTour != other.servicioToursIdTour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaTourPK[ reservaIdReserva=" + reservaIdReserva + ", servicioToursIdTour=" + servicioToursIdTour + " ]";
    }
    
}
