/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jjvargasa
 */
@Embeddable
public class CoSolAdqEntregaDPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "VIGENCIA")
    private short vigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_SOL_ADQ")
    private int numSolAdq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ENTREGA")
    private short numEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSECUTIVO")
    private short consecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM")
    private short item;

    public CoSolAdqEntregaDPK() {
    }

    public CoSolAdqEntregaDPK(short vigencia, int numSolAdq, short numEntrega, long id, short consecutivo, short item) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.numEntrega = numEntrega;
        this.id = id;
        this.consecutivo = consecutivo;
        this.item = item;
    }

    public short getVigencia() {
        return vigencia;
    }

    public void setVigencia(short vigencia) {
        this.vigencia = vigencia;
    }

    public int getNumSolAdq() {
        return numSolAdq;
    }

    public void setNumSolAdq(int numSolAdq) {
        this.numSolAdq = numSolAdq;
    }

    public short getNumEntrega() {
        return numEntrega;
    }

    public void setNumEntrega(short numEntrega) {
        this.numEntrega = numEntrega;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(short consecutivo) {
        this.consecutivo = consecutivo;
    }

    public short getItem() {
        return item;
    }

    public void setItem(short item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) numEntrega;
        hash += (int) id;
        hash += (int) consecutivo;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntregaDPK)) {
            return false;
        }
        CoSolAdqEntregaDPK other = (CoSolAdqEntregaDPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.numEntrega != other.numEntrega) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntregaDPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", numEntrega=" + numEntrega + ", id=" + id + ", consecutivo=" + consecutivo + ", item=" + item + " ]";
    }
    
}
