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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_CATALOGO_D")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoCatalogoD.findAll", query = "SELECT c FROM CoCatalogoD c"),
    @NamedQuery(name = "CoCatalogoD.findById", query = "SELECT c FROM CoCatalogoD c WHERE c.id = :id"),
    @NamedQuery(name = "CoCatalogoD.findByDescripcion", query = "SELECT c FROM CoCatalogoD c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CoCatalogoD.findByAjustable", query = "SELECT c FROM CoCatalogoD c WHERE c.ajustable = :ajustable"),
    @NamedQuery(name = "CoCatalogoD.findByDepreciable", query = "SELECT c FROM CoCatalogoD c WHERE c.depreciable = :depreciable"),
    @NamedQuery(name = "CoCatalogoD.findByIntangible", query = "SELECT c FROM CoCatalogoD c WHERE c.intangible = :intangible"),
    @NamedQuery(name = "CoCatalogoD.findByTiempoReposicion", query = "SELECT c FROM CoCatalogoD c WHERE c.tiempoReposicion = :tiempoReposicion"),
    @NamedQuery(name = "CoCatalogoD.findByTiempoVidaUtil", query = "SELECT c FROM CoCatalogoD c WHERE c.tiempoVidaUtil = :tiempoVidaUtil"),
    @NamedQuery(name = "CoCatalogoD.findByPorcentajeIva", query = "SELECT c FROM CoCatalogoD c WHERE c.porcentajeIva = :porcentajeIva"),
    @NamedQuery(name = "CoCatalogoD.findByMenorCuantia", query = "SELECT c FROM CoCatalogoD c WHERE c.menorCuantia = :menorCuantia"),
    @NamedQuery(name = "CoCatalogoD.findByCodigoCubs", query = "SELECT c FROM CoCatalogoD c WHERE c.codigoCubs = :codigoCubs"),
    @NamedQuery(name = "CoCatalogoD.findByGravado", query = "SELECT c FROM CoCatalogoD c WHERE c.gravado = :gravado"),
    @NamedQuery(name = "CoCatalogoD.findByDeterioro", query = "SELECT c FROM CoCatalogoD c WHERE c.deterioro = :deterioro"),
    @NamedQuery(name = "CoCatalogoD.findByVrResidual", query = "SELECT c FROM CoCatalogoD c WHERE c.vrResidual = :vrResidual"),
    @NamedQuery(name = "CoCatalogoD.findByVidaUtil", query = "SELECT c FROM CoCatalogoD c WHERE c.vidaUtil = :vidaUtil"),
    @NamedQuery(name = "CoCatalogoD.findByDescripcionElemento", query = "SELECT c FROM CoCatalogoD c WHERE c.descripcionElemento = :descripcionElemento"),
    @NamedQuery(name = "CoCatalogoD.findByServicio", query = "SELECT c FROM CoCatalogoD c WHERE c.servicio = :servicio"),
    @NamedQuery(name = "CoCatalogoD.findByCapitalizable", query = "SELECT c FROM CoCatalogoD c WHERE c.capitalizable = :capitalizable"),
    @NamedQuery(name = "CoCatalogoD.findByAmortizable", query = "SELECT c FROM CoCatalogoD c WHERE c.amortizable = :amortizable"),
    @NamedQuery(name = "CoCatalogoD.findByDescripcionLarga", query = "SELECT c FROM CoCatalogoD c WHERE c.descripcionLarga = :descripcionLarga")})
