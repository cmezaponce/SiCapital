/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_DTLLE_SOL_ADQ_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoDtlleSolAdqC.findAll", query = "SELECT c FROM CoDtlleSolAdqC c"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByVigencia", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.coDtlleSolAdqCPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByNumSolAdq", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.coDtlleSolAdqCPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoDtlleSolAdqC.findById", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.coDtlleSolAdqCPK.id = :id"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByConsecutivo", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.coDtlleSolAdqCPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByUnidadMedida", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByCantidad", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByEstado", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.estado = :estado"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByMejoraVidaUtil", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.mejoraVidaUtil = :mejoraVidaUtil"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByAprobado", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.aprobado = :aprobado"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByCantidadAprobada", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.cantidadAprobada = :cantidadAprobada"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByObservaciones", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CoDtlleSolAdqC.findByValorUnitario", query = "SELECT c FROM CoDtlleSolAdqC c WHERE c.valorUnitario = :valorUnitario")})
public class CoDtlleSolAdqC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoDtlleSolAdqCPK coDtlleSolAdqCPK;
    @Size(max = 30)
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Size(max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEJORA_VIDA_UTIL")
    private String mejoraVidaUtil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "APROBADO")
    private String aprobado;
    @Column(name = "CANTIDAD_APROBADA")
    private Integer cantidadAprobada;
    @Size(max = 4000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CoCatalogoC coCatalogoC;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coDtlleSolAdqC")
    private Collection<CoSolAdqEntregaC> coSolAdqEntregaCCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coDtlleSolAdqC")
    private Collection<CoSolAdqCarC> coSolAdqCarCCollection;

    public CoDtlleSolAdqC() {
    }

    public CoDtlleSolAdqC(CoDtlleSolAdqCPK coDtlleSolAdqCPK) {
        this.coDtlleSolAdqCPK = coDtlleSolAdqCPK;
    }

    public CoDtlleSolAdqC(CoDtlleSolAdqCPK coDtlleSolAdqCPK, String mejoraVidaUtil, String aprobado) {
        this.coDtlleSolAdqCPK = coDtlleSolAdqCPK;
        this.mejoraVidaUtil = mejoraVidaUtil;
        this.aprobado = aprobado;
    }

    public CoDtlleSolAdqC(short vigencia, int numSolAdq, long id, short consecutivo) {
        this.coDtlleSolAdqCPK = new CoDtlleSolAdqCPK(vigencia, numSolAdq, id, consecutivo);
    }

    public CoDtlleSolAdqCPK getCoDtlleSolAdqCPK() {
        return coDtlleSolAdqCPK;
    }

    public void setCoDtlleSolAdqCPK(CoDtlleSolAdqCPK coDtlleSolAdqCPK) {
        this.coDtlleSolAdqCPK = coDtlleSolAdqCPK;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMejoraVidaUtil() {
        return mejoraVidaUtil;
    }

    public void setMejoraVidaUtil(String mejoraVidaUtil) {
        this.mejoraVidaUtil = mejoraVidaUtil;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getCantidadAprobada() {
        return cantidadAprobada;
    }

    public void setCantidadAprobada(Integer cantidadAprobada) {
        this.cantidadAprobada = cantidadAprobada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public CoCatalogoC getCoCatalogoC() {
        return coCatalogoC;
    }

    public void setCoCatalogoC(CoCatalogoC coCatalogoC) {
        this.coCatalogoC = coCatalogoC;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaC> getCoSolAdqEntregaCCollection() {
        return coSolAdqEntregaCCollection;
    }

    public void setCoSolAdqEntregaCCollection(Collection<CoSolAdqEntregaC> coSolAdqEntregaCCollection) {
        this.coSolAdqEntregaCCollection = coSolAdqEntregaCCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqCarC> getCoSolAdqCarCCollection() {
        return coSolAdqCarCCollection;
    }

    public void setCoSolAdqCarCCollection(Collection<CoSolAdqCarC> coSolAdqCarCCollection) {
        this.coSolAdqCarCCollection = coSolAdqCarCCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coDtlleSolAdqCPK != null ? coDtlleSolAdqCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoDtlleSolAdqC)) {
            return false;
        }
        CoDtlleSolAdqC other = (CoDtlleSolAdqC) object;
        if ((this.coDtlleSolAdqCPK == null && other.coDtlleSolAdqCPK != null) || (this.coDtlleSolAdqCPK != null && !this.coDtlleSolAdqCPK.equals(other.coDtlleSolAdqCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoDtlleSolAdqC[ coDtlleSolAdqCPK=" + coDtlleSolAdqCPK + " ]";
    }
    
}
