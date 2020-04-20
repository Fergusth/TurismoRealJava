/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gerald
 */
@Embeddable
public class ChecklistPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INVENTARIO_ID_INV")
    private String inventarioIdInv;
    @Basic(optional = false)
    @Column(name = "RESERVA_ID_RESERVA")
    private short reservaIdReserva;

    public ChecklistPK() {
    }

    public ChecklistPK(String inventarioIdInv, short reservaIdReserva) {
        this.inventarioIdInv = inventarioIdInv;
        this.reservaIdReserva = reservaIdReserva;
    }

    public String getInventarioIdInv() {
        return inventarioIdInv;
    }

    public void setInventarioIdInv(String inventarioIdInv) {
        this.inventarioIdInv = inventarioIdInv;
    }

    public short getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(short reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioIdInv != null ? inventarioIdInv.hashCode() : 0);
        hash += (int) reservaIdReserva;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistPK)) {
            return false;
        }
        ChecklistPK other = (ChecklistPK) object;
        if ((this.inventarioIdInv == null && other.inventarioIdInv != null) || (this.inventarioIdInv != null && !this.inventarioIdInv.equals(other.inventarioIdInv))) {
            return false;
        }
        if (this.reservaIdReserva != other.reservaIdReserva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChecklistPK[ inventarioIdInv=" + inventarioIdInv + ", reservaIdReserva=" + reservaIdReserva + " ]";
    }
    
}
