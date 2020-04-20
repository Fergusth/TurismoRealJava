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
@Table(name = "MULTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multa.findAll", query = "SELECT m FROM Multa m"),
    @NamedQuery(name = "Multa.findByIdMulta", query = "SELECT m FROM Multa m WHERE m.idMulta = :idMulta"),
    @NamedQuery(name = "Multa.findByTotalMulta", query = "SELECT m FROM Multa m WHERE m.totalMulta = :totalMulta"),
    @NamedQuery(name = "Multa.findByTotalPagado", query = "SELECT m FROM Multa m WHERE m.totalPagado = :totalPagado"),
    @NamedQuery(name = "Multa.findByPagado", query = "SELECT m FROM Multa m WHERE m.pagado = :pagado"),
    @NamedQuery(name = "Multa.findByDescripcion", query = "SELECT m FROM Multa m WHERE m.descripcion = :descripcion")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MULTA")
    private Integer idMulta;
    @Basic(optional = false)
    @Column(name = "TOTAL_MULTA")
    private long totalMulta;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGADO")
    private long totalPagado;
    @Basic(optional = false)
    @Column(name = "PAGADO")
    private Character pagado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne(optional = false)
    private Reserva reservaIdReserva;

    public Multa() {
    }

    public Multa(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public Multa(Integer idMulta, long totalMulta, long totalPagado, Character pagado, String descripcion) {
        this.idMulta = idMulta;
        this.totalMulta = totalMulta;
        this.totalPagado = totalPagado;
        this.pagado = pagado;
        this.descripcion = descripcion;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public long getTotalMulta() {
        return totalMulta;
    }

    public void setTotalMulta(long totalMulta) {
        this.totalMulta = totalMulta;
    }

    public long getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(long totalPagado) {
        this.totalPagado = totalPagado;
    }

    public Character getPagado() {
        return pagado;
    }

    public void setPagado(Character pagado) {
        this.pagado = pagado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reserva getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(Reserva reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMulta != null ? idMulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        if ((this.idMulta == null && other.idMulta != null) || (this.idMulta != null && !this.idMulta.equals(other.idMulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Multa[ idMulta=" + idMulta + " ]";
    }
    
}
