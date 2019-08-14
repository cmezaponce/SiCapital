/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maikol
 */
@Embeddable
public class CoSolAdqInterventorPK implements Serializable {

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
    @Column(name = "INTERNO_INTERVENTOR")
    private BigInteger internoInterventor;

    public CoSolAdqInterventorPK() {
    }

    public CoSolAdqInterventorPK(short vigencia, int numSolAdq, BigInteger internoInterventor) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.internoInterventor = internoInterventor;
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

    public BigInteger getInternoInterventor() {
        return internoInterventor;
    }

    public void setInternoInterventor(BigInteger internoInterventor) {
        this.internoInterventor = internoInterventor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (internoInterventor != null ? internoInterventor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqInterventorPK)) {
            return false;
        }
        CoSolAdqInterventorPK other = (CoSolAdqInterventorPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if ((this.internoInterventor == null && other.internoInterventor != null) || (this.internoInterventor != null && !this.internoInterventor.equals(other.internoInterventor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqInterventorPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", internoInterventor=" + internoInterventor + " ]";
    }
    
}
