/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaCheckin", query = "SELECT r FROM Reserva r WHERE r.fechaCheckin = :fechaCheckin"),
    @NamedQuery(name = "Reserva.findByFechaCheckout", query = "SELECT r FROM Reserva r WHERE r.fechaCheckout = :fechaCheckout"),
    @NamedQuery(name = "Reserva.findByHoraCheckin", query = "SELECT r FROM Reserva r WHERE r.horaCheckin = :horaCheckin"),
    @NamedQuery(name = "Reserva.findByHoraCheckout", query = "SELECT r FROM Reserva r WHERE r.horaCheckout = :horaCheckout"),
    @NamedQuery(name = "Reserva.findByPrecioTotal", query = "SELECT r FROM Reserva r WHERE r.precioTotal = :precioTotal"),
    @NamedQuery(name = "Reserva.findByTotalPagado", query = "SELECT r FROM Reserva r WHERE r.totalPagado = :totalPagado"),
    @NamedQuery(name = "Reserva.findByEstado", query = "SELECT r FROM Reserva r WHERE r.estado = :estado"),
    @NamedQuery(name = "Reserva.findByFormaPago", query = "SELECT r FROM Reserva r WHERE r.formaPago = :formaPago")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVA")
    private Short idReserva;
    @Basic(optional = false)
    @Column(name = "FECHA_CHECKIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCheckin;
    @Basic(optional = false)
    @Column(name = "FECHA_CHECKOUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCheckout;
    @Basic(optional = false)
    @Column(name = "HORA_CHECKIN")
    private String horaCheckin;
    @Basic(optional = false)
    @Column(name = "HORA_CHECKOUT")
    private String horaCheckout;
    @Basic(optional = false)
    @Column(name = "PRECIO_TOTAL")
    private int precioTotal;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGADO")
    private int totalPagado;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @ManyToMany(mappedBy = "reservaCollection")
    private Collection<Departamento> departamentoCollection;
    @ManyToMany(mappedBy = "reservaCollection")
    private Collection<Acompaniante> acompanianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<Checklist> checklistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ReservaServicio> reservaServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ReservaTour> reservaTourCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaIdReserva")
    private Collection<Multa> multaCollection;
    @JoinColumn(name = "USUARIO_DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Usuario usuarioDni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ReservaTransporte> reservaTransporteCollection;

    public Reserva() {
    }

    public Reserva(Short idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Short idReserva, Date fechaCheckin, Date fechaCheckout, String horaCheckin, String horaCheckout, int precioTotal, int totalPagado, String estado) {
        this.idReserva = idReserva;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckout = fechaCheckout;
        this.horaCheckin = horaCheckin;
        this.horaCheckout = horaCheckout;
        this.precioTotal = precioTotal;
        this.totalPagado = totalPagado;
        this.estado = estado;
    }

    public Short getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Short idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(Date fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public Date getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(Date fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public String getHoraCheckin() {
        return horaCheckin;
    }

    public void setHoraCheckin(String horaCheckin) {
        this.horaCheckin = horaCheckin;
    }

    public String getHoraCheckout() {
        return horaCheckout;
    }

    public void setHoraCheckout(String horaCheckout) {
        this.horaCheckout = horaCheckout;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(int totalPagado) {
        this.totalPagado = totalPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }

    @XmlTransient
    public Collection<Acompaniante> getAcompanianteCollection() {
        return acompanianteCollection;
    }

    public void setAcompanianteCollection(Collection<Acompaniante> acompanianteCollection) {
        this.acompanianteCollection = acompanianteCollection;
    }

    @XmlTransient
    public Collection<Checklist> getChecklistCollection() {
        return checklistCollection;
    }

    public void setChecklistCollection(Collection<Checklist> checklistCollection) {
        this.checklistCollection = checklistCollection;
    }

    @XmlTransient
    public Collection<ReservaServicio> getReservaServicioCollection() {
        return reservaServicioCollection;
    }

    public void setReservaServicioCollection(Collection<ReservaServicio> reservaServicioCollection) {
        this.reservaServicioCollection = reservaServicioCollection;
    }

    @XmlTransient
    public Collection<ReservaTour> getReservaTourCollection() {
        return reservaTourCollection;
    }

    public void setReservaTourCollection(Collection<ReservaTour> reservaTourCollection) {
        this.reservaTourCollection = reservaTourCollection;
    }

    @XmlTransient
    public Collection<Multa> getMultaCollection() {
        return multaCollection;
    }

    public void setMultaCollection(Collection<Multa> multaCollection) {
        this.multaCollection = multaCollection;
    }

    public Usuario getUsuarioDni() {
        return usuarioDni;
    }

    public void setUsuarioDni(Usuario usuarioDni) {
        this.usuarioDni = usuarioDni;
    }

    @XmlTransient
    public Collection<ReservaTransporte> getReservaTransporteCollection() {
        return reservaTransporteCollection;
    }

    public void setReservaTransporteCollection(Collection<ReservaTransporte> reservaTransporteCollection) {
        this.reservaTransporteCollection = reservaTransporteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
