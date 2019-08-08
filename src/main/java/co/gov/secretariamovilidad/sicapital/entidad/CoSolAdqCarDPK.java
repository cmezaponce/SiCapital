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
public class CoSolAdqCarDPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CARACTERISTICA")
    private String caracteristica;

    public CoSolAdqCarDPK() {
    }

    public CoSolAdqCarDPK(short vigencia, int numSolAdq, long id, short consecutivo, String caracteristica) {
        this.vigencia = vigencia;
        this.numSolAdq = numSolAdq;
        this.id = id;
        this.consecutivo = consecutivo;
        this.caracteristica = caracteristica;
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

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vigencia;
        hash += (int) numSolAdq;
        hash += (int) id;
        hash += (int) consecutivo;
        hash += (caracteristica != null ? caracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqCarDPK)) {
            return false;
        }
        CoSolAdqCarDPK other = (CoSolAdqCarDPK) object;
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
        if ((this.caracteristica == null && other.caracteristica != null) || (this.caracteristica != null && !this.caracteristica.equals(other.caracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCarDPK[ vigencia=" + vigencia + ", numSolAdq=" + numSolAdq + ", id=" + id + ", consecutivo=" + consecutivo + ", caracteristica=" + caracteristica + " ]";
    }
    
}
