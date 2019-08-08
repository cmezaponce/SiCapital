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
@Table(name = "CO_SOL_ADQ_PLAN_PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqPlanPago.findAll", query = "SELECT c FROM CoSolAdqPlanPago c"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByVigencia", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.coSolAdqPlanPagoPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByNumSolAdq", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.coSolAdqPlanPagoPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByNumPago", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.coSolAdqPlanPagoPK.numPago = :numPago"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByTipoPago", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.tipoPago = :tipoPago"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByValor", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.valor = :valor"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByTipoValor", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.tipoValor = :tipoValor"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByCondicionPago", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.condicionPago = :condicionPago"),
    @NamedQuery(name = "CoSolAdqPlanPago.findByPeriodoPago", query = "SELECT c FROM CoSolAdqPlanPago c WHERE c.periodoPago = :periodoPago")})
public class CoSolAdqPlanPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqPlanPagoPK coSolAdqPlanPagoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_PAGO")
    private String tipoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_VALOR")
    private String tipoValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONDICION_PAGO")
    private String condicionPago;
    @Size(max = 1000)
    @Column(name = "PERIODO_PAGO")
    private String periodoPago;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqPlanPago() {
    }

    public CoSolAdqPlanPago(CoSolAdqPlanPagoPK coSolAdqPlanPagoPK) {
        this.coSolAdqPlanPagoPK = coSolAdqPlanPagoPK;
    }

    public CoSolAdqPlanPago(CoSolAdqPlanPagoPK coSolAdqPlanPagoPK, String tipoPago, BigDecimal valor, String tipoValor, String condicionPago) {
        this.coSolAdqPlanPagoPK = coSolAdqPlanPagoPK;
        this.tipoPago = tipoPago;
        this.valor = valor;
        this.tipoValor = tipoValor;
        this.condicionPago = condicionPago;
    }

    public CoSolAdqPlanPago(short vigencia, int numSolAdq, short numPago) {
        this.coSolAdqPlanPagoPK = new CoSolAdqPlanPagoPK(vigencia, numSolAdq, numPago);
    }

    public CoSolAdqPlanPagoPK getCoSolAdqPlanPagoPK() {
        return coSolAdqPlanPagoPK;
    }

    public void setCoSolAdqPlanPagoPK(CoSolAdqPlanPagoPK coSolAdqPlanPagoPK) {
        this.coSolAdqPlanPagoPK = coSolAdqPlanPagoPK;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
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
        hash += (coSolAdqPlanPagoPK != null ? coSolAdqPlanPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqPlanPago)) {
            return false;
        }
        CoSolAdqPlanPago other = (CoSolAdqPlanPago) object;
        if ((this.coSolAdqPlanPagoPK == null && other.coSolAdqPlanPagoPK != null) || (this.coSolAdqPlanPagoPK != null && !this.coSolAdqPlanPagoPK.equals(other.coSolAdqPlanPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqPlanPago[ coSolAdqPlanPagoPK=" + coSolAdqPlanPagoPK + " ]";
    }
    
}
