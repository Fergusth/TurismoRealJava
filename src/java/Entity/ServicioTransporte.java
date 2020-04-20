/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "SERVICIO_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioTransporte.findAll", query = "SELECT s FROM ServicioTransporte s"),
    @NamedQuery(name = "ServicioTransporte.findById", query = "SELECT s FROM ServicioTransporte s WHERE s.id = :id"),
    @NamedQuery(name = "ServicioTransporte.findByLugar", query = "SELECT s FROM ServicioTransporte s WHERE s.lugar = :lugar"),
    @NamedQuery(name = "ServicioTransporte.findByHoraComienzo", query = "SELECT s FROM ServicioTransporte s WHERE s.horaComienzo = :horaComienzo"),
    @NamedQuery(name = "ServicioTransporte.findByHoraTermino", query = "SELECT s FROM ServicioTransporte s WHERE s.horaTermino = :horaTermino"),
    @NamedQuery(name = "ServicioTransporte.findByPrecioActual", query = "SELECT s FROM ServicioTransporte s WHERE s.precioActual = :precioActual")})
public class ServicioTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "LUGAR")
    private String lugar;
    @Basic(optional = false)
    @Column(name = "HORA_COMIENZO")
    private String horaComienzo;
    @Basic(optional = false)
    @Column(name = "HORA_TERMINO")
    private String horaTermino;
    @Basic(optional = false)
    @Column(name = "PRECIO_ACTUAL")
    private int precioActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioTransporte")
    private Collection<Transporte> transporteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioTransporte")
    private Collection<ReservaTransporte> reservaTransporteCollection;

    public ServicioTransporte() {
    }

    public ServicioTransporte(Short id) {
        this.id = id;
    }

    public ServicioTransporte(Short id, String lugar, String horaComienzo, String horaTermino, int precioActual) {
        this.id = id;
        this.lugar = lugar;
        this.horaComienzo = horaComienzo;
        this.horaTermino = horaTermino;
        this.precioActual = precioActual;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(String horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    @XmlTransient
    public Collection<Transporte> getTransporteCollection() {
        return transporteCollection;
    }

    public void setTransporteCollection(Collection<Transporte> transporteCollection) {
        this.transporteCollection = transporteCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioTransporte)) {
            return false;
        }
        ServicioTransporte other = (ServicioTransporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ServicioTransporte[ id=" + id + " ]";
    }
    
}
