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
@Table(name = "CO_CATALOGO_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoCatalogoC.findAll", query = "SELECT c FROM CoCatalogoC c"),
    @NamedQuery(name = "CoCatalogoC.findById", query = "SELECT c FROM CoCatalogoC c WHERE c.id = :id"),
    @NamedQuery(name = "CoCatalogoC.findByDescripcion", query = "SELECT c FROM CoCatalogoC c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CoCatalogoC.findByDiasCaducidad", query = "SELECT c FROM CoCatalogoC c WHERE c.diasCaducidad = :diasCaducidad"),
    @NamedQuery(name = "CoCatalogoC.findByDiasAlarma", query = "SELECT c FROM CoCatalogoC c WHERE c.diasAlarma = :diasAlarma"),
    @NamedQuery(name = "CoCatalogoC.findByTiempoReposicion", query = "SELECT c FROM CoCatalogoC c WHERE c.tiempoReposicion = :tiempoReposicion"),
    @NamedQuery(name = "CoCatalogoC.findByStockMinimo", query = "SELECT c FROM CoCatalogoC c WHERE c.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "CoCatalogoC.findByStockMaximo", query = "SELECT c FROM CoCatalogoC c WHERE c.stockMaximo = :stockMaximo"),
    @NamedQuery(name = "CoCatalogoC.findByUnidadMedida", query = "SELECT c FROM CoCatalogoC c WHERE c.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "CoCatalogoC.findByUnidadDistribucion", query = "SELECT c FROM CoCatalogoC c WHERE c.unidadDistribucion = :unidadDistribucion"),
    @NamedQuery(name = "CoCatalogoC.findByFactorConversion", query = "SELECT c FROM CoCatalogoC c WHERE c.factorConversion = :factorConversion"),
    @NamedQuery(name = "CoCatalogoC.findByConsumoFuncionario", query = "SELECT c FROM CoCatalogoC c WHERE c.consumoFuncionario = :consumoFuncionario"),
    @NamedQuery(name = "CoCatalogoC.findByPorcentajeIva", query = "SELECT c FROM CoCatalogoC c WHERE c.porcentajeIva = :porcentajeIva"),
    @NamedQuery(name = "CoCatalogoC.findByCodigoCubs", query = "SELECT c FROM CoCatalogoC c WHERE c.codigoCubs = :codigoCubs"),
    @NamedQuery(name = "CoCatalogoC.findByGravado", query = "SELECT c FROM CoCatalogoC c WHERE c.gravado = :gravado"),
    @NamedQuery(name = "CoCatalogoC.findByDescripcionElemento", query = "SELECT c FROM CoCatalogoC c WHERE c.descripcionElemento = :descripcionElemento")})
public class CoCatalogoC implements Serializable {

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
    @Column(name = "DIAS_CADUCIDAD")
    private Short diasCaducidad;
    @Column(name = "DIAS_ALARMA")
    private Short diasAlarma;
    @Column(name = "TIEMPO_REPOSICION")
    private Short tiempoReposicion;
    @Column(name = "STOCK_MINIMO")
    private Integer stockMinimo;
    @Column(name = "STOCK_MAXIMO")
    private Integer stockMaximo;
    @Size(max = 30)
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @Size(max = 30)
    @Column(name = "UNIDAD_DISTRIBUCION")
    private String unidadDistribucion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTOR_CONVERSION")
    private BigDecimal factorConversion;
    @Column(name = "CONSUMO_FUNCIONARIO")
    private BigDecimal consumoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentajeIva;
    @Size(max = 100)
    @Column(name = "CODIGO_CUBS")
    private String codigoCubs;
    @Size(max = 2)
    @Column(name = "GRAVADO")
    private String gravado;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_ELEMENTO")
    private String descripcionElemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coCatalogoC")
    private Collection<CoDtlleSolAdqC> coDtlleSolAdqCCollection;
    @OneToMany(mappedBy = "idAntecesor")
    private Collection<CoCatalogoC> coCatalogoCCollection;
    @JoinColumn(name = "ID_ANTECESOR", referencedColumnName = "ID")
    @ManyToOne
    private CoCatalogoC idAntecesor;
    @JoinColumn(name = "GRUPO", referencedColumnName = "GRUPO")
    @ManyToOne(optional = false)
    private CoGrupoC grupo;

    public CoCatalogoC() {
    }

    public CoCatalogoC(Long id) {
        this.id = id;
    }

    public CoCatalogoC(Long id, String descripcion, BigDecimal porcentajeIva) {
        this.id = id;
        this.descripcion = descripcion;
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

    public Short getDiasCaducidad() {
        return diasCaducidad;
    }

    public void setDiasCaducidad(Short diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }

    public Short getDiasAlarma() {
        return diasAlarma;
    }

    public void setDiasAlarma(Short diasAlarma) {
        this.diasAlarma = diasAlarma;
    }

    public Short getTiempoReposicion() {
        return tiempoReposicion;
    }

    public void setTiempoReposicion(Short tiempoReposicion) {
        this.tiempoReposicion = tiempoReposicion;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadDistribucion() {
        return unidadDistribucion;
    }

    public void setUnidadDistribucion(String unidadDistribucion) {
        this.unidadDistribucion = unidadDistribucion;
    }

    public BigDecimal getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(BigDecimal factorConversion) {
        this.factorConversion = factorConversion;
    }

    public BigDecimal getConsumoFuncionario() {
        return consumoFuncionario;
    }

    public void setConsumoFuncionario(BigDecimal consumoFuncionario) {
        this.consumoFuncionario = consumoFuncionario;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
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

    public String getDescripcionElemento() {
        return descripcionElemento;
    }

    public void setDescripcionElemento(String descripcionElemento) {
        this.descripcionElemento = descripcionElemento;
    }

    @XmlTransient
    public Collection<CoDtlleSolAdqC> getCoDtlleSolAdqCCollection() {
        return coDtlleSolAdqCCollection;
    }

    public void setCoDtlleSolAdqCCollection(Collection<CoDtlleSolAdqC> coDtlleSolAdqCCollection) {
        this.coDtlleSolAdqCCollection = coDtlleSolAdqCCollection;
    }

    @XmlTransient
    public Collection<CoCatalogoC> getCoCatalogoCCollection() {
        return coCatalogoCCollection;
    }

    public void setCoCatalogoCCollection(Collection<CoCatalogoC> coCatalogoCCollection) {
        this.coCatalogoCCollection = coCatalogoCCollection;
    }

    public CoCatalogoC getIdAntecesor() {
        return idAntecesor;
    }

    public void setIdAntecesor(CoCatalogoC idAntecesor) {
        this.idAntecesor = idAntecesor;
    }

    public CoGrupoC getGrupo() {
        return grupo;
    }

    public void setGrupo(CoGrupoC grupo) {
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
        if (!(object instanceof CoCatalogoC)) {
            return false;
        }
        CoCatalogoC other = (CoCatalogoC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoCatalogoC[ id=" + id + " ]";
    }
    
}
