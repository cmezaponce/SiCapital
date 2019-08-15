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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maikol
 */
@Entity
@Table(name = "TRC_INFORMACION_BASICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrcInformacionBasica.findAll", query = "SELECT t FROM TrcInformacionBasica t")
    , @NamedQuery(name = "TrcInformacionBasica.findById", query = "SELECT t FROM TrcInformacionBasica t WHERE t.trcInformacionBasicaPK.id = :id")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbFechaInicial", query = "SELECT t FROM TrcInformacionBasica t WHERE t.trcInformacionBasicaPK.ibFechaInicial = :ibFechaInicial")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbPrimerNombre", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibPrimerNombre = :ibPrimerNombre")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbNaturaleza", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibNaturaleza = :ibNaturaleza")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbProcedencia", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibProcedencia = :ibProcedencia")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbEntidadFinanciera", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibEntidadFinanciera = :ibEntidadFinanciera")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbSistemaCreo", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibSistemaCreo = :ibSistemaCreo")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbUsuarioCreo", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibUsuarioCreo = :ibUsuarioCreo")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbSegundoNombre", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibSegundoNombre = :ibSegundoNombre")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbPrimerApellido", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibPrimerApellido = :ibPrimerApellido")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbSegundoApellido", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibSegundoApellido = :ibSegundoApellido")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbClaseEntidad", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibClaseEntidad = :ibClaseEntidad")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbSector", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibSector = :ibSector")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbRegimenTributario", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibRegimenTributario = :ibRegimenTributario")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbGranContribuyente", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibGranContribuyente = :ibGranContribuyente")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbAutorretenedor", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibAutorretenedor = :ibAutorretenedor")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbEpClase", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibEpClase = :ibEpClase")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbEpNivel", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibEpNivel = :ibEpNivel")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbEpTipo", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibEpTipo = :ibEpTipo")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbOtraClasificacion", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibOtraClasificacion = :ibOtraClasificacion")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbClaseJuridica", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibClaseJuridica = :ibClaseJuridica")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbPais", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibPais = :ibPais")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbDepto", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibDepto = :ibDepto")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbCiudad", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibCiudad = :ibCiudad")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbCodigoEmbargo", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibCodigoEmbargo = :ibCodigoEmbargo")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbFechaFinal", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibFechaFinal = :ibFechaFinal")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbSistemaCerro", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibSistemaCerro = :ibSistemaCerro")
    , @NamedQuery(name = "TrcInformacionBasica.findByIbUsuarioCerro", query = "SELECT t FROM TrcInformacionBasica t WHERE t.ibUsuarioCerro = :ibUsuarioCerro")})
