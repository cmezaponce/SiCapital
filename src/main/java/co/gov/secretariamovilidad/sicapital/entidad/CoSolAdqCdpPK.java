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
public class CoSolAdqCdpPK implements Serializable {

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
    @Column(name = "NUMERO_DISPONIBILIDAD")
    private int numeroDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_UNIDAD_EJECUTORA")
    private String codigoUnidadEjecutora;

    public CoSolAdqCdpPK() {
    }

    public CoSolAdqCdpPK(short vigencia, int numSolAdq, int numeroDisponibilidad, String codigoUnidadEjecutora) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.numeroDisponibilidad = numeroDisponibilidad;
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

    public int getNumeroDisponibilidad() {
        return numeroDisponibilidad;
    }

    public void setNumeroDisponibilidad(int numeroDisponibilidad) {
        this.numeroDisponibilidad = numeroDisponibilidad;
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
        hash += (int) numeroDisponibilidad;
        hash += (codigoUnidadEjecutora != null ? codigoUnidadEjecutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqCdpPK)) {
            return false;
        }
        CoSolAdqCdpPK other = (CoSolAdqCdpPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.numeroDisponibilidad != other.numeroDisponibilidad) {
            return false;
        }
        if ((this.codigoUnidadEjecutora == null && other.codigoUnidadEjecutora != null) || (this.codigoUnidadEjecutora != null && !this.codigoUnidadEjecutora.equals(other.codigoUnidadEjecutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdpPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", numeroDisponibilidad=" + numeroDisponibilidad + ", codigoUnidadEjecutora=" + codigoUnidadEjecutora + " ]";
    }
    
}
