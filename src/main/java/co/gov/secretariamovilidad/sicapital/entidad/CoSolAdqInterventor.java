/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maikol
 */
@Entity
@Table(name = "CO_SOL_ADQ_INTERVENTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqInterventor.findAll", query = "SELECT c FROM CoSolAdqInterventor c")
    , @NamedQuery(name = "CoSolAdqInterventor.findByVigencia", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.coSolAdqInterventorPK.vigencia = :vigencia")
    , @NamedQuery(name = "CoSolAdqInterventor.findByNumSolAdq", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.coSolAdqInterventorPK.numSolAdq = :numSolAdq")
    , @NamedQuery(name = "CoSolAdqInterventor.findByInternoInterventor", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.coSolAdqInterventorPK.internoInterventor = :internoInterventor")
    , @NamedQuery(name = "CoSolAdqInterventor.findByTipoInterventor", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.tipoInterventor = :tipoInterventor")
    , @NamedQuery(name = "CoSolAdqInterventor.findByCedulaInterventor", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.cedulaInterventor = :cedulaInterventor")
    , @NamedQuery(name = "CoSolAdqInterventor.findByNombreInterventor", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.nombreInterventor = :nombreInterventor")
    , @NamedQuery(name = "CoSolAdqInterventor.findByDependenciaInterventor", query = "SELECT c FROM CoSolAdqInterventor c WHERE c.dependenciaInterventor = :dependenciaInterventor")})
public class CoSolAdqInterventor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqInterventorPK coSolAdqInterventorPK;
    @Size(max = 1)
    @Column(name = "TIPO_INTERVENTOR")
    private String tipoInterventor;
    @Size(max = 30)
    @Column(name = "CEDULA_INTERVENTOR")
    private String cedulaInterventor;
    @Size(max = 200)
    @Column(name = "NOMBRE_INTERVENTOR")
    private String nombreInterventor;
    @Size(max = 60)
    @Column(name = "DEPENDENCIA_INTERVENTOR")
    private String dependenciaInterventor;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false)
        , @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;
    
    @Transient
    private String cargo;
    
    public CoSolAdqInterventor() {
    }

    public CoSolAdqInterventor(CoSolAdqInterventorPK coSolAdqInterventorPK) {
        this.coSolAdqInterventorPK = coSolAdqInterventorPK;
    }

    public CoSolAdqInterventor(short vigencia, int numSolAdq, BigInteger internoInterventor) {
        this.coSolAdqInterventorPK = new CoSolAdqInterventorPK(vigencia, numSolAdq, internoInterventor);
    }

    public CoSolAdqInterventorPK getCoSolAdqInterventorPK() {
        return coSolAdqInterventorPK;
    }

    public void setCoSolAdqInterventorPK(CoSolAdqInterventorPK coSolAdqInterventorPK) {
        this.coSolAdqInterventorPK = coSolAdqInterventorPK;
    }

    public String getTipoInterventor() {
        return tipoInterventor;
    }

    public void setTipoInterventor(String tipoInterventor) {
        this.tipoInterventor = tipoInterventor;
    }

    public String getCedulaInterventor() {
        return cedulaInterventor;
    }

    public void setCedulaInterventor(String cedulaInterventor) {
        this.cedulaInterventor = cedulaInterventor;
    }

    public String getNombreInterventor() {
        return nombreInterventor;
    }

    public void setNombreInterventor(String nombreInterventor) {
        this.nombreInterventor = nombreInterventor;
    }

    public String getDependenciaInterventor() {
        return dependenciaInterventor;
    }

    public void setDependenciaInterventor(String dependenciaInterventor) {
        this.dependenciaInterventor = dependenciaInterventor;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqInterventorPK != null ? coSolAdqInterventorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqInterventor)) {
            return false;
        }
        CoSolAdqInterventor other = (CoSolAdqInterventor) object;
        if ((this.coSolAdqInterventorPK == null && other.coSolAdqInterventorPK != null) || (this.coSolAdqInterventorPK != null && !this.coSolAdqInterventorPK.equals(other.coSolAdqInterventorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqInterventor[ coSolAdqInterventorPK=" + coSolAdqInterventorPK + " ]";
    }
    
}
