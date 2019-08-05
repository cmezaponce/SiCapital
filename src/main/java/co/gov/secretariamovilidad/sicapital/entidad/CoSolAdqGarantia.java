/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_GARANTIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqGarantia.findAll", query = "SELECT c FROM CoSolAdqGarantia c"),
    @NamedQuery(name = "CoSolAdqGarantia.findByVigencia", query = "SELECT c FROM CoSolAdqGarantia c WHERE c.coSolAdqGarantiaPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqGarantia.findByNumSolAdq", query = "SELECT c FROM CoSolAdqGarantia c WHERE c.coSolAdqGarantiaPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqGarantia.findByGarantia", query = "SELECT c FROM CoSolAdqGarantia c WHERE c.coSolAdqGarantiaPK.garantia = :garantia"),
    @NamedQuery(name = "CoSolAdqGarantia.findByObservaciones", query = "SELECT c FROM CoSolAdqGarantia c WHERE c.observaciones = :observaciones")})
public class CoSolAdqGarantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqGarantiaPK coSolAdqGarantiaPK;
    @Size(max = 2000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolAdqGarantia")
    private Collection<CoSolAdqAmparo> coSolAdqAmparoCollection;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqGarantia() {
    }

    public CoSolAdqGarantia(CoSolAdqGarantiaPK coSolAdqGarantiaPK) {
        this.coSolAdqGarantiaPK = coSolAdqGarantiaPK;
    }

    public CoSolAdqGarantia(short vigencia, int numSolAdq, String garantia) {
        this.coSolAdqGarantiaPK = new CoSolAdqGarantiaPK(vigencia, numSolAdq, garantia);
    }

    public CoSolAdqGarantiaPK getCoSolAdqGarantiaPK() {
        return coSolAdqGarantiaPK;
    }

    public void setCoSolAdqGarantiaPK(CoSolAdqGarantiaPK coSolAdqGarantiaPK) {
        this.coSolAdqGarantiaPK = coSolAdqGarantiaPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<CoSolAdqAmparo> getCoSolAdqAmparoCollection() {
        return coSolAdqAmparoCollection;
    }

    public void setCoSolAdqAmparoCollection(Collection<CoSolAdqAmparo> coSolAdqAmparoCollection) {
        this.coSolAdqAmparoCollection = coSolAdqAmparoCollection;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqGarantiaPK != null ? coSolAdqGarantiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqGarantia)) {
            return false;
        }
        CoSolAdqGarantia other = (CoSolAdqGarantia) object;
        if ((this.coSolAdqGarantiaPK == null && other.coSolAdqGarantiaPK != null) || (this.coSolAdqGarantiaPK != null && !this.coSolAdqGarantiaPK.equals(other.coSolAdqGarantiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqGarantia[ coSolAdqGarantiaPK=" + coSolAdqGarantiaPK + " ]";
    }
    
}
