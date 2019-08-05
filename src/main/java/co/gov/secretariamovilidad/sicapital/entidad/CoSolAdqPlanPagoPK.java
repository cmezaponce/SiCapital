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
public class CoSolAdqPlanPagoPK implements Serializable {

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
    @Column(name = "NUM_PAGO")
    private short numPago;

    public CoSolAdqPlanPagoPK() {
    }

    public CoSolAdqPlanPagoPK(short vigencia, int numSolAdq, short numPago) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.numPago = numPago;
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

    public short getNumPago() {
        return numPago;
    }

    public void setNumPago(short numPago) {
        this.numPago = numPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) numPago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqPlanPagoPK)) {
            return false;
        }
        CoSolAdqPlanPagoPK other = (CoSolAdqPlanPagoPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.numPago != other.numPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqPlanPagoPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", numPago=" + numPago + " ]";
    }
    
}
