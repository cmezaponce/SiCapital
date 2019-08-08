/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_RUBRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqRubro.findAll", query = "SELECT c FROM CoSolAdqRubro c"),
    @NamedQuery(name = "CoSolAdqRubro.findByVigencia", query = "SELECT c FROM CoSolAdqRubro c WHERE c.coSolAdqRubroPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqRubro.findByNumSolAdq", query = "SELECT c FROM CoSolAdqRubro c WHERE c.coSolAdqRubroPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqRubro.findByRubroInterno", query = "SELECT c FROM CoSolAdqRubro c WHERE c.coSolAdqRubroPK.rubroInterno = :rubroInterno"),
    @NamedQuery(name = "CoSolAdqRubro.findByTipoPlan", query = "SELECT c FROM CoSolAdqRubro c WHERE c.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "CoSolAdqRubro.findByMonto", query = "SELECT c FROM CoSolAdqRubro c WHERE c.monto = :monto"),
    @NamedQuery(name = "CoSolAdqRubro.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqRubro c WHERE c.coSolAdqRubroPK.codigoUnidadEjecutora = :codigoUnidadEjecutora")})
public class CoSolAdqRubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqRubroPK coSolAdqRubroPK;
    @Size(max = 30)
    @Column(name = "TIPO_PLAN")
    private String tipoPlan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigDecimal monto;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqRubro() {
    }

    public CoSolAdqRubro(CoSolAdqRubroPK coSolAdqRubroPK) {
        this.coSolAdqRubroPK = coSolAdqRubroPK;
    }

    public CoSolAdqRubro(CoSolAdqRubroPK coSolAdqRubroPK, BigDecimal monto) {
        this.coSolAdqRubroPK = coSolAdqRubroPK;
        this.monto = monto;
    }

    public CoSolAdqRubro(short vigencia, int numSolAdq, long rubroInterno, String codigoUnidadEjecutora) {
        this.coSolAdqRubroPK = new CoSolAdqRubroPK(vigencia, numSolAdq, rubroInterno, codigoUnidadEjecutora);
    }

    public CoSolAdqRubroPK getCoSolAdqRubroPK() {
        return coSolAdqRubroPK;
    }

    public void setCoSolAdqRubroPK(CoSolAdqRubroPK coSolAdqRubroPK) {
        this.coSolAdqRubroPK = coSolAdqRubroPK;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqRubroPK != null ? coSolAdqRubroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqRubro)) {
            return false;
        }
        CoSolAdqRubro other = (CoSolAdqRubro) object;
        if ((this.coSolAdqRubroPK == null && other.coSolAdqRubroPK != null) || (this.coSolAdqRubroPK != null && !this.coSolAdqRubroPK.equals(other.coSolAdqRubroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqRubro[ coSolAdqRubroPK=" + coSolAdqRubroPK + " ]";
    }
    
}
