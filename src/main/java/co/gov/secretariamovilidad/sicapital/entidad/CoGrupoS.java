/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "CO_GRUPO_S")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoGrupoS.findAll", query = "SELECT c FROM CoGrupoS c"),
    @NamedQuery(name = "CoGrupoS.findByGrupo", query = "SELECT c FROM CoGrupoS c WHERE c.grupo = :grupo"),
    @NamedQuery(name = "CoGrupoS.findByDescripcion", query = "SELECT c FROM CoGrupoS c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CoGrupoS.findByContenedor", query = "SELECT c FROM CoGrupoS c WHERE c.contenedor = :contenedor"),
    @NamedQuery(name = "CoGrupoS.findByCodigoCompania", query = "SELECT c FROM CoGrupoS c WHERE c.codigoCompania = :codigoCompania")})
public class CoGrupoS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUPO")
    private Integer grupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTENEDOR")
    private short contenedor;
    @Size(max = 3)
    @Column(name = "CODIGO_COMPANIA")
    private String codigoCompania;
    @OneToMany(mappedBy = "grupoAntecesor")
    private Collection<CoGrupoS> coGrupoSCollection;
    @JoinColumn(name = "GRUPO_ANTECESOR", referencedColumnName = "GRUPO")
    @ManyToOne
    private CoGrupoS grupoAntecesor;
    @OneToMany(mappedBy = "grupo")
    private Collection<CoCatalogoS> coCatalogoSCollection;

    public CoGrupoS() {
    }

    public CoGrupoS(Integer grupo) {
        this.grupo = grupo;
    }

    public CoGrupoS(Integer grupo, String descripcion, short contenedor) {
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.contenedor = contenedor;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getContenedor() {
        return contenedor;
    }

    public void setContenedor(short contenedor) {
        this.contenedor = contenedor;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    @XmlTransient
    public Collection<CoGrupoS> getCoGrupoSCollection() {
        return coGrupoSCollection;
    }

    public void setCoGrupoSCollection(Collection<CoGrupoS> coGrupoSCollection) {
        this.coGrupoSCollection = coGrupoSCollection;
    }

    public CoGrupoS getGrupoAntecesor() {
        return grupoAntecesor;
    }

    public void setGrupoAntecesor(CoGrupoS grupoAntecesor) {
        this.grupoAntecesor = grupoAntecesor;
    }

    @XmlTransient
    public Collection<CoCatalogoS> getCoCatalogoSCollection() {
        return coCatalogoSCollection;
    }

    public void setCoCatalogoSCollection(Collection<CoCatalogoS> coCatalogoSCollection) {
        this.coCatalogoSCollection = coCatalogoSCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupo != null ? grupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoGrupoS)) {
            return false;
        }
        CoGrupoS other = (CoGrupoS) object;
        if ((this.grupo == null && other.grupo != null) || (this.grupo != null && !this.grupo.equals(other.grupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoGrupoS[ grupo=" + grupo + " ]";
    }
    
}
