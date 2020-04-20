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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findById", query = "SELECT d FROM Departamento d WHERE d.id = :id"),
    @NamedQuery(name = "Departamento.findByDireccion", query = "SELECT d FROM Departamento d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Departamento.findByCantBanios", query = "SELECT d FROM Departamento d WHERE d.cantBanios = :cantBanios"),
    @NamedQuery(name = "Departamento.findByCantDormitorios", query = "SELECT d FROM Departamento d WHERE d.cantDormitorios = :cantDormitorios"),
    @NamedQuery(name = "Departamento.findByPrecioDiario", query = "SELECT d FROM Departamento d WHERE d.precioDiario = :precioDiario"),
    @NamedQuery(name = "Departamento.findByDescripcion", query = "SELECT d FROM Departamento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Departamento.findByActivado", query = "SELECT d FROM Departamento d WHERE d.activado = :activado"),
    @NamedQuery(name = "Departamento.findByCondicionesUso", query = "SELECT d FROM Departamento d WHERE d.condicionesUso = :condicionesUso"),
    @NamedQuery(name = "Departamento.findByInternet", query = "SELECT d FROM Departamento d WHERE d.internet = :internet"),
    @NamedQuery(name = "Departamento.findByCalefaccion", query = "SELECT d FROM Departamento d WHERE d.calefaccion = :calefaccion"),
    @NamedQuery(name = "Departamento.findByPromMesDividendo", query = "SELECT d FROM Departamento d WHERE d.promMesDividendo = :promMesDividendo"),
    @NamedQuery(name = "Departamento.findByPromMesContribuciones", query = "SELECT d FROM Departamento d WHERE d.promMesContribuciones = :promMesContribuciones")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "CANT_BANIOS")
    private short cantBanios;
    @Basic(optional = false)
    @Column(name = "CANT_DORMITORIOS")
    private short cantDormitorios;
    @Basic(optional = false)
    @Column(name = "PRECIO_DIARIO")
    private int precioDiario;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ACTIVADO")
    private Character activado;
    @Column(name = "CONDICIONES_USO")
    private String condicionesUso;
    @Basic(optional = false)
    @Column(name = "INTERNET")
    private Character internet;
    @Basic(optional = false)
    @Column(name = "CALEFACCION")
    private Character calefaccion;
    @Basic(optional = false)
    @Column(name = "PROM_MES_DIVIDENDO")
    private long promMesDividendo;
    @Basic(optional = false)
    @Column(name = "PROM_MES_CONTRIBUCIONES")
    private long promMesContribuciones;
    @JoinTable(name = "RESERVA_DPTO", joinColumns = {
        @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA")})
    @ManyToMany
    private Collection<Reserva> reservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private Collection<FotoDept> fotoDeptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private Collection<Mantencion> mantencionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ciudad ciudadId;

    public Departamento() {
    }

    public Departamento(Short id) {
        this.id = id;
    }

    public Departamento(Short id, String direccion, short cantBanios, short cantDormitorios, int precioDiario, String descripcion, Character activado, Character internet, Character calefaccion, long promMesDividendo, long promMesContribuciones) {
        this.id = id;
        this.direccion = direccion;
        this.cantBanios = cantBanios;
        this.cantDormitorios = cantDormitorios;
        this.precioDiario = precioDiario;
        this.descripcion = descripcion;
        this.activado = activado;
        this.internet = internet;
        this.calefaccion = calefaccion;
        this.promMesDividendo = promMesDividendo;
        this.promMesContribuciones = promMesContribuciones;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public short getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(short cantBanios) {
        this.cantBanios = cantBanios;
    }

    public short getCantDormitorios() {
        return cantDormitorios;
    }

    public void setCantDormitorios(short cantDormitorios) {
        this.cantDormitorios = cantDormitorios;
    }

    public int getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(int precioDiario) {
        this.precioDiario = precioDiario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getActivado() {
        return activado;
    }

    public void setActivado(Character activado) {
        this.activado = activado;
    }

    public String getCondicionesUso() {
        return condicionesUso;
    }

    public void setCondicionesUso(String condicionesUso) {
        this.condicionesUso = condicionesUso;
    }

    public Character getInternet() {
        return internet;
    }

    public void setInternet(Character internet) {
        this.internet = internet;
    }

    public Character getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(Character calefaccion) {
        this.calefaccion = calefaccion;
    }

    public long getPromMesDividendo() {
        return promMesDividendo;
    }

    public void setPromMesDividendo(long promMesDividendo) {
        this.promMesDividendo = promMesDividendo;
    }

    public long getPromMesContribuciones() {
        return promMesContribuciones;
    }

    public void setPromMesContribuciones(long promMesContribuciones) {
        this.promMesContribuciones = promMesContribuciones;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<FotoDept> getFotoDeptCollection() {
        return fotoDeptCollection;
    }

    public void setFotoDeptCollection(Collection<FotoDept> fotoDeptCollection) {
        this.fotoDeptCollection = fotoDeptCollection;
    }

    @XmlTransient
    public Collection<Mantencion> getMantencionCollection() {
        return mantencionCollection;
    }

    public void setMantencionCollection(Collection<Mantencion> mantencionCollection) {
        this.mantencionCollection = mantencionCollection;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Departamento[ id=" + id + " ]";
    }
    
}
