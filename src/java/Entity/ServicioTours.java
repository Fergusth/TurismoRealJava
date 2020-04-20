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
@Table(name = "SERVICIO_TOURS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioTours.findAll", query = "SELECT s FROM ServicioTours s"),
    @NamedQuery(name = "ServicioTours.findByIdTour", query = "SELECT s FROM ServicioTours s WHERE s.idTour = :idTour"),
    @NamedQuery(name = "ServicioTours.findByHoraLlegada", query = "SELECT s FROM ServicioTours s WHERE s.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "ServicioTours.findByHoraSalida", query = "SELECT s FROM ServicioTours s WHERE s.horaSalida = :horaSalida"),
    @NamedQuery(name = "ServicioTours.findByPrecioActual", query = "SELECT s FROM ServicioTours s WHERE s.precioActual = :precioActual"),
    @NamedQuery(name = "ServicioTours.findByDisponible", query = "SELECT s FROM ServicioTours s WHERE s.disponible = :disponible"),
    @NamedQuery(name = "ServicioTours.findByMesTempDesde", query = "SELECT s FROM ServicioTours s WHERE s.mesTempDesde = :mesTempDesde"),
    @NamedQuery(name = "ServicioTours.findByMesTempHasta", query = "SELECT s FROM ServicioTours s WHERE s.mesTempHasta = :mesTempHasta"),
    @NamedQuery(name = "ServicioTours.findByFecha", query = "SELECT s FROM ServicioTours s WHERE s.fecha = :fecha")})
public class ServicioTours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TOUR")
    private Short idTour;
    @Basic(optional = false)
    @Column(name = "HORA_LLEGADA")
    private String horaLlegada;
    @Basic(optional = false)
    @Column(name = "HORA_SALIDA")
    private String horaSalida;
    @Basic(optional = false)
    @Column(name = "PRECIO_ACTUAL")
    private int precioActual;
    @Basic(optional = false)
    @Column(name = "DISPONIBLE")
    private Character disponible;
    @Column(name = "MES_TEMP_DESDE")
    private Short mesTempDesde;
    @Column(name = "MES_TEMP_HASTA")
    private Short mesTempHasta;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ZONA_TOUR_ID_ZONA", referencedColumnName = "ID_ZONA")
    @ManyToOne(optional = false)
    private ZonaTour zonaTourIdZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioTours")
    private Collection<ReservaTour> reservaTourCollection;

    public ServicioTours() {
    }

    public ServicioTours(Short idTour) {
        this.idTour = idTour;
    }

    public ServicioTours(Short idTour, String horaLlegada, String horaSalida, int precioActual, Character disponible, Date fecha) {
        this.idTour = idTour;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.precioActual = precioActual;
        this.disponible = disponible;
        this.fecha = fecha;
    }

    public Short getIdTour() {
        return idTour;
    }

    public void setIdTour(Short idTour) {
        this.idTour = idTour;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public Character getDisponible() {
        return disponible;
    }

    public void setDisponible(Character disponible) {
        this.disponible = disponible;
    }

    public Short getMesTempDesde() {
        return mesTempDesde;
    }

    public void setMesTempDesde(Short mesTempDesde) {
        this.mesTempDesde = mesTempDesde;
    }

    public Short getMesTempHasta() {
        return mesTempHasta;
    }

    public void setMesTempHasta(Short mesTempHasta) {
        this.mesTempHasta = mesTempHasta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ZonaTour getZonaTourIdZona() {
        return zonaTourIdZona;
    }

    public void setZonaTourIdZona(ZonaTour zonaTourIdZona) {
        this.zonaTourIdZona = zonaTourIdZona;
    }

    @XmlTransient
    public Collection<ReservaTour> getReservaTourCollection() {
        return reservaTourCollection;
    }

    public void setReservaTourCollection(Collection<ReservaTour> reservaTourCollection) {
        this.reservaTourCollection = reservaTourCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTour != null ? idTour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioTours)) {
            return false;
        }
        ServicioTours other = (ServicioTours) object;
        if ((this.idTour == null && other.idTour != null) || (this.idTour != null && !this.idTour.equals(other.idTour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ServicioTours[ idTour=" + idTour + " ]";
    }
    
}
