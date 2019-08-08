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
@Table(name = "CO_CATALOGO_S")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoCatalogoS.findAll", query = "SELECT c FROM CoCatalogoS c"),
    @NamedQuery(name = "CoCatalogoS.findById", query = "SELECT c FROM CoCatalogoS c WHERE c.id = :id"),
    @NamedQuery(name = "CoCatalogoS.findByDescripcion", query = "SELECT c FROM CoCatalogoS c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CoCatalogoS.findByPorcentajeIva", query = "SELECT c FROM CoCatalogoS c WHERE c.porcentajeIva = :porcentajeIva"),
    @NamedQuery(name = "CoCatalogoS.findByCodigoCubs", query = "SELECT c FROM CoCatalogoS c WHERE c.codigoCubs = :codigoCubs")})
public class CoCatalogoS implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentajeIva;
    @Size(max = 100)
    @Column(name = "CODIGO_CUBS")
    private String codigoCubs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coCatalogoS")
    private Collection<CoDtlleSolAdqS> coDtlleSolAdqSCollection;
    @OneToMany(mappedBy = "idAntecesor")
    private Collection<CoCatalogoS> coCatalogoSCollection;
    @JoinColumn(name = "ID_ANTECESOR", referencedColumnName = "ID")
    @ManyToOne
    private CoCatalogoS idAntecesor;
    @JoinColumn(name = "GRUPO", referencedColumnName = "GRUPO")
    @ManyToOne
    private CoGrupoS grupo;

    public CoCatalogoS() {
    }

    public CoCatalogoS(Long id) {
        this.id = id;
    }

    public CoCatalogoS(Long id, String descripcion, BigDecimal porcentajeIva) {
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

    @XmlTransient
    public Collection<CoDtlleSolAdqS> getCoDtlleSolAdqSCollection() {
        return coDtlleSolAdqSCollection;
    }

    public void setCoDtlleSolAdqSCollection(Collection<CoDtlleSolAdqS> coDtlleSolAdqSCollection) {
        this.coDtlleSolAdqSCollection = coDtlleSolAdqSCollection;
    }

    @XmlTransient
    public Collection<CoCatalogoS> getCoCatalogoSCollection() {
        return coCatalogoSCollection;
    }

    public void setCoCatalogoSCollection(Collection<CoCatalogoS> coCatalogoSCollection) {
        this.coCatalogoSCollection = coCatalogoSCollection;
    }

    public CoCatalogoS getIdAntecesor() {
        return idAntecesor;
    }

    public void setIdAntecesor(CoCatalogoS idAntecesor) {
        this.idAntecesor = idAntecesor;
    }

    public CoGrupoS getGrupo() {
        return grupo;
    }

    public void setGrupo(CoGrupoS grupo) {
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
        if (!(object instanceof CoCatalogoS)) {
            return false;
        }
        CoCatalogoS other = (CoCatalogoS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoCatalogoS[ id=" + id + " ]";
    }
    
}
