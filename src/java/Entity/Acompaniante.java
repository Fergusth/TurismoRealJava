/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "ACOMPANIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompaniante.findAll", query = "SELECT a FROM Acompaniante a"),
    @NamedQuery(name = "Acompaniante.findByDni", query = "SELECT a FROM Acompaniante a WHERE a.dni = :dni"),
    @NamedQuery(name = "Acompaniante.findByNombreCompleto", query = "SELECT a FROM Acompaniante a WHERE a.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Acompaniante.findByExtranjero", query = "SELECT a FROM Acompaniante a WHERE a.extranjero = :extranjero"),
    @NamedQuery(name = "Acompaniante.findByCorreo", query = "SELECT a FROM Acompaniante a WHERE a.correo = :correo"),
    @NamedQuery(name = "Acompaniante.findByTelefono", query = "SELECT a FROM Acompaniante a WHERE a.telefono = :telefono")})
public class Acompaniante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Basic(optional = false)
    @Column(name = "EXTRANJERO")
    private Character extranjero;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "TELEFONO")
    private Integer telefono;
    @JoinTable(name = "RESERVA_ACOMP", joinColumns = {
        @JoinColumn(name = "ACOMPANIANTE_DNI", referencedColumnName = "DNI")}, inverseJoinColumns = {
        @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA")})
    @ManyToMany
    private Collection<Reserva> reservaCollection;

    public Acompaniante() {
    }

    public Acompaniante(String dni) {
        this.dni = dni;
    }

    public Acompaniante(String dni, String nombreCompleto, Character extranjero) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.extranjero = extranjero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Character getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(Character extranjero) {
        this.extranjero = extranjero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompaniante)) {
            return false;
        }
        Acompaniante other = (Acompaniante) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Acompaniante[ dni=" + dni + " ]";
    }
    
}
