/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_VIABIL_X_LINEA_PLAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoViabilXLineaPlan.findAll", query = "SELECT c FROM CoViabilXLineaPlan c"),
    @NamedQuery(name = "CoViabilXLineaPlan.findByCscNroViabilidad", query = "SELECT c FROM CoViabilXLineaPlan c WHERE c.cscNroViabilidad = :cscNroViabilidad"),
    @NamedQuery(name = "CoViabilXLineaPlan.findByNroViabilidad", query = "SELECT c FROM CoViabilXLineaPlan c WHERE c.nroViabilidad = :nroViabilidad"),
    @NamedQuery(name = "CoViabilXLineaPlan.findByValorViabilizado", query = "SELECT c FROM CoViabilXLineaPlan c WHERE c.valorViabilizado = :valorViabilizado"),
    @NamedQuery(name = "CoViabilXLineaPlan.findByFechaAprobViabilidad", query = "SELECT c FROM CoViabilXLineaPlan c WHERE c.fechaAprobViabilidad = :fechaAprobViabilidad"),
    @NamedQuery(name = "CoViabilXLineaPlan.findByUsuarioRegViabilidad", query = "SELECT c FROM CoViabilXLineaPlan c WHERE c.usuarioRegViabilidad = :usuarioRegViabilidad")})
public class CoViabilXLineaPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CSC_NRO_VIABILIDAD")
    private Integer cscNroViabilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_VIABILIDAD")
    private int nroViabilidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_VIABILIZADO")
    private BigDecimal valorViabilizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_APROB_VIABILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobViabilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_REG_VIABILIDAD")
    private String usuarioRegViabilidad;
    @ManyToMany(mappedBy = "coViabilXLineaPlanCollection")
    private Collection<CoSolicitudAdq> coSolicitudAdqCollection;
    @JoinColumns({
        @JoinColumn(name = "ID_PLAN_CONTRATACION", referencedColumnName = "ID_PLAN_CONTRATACION"),
        @JoinColumn(name = "CODIGO_COMPA\u00d1IA", referencedColumnName = "CODIGO_COMPANIA"),
        @JoinColumn(name = "A\u00d1O", referencedColumnName = "ANO"),
        @JoinColumn(name = "ID_DET_PLAN", referencedColumnName = "ID_DET_PLAN")})
    @ManyToOne(optional = false)
    private CoPlanDet coPlanDet;

    public CoViabilXLineaPlan() {
    }

    public CoViabilXLineaPlan(Integer cscNroViabilidad) {
        this.cscNroViabilidad = cscNroViabilidad;
    }

    public CoViabilXLineaPlan(Integer cscNroViabilidad, int nroViabilidad, BigDecimal valorViabilizado, Date fechaAprobViabilidad, String usuarioRegViabilidad) {
        this.cscNroViabilidad = cscNroViabilidad;
        this.nroViabilidad = nroViabilidad;
        this.valorViabilizado = valorViabilizado;
        this.fechaAprobViabilidad = fechaAprobViabilidad;
        this.usuarioRegViabilidad = usuarioRegViabilidad;
    }

    public Integer getCscNroViabilidad() {
        return cscNroViabilidad;
    }

    public void setCscNroViabilidad(Integer cscNroViabilidad) {
        this.cscNroViabilidad = cscNroViabilidad;
    }

    public int getNroViabilidad() {
        return nroViabilidad;
    }

    public void setNroViabilidad(int nroViabilidad) {
        this.nroViabilidad = nroViabilidad;
    }

    public BigDecimal getValorViabilizado() {
        return valorViabilizado;
    }

    public void setValorViabilizado(BigDecimal valorViabilizado) {
        this.valorViabilizado = valorViabilizado;
    }

    public Date getFechaAprobViabilidad() {
        return fechaAprobViabilidad;
    }

    public void setFechaAprobViabilidad(Date fechaAprobViabilidad) {
        this.fechaAprobViabilidad = fechaAprobViabilidad;
    }

    public String getUsuarioRegViabilidad() {
        return usuarioRegViabilidad;
    }

    public void setUsuarioRegViabilidad(String usuarioRegViabilidad) {
        this.usuarioRegViabilidad = usuarioRegViabilidad;
    }

    @XmlTransient
    public Collection<CoSolicitudAdq> getCoSolicitudAdqCollection() {
        return coSolicitudAdqCollection;
    }

    public void setCoSolicitudAdqCollection(Collection<CoSolicitudAdq> coSolicitudAdqCollection) {
        this.coSolicitudAdqCollection = coSolicitudAdqCollection;
    }

    public CoPlanDet getCoPlanDet() {
        return coPlanDet;
    }

    public void setCoPlanDet(CoPlanDet coPlanDet) {
        this.coPlanDet = coPlanDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cscNroViabilidad != null ? cscNroViabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoViabilXLineaPlan)) {
            return false;
        }
        CoViabilXLineaPlan other = (CoViabilXLineaPlan) object;
        if ((this.cscNroViabilidad == null && other.cscNroViabilidad != null) || (this.cscNroViabilidad != null && !this.cscNroViabilidad.equals(other.cscNroViabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoViabilXLineaPlan[ cscNroViabilidad=" + cscNroViabilidad + " ]";
    }
    
}
