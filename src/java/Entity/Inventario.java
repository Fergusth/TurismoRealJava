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
@Table(name = "INVENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdInv", query = "SELECT i FROM Inventario i WHERE i.idInv = :idInv"),
    @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inventario.findByPrecio", query = "SELECT i FROM Inventario i WHERE i.precio = :precio"),
    @NamedQuery(name = "Inventario.findByImportante", query = "SELECT i FROM Inventario i WHERE i.importante = :importante"),
    @NamedQuery(name = "Inventario.findByEstado", query = "SELECT i FROM Inventario i WHERE i.estado = :estado"),
    @NamedQuery(name = "Inventario.findByActivado", query = "SELECT i FROM Inventario i WHERE i.activado = :activado")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INV")
    private String idInv;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @Column(name = "IMPORTANTE")
    private Character importante;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "ACTIVADO")
    private Character activado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private Collection<Checklist> checklistCollection;
    @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento departamentoId;

    public Inventario() {
    }

    public Inventario(String idInv) {
        this.idInv = idInv;
    }

    public Inventario(String idInv, String nombre, int precio, Character importante, String estado, Character activado) {
        this.idInv = idInv;
        this.nombre = nombre;
        this.precio = precio;
        this.importante = importante;
        this.estado = estado;
        this.activado = activado;
    }

    public String getIdInv() {
        return idInv;
    }

    public void setIdInv(String idInv) {
        this.idInv = idInv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Character getImportante() {
        return importante;
    }

    public void setImportante(Character importante) {
        this.importante = importante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Character getActivado() {
        return activado;
    }

    public void setActivado(Character activado) {
        this.activado = activado;
    }

    @XmlTransient
    public Collection<Checklist> getChecklistCollection() {
        return checklistCollection;
    }

    public void setChecklistCollection(Collection<Checklist> checklistCollection) {
        this.checklistCollection = checklistCollection;
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
        hash += (idInv != null ? idInv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idInv == null && other.idInv != null) || (this.idInv != null && !this.idInv.equals(other.idInv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Inventario[ idInv=" + idInv + " ]";
    }
    
}
