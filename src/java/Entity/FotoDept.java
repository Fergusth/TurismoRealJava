/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerald
 */
@Entity
@Table(name = "FOTO_DEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotoDept.findAll", query = "SELECT f FROM FotoDept f"),
    @NamedQuery(name = "FotoDept.findById", query = "SELECT f FROM FotoDept f WHERE f.id = :id"),
    @NamedQuery(name = "FotoDept.findByFoto", query = "SELECT f FROM FotoDept f WHERE f.foto = :foto")})
public class FotoDept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "FOTO")
    private String foto;
    @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento departamentoId;

    public FotoDept() {
    }

    public FotoDept(Short id) {
        this.id = id;
    }

    public FotoDept(Short id, String foto) {
        this.id = id;
        this.foto = foto;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoDept)) {
            return false;
        }
        FotoDept other = (FotoDept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FotoDept[ id=" + id + " ]";
    }
    
}
