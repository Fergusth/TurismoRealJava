/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "RESERVA_TOUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaTour.findAll", query = "SELECT r FROM ReservaTour r"),
    @NamedQuery(name = "ReservaTour.findByPrecioContratado", query = "SELECT r FROM ReservaTour r WHERE r.precioContratado = :precioContratado"),
    @NamedQuery(name = "ReservaTour.findByReservaIdReserva", query = "SELECT r FROM ReservaTour r WHERE r.reservaTourPK.reservaIdReserva = :reservaIdReserva"),
    @NamedQuery(name = "ReservaTour.findByServicioToursIdTour", query = "SELECT r FROM ReservaTour r WHERE r.reservaTourPK.servicioToursIdTour = :servicioToursIdTour"),
    @NamedQuery(name = "ReservaTour.findByEstado", query = "SELECT r FROM ReservaTour r WHERE r.estado = :estado")})
public class ReservaTour implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaTourPK reservaTourPK;
    @Basic(optional = false)
    @Column(name = "PRECIO_CONTRATADO")
    private int precioContratado;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;
    @JoinColumn(name = "SERVICIO_TOURS_ID_TOUR", referencedColumnName = "ID_TOUR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServicioTours servicioTours;

    public ReservaTour() {
    }

    public ReservaTour(ReservaTourPK reservaTourPK) {
        this.reservaTourPK = reservaTourPK;
    }

    public ReservaTour(ReservaTourPK reservaTourPK, int precioContratado, String estado) {
        this.reservaTourPK = reservaTourPK;
        this.precioContratado = precioContratado;
        this.estado = estado;
    }

    public ReservaTour(short reservaIdReserva, short servicioToursIdTour) {
        this.reservaTourPK = new ReservaTourPK(reservaIdReserva, servicioToursIdTour);
    }

    public ReservaTourPK getReservaTourPK() {
        return reservaTourPK;
    }

    public void setReservaTourPK(ReservaTourPK reservaTourPK) {
        this.reservaTourPK = reservaTourPK;
    }

    public int getPrecioContratado() {
        return precioContratado;
    }

    public void setPrecioContratado(int precioContratado) {
        this.precioContratado = precioContratado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ServicioTours getServicioTours() {
        return servicioTours;
    }

    public void setServicioTours(ServicioTours servicioTours) {
        this.servicioTours = servicioTours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaTourPK != null ? reservaTourPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTour)) {
            return false;
        }
        ReservaTour other = (ReservaTour) object;
        if ((this.reservaTourPK == null && other.reservaTourPK != null) || (this.reservaTourPK != null && !this.reservaTourPK.equals(other.reservaTourPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaTour[ reservaTourPK=" + reservaTourPK + " ]";
    }
    
}
