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
@Table(name = "CO_DTLLE_SOL_ADQ_S")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoDtlleSolAdqS.findAll", query = "SELECT c FROM CoDtlleSolAdqS c"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByVigencia", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.coDtlleSolAdqSPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByNumSolAdq", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.coDtlleSolAdqSPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoDtlleSolAdqS.findById", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.coDtlleSolAdqSPK.id = :id"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByConsecutivo", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.coDtlleSolAdqSPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByCantidad", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByEstado", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.estado = :estado"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByMejoraVidaUtil", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.mejoraVidaUtil = :mejoraVidaUtil"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByAprobado", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.aprobado = :aprobado"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByCantidadAprobada", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.cantidadAprobada = :cantidadAprobada"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByObservaciones", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CoDtlleSolAdqS.findByValorUnitario", query = "SELECT c FROM CoDtlleSolAdqS c WHERE c.valorUnitario = :valorUnitario")})
public class CoDtlleSolAdqS implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoDtlleSolAdqSPK coDtlleSolAdqSPK;
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
    private CoCatalogoS coCatalogoS;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coDtlleSolAdqS")
    private Collection<CoSolAdqEntregaS> coSolAdqEntregaSCollection;

    public CoDtlleSolAdqS() {
    }

    public CoDtlleSolAdqS(CoDtlleSolAdqSPK coDtlleSolAdqSPK) {
        this.coDtlleSolAdqSPK = coDtlleSolAdqSPK;
    }

    public CoDtlleSolAdqS(CoDtlleSolAdqSPK coDtlleSolAdqSPK, int cantidad, String estado, String mejoraVidaUtil) {
        this.coDtlleSolAdqSPK = coDtlleSolAdqSPK;
        this.cantidad = cantidad;
        this.estado = estado;
        this.mejoraVidaUtil = mejoraVidaUtil;
    }

    public CoDtlleSolAdqS(short vigencia, int numSolAdq, long id, short consecutivo) {
        this.coDtlleSolAdqSPK = new CoDtlleSolAdqSPK(vigencia, numSolAdq, id, consecutivo);
    }

    public CoDtlleSolAdqSPK getCoDtlleSolAdqSPK() {
        return coDtlleSolAdqSPK;
    }

    public void setCoDtlleSolAdqSPK(CoDtlleSolAdqSPK coDtlleSolAdqSPK) {
        this.coDtlleSolAdqSPK = coDtlleSolAdqSPK;
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

    public CoCatalogoS getCoCatalogoS() {
        return coCatalogoS;
    }

    public void setCoCatalogoS(CoCatalogoS coCatalogoS) {
        this.coCatalogoS = coCatalogoS;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaS> getCoSolAdqEntregaSCollection() {
        return coSolAdqEntregaSCollection;
    }

    public void setCoSolAdqEntregaSCollection(Collection<CoSolAdqEntregaS> coSolAdqEntregaSCollection) {
        this.coSolAdqEntregaSCollection = coSolAdqEntregaSCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coDtlleSolAdqSPK != null ? coDtlleSolAdqSPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoDtlleSolAdqS)) {
            return false;
        }
        CoDtlleSolAdqS other = (CoDtlleSolAdqS) object;
        if ((this.coDtlleSolAdqSPK == null && other.coDtlleSolAdqSPK != null) || (this.coDtlleSolAdqSPK != null && !this.coDtlleSolAdqSPK.equals(other.coDtlleSolAdqSPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoDtlleSolAdqS[ coDtlleSolAdqSPK=" + coDtlleSolAdqSPK + " ]";
    }
    
}