public class CoCatalogoD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "AJUSTABLE")
    private String ajustable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DEPRECIABLE")
    private String depreciable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INTANGIBLE")
    private String intangible;
    @Column(name = "TIEMPO_REPOSICION")
    private Short tiempoReposicion;
    @Column(name = "TIEMPO_VIDA_UTIL")
    private Integer tiempoVidaUtil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentajeIva;
    @Size(max = 1)
    @Column(name = "MENOR_CUANTIA")
    private String menorCuantia;
    @Size(max = 100)
    @Column(name = "CODIGO_CUBS")
    private String codigoCubs;
    @Size(max = 2)
    @Column(name = "GRAVADO")
    private String gravado;
    @Size(max = 2)
    @Column(name = "DETERIORO")
    private String deterioro;
    @Size(max = 2)
    @Column(name = "VR_RESIDUAL")
    private String vrResidual;
    @Column(name = "VIDA_UTIL")
    private BigInteger vidaUtil;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_ELEMENTO")
    private String descripcionElemento;
    @Size(max = 2)
    @Column(name = "SERVICIO")
    private String servicio;
    @Size(max = 2)
    @Column(name = "CAPITALIZABLE")
    private String capitalizable;
    @Size(max = 2)
    @Column(name = "AMORTIZABLE")
    private String amortizable;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_LARGA")
    private String descripcionLarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coCatalogoD")
    private Collection<CoDtlleSolAdqD> coDtlleSolAdqDCollection;
    @OneToMany(mappedBy = "idAntecesor")
    private Collection<CoCatalogoD> coCatalogoDCollection;
    @JoinColumn(name = "ID_ANTECESOR", referencedColumnName = "ID")
    @ManyToOne
    private CoCatalogoD idAntecesor;
    @JoinColumn(name = "GRUPO", referencedColumnName = "GRUPO")
    @ManyToOne(optional = false)
    private CoGrupoD grupo;

    public CoCatalogoD() {
    }

    public CoCatalogoD(Long id) {
        this.id = id;
    }

    public CoCatalogoD(Long id, String descripcion, String ajustable, String depreciable, String intangible, BigDecimal porcentajeIva) {
        this.id = id;
        this.descripcion = descripcion;
        this.ajustable = ajustable;
        this.depreciable = depreciable;
        this.intangible = intangible;
        this.porcentajeIva = porcentajeIva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAjustable() {
        return ajustable;
    }

    public void setAjustable(String ajustable) {
        this.ajustable = ajustable;
    }

    public String getDepreciable() {
        return depreciable;
    }

    public void setDepreciable(String depreciable) {
        this.depreciable = depreciable;
    }

    public String getIntangible() {
        return intangible;
    }

    public void setIntangible(String intangible) {
        this.intangible = intangible;
    }

    public Short getTiempoReposicion() {
        return tiempoReposicion;
    }

    public void setTiempoReposicion(Short tiempoReposicion) {
        this.tiempoReposicion = tiempoReposicion;
    }

    public Integer getTiempoVidaUtil() {
        return tiempoVidaUtil;
    }

    public void setTiempoVidaUtil(Integer tiempoVidaUtil) {
        this.tiempoVidaUtil = tiempoVidaUtil;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public String getMenorCuantia() {
        return menorCuantia;
    }

    public void setMenorCuantia(String menorCuantia) {
        this.menorCuantia = menorCuantia;
    }

    public String getCodigoCubs() {
        return codigoCubs;
    }

    public void setCodigoCubs(String codigoCubs) {
        this.codigoCubs = codigoCubs;
    }

    public String getGravado() {
        return gravado;
    }

    public void setGravado(String gravado) {
        this.gravado = gravado;
    }

    public String getDeterioro() {
        return deterioro;
    }

    public void setDeterioro(String deterioro) {
        this.deterioro = deterioro;
    }

    public String getVrResidual() {
        return vrResidual;
    }

    public void setVrResidual(String vrResidual) {
        this.vrResidual = vrResidual;
    }

    public BigInteger getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(BigInteger vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getDescripcionElemento() {
        return descripcionElemento;
    }

    public void setDescripcionElemento(String descripcionElemento) {
        this.descripcionElemento = descripcionElemento;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCapitalizable() {
        return capitalizable;
    }

    public void setCapitalizable(String capitalizable) {
        this.capitalizable = capitalizable;
    }

    public String getAmortizable() {
        return amortizable;
    }

    public void setAmortizable(String amortizable) {
        this.amortizable = amortizable;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    @XmlTransient
    public Collection<CoDtlleSolAdqD> getCoDtlleSolAdqDCollection() {
        return coDtlleSolAdqDCollection;
    }

    public void setCoDtlleSolAdqDCollection(Collection<CoDtlleSolAdqD> coDtlleSolAdqDCollection) {
        this.coDtlleSolAdqDCollection = coDtlleSolAdqDCollection;
    }

    @XmlTransient
    public Collection<CoCatalogoD> getCoCatalogoDCollection() {
        return coCatalogoDCollection;
    }

    public void setCoCatalogoDCollection(Collection<CoCatalogoD> coCatalogoDCollection) {
        this.coCatalogoDCollection = coCatalogoDCollection;
    }

    public CoCatalogoD getIdAntecesor() {
        return idAntecesor;
    }

    public void setIdAntecesor(CoCatalogoD idAntecesor) {
        this.idAntecesor = idAntecesor;
    }

    public CoGrupoD getGrupo() {
        return grupo;
    }

    public void setGrupo(CoGrupoD grupo) {
        this.grupo = grupo;
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
        if (!(object instanceof CoCatalogoD)) {
            return false;
        }
        CoCatalogoD other = (CoCatalogoD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoCatalogoD[ id=" + id + " ]";
    }
    
}
