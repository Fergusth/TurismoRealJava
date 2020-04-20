/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByFecha", query = "SELECT t FROM Transporte t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Transporte.findByConductorDni", query = "SELECT t FROM Transporte t WHERE t.transportePK.conductorDni = :conductorDni"),
    @NamedQuery(name = "Transporte.findByVehiculoPatente", query = "SELECT t FROM Transporte t WHERE t.transportePK.vehiculoPatente = :vehiculoPatente"),
    @NamedQuery(name = "Transporte.findByServicioTransporteId", query = "SELECT t FROM Transporte t WHERE t.transportePK.servicioTransporteId = :servicioTransporteId")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransportePK transportePK;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "CONDUCTOR_DNI", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Conductor conductor;
    @JoinColumn(name = "SERVICIO_TRANSPORTE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServicioTransporte servicioTransporte;
    @JoinColumn(name = "VEHICULO_PATENTE", referencedColumnName = "PATENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehiculo vehiculo;

    public Transporte() {
    }

    public Transporte(TransportePK transportePK) {
        this.transportePK = transportePK;
    }

    public Transporte(TransportePK transportePK, Date fecha) {
        this.transportePK = transportePK;
        this.fecha = fecha;
    }

    public Transporte(String conductorDni, String vehiculoPatente, short servicioTransporteId) {
        this.transportePK = new TransportePK(conductorDni, vehiculoPatente, servicioTransporteId);
    }

    public TransportePK getTransportePK() {
        return transportePK;
    }

    public void setTransportePK(TransportePK transportePK) {
        this.transportePK = transportePK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public ServicioTransporte getServicioTransporte() {
        return servicioTransporte;
    }

    public void setServicioTransporte(ServicioTransporte servicioTransporte) {
        this.servicioTransporte = servicioTransporte;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transportePK != null ? transportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.transportePK == null && other.transportePK != null) || (this.transportePK != null && !this.transportePK.equals(other.transportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Transporte[ transportePK=" + transportePK + " ]";
    }
    
}
