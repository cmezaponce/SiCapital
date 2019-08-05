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
public class CoSolAdqDepPK implements Serializable {

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
    @Size(min = 1, max = 6)
    @Column(name = "DEPENDENCIA_DESTINO")
    private String dependenciaDestino;

    public CoSolAdqDepPK() {
    }

    public CoSolAdqDepPK(short vigencia, int numSolAdq, String dependenciaDestino) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.dependenciaDestino = dependenciaDestino;
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

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public void setDependenciaDestino(String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (dependenciaDestino != null ? dependenciaDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqDepPK)) {
            return false;
        }
        CoSolAdqDepPK other = (CoSolAdqDepPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if ((this.dependenciaDestino == null && other.dependenciaDestino != null) || (this.dependenciaDestino != null && !this.dependenciaDestino.equals(other.dependenciaDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqDepPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", dependenciaDestino=" + dependenciaDestino + " ]";
    }
    
}
