/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOLICITUD_ADQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolicitudAdq.findAll", query = "SELECT c FROM CoSolicitudAdq c"),
    @NamedQuery(name = "CoSolicitudAdq.findByVigencia", query = "SELECT c FROM CoSolicitudAdq c WHERE c.coSolicitudAdqPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolicitudAdq.findByVigenciaNumSiscoNum", query = "SELECT c FROM CoSolicitudAdq c WHERE c.coSolicitudAdqPK.vigencia = :vigencia and c.coSolicitudAdqPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolicitudAdq.findByNumSolAdq", query = "SELECT c FROM CoSolicitudAdq c WHERE c.coSolicitudAdqPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolicitudAdq.findByExternaInterna", query = "SELECT c FROM CoSolicitudAdq c WHERE c.externaInterna = :externaInterna"),
    @NamedQuery(name = "CoSolicitudAdq.findByEnviadaRecibida", query = "SELECT c FROM CoSolicitudAdq c WHERE c.enviadaRecibida = :enviadaRecibida"),
    @NamedQuery(name = "CoSolicitudAdq.findByNumeroRadicacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.numeroRadicacion = :numeroRadicacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByCodigoCompania", query = "SELECT c FROM CoSolicitudAdq c WHERE c.codigoCompania = :codigoCompania"),
    @NamedQuery(name = "CoSolicitudAdq.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolicitudAdq c WHERE c.codigoUnidadEjecutora = :codigoUnidadEjecutora"),
    @NamedQuery(name = "CoSolicitudAdq.findByDependencia", query = "SELECT c FROM CoSolicitudAdq c WHERE c.dependencia = :dependencia"),
    @NamedQuery(name = "CoSolicitudAdq.findByFuncionario", query = "SELECT c FROM CoSolicitudAdq c WHERE c.funcionario = :funcionario"),
    @NamedQuery(name = "CoSolicitudAdq.findByFechaSolicitud", query = "SELECT c FROM CoSolicitudAdq c WHERE c.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "CoSolicitudAdq.findByOrigenSolicitud", query = "SELECT c FROM CoSolicitudAdq c WHERE c.origenSolicitud = :origenSolicitud"),
    @NamedQuery(name = "CoSolicitudAdq.findByEstado", query = "SELECT c FROM CoSolicitudAdq c WHERE c.estado = :estado"),
    @NamedQuery(name = "CoSolicitudAdq.findByDependenciaDestino", query = "SELECT c FROM CoSolicitudAdq c WHERE c.dependenciaDestino = :dependenciaDestino"),
    @NamedQuery(name = "CoSolicitudAdq.findByConceptoGasto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.conceptoGasto = :conceptoGasto"),
    @NamedQuery(name = "CoSolicitudAdq.findByCondicionesContratacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.condicionesContratacion = :condicionesContratacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByAutorizada", query = "SELECT c FROM CoSolicitudAdq c WHERE c.autorizada = :autorizada"),
    @NamedQuery(name = "CoSolicitudAdq.findByFechaAutorizacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.fechaAutorizacion = :fechaAutorizacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByFormaTramite", query = "SELECT c FROM CoSolicitudAdq c WHERE c.formaTramite = :formaTramite"),
    @NamedQuery(name = "CoSolicitudAdq.findByCausasNegacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.causasNegacion = :causasNegacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByNumeroDisponibilidad", query = "SELECT c FROM CoSolicitudAdq c WHERE c.numeroDisponibilidad = :numeroDisponibilidad"),
    @NamedQuery(name = "CoSolicitudAdq.findByFechaDisponibilidad", query = "SELECT c FROM CoSolicitudAdq c WHERE c.fechaDisponibilidad = :fechaDisponibilidad"),
    @NamedQuery(name = "CoSolicitudAdq.findByValorContratacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.valorContratacion = :valorContratacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByMedioObtencion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.medioObtencion = :medioObtencion"),
    @NamedQuery(name = "CoSolicitudAdq.findByEspecificacionTecnica", query = "SELECT c FROM CoSolicitudAdq c WHERE c.especificacionTecnica = :especificacionTecnica"),
    @NamedQuery(name = "CoSolicitudAdq.findByFirmaDigital", query = "SELECT c FROM CoSolicitudAdq c WHERE c.firmaDigital = :firmaDigital"),
    @NamedQuery(name = "CoSolicitudAdq.findByObjeto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.objeto = :objeto"),
    @NamedQuery(name = "CoSolicitudAdq.findByTipoPlazoSol", query = "SELECT c FROM CoSolicitudAdq c WHERE c.tipoPlazoSol = :tipoPlazoSol"),
    @NamedQuery(name = "CoSolicitudAdq.findByPlazoSol", query = "SELECT c FROM CoSolicitudAdq c WHERE c.plazoSol = :plazoSol"),
    @NamedQuery(name = "CoSolicitudAdq.findByTipoContratacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.tipoContratacion = :tipoContratacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByFechaLimite", query = "SELECT c FROM CoSolicitudAdq c WHERE c.fechaLimite = :fechaLimite"),
    @NamedQuery(name = "CoSolicitudAdq.findByProyectoContable", query = "SELECT c FROM CoSolicitudAdq c WHERE c.proyectoContable = :proyectoContable"),
    @NamedQuery(name = "CoSolicitudAdq.findByCentroCostoCont", query = "SELECT c FROM CoSolicitudAdq c WHERE c.centroCostoCont = :centroCostoCont"),
    @NamedQuery(name = "CoSolicitudAdq.findByCentroContable", query = "SELECT c FROM CoSolicitudAdq c WHERE c.centroContable = :centroContable"),
    @NamedQuery(name = "CoSolicitudAdq.findByRutaTerminos", query = "SELECT c FROM CoSolicitudAdq c WHERE c.rutaTerminos = :rutaTerminos"),
    @NamedQuery(name = "CoSolicitudAdq.findByTieneCdp", query = "SELECT c FROM CoSolicitudAdq c WHERE c.tieneCdp = :tieneCdp"),
    @NamedQuery(name = "CoSolicitudAdq.findByPagosNoDeterminados", query = "SELECT c FROM CoSolicitudAdq c WHERE c.pagosNoDeterminados = :pagosNoDeterminados"),
    @NamedQuery(name = "CoSolicitudAdq.findByJustificacion2", query = "SELECT c FROM CoSolicitudAdq c WHERE c.justificacion2 = :justificacion2"),
    @NamedQuery(name = "CoSolicitudAdq.findByObservacionesPlazo", query = "SELECT c FROM CoSolicitudAdq c WHERE c.observacionesPlazo = :observacionesPlazo"),
    @NamedQuery(name = "CoSolicitudAdq.findByTipoSolicitud", query = "SELECT c FROM CoSolicitudAdq c WHERE c.tipoSolicitud = :tipoSolicitud"),
    @NamedQuery(name = "CoSolicitudAdq.findByInternoOc", query = "SELECT c FROM CoSolicitudAdq c WHERE c.internoOc = :internoOc"),
    @NamedQuery(name = "CoSolicitudAdq.findByNumModificacion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.numModificacion = :numModificacion"),
    @NamedQuery(name = "CoSolicitudAdq.findByAlcanceObjeto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.alcanceObjeto = :alcanceObjeto"),
    @NamedQuery(name = "CoSolicitudAdq.findByValidezOferta", query = "SELECT c FROM CoSolicitudAdq c WHERE c.validezOferta = :validezOferta"),
    @NamedQuery(name = "CoSolicitudAdq.findByTipoPlazoOferta", query = "SELECT c FROM CoSolicitudAdq c WHERE c.tipoPlazoOferta = :tipoPlazoOferta"),
    @NamedQuery(name = "CoSolicitudAdq.findBySitioEntrega", query = "SELECT c FROM CoSolicitudAdq c WHERE c.sitioEntrega = :sitioEntrega"),
    @NamedQuery(name = "CoSolicitudAdq.findByIdEstConvOpor", query = "SELECT c FROM CoSolicitudAdq c WHERE c.idEstConvOpor = :idEstConvOpor"),
    @NamedQuery(name = "CoSolicitudAdq.findByExpGenContratista", query = "SELECT c FROM CoSolicitudAdq c WHERE c.expGenContratista = :expGenContratista"),
    @NamedQuery(name = "CoSolicitudAdq.findByExpEspContratista", query = "SELECT c FROM CoSolicitudAdq c WHERE c.expEspContratista = :expEspContratista"),
    @NamedQuery(name = "CoSolicitudAdq.findByFormacionContratista", query = "SELECT c FROM CoSolicitudAdq c WHERE c.formacionContratista = :formacionContratista"),
    @NamedQuery(name = "CoSolicitudAdq.findByFormaPagoCont", query = "SELECT c FROM CoSolicitudAdq c WHERE c.formaPagoCont = :formaPagoCont"),
    @NamedQuery(name = "CoSolicitudAdq.findByNecesidad", query = "SELECT c FROM CoSolicitudAdq c WHERE c.necesidad = :necesidad"),
    @NamedQuery(name = "CoSolicitudAdq.findByModalidadSeleccion", query = "SELECT c FROM CoSolicitudAdq c WHERE c.modalidadSeleccion = :modalidadSeleccion"),
    @NamedQuery(name = "CoSolicitudAdq.findByCalPresupuesto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.calPresupuesto = :calPresupuesto"),
    @NamedQuery(name = "CoSolicitudAdq.findBySopPresupuesto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.sopPresupuesto = :sopPresupuesto"),
    @NamedQuery(name = "CoSolicitudAdq.findByValorMensual", query = "SELECT c FROM CoSolicitudAdq c WHERE c.valorMensual = :valorMensual"),
    @NamedQuery(name = "CoSolicitudAdq.findByRequisitoJuridico", query = "SELECT c FROM CoSolicitudAdq c WHERE c.requisitoJuridico = :requisitoJuridico"),
    @NamedQuery(name = "CoSolicitudAdq.findByRequisitoFinanciero", query = "SELECT c FROM CoSolicitudAdq c WHERE c.requisitoFinanciero = :requisitoFinanciero"),
    @NamedQuery(name = "CoSolicitudAdq.findByRequisitoTecnico", query = "SELECT c FROM CoSolicitudAdq c WHERE c.requisitoTecnico = :requisitoTecnico"),
    @NamedQuery(name = "CoSolicitudAdq.findByPorcentajeCalidad", query = "SELECT c FROM CoSolicitudAdq c WHERE c.porcentajeCalidad = :porcentajeCalidad"),
    @NamedQuery(name = "CoSolicitudAdq.findByPorcentajePrecio", query = "SELECT c FROM CoSolicitudAdq c WHERE c.porcentajePrecio = :porcentajePrecio"),
    @NamedQuery(name = "CoSolicitudAdq.findByPorcentajeApoyo", query = "SELECT c FROM CoSolicitudAdq c WHERE c.porcentajeApoyo = :porcentajeApoyo"),
    @NamedQuery(name = "CoSolicitudAdq.findByPorcentajeNacional", query = "SELECT c FROM CoSolicitudAdq c WHERE c.porcentajeNacional = :porcentajeNacional"),
    @NamedQuery(name = "CoSolicitudAdq.findByPorcentajeExtranjero", query = "SELECT c FROM CoSolicitudAdq c WHERE c.porcentajeExtranjero = :porcentajeExtranjero"),
    @NamedQuery(name = "CoSolicitudAdq.findByPuntajeCalidad", query = "SELECT c FROM CoSolicitudAdq c WHERE c.puntajeCalidad = :puntajeCalidad"),
    @NamedQuery(name = "CoSolicitudAdq.findByPuntajePrecio", query = "SELECT c FROM CoSolicitudAdq c WHERE c.puntajePrecio = :puntajePrecio"),
    @NamedQuery(name = "CoSolicitudAdq.findByPuntajeApoyo", query = "SELECT c FROM CoSolicitudAdq c WHERE c.puntajeApoyo = :puntajeApoyo"),
    @NamedQuery(name = "CoSolicitudAdq.findByPuntajeNacional", query = "SELECT c FROM CoSolicitudAdq c WHERE c.puntajeNacional = :puntajeNacional"),
    @NamedQuery(name = "CoSolicitudAdq.findByPuntajeExtranjero", query = "SELECT c FROM CoSolicitudAdq c WHERE c.puntajeExtranjero = :puntajeExtranjero"),
    @NamedQuery(name = "CoSolicitudAdq.findByFactoresPonderables", query = "SELECT c FROM CoSolicitudAdq c WHERE c.factoresPonderables = :factoresPonderables"),
    @NamedQuery(name = "CoSolicitudAdq.findByOtrosAspectosObjeto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.otrosAspectosObjeto = :otrosAspectosObjeto"),
    @NamedQuery(name = "CoSolicitudAdq.findByConstNoExistOferente", query = "SELECT c FROM CoSolicitudAdq c WHERE c.constNoExistOferente = :constNoExistOferente"),
    @NamedQuery(name = "CoSolicitudAdq.findByObsPpto", query = "SELECT c FROM CoSolicitudAdq c WHERE c.obsPpto = :obsPpto")})
