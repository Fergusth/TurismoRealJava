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
@Table(name = "RESERVA_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaTransporte.findAll", query = "SELECT r FROM ReservaTransporte r"),
    @NamedQuery(name = "ReservaTransporte.findByPrecioContratado", query = "SELECT r FROM ReservaTransporte r WHERE r.precioContratado = :precioContratado"),
    @NamedQuery(name = "ReservaTransporte.findByReservaIdReserva", query = "SELECT r FROM ReservaTransporte r WHERE r.reservaTransportePK.reservaIdReserva = :reservaIdReserva"),
    @NamedQuery(name = "ReservaTransporte.findByServicioTransporteId", query = "SELECT r FROM ReservaTransporte r WHERE r.reservaTransportePK.servicioTransporteId = :servicioTransporteId")})
public class ReservaTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaTransportePK reservaTransportePK;
    @Basic(optional = false)
    @Column(name = "PRECIO_CONTRATADO")
    private int precioContratado;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;
    @JoinColumn(name = "SERVICIO_TRANSPORTE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServicioTransporte servicioTransporte;

    public ReservaTransporte() {
    }

    public ReservaTransporte(ReservaTransportePK reservaTransportePK) {
        this.reservaTransportePK = reservaTransportePK;
    }

    public ReservaTransporte(ReservaTransportePK reservaTransportePK, int precioContratado) {
        this.reservaTransportePK = reservaTransportePK;
        this.precioContratado = precioContratado;
    }

    public ReservaTransporte(short reservaIdReserva, short servicioTransporteId) {
        this.reservaTransportePK = new ReservaTransportePK(reservaIdReserva, servicioTransporteId);
    }

    public ReservaTransportePK getReservaTransportePK() {
        return reservaTransportePK;
    }

    public void setReservaTransportePK(ReservaTransportePK reservaTransportePK) {
        this.reservaTransportePK = reservaTransportePK;
    }

    public int getPrecioContratado() {
        return precioContratado;
    }

    public void setPrecioContratado(int precioContratado) {
        this.precioContratado = precioContratado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ServicioTransporte getServicioTransporte() {
        return servicioTransporte;
    }

    public void setServicioTransporte(ServicioTransporte servicioTransporte) {
        this.servicioTransporte = servicioTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaTransportePK != null ? reservaTransportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTransporte)) {
            return false;
        }
        ReservaTransporte other = (ReservaTransporte) object;
        if ((this.reservaTransportePK == null && other.reservaTransportePK != null) || (this.reservaTransportePK != null && !this.reservaTransportePK.equals(other.reservaTransportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaTransporte[ reservaTransportePK=" + reservaTransportePK + " ]";
    }
    
}
