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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ZONA_TOUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaTour.findAll", query = "SELECT z FROM ZonaTour z"),
    @NamedQuery(name = "ZonaTour.findByIdZona", query = "SELECT z FROM ZonaTour z WHERE z.idZona = :idZona"),
    @NamedQuery(name = "ZonaTour.findByNombreZona", query = "SELECT z FROM ZonaTour z WHERE z.nombreZona = :nombreZona")})
public class ZonaTour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ZONA")
    private Short idZona;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ZONA")
    private String nombreZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaTourIdZona")
    private Collection<ServicioTours> servicioToursCollection;
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ciudad ciudadId;

    public ZonaTour() {
    }

    public ZonaTour(Short idZona) {
        this.idZona = idZona;
    }

    public ZonaTour(Short idZona, String nombreZona) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
    }

    public Short getIdZona() {
        return idZona;
    }

    public void setIdZona(Short idZona) {
        this.idZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    @XmlTransient
    public Collection<ServicioTours> getServicioToursCollection() {
        return servicioToursCollection;
    }

    public void setServicioToursCollection(Collection<ServicioTours> servicioToursCollection) {
        this.servicioToursCollection = servicioToursCollection;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaTour)) {
            return false;
        }
        ZonaTour other = (ZonaTour) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ZonaTour[ idZona=" + idZona + " ]";
    }
    
}
