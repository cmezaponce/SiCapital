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
@Table(name = "CO_DTLLE_SOL_ADQ_D")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoDtlleSolAdqD.findAll", query = "SELECT c FROM CoDtlleSolAdqD c"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByVigencia", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.coDtlleSolAdqDPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByNumSolAdq", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.coDtlleSolAdqDPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoDtlleSolAdqD.findById", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.coDtlleSolAdqDPK.id = :id"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByConsecutivo", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.coDtlleSolAdqDPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByCantidad", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByEstado", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.estado = :estado"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByMejoraVidaUtil", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.mejoraVidaUtil = :mejoraVidaUtil"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByAprobado", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.aprobado = :aprobado"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByCantidadAprobada", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.cantidadAprobada = :cantidadAprobada"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByObservaciones", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CoDtlleSolAdqD.findByValorUnitario", query = "SELECT c FROM CoDtlleSolAdqD c WHERE c.valorUnitario = :valorUnitario")})
public class CoDtlleSolAdqD implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoDtlleSolAdqDPK coDtlleSolAdqDPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEJORA_VIDA_UTIL")
    private String mejoraVidaUtil;
    @Size(max = 1)
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
    private CoCatalogoD coCatalogoD;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coDtlleSolAdqD")
    private Collection<CoSolAdqEntregaD> coSolAdqEntregaDCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coDtlleSolAdqD")
    private Collection<CoSolAdqCarD> coSolAdqCarDCollection;

    public CoDtlleSolAdqD() {
    }

    public CoDtlleSolAdqD(CoDtlleSolAdqDPK coDtlleSolAdqDPK) {
        this.coDtlleSolAdqDPK = coDtlleSolAdqDPK;
    }

    public CoDtlleSolAdqD(CoDtlleSolAdqDPK coDtlleSolAdqDPK, int cantidad, String estado, String mejoraVidaUtil) {
        this.coDtlleSolAdqDPK = coDtlleSolAdqDPK;
        this.cantidad = cantidad;
        this.estado = estado;
        this.mejoraVidaUtil = mejoraVidaUtil;
    }

    public CoDtlleSolAdqD(short vigencia, int numSolAdq, long id, short consecutivo) {
        this.coDtlleSolAdqDPK = new CoDtlleSolAdqDPK(vigencia, numSolAdq, id, consecutivo);
    }

    public CoDtlleSolAdqDPK getCoDtlleSolAdqDPK() {
        return coDtlleSolAdqDPK;
    }

    public void setCoDtlleSolAdqDPK(CoDtlleSolAdqDPK coDtlleSolAdqDPK) {
        this.coDtlleSolAdqDPK = coDtlleSolAdqDPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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

    public CoCatalogoD getCoCatalogoD() {
        return coCatalogoD;
    }

    public void setCoCatalogoD(CoCatalogoD coCatalogoD) {
        this.coCatalogoD = coCatalogoD;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaD> getCoSolAdqEntregaDCollection() {
        return coSolAdqEntregaDCollection;
    }

    public void setCoSolAdqEntregaDCollection(Collection<CoSolAdqEntregaD> coSolAdqEntregaDCollection) {
        this.coSolAdqEntregaDCollection = coSolAdqEntregaDCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqCarD> getCoSolAdqCarDCollection() {
        return coSolAdqCarDCollection;
    }

    public void setCoSolAdqCarDCollection(Collection<CoSolAdqCarD> coSolAdqCarDCollection) {
        this.coSolAdqCarDCollection = coSolAdqCarDCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coDtlleSolAdqDPK != null ? coDtlleSolAdqDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoDtlleSolAdqD)) {
            return false;
        }
        CoDtlleSolAdqD other = (CoDtlleSolAdqD) object;
        if ((this.coDtlleSolAdqDPK == null && other.coDtlleSolAdqDPK != null) || (this.coDtlleSolAdqDPK != null && !this.coDtlleSolAdqDPK.equals(other.coDtlleSolAdqDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoDtlleSolAdqD[ coDtlleSolAdqDPK=" + coDtlleSolAdqDPK + " ]";
    }
    
}
