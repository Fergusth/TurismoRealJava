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
@Table(name = "SERVICIO_EXTRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioExtra.findAll", query = "SELECT s FROM ServicioExtra s"),
    @NamedQuery(name = "ServicioExtra.findById", query = "SELECT s FROM ServicioExtra s WHERE s.id = :id"),
    @NamedQuery(name = "ServicioExtra.findByNombreServicioEx", query = "SELECT s FROM ServicioExtra s WHERE s.nombreServicioEx = :nombreServicioEx"),
    @NamedQuery(name = "ServicioExtra.findByPrecioActual", query = "SELECT s FROM ServicioExtra s WHERE s.precioActual = :precioActual"),
    @NamedQuery(name = "ServicioExtra.findByActivado", query = "SELECT s FROM ServicioExtra s WHERE s.activado = :activado")})
public class ServicioExtra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SERVICIO_EX")
    private String nombreServicioEx;
    @Basic(optional = false)
    @Column(name = "PRECIO_ACTUAL")
    private int precioActual;
    @Basic(optional = false)
    @Column(name = "ACTIVADO")
    private Character activado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioExtra")
    private Collection<ReservaServicio> reservaServicioCollection;

    public ServicioExtra() {
    }

    public ServicioExtra(Short id) {
        this.id = id;
    }

    public ServicioExtra(Short id, String nombreServicioEx, int precioActual, Character activado) {
        this.id = id;
        this.nombreServicioEx = nombreServicioEx;
        this.precioActual = precioActual;
        this.activado = activado;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombreServicioEx() {
        return nombreServicioEx;
    }

    public void setNombreServicioEx(String nombreServicioEx) {
        this.nombreServicioEx = nombreServicioEx;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public Character getActivado() {
        return activado;
    }

    public void setActivado(Character activado) {
        this.activado = activado;
    }

    @XmlTransient
    public Collection<ReservaServicio> getReservaServicioCollection() {
        return reservaServicioCollection;
    }

    public void setReservaServicioCollection(Collection<ReservaServicio> reservaServicioCollection) {
        this.reservaServicioCollection = reservaServicioCollection;
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
        if (!(object instanceof ServicioExtra)) {
            return false;
        }
        ServicioExtra other = (ServicioExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ServicioExtra[ id=" + id + " ]";
    }
    
}