public class CoSolicitudAdq implements Serializable {

    @Lob
    @Column(name = "JUSTIFICATION")
    private String justification;
    @Column(name = "PLAZO_SOL2")
    private BigDecimal plazoSol2;
    @Size(max = 30)
    @Column(name = "TIPO_PLAZO_SOL2")
    private String tipoPlazoSol2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private List<CoSolAdqInterventor> coSolAdqInterventorList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolicitudAdqPK coSolicitudAdqPK;
    @Size(max = 1)
    @Column(name = "EXTERNA_INTERNA")
    private String externaInterna;
    @Size(max = 1)
    @Column(name = "ENVIADA_RECIBIDA")
    private String enviadaRecibida;
    @Column(name = "NUMERO_RADICACION")
    private Long numeroRadicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_COMPANIA")
    private String codigoCompania;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_UNIDAD_EJECUTORA")
    private String codigoUnidadEjecutora;
    @Size(max = 6)
    @Column(name = "DEPENDENCIA")
    private String dependencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNCIONARIO")
    private BigInteger funcionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ORIGEN_SOLICITUD")
    private String origenSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "DEPENDENCIA_DESTINO")
    private String dependenciaDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONCEPTO_GASTO")
    private String conceptoGasto;
    @Lob
    @Size(max = 0)
    @Column(name = "JUSTIFICACION")
    private String justificacion;
    @Size(max = 4000)
    @Column(name = "CONDICIONES_CONTRATACION")
    private String condicionesContratacion;
    @Size(max = 1)
    @Column(name = "AUTORIZADA")
    private String autorizada;
    @Column(name = "FECHA_AUTORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizacion;
    @Size(max = 30)
    @Column(name = "FORMA_TRAMITE")
    private String formaTramite;
    @Size(max = 4000)
    @Column(name = "CAUSAS_NEGACION")
    private String causasNegacion;
    @Column(name = "NUMERO_DISPONIBILIDAD")
    private Integer numeroDisponibilidad;
    @Column(name = "FECHA_DISPONIBILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDisponibilidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_CONTRATACION")
    private BigDecimal valorContratacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MEDIO_OBTENCION")
    private String medioObtencion;
    @Size(max = 4000)
    @Column(name = "ESPECIFICACION_TECNICA")
    private String especificacionTecnica;
    @Size(max = 120)
    @Column(name = "FIRMA_DIGITAL")
    private String firmaDigital;
    @Size(max = 4000)
    @Column(name = "OBJETO")
    private String objeto;
    @Size(max = 30)
    @Column(name = "TIPO_PLAZO_SOL")
    private String tipoPlazoSol;
    @Column(name = "PLAZO_SOL")
    private BigDecimal plazoSol;
    @Size(max = 60)
    @Column(name = "TIPO_CONTRATACION")
    private String tipoContratacion;
    @Column(name = "FECHA_LIMITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLimite;
    @Size(max = 30)
    @Column(name = "PROYECTO_CONTABLE")
    private String proyectoContable;
    @Size(max = 30)
    @Column(name = "CENTRO_COSTO_CONT")
    private String centroCostoCont;
    @Size(max = 30)
    @Column(name = "CENTRO_CONTABLE")
    private String centroContable;
    @Size(max = 4000)
    @Column(name = "RUTA_TERMINOS")
    private String rutaTerminos;
    @Size(max = 1)
    @Column(name = "TIENE_CDP")
    private String tieneCdp;
    @Size(max = 4000)
    @Column(name = "PAGOS_NO_DETERMINADOS")
    private String pagosNoDeterminados;
    @Size(max = 4000)
    @Column(name = "JUSTIFICACION2")
    private String justificacion2;
    @Size(max = 4000)
    @Column(name = "OBSERVACIONES_PLAZO")
    private String observacionesPlazo;
    @Size(max = 30)
    @Column(name = "TIPO_SOLICITUD")
    private String tipoSolicitud;
    @Column(name = "INTERNO_OC")
    private Integer internoOc;
    @Column(name = "NUM_MODIFICACION")
    private Short numModificacion;
    @Size(max = 4000)
    @Column(name = "ALCANCE_OBJETO")
    private String alcanceObjeto;
    @Column(name = "VALIDEZ_OFERTA")
    private Short validezOferta;
    @Size(max = 30)
    @Column(name = "TIPO_PLAZO_OFERTA")
    private String tipoPlazoOferta;
    @Size(max = 250)
    @Column(name = "SITIO_ENTREGA")
    private String sitioEntrega;
    @Column(name = "ID_EST_CONV_OPOR")
    private Integer idEstConvOpor;
    @Size(max = 4000)
    @Column(name = "EXP_GEN_CONTRATISTA")
    private String expGenContratista;
    @Size(max = 4000)
    @Column(name = "EXP_ESP_CONTRATISTA")
    private String expEspContratista;
    @Size(max = 4000)
    @Column(name = "FORMACION_CONTRATISTA")
    private String formacionContratista;
    @Size(max = 4000)
    @Column(name = "FORMA_PAGO_CONT")
    private String formaPagoCont;
    @Size(max = 4000)
    @Column(name = "NECESIDAD")
    private String necesidad;
    @Size(max = 30)
    @Column(name = "MODALIDAD_SELECCION")
    private String modalidadSeleccion;
    @Size(max = 4000)
    @Column(name = "CAL_PRESUPUESTO")
    private String calPresupuesto;
    @Size(max = 4000)
    @Column(name = "SOP_PRESUPUESTO")
    private String sopPresupuesto;
    @Column(name = "VALOR_MENSUAL")
    private BigDecimal valorMensual;
    @Size(max = 4000)
    @Column(name = "REQUISITO_JURIDICO")
    private String requisitoJuridico;
    @Size(max = 4000)
    @Column(name = "REQUISITO_FINANCIERO")
    private String requisitoFinanciero;
    @Size(max = 4000)
    @Column(name = "REQUISITO_TECNICO")
    private String requisitoTecnico;
    @Column(name = "PORCENTAJE_CALIDAD")
    private BigDecimal porcentajeCalidad;
    @Column(name = "PORCENTAJE_PRECIO")
    private BigDecimal porcentajePrecio;
    @Column(name = "PORCENTAJE_APOYO")
    private BigDecimal porcentajeApoyo;
    @Column(name = "PORCENTAJE_NACIONAL")
    private BigDecimal porcentajeNacional;
    @Column(name = "PORCENTAJE_EXTRANJERO")
    private BigDecimal porcentajeExtranjero;
    @Column(name = "PUNTAJE_CALIDAD")
    private BigDecimal puntajeCalidad;
    @Column(name = "PUNTAJE_PRECIO")
    private BigDecimal puntajePrecio;
    @Column(name = "PUNTAJE_APOYO")
    private BigDecimal puntajeApoyo;
    @Column(name = "PUNTAJE_NACIONAL")
    private BigDecimal puntajeNacional;
    @Column(name = "PUNTAJE_EXTRANJERO")
    private BigDecimal puntajeExtranjero;
    @Size(max = 4000)
    @Column(name = "FACTORES_PONDERABLES")
    private String factoresPonderables;
    @Size(max = 2000)
    @Column(name = "OTROS_ASPECTOS_OBJETO")
    private String otrosAspectosObjeto;
    @Size(max = 4000)
    @Column(name = "CONST_NO_EXIST_OFERENTE")
    private String constNoExistOferente;
    @Size(max = 4000)
    @Column(name = "OBS_PPTO")
    private String obsPpto;
    @JoinTable(name = "CO_SOL_ADQ_REN", joinColumns = {
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA"),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ")}, inverseJoinColumns = {
        @JoinColumn(name = "CSC_NRO_VIABILIDAD", referencedColumnName = "CSC_NRO_VIABILIDAD")})
    @ManyToMany
    private Collection<CoViabilXLineaPlan> coViabilXLineaPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqUe> coSolAdqUeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqCdp> coSolAdqCdpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqPlanPago> coSolAdqPlanPagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoDtlleSolAdqC> coDtlleSolAdqCCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoDtlleSolAdqD> coDtlleSolAdqDCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqAnexo> coSolAdqAnexoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoDtlleSolAdqS> coDtlleSolAdqSCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqEntrega> coSolAdqEntregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqObligacion> coSolAdqObligacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqDep> coSolAdqDepCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqGarantia> coSolAdqGarantiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolicitudAdq")
    private Collection<CoSolAdqRubro> coSolAdqRubroCollection;
    
    @Transient
    private String dependenciaSolicitud;
    @Transient
    private CoSolAdqInterventor coSolAdqInterventor;
    
    public CoSolicitudAdq() {
    }

    public CoSolicitudAdq(CoSolicitudAdqPK coSolicitudAdqPK) {
        this.coSolicitudAdqPK = coSolicitudAdqPK;
    }

    public CoSolicitudAdq(CoSolicitudAdqPK coSolicitudAdqPK, String codigoCompania, String codigoUnidadEjecutora, BigInteger funcionario, Date fechaSolicitud, String origenSolicitud, String estado, String dependenciaDestino, String conceptoGasto, BigDecimal valorContratacion, String medioObtencion) {
        this.coSolicitudAdqPK = coSolicitudAdqPK;
        this.codigoCompania = codigoCompania;
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
        this.funcionario = funcionario;
        this.fechaSolicitud = fechaSolicitud;
        this.origenSolicitud = origenSolicitud;
        this.estado = estado;
        this.dependenciaDestino = dependenciaDestino;
        this.conceptoGasto = conceptoGasto;
        this.valorContratacion = valorContratacion;
        this.medioObtencion = medioObtencion;
    }

    public CoSolicitudAdq(short vigencia, int numSolAdq) {
        this.coSolicitudAdqPK = new CoSolicitudAdqPK(vigencia, numSolAdq);
    }

    public CoSolicitudAdqPK getCoSolicitudAdqPK() {
        return coSolicitudAdqPK;
    }

    public void setCoSolicitudAdqPK(CoSolicitudAdqPK coSolicitudAdqPK) {
        this.coSolicitudAdqPK = coSolicitudAdqPK;
    }

    public String getExternaInterna() {
        return externaInterna;
    }

    public void setExternaInterna(String externaInterna) {
        this.externaInterna = externaInterna;
    }

    public String getEnviadaRecibida() {
        return enviadaRecibida;
    }

    public void setEnviadaRecibida(String enviadaRecibida) {
        this.enviadaRecibida = enviadaRecibida;
    }

    public Long getNumeroRadicacion() {
        return numeroRadicacion;
    }

    public void setNumeroRadicacion(Long numeroRadicacion) {
        this.numeroRadicacion = numeroRadicacion;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    public String getCodigoUnidadEjecutora() {
        return codigoUnidadEjecutora;
    }

    public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public BigInteger getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(BigInteger funcionario) {
        this.funcionario = funcionario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getOrigenSolicitud() {
        return origenSolicitud;
    }

    public void setOrigenSolicitud(String origenSolicitud) {
        this.origenSolicitud = origenSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public void setDependenciaDestino(String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public String getConceptoGasto() {
        return conceptoGasto;
    }

    public void setConceptoGasto(String conceptoGasto) {
        this.conceptoGasto = conceptoGasto;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getCondicionesContratacion() {
        return condicionesContratacion;
    }

    public void setCondicionesContratacion(String condicionesContratacion) {
        this.condicionesContratacion = condicionesContratacion;
    }

    public String getAutorizada() {
        return autorizada;
    }

    public void setAutorizada(String autorizada) {
        this.autorizada = autorizada;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getFormaTramite() {
        return formaTramite;
    }

    public void setFormaTramite(String formaTramite) {
        this.formaTramite = formaTramite;
    }

    public String getCausasNegacion() {
        return causasNegacion;
    }

    public void setCausasNegacion(String causasNegacion) {
        this.causasNegacion = causasNegacion;
    }

    public Integer getNumeroDisponibilidad() {
        return numeroDisponibilidad;
    }

    public void setNumeroDisponibilidad(Integer numeroDisponibilidad) {
        this.numeroDisponibilidad = numeroDisponibilidad;
    }

    public Date getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(Date fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public BigDecimal getValorContratacion() {
        return valorContratacion;
    }

    public void setValorContratacion(BigDecimal valorContratacion) {
        this.valorContratacion = valorContratacion;
    }

    public String getMedioObtencion() {
        return medioObtencion;
    }

    public void setMedioObtencion(String medioObtencion) {
        this.medioObtencion = medioObtencion;
    }

    public String getEspecificacionTecnica() {
        return especificacionTecnica;
    }

    public void setEspecificacionTecnica(String especificacionTecnica) {
        this.especificacionTecnica = especificacionTecnica;
    }

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getTipoPlazoSol() {
        return tipoPlazoSol;
    }

    public void setTipoPlazoSol(String tipoPlazoSol) {
        this.tipoPlazoSol = tipoPlazoSol;
    }

    public BigDecimal getPlazoSol() {
        return plazoSol;
    }

    public void setPlazoSol(BigDecimal plazoSol) {
        this.plazoSol = plazoSol;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getProyectoContable() {
        return proyectoContable;
    }

    public void setProyectoContable(String proyectoContable) {
        this.proyectoContable = proyectoContable;
    }

    public String getCentroCostoCont() {
        return centroCostoCont;
    }

    public void setCentroCostoCont(String centroCostoCont) {
        this.centroCostoCont = centroCostoCont;
    }

    public String getCentroContable() {
        return centroContable;
    }

    public void setCentroContable(String centroContable) {
        this.centroContable = centroContable;
    }

    public String getRutaTerminos() {
        return rutaTerminos;
    }

    public void setRutaTerminos(String rutaTerminos) {
        this.rutaTerminos = rutaTerminos;
    }

    public String getTieneCdp() {
        return tieneCdp;
    }

    public void setTieneCdp(String tieneCdp) {
        this.tieneCdp = tieneCdp;
    }

    public String getPagosNoDeterminados() {
        return pagosNoDeterminados;
    }

    public void setPagosNoDeterminados(String pagosNoDeterminados) {
        this.pagosNoDeterminados = pagosNoDeterminados;
    }

    public String getJustificacion2() {
        return justificacion2;
    }

    public void setJustificacion2(String justificacion2) {
        this.justificacion2 = justificacion2;
    }

    public String getObservacionesPlazo() {
        return observacionesPlazo;
    }

    public void setObservacionesPlazo(String observacionesPlazo) {
        this.observacionesPlazo = observacionesPlazo;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Integer getInternoOc() {
        return internoOc;
    }

    public void setInternoOc(Integer internoOc) {
        this.internoOc = internoOc;
    }

    public Short getNumModificacion() {
        return numModificacion;
    }

    public void setNumModificacion(Short numModificacion) {
        this.numModificacion = numModificacion;
    }

    public String getAlcanceObjeto() {
        return alcanceObjeto;
    }

    public void setAlcanceObjeto(String alcanceObjeto) {
        this.alcanceObjeto = alcanceObjeto;
    }

    public Short getValidezOferta() {
        return validezOferta;
    }

    public void setValidezOferta(Short validezOferta) {
        this.validezOferta = validezOferta;
    }

    public String getTipoPlazoOferta() {
        return tipoPlazoOferta;
    }

    public void setTipoPlazoOferta(String tipoPlazoOferta) {
        this.tipoPlazoOferta = tipoPlazoOferta;
    }

    public String getSitioEntrega() {
        return sitioEntrega;
    }

    public void setSitioEntrega(String sitioEntrega) {
        this.sitioEntrega = sitioEntrega;
    }

    public Integer getIdEstConvOpor() {
        return idEstConvOpor;
    }

    public void setIdEstConvOpor(Integer idEstConvOpor) {
        this.idEstConvOpor = idEstConvOpor;
    }

    public String getExpGenContratista() {
        return expGenContratista;
    }

    public void setExpGenContratista(String expGenContratista) {
        this.expGenContratista = expGenContratista;
    }

    public String getExpEspContratista() {
        return expEspContratista;
    }

    public void setExpEspContratista(String expEspContratista) {
        this.expEspContratista = expEspContratista;
    }

    public String getFormacionContratista() {
        return formacionContratista;
    }

    public void setFormacionContratista(String formacionContratista) {
        this.formacionContratista = formacionContratista;
    }

    public String getFormaPagoCont() {
        return formaPagoCont;
    }

    public void setFormaPagoCont(String formaPagoCont) {
        this.formaPagoCont = formaPagoCont;
    }

    public String getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }

    public String getModalidadSeleccion() {
        return modalidadSeleccion;
    }

    public void setModalidadSeleccion(String modalidadSeleccion) {
        this.modalidadSeleccion = modalidadSeleccion;
    }

    public String getCalPresupuesto() {
        return calPresupuesto;
    }

    public void setCalPresupuesto(String calPresupuesto) {
        this.calPresupuesto = calPresupuesto;
    }

    public String getSopPresupuesto() {
        return sopPresupuesto;
    }

    public void setSopPresupuesto(String sopPresupuesto) {
        this.sopPresupuesto = sopPresupuesto;
    }

    public BigDecimal getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(BigDecimal valorMensual) {
        this.valorMensual = valorMensual;
    }

    public String getRequisitoJuridico() {
        return requisitoJuridico;
    }

    public void setRequisitoJuridico(String requisitoJuridico) {
        this.requisitoJuridico = requisitoJuridico;
    }

    public String getRequisitoFinanciero() {
        return requisitoFinanciero;
    }

    public void setRequisitoFinanciero(String requisitoFinanciero) {
        this.requisitoFinanciero = requisitoFinanciero;
    }

    public String getRequisitoTecnico() {
        return requisitoTecnico;
    }

    public void setRequisitoTecnico(String requisitoTecnico) {
        this.requisitoTecnico = requisitoTecnico;
    }

    public BigDecimal getPorcentajeCalidad() {
        return porcentajeCalidad;
    }

    public void setPorcentajeCalidad(BigDecimal porcentajeCalidad) {
        this.porcentajeCalidad = porcentajeCalidad;
    }

    public BigDecimal getPorcentajePrecio() {
        return porcentajePrecio;
    }

    public void setPorcentajePrecio(BigDecimal porcentajePrecio) {
        this.porcentajePrecio = porcentajePrecio;
    }

    public BigDecimal getPorcentajeApoyo() {
        return porcentajeApoyo;
    }

    public void setPorcentajeApoyo(BigDecimal porcentajeApoyo) {
        this.porcentajeApoyo = porcentajeApoyo;
    }

    public BigDecimal getPorcentajeNacional() {
        return porcentajeNacional;
    }

    public void setPorcentajeNacional(BigDecimal porcentajeNacional) {
        this.porcentajeNacional = porcentajeNacional;
    }

    public BigDecimal getPorcentajeExtranjero() {
        return porcentajeExtranjero;
    }

    public void setPorcentajeExtranjero(BigDecimal porcentajeExtranjero) {
        this.porcentajeExtranjero = porcentajeExtranjero;
    }

    public BigDecimal getPuntajeCalidad() {
        return puntajeCalidad;
    }

    public void setPuntajeCalidad(BigDecimal puntajeCalidad) {
        this.puntajeCalidad = puntajeCalidad;
    }

    public BigDecimal getPuntajePrecio() {
        return puntajePrecio;
    }

    public void setPuntajePrecio(BigDecimal puntajePrecio) {
        this.puntajePrecio = puntajePrecio;
    }

    public BigDecimal getPuntajeApoyo() {
        return puntajeApoyo;
    }

    public void setPuntajeApoyo(BigDecimal puntajeApoyo) {
        this.puntajeApoyo = puntajeApoyo;
    }

    public BigDecimal getPuntajeNacional() {
        return puntajeNacional;
    }

    public void setPuntajeNacional(BigDecimal puntajeNacional) {
        this.puntajeNacional = puntajeNacional;
    }

    public BigDecimal getPuntajeExtranjero() {
        return puntajeExtranjero;
    }

    public void setPuntajeExtranjero(BigDecimal puntajeExtranjero) {
        this.puntajeExtranjero = puntajeExtranjero;
    }

    public String getFactoresPonderables() {
        return factoresPonderables;
    }

    public void setFactoresPonderables(String factoresPonderables) {
        this.factoresPonderables = factoresPonderables;
    }

    public String getOtrosAspectosObjeto() {
        return otrosAspectosObjeto;
    }

    public void setOtrosAspectosObjeto(String otrosAspectosObjeto) {
        this.otrosAspectosObjeto = otrosAspectosObjeto;
    }

    public String getConstNoExistOferente() {
        return constNoExistOferente;
    }

    public void setConstNoExistOferente(String constNoExistOferente) {
        this.constNoExistOferente = constNoExistOferente;
    }

    public String getObsPpto() {
        return obsPpto;
    }

    public void setObsPpto(String obsPpto) {
        this.obsPpto = obsPpto;
    }

    @XmlTransient
    public Collection<CoViabilXLineaPlan> getCoViabilXLineaPlanCollection() {
        return coViabilXLineaPlanCollection;
    }

    public void setCoViabilXLineaPlanCollection(Collection<CoViabilXLineaPlan> coViabilXLineaPlanCollection) {
        this.coViabilXLineaPlanCollection = coViabilXLineaPlanCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqUe> getCoSolAdqUeCollection() {
        return coSolAdqUeCollection;
    }

    public void setCoSolAdqUeCollection(Collection<CoSolAdqUe> coSolAdqUeCollection) {
        this.coSolAdqUeCollection = coSolAdqUeCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqCdp> getCoSolAdqCdpCollection() {
        return coSolAdqCdpCollection;
    }

    public void setCoSolAdqCdpCollection(Collection<CoSolAdqCdp> coSolAdqCdpCollection) {
        this.coSolAdqCdpCollection = coSolAdqCdpCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqPlanPago> getCoSolAdqPlanPagoCollection() {
        return coSolAdqPlanPagoCollection;
    }

    public void setCoSolAdqPlanPagoCollection(Collection<CoSolAdqPlanPago> coSolAdqPlanPagoCollection) {
        this.coSolAdqPlanPagoCollection = coSolAdqPlanPagoCollection;
    }

    @XmlTransient
    public Collection<CoDtlleSolAdqC> getCoDtlleSolAdqCCollection() {
        return coDtlleSolAdqCCollection;
    }

    public void setCoDtlleSolAdqCCollection(Collection<CoDtlleSolAdqC> coDtlleSolAdqCCollection) {
        this.coDtlleSolAdqCCollection = coDtlleSolAdqCCollection;
    }

    @XmlTransient
    public Collection<CoDtlleSolAdqD> getCoDtlleSolAdqDCollection() {
        return coDtlleSolAdqDCollection;
    }

    public void setCoDtlleSolAdqDCollection(Collection<CoDtlleSolAdqD> coDtlleSolAdqDCollection) {
        this.coDtlleSolAdqDCollection = coDtlleSolAdqDCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqAnexo> getCoSolAdqAnexoCollection() {
        return coSolAdqAnexoCollection;
    }

    public void setCoSolAdqAnexoCollection(Collection<CoSolAdqAnexo> coSolAdqAnexoCollection) {
        this.coSolAdqAnexoCollection = coSolAdqAnexoCollection;
    }

    @XmlTransient
    public Collection<CoDtlleSolAdqS> getCoDtlleSolAdqSCollection() {
        return coDtlleSolAdqSCollection;
    }

    public void setCoDtlleSolAdqSCollection(Collection<CoDtlleSolAdqS> coDtlleSolAdqSCollection) {
        this.coDtlleSolAdqSCollection = coDtlleSolAdqSCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqEntrega> getCoSolAdqEntregaCollection() {
        return coSolAdqEntregaCollection;
    }

    public void setCoSolAdqEntregaCollection(Collection<CoSolAdqEntrega> coSolAdqEntregaCollection) {
        this.coSolAdqEntregaCollection = coSolAdqEntregaCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqObligacion> getCoSolAdqObligacionCollection() {
        return coSolAdqObligacionCollection;
    }

    public void setCoSolAdqObligacionCollection(Collection<CoSolAdqObligacion> coSolAdqObligacionCollection) {
        this.coSolAdqObligacionCollection = coSolAdqObligacionCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqDep> getCoSolAdqDepCollection() {
        return coSolAdqDepCollection;
    }

    public void setCoSolAdqDepCollection(Collection<CoSolAdqDep> coSolAdqDepCollection) {
        this.coSolAdqDepCollection = coSolAdqDepCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqGarantia> getCoSolAdqGarantiaCollection() {
        return coSolAdqGarantiaCollection;
    }

    public void setCoSolAdqGarantiaCollection(Collection<CoSolAdqGarantia> coSolAdqGarantiaCollection) {
        this.coSolAdqGarantiaCollection = coSolAdqGarantiaCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqRubro> getCoSolAdqRubroCollection() {
        return coSolAdqRubroCollection;
    }

    public void setCoSolAdqRubroCollection(Collection<CoSolAdqRubro> coSolAdqRubroCollection) {
        this.coSolAdqRubroCollection = coSolAdqRubroCollection;
    }

    public String getDependenciaSolicitud() {
        return dependenciaSolicitud;
    }

    public void setDependenciaSolicitud(String dependenciaSolicitud) {
        this.dependenciaSolicitud = dependenciaSolicitud;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolicitudAdqPK != null ? coSolicitudAdqPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolicitudAdq)) {
            return false;
        }
        CoSolicitudAdq other = (CoSolicitudAdq) object;
        if ((this.coSolicitudAdqPK == null && other.coSolicitudAdqPK != null) || (this.coSolicitudAdqPK != null && !this.coSolicitudAdqPK.equals(other.coSolicitudAdqPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq[ coSolicitudAdqPK=" + coSolicitudAdqPK + " ]";
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public BigDecimal getPlazoSol2() {
        return plazoSol2;
    }

    public void setPlazoSol2(BigDecimal plazoSol2) {
        this.plazoSol2 = plazoSol2;
    }

    public String getTipoPlazoSol2() {
        return tipoPlazoSol2;
    }

    public void setTipoPlazoSol2(String tipoPlazoSol2) {
        this.tipoPlazoSol2 = tipoPlazoSol2;
    }

    @XmlTransient
    public List<CoSolAdqInterventor> getCoSolAdqInterventorList() {
        return coSolAdqInterventorList;
    }

    public void setCoSolAdqInterventorList(List<CoSolAdqInterventor> coSolAdqInterventorList) {
        this.coSolAdqInterventorList = coSolAdqInterventorList;
    }

    public CoSolAdqInterventor getCoSolAdqInterventor() {
        return coSolAdqInterventor;
    }

    public void setCoSolAdqInterventor(CoSolAdqInterventor coSolAdqInterventor) {
        this.coSolAdqInterventor = coSolAdqInterventor;
    }
    
    
}
