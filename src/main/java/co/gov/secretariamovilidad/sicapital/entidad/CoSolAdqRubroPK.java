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
 * @author jjvargasa
 */
@Embeddable
public class CoSolAdqRubroPK implements Serializable {

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
    @Column(name = "RUBRO_INTERNO")
    private long rubroInterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_UNIDAD_EJECUTORA")
    private String codigoUnidadEjecutora;

    public CoSolAdqRubroPK() {
    }

    public CoSolAdqRubroPK(short vigencia, int numSolAdq, long rubroInterno, String codigoUnidadEjecutora) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.rubroInterno = rubroInterno;
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
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

    public long getRubroInterno() {
        return rubroInterno;
    }

    public void setRubroInterno(long rubroInterno) {
        this.rubroInterno = rubroInterno;
    }

    public String getCodigoUnidadEjecutora() {
        return codigoUnidadEjecutora;
    }

    public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) rubroInterno;
        hash += (codigoUnidadEjecutora != null ? codigoUnidadEjecutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqRubroPK)) {
            return false;
        }
        CoSolAdqRubroPK other = (CoSolAdqRubroPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.rubroInterno != other.rubroInterno) {
            return false;
        }
        if ((this.codigoUnidadEjecutora == null && other.codigoUnidadEjecutora != null) || (this.codigoUnidadEjecutora != null && !this.codigoUnidadEjecutora.equals(other.codigoUnidadEjecutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqRubroPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", rubroInterno=" + rubroInterno + ", codigoUnidadEjecutora=" + codigoUnidadEjecutora + " ]";
    }
    
}
