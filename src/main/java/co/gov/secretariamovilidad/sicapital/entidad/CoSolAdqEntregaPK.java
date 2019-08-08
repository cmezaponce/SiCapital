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
public class CoSolAdqEntregaPK implements Serializable {

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

    public CoSolAdqEntregaPK() {
    }

    public CoSolAdqEntregaPK(short vigencia, int numSolAdq, short numEntrega) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.numEntrega = numEntrega;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) numEntrega;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntregaPK)) {
            return false;
        }
        CoSolAdqEntregaPK other = (CoSolAdqEntregaPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.numEntrega != other.numEntrega) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntregaPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", numEntrega=" + numEntrega + " ]";
    }
    
}
