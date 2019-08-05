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
public class CoSolAdqAmparoPK implements Serializable {

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
    @Size(min = 1, max = 30)
    @Column(name = "GARANTIA")
    private String garantia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "AMPARO")
    private String amparo;

    public CoSolAdqAmparoPK() {
    }

    public CoSolAdqAmparoPK(short vigencia, int numSolAdq, String garantia, String amparo) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.garantia = garantia;
        this.amparo = amparo;
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

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getAmparo() {
        return amparo;
    }

    public void setAmparo(String amparo) {
        this.amparo = amparo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (garantia != null ? garantia.hashCode() : 0);
        hash += (amparo != null ? amparo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqAmparoPK)) {
            return false;
        }
        CoSolAdqAmparoPK other = (CoSolAdqAmparoPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if ((this.garantia == null && other.garantia != null) || (this.garantia != null && !this.garantia.equals(other.garantia))) {
            return false;
        }
        if ((this.amparo == null && other.amparo != null) || (this.amparo != null && !this.amparo.equals(other.amparo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqAmparoPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", garantia=" + garantia + ", amparo=" + amparo + " ]";
    }
    
}
