/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_CDP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqCdp.findAll", query = "SELECT c FROM CoSolAdqCdp c"),
    @NamedQuery(name = "CoSolAdqCdp.findByVigencia", query = "SELECT c FROM CoSolAdqCdp c WHERE c.coSolAdqCdpPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqCdp.findByNumSolAdq", query = "SELECT c FROM CoSolAdqCdp c WHERE c.coSolAdqCdpPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqCdp.findByNumeroDisponibilidad", query = "SELECT c FROM CoSolAdqCdp c WHERE c.coSolAdqCdpPK.numeroDisponibilidad = :numeroDisponibilidad"),
    @NamedQuery(name = "CoSolAdqCdp.findByFechaDisponibilidad", query = "SELECT c FROM CoSolAdqCdp c WHERE c.fechaDisponibilidad = :fechaDisponibilidad"),
    @NamedQuery(name = "CoSolAdqCdp.findByValor", query = "SELECT c FROM CoSolAdqCdp c WHERE c.valor = :valor"),
    @NamedQuery(name = "CoSolAdqCdp.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqCdp c WHERE c.coSolAdqCdpPK.codigoUnidadEjecutora = :codigoUnidadEjecutora")})
public class CoSolAdqCdp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqCdpPK coSolAdqCdpPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DISPONIBILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDisponibilidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqCdp() {
    }

    public CoSolAdqCdp(CoSolAdqCdpPK coSolAdqCdpPK) {
        this.coSolAdqCdpPK = coSolAdqCdpPK;
    }

    public CoSolAdqCdp(CoSolAdqCdpPK coSolAdqCdpPK, Date fechaDisponibilidad, BigDecimal valor) {
        this.coSolAdqCdpPK = coSolAdqCdpPK;
        this.fechaDisponibilidad = fechaDisponibilidad;
        this.valor = valor;
    }

    public CoSolAdqCdp(short vigencia, int numSolAdq, int numeroDisponibilidad, String codigoUnidadEjecutora) {
        this.coSolAdqCdpPK = new CoSolAdqCdpPK(vigencia, numSolAdq, numeroDisponibilidad, codigoUnidadEjecutora);
    }

    public CoSolAdqCdpPK getCoSolAdqCdpPK() {
        return coSolAdqCdpPK;
    }

    public void setCoSolAdqCdpPK(CoSolAdqCdpPK coSolAdqCdpPK) {
        this.coSolAdqCdpPK = coSolAdqCdpPK;
    }

    public Date getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(Date fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        hash += (coSolAdqCdpPK != null ? coSolAdqCdpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqCdp)) {
            return false;
        }
        CoSolAdqCdp other = (CoSolAdqCdp) object;
        if ((this.coSolAdqCdpPK == null && other.coSolAdqCdpPK != null) || (this.coSolAdqCdpPK != null && !this.coSolAdqCdpPK.equals(other.coSolAdqCdpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdp[ coSolAdqCdpPK=" + coSolAdqCdpPK + " ]";
    }
    
}
