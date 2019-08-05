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
public class CoDtlleSolAdqDPK implements Serializable {

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
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSECUTIVO")
    private short consecutivo;

    public CoDtlleSolAdqDPK() {
    }

    public CoDtlleSolAdqDPK(short vigencia, int numSolAdq, long id, short consecutivo) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.id = id;
        this.consecutivo = consecutivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) id;
        hash += (int) consecutivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoDtlleSolAdqDPK)) {
            return false;
        }
        CoDtlleSolAdqDPK other = (CoDtlleSolAdqDPK) object;
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.numSolAdq != other.numSolAdq) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoDtlleSolAdqDPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", id=" + id + ", consecutivo=" + consecutivo + " ]";
    }
    
}
