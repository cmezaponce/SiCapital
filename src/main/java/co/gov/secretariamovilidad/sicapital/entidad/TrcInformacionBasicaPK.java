/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maikol
 */
@Embeddable
public class TrcInformacionBasicaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IB_FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ibFechaInicial;

    public TrcInformacionBasicaPK() {
    }

    public TrcInformacionBasicaPK(BigInteger id, Date ibFechaInicial) {
        this.id = id;
        this.ibFechaInicial = ibFechaInicial;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getIbFechaInicial() {
        return ibFechaInicial;
    }

    public void setIbFechaInicial(Date ibFechaInicial) {
        this.ibFechaInicial = ibFechaInicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (ibFechaInicial != null ? ibFechaInicial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrcInformacionBasicaPK)) {
            return false;
        }
        TrcInformacionBasicaPK other = (TrcInformacionBasicaPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.ibFechaInicial == null && other.ibFechaInicial != null) || (this.ibFechaInicial != null && !this.ibFechaInicial.equals(other.ibFechaInicial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.TrcInformacionBasicaPK[ id=" + id + ", ibFechaInicial=" + ibFechaInicial + " ]";
    }
    
}
