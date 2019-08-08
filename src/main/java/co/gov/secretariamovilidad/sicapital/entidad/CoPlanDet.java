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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CO_PLAN_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoPlanDet.findAll", query = "SELECT c FROM CoPlanDet c"),
    @NamedQuery(name = "CoPlanDet.findByIdPlanContratacion", query = "SELECT c FROM CoPlanDet c WHERE c.coPlanDetPK.idPlanContratacion = :idPlanContratacion"),
    @NamedQuery(name = "CoPlanDet.findByCodigoCompania", query = "SELECT c FROM CoPlanDet c WHERE c.coPlanDetPK.codigoCompania = :codigoCompania"),
    @NamedQuery(name = "CoPlanDet.findByAno", query = "SELECT c FROM CoPlanDet c WHERE c.coPlanDetPK.ano = :ano"),
    @NamedQuery(name = "CoPlanDet.findByIdDetPlan", query = "SELECT c FROM CoPlanDet c WHERE c.coPlanDetPK.idDetPlan = :idDetPlan"),
    @NamedQuery(name = "CoPlanDet.findByNroOrden", query = "SELECT c FROM CoPlanDet c WHERE c.nroOrden = :nroOrden"),
    @NamedQuery(name = "CoPlanDet.findByTipoLinea", query = "SELECT c FROM CoPlanDet c WHERE c.tipoLinea = :tipoLinea"),
    @NamedQuery(name = "CoPlanDet.findByFechaRegistro", query = "SELECT c FROM CoPlanDet c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CoPlanDet.findByAreaOrigen", query = "SELECT c FROM CoPlanDet c WHERE c.areaOrigen = :areaOrigen"),
    @NamedQuery(name = "CoPlanDet.findByGrupo\u00c1reaOrigen", query = "SELECT c FROM CoPlanDet c WHERE c.grupo\u00c1reaOrigen = :grupo\u00c1reaOrigen"),
    @NamedQuery(name = "CoPlanDet.findByUnidadEjecutora", query = "SELECT c FROM CoPlanDet c WHERE c.unidadEjecutora = :unidadEjecutora"),
    @NamedQuery(name = "CoPlanDet.findByUnspsc", query = "SELECT c FROM CoPlanDet c WHERE c.unspsc = :unspsc"),
    @NamedQuery(name = "CoPlanDet.findByCodigoFuenteFinanc", query = "SELECT c FROM CoPlanDet c WHERE c.codigoFuenteFinanc = :codigoFuenteFinanc"),
    @NamedQuery(name = "CoPlanDet.findByCscFuenteFinanc", query = "SELECT c FROM CoPlanDet c WHERE c.cscFuenteFinanc = :cscFuenteFinanc"),
    @NamedQuery(name = "CoPlanDet.findByFinanciado", query = "SELECT c FROM CoPlanDet c WHERE c.financiado = :financiado"),
    @NamedQuery(name = "CoPlanDet.findByRubro", query = "SELECT c FROM CoPlanDet c WHERE c.rubro = :rubro"),
    @NamedQuery(name = "CoPlanDet.findByCodTipoGasto", query = "SELECT c FROM CoPlanDet c WHERE c.codTipoGasto = :codTipoGasto"),
    @NamedQuery(name = "CoPlanDet.findByCodCompGasto", query = "SELECT c FROM CoPlanDet c WHERE c.codCompGasto = :codCompGasto"),
    @NamedQuery(name = "CoPlanDet.findByCodObjGasto", query = "SELECT c FROM CoPlanDet c WHERE c.codObjGasto = :codObjGasto"),
    @NamedQuery(name = "CoPlanDet.findByPuntoInversi\u00f3n", query = "SELECT c FROM CoPlanDet c WHERE c.puntoInversi\u00f3n = :puntoInversi\u00f3n"),
    @NamedQuery(name = "CoPlanDet.findByPerfilCps", query = "SELECT c FROM CoPlanDet c WHERE c.perfilCps = :perfilCps"),
    @NamedQuery(name = "CoPlanDet.findByObjeto", query = "SELECT c FROM CoPlanDet c WHERE c.objeto = :objeto"),
    @NamedQuery(name = "CoPlanDet.findByTipoContrato", query = "SELECT c FROM CoPlanDet c WHERE c.tipoContrato = :tipoContrato"),
    @NamedQuery(name = "CoPlanDet.findByProcesoSeleccion", query = "SELECT c FROM CoPlanDet c WHERE c.procesoSeleccion = :procesoSeleccion"),
    @NamedQuery(name = "CoPlanDet.findByMontoEstimado", query = "SELECT c FROM CoPlanDet c WHERE c.montoEstimado = :montoEstimado"),
    @NamedQuery(name = "CoPlanDet.findByNumeroContratos", query = "SELECT c FROM CoPlanDet c WHERE c.numeroContratos = :numeroContratos"),
    @NamedQuery(name = "CoPlanDet.findByMesesEjecucion", query = "SELECT c FROM CoPlanDet c WHERE c.mesesEjecucion = :mesesEjecucion"),
    @NamedQuery(name = "CoPlanDet.findByPlazoEjecucion", query = "SELECT c FROM CoPlanDet c WHERE c.plazoEjecucion = :plazoEjecucion"),
    @NamedQuery(name = "CoPlanDet.findByTipoPlazoEjecucion", query = "SELECT c FROM CoPlanDet c WHERE c.tipoPlazoEjecucion = :tipoPlazoEjecucion"),
    @NamedQuery(name = "CoPlanDet.findByFechaIniProceso", query = "SELECT c FROM CoPlanDet c WHERE c.fechaIniProceso = :fechaIniProceso"),
    @NamedQuery(name = "CoPlanDet.findByFechaAdjudicaci\u00f3n", query = "SELECT c FROM CoPlanDet c WHERE c.fechaAdjudicaci\u00f3n = :fechaAdjudicaci\u00f3n"),
    @NamedQuery(name = "CoPlanDet.findByContacto", query = "SELECT c FROM CoPlanDet c WHERE c.contacto = :contacto"),
    @NamedQuery(name = "CoPlanDet.findByObsSolicitante", query = "SELECT c FROM CoPlanDet c WHERE c.obsSolicitante = :obsSolicitante"),
    @NamedQuery(name = "CoPlanDet.findByFechaRadicacion", query = "SELECT c FROM CoPlanDet c WHERE c.fechaRadicacion = :fechaRadicacion"),
    @NamedQuery(name = "CoPlanDet.findByNumeroRadicacion", query = "SELECT c FROM CoPlanDet c WHERE c.numeroRadicacion = :numeroRadicacion"),
    @NamedQuery(name = "CoPlanDet.findByObsModificaci\u00f3n", query = "SELECT c FROM CoPlanDet c WHERE c.obsModificaci\u00f3n = :obsModificaci\u00f3n"),
    @NamedQuery(name = "CoPlanDet.findByValorTotViabilizado", query = "SELECT c FROM CoPlanDet c WHERE c.valorTotViabilizado = :valorTotViabilizado"),
    @NamedQuery(name = "CoPlanDet.findByFechaAprobacion", query = "SELECT c FROM CoPlanDet c WHERE c.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "CoPlanDet.findByUsuarioGenPlan", query = "SELECT c FROM CoPlanDet c WHERE c.usuarioGenPlan = :usuarioGenPlan"),
    @NamedQuery(name = "CoPlanDet.findByFechaGenPlan", query = "SELECT c FROM CoPlanDet c WHERE c.fechaGenPlan = :fechaGenPlan")})
