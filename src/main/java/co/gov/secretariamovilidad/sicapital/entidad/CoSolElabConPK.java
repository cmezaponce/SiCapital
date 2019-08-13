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
import javax.validation.constraints.Size;

/**
 *
 * @author maikol
 */
@Embeddable
public class CoSolElabConPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_COMPANIA")
    private String codigoCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIGENCIA")
    private short vigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_SOL_ADQ")
    private int numSolAdq;

    public CoSolElabConPK() {
    }

    public CoSolElabConPK(String codigoCompania, short vigencia, int numSolAdq) {
        this.codigoCompania = codigoCompania;
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompania != null ? codigoCompania.hashCode() : 0);
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolElabConPK)) {
            return false;
        }
        CoSolElabConPK other = (CoSolElabConPK) object;
        if ((this.codigoCompania == null && other.codigoCompania != null) || (this.codigoCompania != null && !this.codigoCompania.equals(other.codigoCompania))) {
            return false;
        }
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolElabConPK[ codigoCompania=" + codigoCompania + ", vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + " ]";
    }
    
}
