package co.gov.secretariamovilidad.sicapital.entidad;

/**
 *
 * @author maikol
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CO_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoProveedor.findAll", query = "SELECT c FROM CoProveedor c"),
    @NamedQuery(name = "CoProveedor.findNumIdentificacion", query = "SELECT c FROM CoProveedor c where c.numIdentificacion = :numIdentificacion")
})
public class CoProveedor implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERNO_PROVEEDOR")
    private BigDecimal internoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_IDENTIFICACION")
    private long numIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NATURALEZA")
    private String naturaleza;
    @Size(max = 30)
    @Column(name = "TIPO_ENTIDAD")
    private String tipoEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "NACIONAL")
    private String nacional;
    @Size(max = 1)
    @Column(name = "FILIAL_COLOMBIA")
    private String filialColombia;
    @Size(max = 120)
    @Column(name = "REPRESENTANTE_LEGAL")
    private String representanteLegal;
    @Column(name = "IDENTIFICACION_REPRESENTANTE")
    private Long identificacionRepresentante;
    @Size(max = 120)
    @Column(name = "CONTACTO")
    private String contacto;
    @Size(max = 250)
    @Column(name = "EXPERIENCIA")
    private String experiencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "REGIMEN_RETEFUENTE")
    private String regimenRetefuente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "REGIMEN_IVA")
    private String regimenIva;
    @Size(max = 30)
    @Column(name = "COMPORTAMIENTO")
    private String comportamiento;
    @Size(max = 250)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "NUM_ACTO_ADMINISTRATIVO")
    private Integer numActoAdministrativo;
    @Column(name = "FECHA_ACTO_ADMON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActoAdmon;
    @Size(max = 30)
    @Column(name = "MATRICULA_REGISTRO")
    private String matriculaRegistro;
    @Column(name = "FECHA_MATRICULA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMatriculaRegistro;
    @Column(name = "BANCO_SAP")
    private Short bancoSap;
    @Size(max = 16)
    @Column(name = "NUM_CUENTA_SAP")
    private String numCuentaSap;
    @Size(max = 30)
    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "VIGENCIA_SOCIEDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaSociedad;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "RESTRICCION_REPRESENTANTE")
    private BigDecimal restriccionRepresentante;
    @Size(max = 30)
    @Column(name = "TIPO_IDENT_REPRESENTANTE")
    private String tipoIdentRepresentante;
    @Size(max = 30)
    @Column(name = "TIPO_VALOR")
    private String tipoValor;
    @Column(name = "ID_TERCERO")
    private BigInteger idTercero;
    @Size(max = 30)
    @Column(name = "TIPO_PROVEEDOR")
    private String tipoProveedor;

    public CoProveedor() {
    }

    public CoProveedor(BigDecimal internoProveedor) {
        this.internoProveedor = internoProveedor;
    }

    public CoProveedor(BigDecimal internoProveedor, String tipoIdentificacion, long numIdentificacion, String razonSocial, String naturaleza, String nacional, String regimenRetefuente, String regimenIva) {
        this.internoProveedor = internoProveedor;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.razonSocial = razonSocial;
        this.naturaleza = naturaleza;
        this.nacional = nacional;
        this.regimenRetefuente = regimenRetefuente;
        this.regimenIva = regimenIva;
    }

    public BigDecimal getInternoProveedor() {
        return internoProveedor;
    }

    public void setInternoProveedor(BigDecimal internoProveedor) {
        this.internoProveedor = internoProveedor;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public long getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getNacional() {
        return nacional;
    }

    public void setNacional(String nacional) {
        this.nacional = nacional;
    }

    public String getFilialColombia() {
        return filialColombia;
    }

    public void setFilialColombia(String filialColombia) {
        this.filialColombia = filialColombia;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Long getIdentificacionRepresentante() {
        return identificacionRepresentante;
    }

    public void setIdentificacionRepresentante(Long identificacionRepresentante) {
        this.identificacionRepresentante = identificacionRepresentante;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getRegimenRetefuente() {
        return regimenRetefuente;
    }

    public void setRegimenRetefuente(String regimenRetefuente) {
        this.regimenRetefuente = regimenRetefuente;
    }

    public String getRegimenIva() {
        return regimenIva;
    }

    public void setRegimenIva(String regimenIva) {
        this.regimenIva = regimenIva;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getNumActoAdministrativo() {
        return numActoAdministrativo;
    }

    public void setNumActoAdministrativo(Integer numActoAdministrativo) {
        this.numActoAdministrativo = numActoAdministrativo;
    }

    public Date getFechaActoAdmon() {
        return fechaActoAdmon;
    }

    public void setFechaActoAdmon(Date fechaActoAdmon) {
        this.fechaActoAdmon = fechaActoAdmon;
    }

    public String getMatriculaRegistro() {
        return matriculaRegistro;
    }

    public void setMatriculaRegistro(String matriculaRegistro) {
        this.matriculaRegistro = matriculaRegistro;
    }

    public Date getFechaMatriculaRegistro() {
        return fechaMatriculaRegistro;
    }

    public void setFechaMatriculaRegistro(Date fechaMatriculaRegistro) {
        this.fechaMatriculaRegistro = fechaMatriculaRegistro;
    }

    public Short getBancoSap() {
        return bancoSap;
    }

    public void setBancoSap(Short bancoSap) {
        this.bancoSap = bancoSap;
    }

    public String getNumCuentaSap() {
        return numCuentaSap;
    }

    public void setNumCuentaSap(String numCuentaSap) {
        this.numCuentaSap = numCuentaSap;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Date getVigenciaSociedad() {
        return vigenciaSociedad;
    }

    public void setVigenciaSociedad(Date vigenciaSociedad) {
        this.vigenciaSociedad = vigenciaSociedad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getRestriccionRepresentante() {
        return restriccionRepresentante;
    }

    public void setRestriccionRepresentante(BigDecimal restriccionRepresentante) {
        this.restriccionRepresentante = restriccionRepresentante;
    }

    public String getTipoIdentRepresentante() {
        return tipoIdentRepresentante;
    }

    public void setTipoIdentRepresentante(String tipoIdentRepresentante) {
        this.tipoIdentRepresentante = tipoIdentRepresentante;
    }

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    public BigInteger getIdTercero() {
        return idTercero;
    }

    public void setIdTercero(BigInteger idTercero) {
        this.idTercero = idTercero;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internoProveedor != null ? internoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoProveedor)) {
            return false;
        }
        CoProveedor other = (CoProveedor) object;
        if ((this.internoProveedor == null && other.internoProveedor != null) || (this.internoProveedor != null && !this.internoProveedor.equals(other.internoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.coProveedor[ internoProveedor=" + internoProveedor + " ]";
    }
    
}