public class TrcInformacionBasica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrcInformacionBasicaPK trcInformacionBasicaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "IB_PRIMER_NOMBRE")
    private String ibPrimerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "IB_NATURALEZA")
    private String ibNaturaleza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "IB_PROCEDENCIA")
    private String ibProcedencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "IB_ENTIDAD_FINANCIERA")
    private String ibEntidadFinanciera;
    @Size(max = 30)
    @Column(name = "IB_SISTEMA_CREO")
    private String ibSistemaCreo;
    @Size(max = 30)
    @Column(name = "IB_USUARIO_CREO")
    private String ibUsuarioCreo;
    @Size(max = 120)
    @Column(name = "IB_SEGUNDO_NOMBRE")
    private String ibSegundoNombre;
    @Size(max = 120)
    @Column(name = "IB_PRIMER_APELLIDO")
    private String ibPrimerApellido;
    @Size(max = 120)
    @Column(name = "IB_SEGUNDO_APELLIDO")
    private String ibSegundoApellido;
    @Size(max = 30)
    @Column(name = "IB_CLASE_ENTIDAD")
    private String ibClaseEntidad;
    @Size(max = 30)
    @Column(name = "IB_SECTOR")
    private String ibSector;
    @Size(max = 30)
    @Column(name = "IB_REGIMEN_TRIBUTARIO")
    private String ibRegimenTributario;
    @Size(max = 1)
    @Column(name = "IB_GRAN_CONTRIBUYENTE")
    private String ibGranContribuyente;
    @Size(max = 1)
    @Column(name = "IB_AUTORRETENEDOR")
    private String ibAutorretenedor;
    @Size(max = 30)
    @Column(name = "IB_EP_CLASE")
    private String ibEpClase;
    @Size(max = 30)
    @Column(name = "IB_EP_NIVEL")
    private String ibEpNivel;
    @Size(max = 30)
    @Column(name = "IB_EP_TIPO")
    private String ibEpTipo;
    @Size(max = 30)
    @Column(name = "IB_OTRA_CLASIFICACION")
    private String ibOtraClasificacion;
    @Size(max = 30)
    @Column(name = "IB_CLASE_JURIDICA")
    private String ibClaseJuridica;
    @Size(max = 30)
    @Column(name = "IB_PAIS")
    private String ibPais;
    @Size(max = 30)
    @Column(name = "IB_DEPTO")
    private String ibDepto;
    @Size(max = 30)
    @Column(name = "IB_CIUDAD")
    private String ibCiudad;
    @Size(max = 30)
    @Column(name = "IB_CODIGO_EMBARGO")
    private String ibCodigoEmbargo;
    @Column(name = "IB_FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ibFechaFinal;
    @Size(max = 30)
    @Column(name = "IB_SISTEMA_CERRO")
    private String ibSistemaCerro;
    @Size(max = 30)
    @Column(name = "IB_USUARIO_CERRO")
    private String ibUsuarioCerro;
    @JoinColumn(name = "IB_CODIGO_BAN_AGRARIO", referencedColumnName = "CODIGO_OFICINA")
    @ManyToOne
    private TrcOficinasBancoAgrario ibCodigoBanAgrario;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrcTerceros trcTerceros;

    public TrcInformacionBasica() {
    }

    public TrcInformacionBasica(TrcInformacionBasicaPK trcInformacionBasicaPK) {
        this.trcInformacionBasicaPK = trcInformacionBasicaPK;
    }

    public TrcInformacionBasica(TrcInformacionBasicaPK trcInformacionBasicaPK, String ibPrimerNombre, String ibNaturaleza, String ibProcedencia, String ibEntidadFinanciera) {
        this.trcInformacionBasicaPK = trcInformacionBasicaPK;
        this.ibPrimerNombre = ibPrimerNombre;
        this.ibNaturaleza = ibNaturaleza;
        this.ibProcedencia = ibProcedencia;
        this.ibEntidadFinanciera = ibEntidadFinanciera;
    }

    public TrcInformacionBasica(BigInteger id, Date ibFechaInicial) {
        this.trcInformacionBasicaPK = new TrcInformacionBasicaPK(id, ibFechaInicial);
    }

    public TrcInformacionBasicaPK getTrcInformacionBasicaPK() {
        return trcInformacionBasicaPK;
    }

    public void setTrcInformacionBasicaPK(TrcInformacionBasicaPK trcInformacionBasicaPK) {
        this.trcInformacionBasicaPK = trcInformacionBasicaPK;
    }

    public String getIbPrimerNombre() {
        return ibPrimerNombre;
    }

    public void setIbPrimerNombre(String ibPrimerNombre) {
        this.ibPrimerNombre = ibPrimerNombre;
    }

    public String getIbNaturaleza() {
        return ibNaturaleza;
    }

    public void setIbNaturaleza(String ibNaturaleza) {
        this.ibNaturaleza = ibNaturaleza;
    }

    public String getIbProcedencia() {
        return ibProcedencia;
    }

    public void setIbProcedencia(String ibProcedencia) {
        this.ibProcedencia = ibProcedencia;
    }

    public String getIbEntidadFinanciera() {
        return ibEntidadFinanciera;
    }

    public void setIbEntidadFinanciera(String ibEntidadFinanciera) {
        this.ibEntidadFinanciera = ibEntidadFinanciera;
    }

    public String getIbSistemaCreo() {
        return ibSistemaCreo;
    }

    public void setIbSistemaCreo(String ibSistemaCreo) {
        this.ibSistemaCreo = ibSistemaCreo;
    }

    public String getIbUsuarioCreo() {
        return ibUsuarioCreo;
    }

    public void setIbUsuarioCreo(String ibUsuarioCreo) {
        this.ibUsuarioCreo = ibUsuarioCreo;
    }

    public String getIbSegundoNombre() {
        return ibSegundoNombre;
    }

    public void setIbSegundoNombre(String ibSegundoNombre) {
        this.ibSegundoNombre = ibSegundoNombre;
    }

    public String getIbPrimerApellido() {
        return ibPrimerApellido;
    }

    public void setIbPrimerApellido(String ibPrimerApellido) {
        this.ibPrimerApellido = ibPrimerApellido;
    }

    public String getIbSegundoApellido() {
        return ibSegundoApellido;
    }

    public void setIbSegundoApellido(String ibSegundoApellido) {
        this.ibSegundoApellido = ibSegundoApellido;
    }

    public String getIbClaseEntidad() {
        return ibClaseEntidad;
    }

    public void setIbClaseEntidad(String ibClaseEntidad) {
        this.ibClaseEntidad = ibClaseEntidad;
    }

    public String getIbSector() {
        return ibSector;
    }

    public void setIbSector(String ibSector) {
        this.ibSector = ibSector;
    }

    public String getIbRegimenTributario() {
        return ibRegimenTributario;
    }

    public void setIbRegimenTributario(String ibRegimenTributario) {
        this.ibRegimenTributario = ibRegimenTributario;
    }

    public String getIbGranContribuyente() {
        return ibGranContribuyente;
    }

    public void setIbGranContribuyente(String ibGranContribuyente) {
        this.ibGranContribuyente = ibGranContribuyente;
    }

    public String getIbAutorretenedor() {
        return ibAutorretenedor;
    }

    public void setIbAutorretenedor(String ibAutorretenedor) {
        this.ibAutorretenedor = ibAutorretenedor;
    }

    public String getIbEpClase() {
        return ibEpClase;
    }

    public void setIbEpClase(String ibEpClase) {
        this.ibEpClase = ibEpClase;
    }

    public String getIbEpNivel() {
        return ibEpNivel;
    }

    public void setIbEpNivel(String ibEpNivel) {
        this.ibEpNivel = ibEpNivel;
    }

    public String getIbEpTipo() {
        return ibEpTipo;
    }

    public void setIbEpTipo(String ibEpTipo) {
        this.ibEpTipo = ibEpTipo;
    }

    public String getIbOtraClasificacion() {
        return ibOtraClasificacion;
    }

    public void setIbOtraClasificacion(String ibOtraClasificacion) {
        this.ibOtraClasificacion = ibOtraClasificacion;
    }

    public String getIbClaseJuridica() {
        return ibClaseJuridica;
    }

    public void setIbClaseJuridica(String ibClaseJuridica) {
        this.ibClaseJuridica = ibClaseJuridica;
    }

    public String getIbPais() {
        return ibPais;
    }

    public void setIbPais(String ibPais) {
        this.ibPais = ibPais;
    }

    public String getIbDepto() {
        return ibDepto;
    }

    public void setIbDepto(String ibDepto) {
        this.ibDepto = ibDepto;
    }

    public String getIbCiudad() {
        return ibCiudad;
    }

    public void setIbCiudad(String ibCiudad) {
        this.ibCiudad = ibCiudad;
    }

    public String getIbCodigoEmbargo() {
        return ibCodigoEmbargo;
    }

    public void setIbCodigoEmbargo(String ibCodigoEmbargo) {
        this.ibCodigoEmbargo = ibCodigoEmbargo;
    }

    public Date getIbFechaFinal() {
        return ibFechaFinal;
    }

    public void setIbFechaFinal(Date ibFechaFinal) {
        this.ibFechaFinal = ibFechaFinal;
    }

    public String getIbSistemaCerro() {
        return ibSistemaCerro;
    }

    public void setIbSistemaCerro(String ibSistemaCerro) {
        this.ibSistemaCerro = ibSistemaCerro;
    }

    public String getIbUsuarioCerro() {
        return ibUsuarioCerro;
    }

    public void setIbUsuarioCerro(String ibUsuarioCerro) {
        this.ibUsuarioCerro = ibUsuarioCerro;
    }

    public TrcOficinasBancoAgrario getIbCodigoBanAgrario() {
        return ibCodigoBanAgrario;
    }

    public void setIbCodigoBanAgrario(TrcOficinasBancoAgrario ibCodigoBanAgrario) {
        this.ibCodigoBanAgrario = ibCodigoBanAgrario;
    }

    public TrcTerceros getTrcTerceros() {
        return trcTerceros;
    }

    public void setTrcTerceros(TrcTerceros trcTerceros) {
        this.trcTerceros = trcTerceros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trcInformacionBasicaPK != null ? trcInformacionBasicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrcInformacionBasica)) {
            return false;
        }
        TrcInformacionBasica other = (TrcInformacionBasica) object;
        if ((this.trcInformacionBasicaPK == null && other.trcInformacionBasicaPK != null) || (this.trcInformacionBasicaPK != null && !this.trcInformacionBasicaPK.equals(other.trcInformacionBasicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.TrcInformacionBasica[ trcInformacionBasicaPK=" + trcInformacionBasicaPK + " ]";
    }
    
}
