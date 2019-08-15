/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author maikol
 */
@Entity
@Table(name = "TRC_OFICINAS_BANCO_AGRARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrcOficinasBancoAgrario.findAll", query = "SELECT t FROM TrcOficinasBancoAgrario t")
    , @NamedQuery(name = "TrcOficinasBancoAgrario.findByCodigoOficina", query = "SELECT t FROM TrcOficinasBancoAgrario t WHERE t.codigoOficina = :codigoOficina")
    , @NamedQuery(name = "TrcOficinasBancoAgrario.findByNombre", query = "SELECT t FROM TrcOficinasBancoAgrario t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TrcOficinasBancoAgrario.findByCodDepto", query = "SELECT t FROM TrcOficinasBancoAgrario t WHERE t.codDepto = :codDepto")})
public class TrcOficinasBancoAgrario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_OFICINA")
    private String codigoOficina;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4)
    @Column(name = "COD_DEPTO")
    private String codDepto;
    @OneToMany(mappedBy = "ibCodigoBanAgrario")
    private List<TrcInformacionBasica> trcInformacionBasicaList;

    public TrcOficinasBancoAgrario() {
    }

    public TrcOficinasBancoAgrario(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
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
        hash += (codigoOficina != null ? codigoOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrcOficinasBancoAgrario)) {
            return false;
        }
        TrcOficinasBancoAgrario other = (TrcOficinasBancoAgrario) object;
        if ((this.codigoOficina == null && other.codigoOficina != null) || (this.codigoOficina != null && !this.codigoOficina.equals(other.codigoOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.TrcOficinasBancoAgrario[ codigoOficina=" + codigoOficina + " ]";
    }
    
}
