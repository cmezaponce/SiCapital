/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author maikol
 */
@Entity
@Table(name = "TRC_TERCEROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrcTerceros.findAll", query = "SELECT t FROM TrcTerceros t")
    , @NamedQuery(name = "TrcTerceros.findById", query = "SELECT t FROM TrcTerceros t WHERE t.id = :id")
    , @NamedQuery(name = "TrcTerceros.findBySistema", query = "SELECT t FROM TrcTerceros t WHERE t.sistema = :sistema")
    , @NamedQuery(name = "TrcTerceros.findByFechaCreacion", query = "SELECT t FROM TrcTerceros t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TrcTerceros.findByUsuario", query = "SELECT t FROM TrcTerceros t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TrcTerceros.findByCompuesto", query = "SELECT t FROM TrcTerceros t WHERE t.compuesto = :compuesto")
    , @NamedQuery(name = "TrcTerceros.findByTipoTercero", query = "SELECT t FROM TrcTerceros t WHERE t.tipoTercero = :tipoTercero")
    , @NamedQuery(name = "TrcTerceros.findByEstado", query = "SELECT t FROM TrcTerceros t WHERE t.estado = :estado")
    , @NamedQuery(name = "TrcTerceros.findByCodigoEntidad", query = "SELECT t FROM TrcTerceros t WHERE t.codigoEntidad = :codigoEntidad")
    , @NamedQuery(name = "TrcTerceros.findByTipoIdentificacion", query = "SELECT t FROM TrcTerceros t WHERE t.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "TrcTerceros.findByCodigoIdentificacion", query = "SELECT t FROM TrcTerceros t WHERE t.codigoIdentificacion = :codigoIdentificacion")
    , @NamedQuery(name = "TrcTerceros.findByCodigoSuperbancaria", query = "SELECT t FROM TrcTerceros t WHERE t.codigoSuperbancaria = :codigoSuperbancaria")
    , @NamedQuery(name = "TrcTerceros.findByCodigoContaduria", query = "SELECT t FROM TrcTerceros t WHERE t.codigoContaduria = :codigoContaduria")
    , @NamedQuery(name = "TrcTerceros.findByOtraCodificacion", query = "SELECT t FROM TrcTerceros t WHERE t.otraCodificacion = :otraCodificacion")
    , @NamedQuery(name = "TrcTerceros.findByTipoSuperbancaria", query = "SELECT t FROM TrcTerceros t WHERE t.tipoSuperbancaria = :tipoSuperbancaria")
    , @NamedQuery(name = "TrcTerceros.findByTipoCancelacion", query = "SELECT t FROM TrcTerceros t WHERE t.tipoCancelacion = :tipoCancelacion")})
public class TrcTerceros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SISTEMA")
    private String sistema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COMPUESTO")
    private String compuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_TERCERO")
    private String tipoTercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 20)
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Size(max = 30)
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Size(max = 20)
    @Column(name = "CODIGO_IDENTIFICACION")
    private String codigoIdentificacion;
    @Size(max = 20)
    @Column(name = "CODIGO_SUPERBANCARIA")
    private String codigoSuperbancaria;
    @Size(max = 30)
    @Column(name = "CODIGO_CONTADURIA")
    private String codigoContaduria;
    @Size(max = 30)
    @Column(name = "OTRA_CODIFICACION")
    private String otraCodificacion;
    @Size(max = 20)
    @Column(name = "TIPO_SUPERBANCARIA")
    private String tipoSuperbancaria;
    @Size(max = 2)
    @Column(name = "TIPO_CANCELACION")
    private String tipoCancelacion;
    @OneToMany(mappedBy = "predecesor")
    private List<TrcTerceros> trcTercerosList;
    @JoinColumn(name = "PREDECESOR", referencedColumnName = "ID")
    @ManyToOne
    private TrcTerceros predecesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trcTerceros")
    private List<TrcInformacionBasica> trcInformacionBasicaList;

    public TrcTerceros() {
    }

    public TrcTerceros(BigDecimal id) {
        this.id = id;
    }

    public TrcTerceros(BigDecimal id, String sistema, Date fechaCreacion, String usuario, String compuesto, String tipoTercero, String estado) {
        this.id = id;
        this.sistema = sistema;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.compuesto = compuesto;
        this.tipoTercero = tipoTercero;
        this.estado = estado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getCodigoSuperbancaria() {
        return codigoSuperbancaria;
    }

    public void setCodigoSuperbancaria(String codigoSuperbancaria) {
        this.codigoSuperbancaria = codigoSuperbancaria;
    }

    public String getCodigoContaduria() {
        return codigoContaduria;
    }

    public void setCodigoContaduria(String codigoContaduria) {
        this.codigoContaduria = codigoContaduria;
    }

    public String getOtraCodificacion() {
        return otraCodificacion;
    }

    public void setOtraCodificacion(String otraCodificacion) {
        this.otraCodificacion = otraCodificacion;
    }

    public String getTipoSuperbancaria() {
        return tipoSuperbancaria;
    }

    public void setTipoSuperbancaria(String tipoSuperbancaria) {
        this.tipoSuperbancaria = tipoSuperbancaria;
    }

    public String getTipoCancelacion() {
        return tipoCancelacion;
    }

    public void setTipoCancelacion(String tipoCancelacion) {
        this.tipoCancelacion = tipoCancelacion;
    }

    @XmlTransient
    public List<TrcTerceros> getTrcTercerosList() {
        return trcTercerosList;
    }

    public void setTrcTercerosList(List<TrcTerceros> trcTercerosList) {
        this.trcTercerosList = trcTercerosList;
    }

    public TrcTerceros getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(TrcTerceros predecesor) {
        this.predecesor = predecesor;
    }

    @XmlTransient
    public List<TrcInformacionBasica> getTrcInformacionBasicaList() {
        return trcInformacionBasicaList;
    }

    public void setTrcInformacionBasicaList(List<TrcInformacionBasica> trcInformacionBasicaList) {
        this.trcInformacionBasicaList = trcInformacionBasicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrcTerceros)) {
            return false;
        }
        TrcTerceros other = (TrcTerceros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.TrcTerceros[ id=" + id + " ]";
    }
    
}
