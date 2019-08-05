/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_OBLIGACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqObligacion.findAll", query = "SELECT c FROM CoSolAdqObligacion c"),
    @NamedQuery(name = "CoSolAdqObligacion.findByVigencia", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.coSolAdqObligacionPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqObligacion.findByNumSolAdq", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.coSolAdqObligacionPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqObligacion.findByItem", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.coSolAdqObligacionPK.item = :item"),
    @NamedQuery(name = "CoSolAdqObligacion.findByObligacion", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.obligacion = :obligacion"),
    @NamedQuery(name = "CoSolAdqObligacion.findBySecuencia", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.secuencia = :secuencia"),
    @NamedQuery(name = "CoSolAdqObligacion.findByObligacionDe", query = "SELECT c FROM CoSolAdqObligacion c WHERE c.obligacionDe = :obligacionDe")})
public class CoSolAdqObligacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqObligacionPK coSolAdqObligacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "OBLIGACION")
    private String obligacion;
    @Column(name = "SECUENCIA")
    private Short secuencia;
    @Size(max = 1)
    @Column(name = "OBLIGACION_DE")
    private String obligacionDe;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqObligacion() {
    }

    public CoSolAdqObligacion(CoSolAdqObligacionPK coSolAdqObligacionPK) {
        this.coSolAdqObligacionPK = coSolAdqObligacionPK;
    }

    public CoSolAdqObligacion(CoSolAdqObligacionPK coSolAdqObligacionPK, String obligacion) {
        this.coSolAdqObligacionPK = coSolAdqObligacionPK;
        this.obligacion = obligacion;
    }

    public CoSolAdqObligacion(short vigencia, int numSolAdq, int item) {
        this.coSolAdqObligacionPK = new CoSolAdqObligacionPK(vigencia, numSolAdq, item);
    }

    public CoSolAdqObligacionPK getCoSolAdqObligacionPK() {
        return coSolAdqObligacionPK;
    }

    public void setCoSolAdqObligacionPK(CoSolAdqObligacionPK coSolAdqObligacionPK) {
        this.coSolAdqObligacionPK = coSolAdqObligacionPK;
    }

    public String getObligacion() {
        return obligacion;
    }

    public void setObligacion(String obligacion) {
        this.obligacion = obligacion;
    }

    public Short getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Short secuencia) {
        this.secuencia = secuencia;
    }

    public String getObligacionDe() {
        return obligacionDe;
    }

    public void setObligacionDe(String obligacionDe) {
        this.obligacionDe = obligacionDe;
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
        hash += (coSolAdqObligacionPK != null ? coSolAdqObligacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqObligacion)) {
            return false;
        }
        CoSolAdqObligacion other = (CoSolAdqObligacion) object;
        if ((this.coSolAdqObligacionPK == null && other.coSolAdqObligacionPK != null) || (this.coSolAdqObligacionPK != null && !this.coSolAdqObligacionPK.equals(other.coSolAdqObligacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqObligacion[ coSolAdqObligacionPK=" + coSolAdqObligacionPK + " ]";
    }
    
}
