/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CHECKLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklist.findAll", query = "SELECT c FROM Checklist c"),
    @NamedQuery(name = "Checklist.findByEstadoEntrega", query = "SELECT c FROM Checklist c WHERE c.estadoEntrega = :estadoEntrega"),
    @NamedQuery(name = "Checklist.findByEstadoDevuelto", query = "SELECT c FROM Checklist c WHERE c.estadoDevuelto = :estadoDevuelto"),
    @NamedQuery(name = "Checklist.findByDescripcion", query = "SELECT c FROM Checklist c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Checklist.findByInventarioIdInv", query = "SELECT c FROM Checklist c WHERE c.checklistPK.inventarioIdInv = :inventarioIdInv"),
    @NamedQuery(name = "Checklist.findByReservaIdReserva", query = "SELECT c FROM Checklist c WHERE c.checklistPK.reservaIdReserva = :reservaIdReserva")})
public class Checklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChecklistPK checklistPK;
    @Basic(optional = false)
    @Column(name = "ESTADO_ENTREGA")
    private String estadoEntrega;
    @Basic(optional = false)
    @Column(name = "ESTADO_DEVUELTO")
    private String estadoDevuelto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "INVENTARIO_ID_INV", referencedColumnName = "ID_INV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inventario inventario;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;

    public Checklist() {
    }

    public Checklist(ChecklistPK checklistPK) {
        this.checklistPK = checklistPK;
    }

    public Checklist(ChecklistPK checklistPK, String estadoEntrega, String estadoDevuelto, String descripcion) {
        this.checklistPK = checklistPK;
        this.estadoEntrega = estadoEntrega;
        this.estadoDevuelto = estadoDevuelto;
        this.descripcion = descripcion;
    }

    public Checklist(String inventarioIdInv, short reservaIdReserva) {
        this.checklistPK = new ChecklistPK(inventarioIdInv, reservaIdReserva);
    }

    public ChecklistPK getChecklistPK() {
        return checklistPK;
    }

    public void setChecklistPK(ChecklistPK checklistPK) {
        this.checklistPK = checklistPK;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getEstadoDevuelto() {
        return estadoDevuelto;
    }

    public void setEstadoDevuelto(String estadoDevuelto) {
        this.estadoDevuelto = estadoDevuelto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checklistPK != null ? checklistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checklist)) {
            return false;
        }
        Checklist other = (Checklist) object;
        if ((this.checklistPK == null && other.checklistPK != null) || (this.checklistPK != null && !this.checklistPK.equals(other.checklistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Checklist[ checklistPK=" + checklistPK + " ]";
    }
    
}