public class CoPlanDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoPlanDetPK coPlanDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NRO_ORDEN")
    private String nroOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_LINEA")
    private String tipoLinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "AREA_ORIGEN")
    private String areaOrigen;
    @Size(max = 3)
    @Column(name = "GRUPO_\u00c1REA_ORIGEN")
    private String grupoÁreaOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UNIDAD_EJECUTORA")
    private String unidadEjecutora;
    @Size(max = 10)
    @Column(name = "UNSPSC")
    private String unspsc;
    @Size(max = 2)
    @Column(name = "CODIGO_FUENTE_FINANC")
    private String codigoFuenteFinanc;
    @Column(name = "CSC_FUENTE_FINANC")
    private Integer cscFuenteFinanc;
    @Size(max = 1)
    @Column(name = "FINANCIADO")
    private String financiado;
    @Column(name = "RUBRO")
    private Long rubro;
    @Size(max = 10)
    @Column(name = "COD_TIPO_GASTO")
    private String codTipoGasto;
    @Size(max = 10)
    @Column(name = "COD_COMP_GASTO")
    private String codCompGasto;
    @Size(max = 10)
    @Column(name = "COD_OBJ_GASTO")
    private String codObjGasto;
    @Size(max = 3)
    @Column(name = "PUNTO_INVERSI\u00d3N")
    private String puntoInversión;
    @Size(max = 5)
    @Column(name = "PERFIL_CPS")
    private String perfilCps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "OBJETO")
    private String objeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_CONTRATO")
    private String tipoContrato;
    @Size(max = 30)
    @Column(name = "PROCESO_SELECCION")
    private String procesoSeleccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_ESTIMADO")
    private BigDecimal montoEstimado;
    @Column(name = "NUMERO_CONTRATOS")
    private Short numeroContratos;
    @Column(name = "MESES_EJECUCION")
    private Short mesesEjecucion;
    @Column(name = "PLAZO_EJECUCION")
    private BigDecimal plazoEjecucion;
    @Size(max = 30)
    @Column(name = "TIPO_PLAZO_EJECUCION")
    private String tipoPlazoEjecucion;
    @Column(name = "FECHA_INI_PROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniProceso;
    @Column(name = "FECHA_ADJUDICACI\u00d3N")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdjudicación;
    @Column(name = "CONTACTO")
    private Long contacto;
    @Size(max = 4000)
    @Column(name = "OBS_SOLICITANTE")
    private String obsSolicitante;
    @Column(name = "FECHA_RADICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicacion;
    @Column(name = "NUMERO_RADICACION")
    private Long numeroRadicacion;
    @Size(max = 4000)
    @Column(name = "OBS_MODIFICACI\u00d3N")
    private String obsModificación;
    @Column(name = "VALOR_TOT_VIABILIZADO")
    private BigDecimal valorTotViabilizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_APROBACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_GEN_PLAN")
    private String usuarioGenPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_GEN_PLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coPlanDet")
    private Collection<CoViabilXLineaPlan> coViabilXLineaPlanCollection;
    @JoinColumn(name = "ID_PLAN_CONTRATACION", referencedColumnName = "ID_PLAN_CONTRATACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CoPlanContratacion coPlanContratacion;

    public CoPlanDet() {
    }

    public CoPlanDet(CoPlanDetPK coPlanDetPK) {
        this.coPlanDetPK = coPlanDetPK;
    }

    public CoPlanDet(CoPlanDetPK coPlanDetPK, String nroOrden, String tipoLinea, Date fechaRegistro, String areaOrigen, String unidadEjecutora, String objeto, String tipoContrato, Date fechaAprobacion, String usuarioGenPlan, Date fechaGenPlan) {
        this.coPlanDetPK = coPlanDetPK;
        this.nroOrden = nroOrden;
        this.tipoLinea = tipoLinea;
        this.fechaRegistro = fechaRegistro;
        this.areaOrigen = areaOrigen;
        this.unidadEjecutora = unidadEjecutora;
        this.objeto = objeto;
        this.tipoContrato = tipoContrato;
        this.fechaAprobacion = fechaAprobacion;
        this.usuarioGenPlan = usuarioGenPlan;
        this.fechaGenPlan = fechaGenPlan;
    }

    public CoPlanDet(int idPlanContratacion, String codigoCompania, String ano, long idDetPlan) {
        this.coPlanDetPK = new CoPlanDetPK(idPlanContratacion, codigoCompania, ano, idDetPlan);
    }

    public CoPlanDetPK getCoPlanDetPK() {
        return coPlanDetPK;
    }

    public void setCoPlanDetPK(CoPlanDetPK coPlanDetPK) {
        this.coPlanDetPK = coPlanDetPK;
    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getTipoLinea() {
        return tipoLinea;
    }

    public void setTipoLinea(String tipoLinea) {
        this.tipoLinea = tipoLinea;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getAreaOrigen() {
        return areaOrigen;
    }

    public void setAreaOrigen(String areaOrigen) {
        this.areaOrigen = areaOrigen;
    }

    public String getGrupoÁreaOrigen() {
        return grupoÁreaOrigen;
    }

    public void setGrupoÁreaOrigen(String grupoÁreaOrigen) {
        this.grupoÁreaOrigen = grupoÁreaOrigen;
    }

    public String getUnidadEjecutora() {
        return unidadEjecutora;
    }

    public void setUnidadEjecutora(String unidadEjecutora) {
        this.unidadEjecutora = unidadEjecutora;
    }

    public String getUnspsc() {
        return unspsc;
    }

    public void setUnspsc(String unspsc) {
        this.unspsc = unspsc;
    }

    public String getCodigoFuenteFinanc() {
        return codigoFuenteFinanc;
    }

    public void setCodigoFuenteFinanc(String codigoFuenteFinanc) {
        this.codigoFuenteFinanc = codigoFuenteFinanc;
    }

    public Integer getCscFuenteFinanc() {
        return cscFuenteFinanc;
    }

    public void setCscFuenteFinanc(Integer cscFuenteFinanc) {
        this.cscFuenteFinanc = cscFuenteFinanc;
    }

    public String getFinanciado() {
        return financiado;
    }

    public void setFinanciado(String financiado) {
        this.financiado = financiado;
    }

    public Long getRubro() {
        return rubro;
    }

    public void setRubro(Long rubro) {
        this.rubro = rubro;
    }

    public String getCodTipoGasto() {
        return codTipoGasto;
    }

    public void setCodTipoGasto(String codTipoGasto) {
        this.codTipoGasto = codTipoGasto;
    }

    public String getCodCompGasto() {
        return codCompGasto;
    }

    public void setCodCompGasto(String codCompGasto) {
        this.codCompGasto = codCompGasto;
    }

    public String getCodObjGasto() {
        return codObjGasto;
    }

    public void setCodObjGasto(String codObjGasto) {
        this.codObjGasto = codObjGasto;
    }

    public String getPuntoInversión() {
        return puntoInversión;
    }

    public void setPuntoInversión(String puntoInversión) {
        this.puntoInversión = puntoInversión;
    }

    public String getPerfilCps() {
        return perfilCps;
    }

    public void setPerfilCps(String perfilCps) {
        this.perfilCps = perfilCps;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getProcesoSeleccion() {
        return procesoSeleccion;
    }

    public void setProcesoSeleccion(String procesoSeleccion) {
        this.procesoSeleccion = procesoSeleccion;
    }

    public BigDecimal getMontoEstimado() {
        return montoEstimado;
    }

    public void setMontoEstimado(BigDecimal montoEstimado) {
        this.montoEstimado = montoEstimado;
    }

    public Short getNumeroContratos() {
        return numeroContratos;
    }

    public void setNumeroContratos(Short numeroContratos) {
        this.numeroContratos = numeroContratos;
    }

    public Short getMesesEjecucion() {
        return mesesEjecucion;
    }

    public void setMesesEjecucion(Short mesesEjecucion) {
        this.mesesEjecucion = mesesEjecucion;
    }

    public BigDecimal getPlazoEjecucion() {
        return plazoEjecucion;
    }

    public void setPlazoEjecucion(BigDecimal plazoEjecucion) {
        this.plazoEjecucion = plazoEjecucion;
    }

    public String getTipoPlazoEjecucion() {
        return tipoPlazoEjecucion;
    }

    public void setTipoPlazoEjecucion(String tipoPlazoEjecucion) {
        this.tipoPlazoEjecucion = tipoPlazoEjecucion;
    }

    public Date getFechaIniProceso() {
        return fechaIniProceso;
    }

    public void setFechaIniProceso(Date fechaIniProceso) {
        this.fechaIniProceso = fechaIniProceso;
    }

    public Date getFechaAdjudicación() {
        return fechaAdjudicación;
    }

    public void setFechaAdjudicación(Date fechaAdjudicación) {
        this.fechaAdjudicación = fechaAdjudicación;
    }

    public Long getContacto() {
        return contacto;
    }

    public void setContacto(Long contacto) {
        this.contacto = contacto;
    }

    public String getObsSolicitante() {
        return obsSolicitante;
    }

    public void setObsSolicitante(String obsSolicitante) {
        this.obsSolicitante = obsSolicitante;
    }

    public Date getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(Date fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public Long getNumeroRadicacion() {
        return numeroRadicacion;
    }

    public void setNumeroRadicacion(Long numeroRadicacion) {
        this.numeroRadicacion = numeroRadicacion;
    }

    public String getObsModificación() {
        return obsModificación;
    }

    public void setObsModificación(String obsModificación) {
        this.obsModificación = obsModificación;
    }

    public BigDecimal getValorTotViabilizado() {
        return valorTotViabilizado;
    }

    public void setValorTotViabilizado(BigDecimal valorTotViabilizado) {
        this.valorTotViabilizado = valorTotViabilizado;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getUsuarioGenPlan() {
        return usuarioGenPlan;
    }

    public void setUsuarioGenPlan(String usuarioGenPlan) {
        this.usuarioGenPlan = usuarioGenPlan;
    }

    public Date getFechaGenPlan() {
        return fechaGenPlan;
    }

    public void setFechaGenPlan(Date fechaGenPlan) {
        this.fechaGenPlan = fechaGenPlan;
    }

    @XmlTransient
    public Collection<CoViabilXLineaPlan> getCoViabilXLineaPlanCollection() {
        return coViabilXLineaPlanCollection;
    }

    public void setCoViabilXLineaPlanCollection(Collection<CoViabilXLineaPlan> coViabilXLineaPlanCollection) {
        this.coViabilXLineaPlanCollection = coViabilXLineaPlanCollection;
    }

    public CoPlanContratacion getCoPlanContratacion() {
        return coPlanContratacion;
    }

    public void setCoPlanContratacion(CoPlanContratacion coPlanContratacion) {
        this.coPlanContratacion = coPlanContratacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coPlanDetPK != null ? coPlanDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoPlanDet)) {
            return false;
        }
        CoPlanDet other = (CoPlanDet) object;
        if ((this.coPlanDetPK == null && other.coPlanDetPK != null) || (this.coPlanDetPK != null && !this.coPlanDetPK.equals(other.coPlanDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoPlanDet[ coPlanDetPK=" + coPlanDetPK + " ]";
    }
    
}
