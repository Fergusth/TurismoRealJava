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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MANTENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantencion.findAll", query = "SELECT m FROM Mantencion m"),
    @NamedQuery(name = "Mantencion.findByIdMantencion", query = "SELECT m FROM Mantencion m WHERE m.idMantencion = :idMantencion"),
    @NamedQuery(name = "Mantencion.findByFechaInicio", query = "SELECT m FROM Mantencion m WHERE m.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Mantencion.findByFechaTermino", query = "SELECT m FROM Mantencion m WHERE m.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Mantencion.findByCosto", query = "SELECT m FROM Mantencion m WHERE m.costo = :costo"),
    @NamedQuery(name = "Mantencion.findByDescripcion", query = "SELECT m FROM Mantencion m WHERE m.descripcion = :descripcion")})
public class Mantencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MANTENCION")
    private Short idMantencion;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private int costo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento departamentoId;

    public Mantencion() {
    }

    public Mantencion(Short idMantencion) {
        this.idMantencion = idMantencion;
    }

    public Mantencion(Short idMantencion, Date fechaInicio, Date fechaTermino, int costo, String descripcion) {
        this.idMantencion = idMantencion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public Short getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(Short idMantencion) {
        this.idMantencion = idMantencion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamento departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantencion != null ? idMantencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantencion)) {
            return false;
        }
        Mantencion other = (Mantencion) object;
        if ((this.idMantencion == null && other.idMantencion != null) || (this.idMantencion != null && !this.idMantencion.equals(other.idMantencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Mantencion[ idMantencion=" + idMantencion + " ]";
    }
    
}
