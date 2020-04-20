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
@Table(name = "RESERVA_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaServicio.findAll", query = "SELECT r FROM ReservaServicio r"),
    @NamedQuery(name = "ReservaServicio.findByPrecioContratado", query = "SELECT r FROM ReservaServicio r WHERE r.precioContratado = :precioContratado"),
    @NamedQuery(name = "ReservaServicio.findByReservaIdReserva", query = "SELECT r FROM ReservaServicio r WHERE r.reservaServicioPK.reservaIdReserva = :reservaIdReserva"),
    @NamedQuery(name = "ReservaServicio.findByServicioExtraId", query = "SELECT r FROM ReservaServicio r WHERE r.reservaServicioPK.servicioExtraId = :servicioExtraId")})
public class ReservaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaServicioPK reservaServicioPK;
    @Basic(optional = false)
    @Column(name = "PRECIO_CONTRATADO")
    private int precioContratado;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;
    @JoinColumn(name = "SERVICIO_EXTRA_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServicioExtra servicioExtra;

    public ReservaServicio() {
    }

    public ReservaServicio(ReservaServicioPK reservaServicioPK) {
        this.reservaServicioPK = reservaServicioPK;
    }

    public ReservaServicio(ReservaServicioPK reservaServicioPK, int precioContratado) {
        this.reservaServicioPK = reservaServicioPK;
        this.precioContratado = precioContratado;
    }

    public ReservaServicio(short reservaIdReserva, short servicioExtraId) {
        this.reservaServicioPK = new ReservaServicioPK(reservaIdReserva, servicioExtraId);
    }

    public ReservaServicioPK getReservaServicioPK() {
        return reservaServicioPK;
    }

    public void setReservaServicioPK(ReservaServicioPK reservaServicioPK) {
        this.reservaServicioPK = reservaServicioPK;
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

    public ServicioExtra getServicioExtra() {
        return servicioExtra;
    }

    public void setServicioExtra(ServicioExtra servicioExtra) {
        this.servicioExtra = servicioExtra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaServicioPK != null ? reservaServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaServicio)) {
            return false;
        }
        ReservaServicio other = (ReservaServicio) object;
        if ((this.reservaServicioPK == null && other.reservaServicioPK != null) || (this.reservaServicioPK != null && !this.reservaServicioPK.equals(other.reservaServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservaServicio[ reservaServicioPK=" + reservaServicioPK + " ]";
    }
    
}
