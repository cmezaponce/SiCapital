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
@Table(name = "CO_SOL_ADQ_ANEXO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqAnexo.findAll", query = "SELECT c FROM CoSolAdqAnexo c"),
    @NamedQuery(name = "CoSolAdqAnexo.findByVigencia", query = "SELECT c FROM CoSolAdqAnexo c WHERE c.coSolAdqAnexoPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqAnexo.findByNumSolAdq", query = "SELECT c FROM CoSolAdqAnexo c WHERE c.coSolAdqAnexoPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqAnexo.findBySecuencia", query = "SELECT c FROM CoSolAdqAnexo c WHERE c.coSolAdqAnexoPK.secuencia = :secuencia"),
    @NamedQuery(name = "CoSolAdqAnexo.findByDocumento", query = "SELECT c FROM CoSolAdqAnexo c WHERE c.documento = :documento"),
    @NamedQuery(name = "CoSolAdqAnexo.findByObservaciones", query = "SELECT c FROM CoSolAdqAnexo c WHERE c.observaciones = :observaciones")})
public class CoSolAdqAnexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqAnexoPK coSolAdqAnexoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOCUMENTO")
    private String documento;
    @Size(max = 2000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqAnexo() {
    }

    public CoSolAdqAnexo(CoSolAdqAnexoPK coSolAdqAnexoPK) {
        this.coSolAdqAnexoPK = coSolAdqAnexoPK;
    }

    public CoSolAdqAnexo(CoSolAdqAnexoPK coSolAdqAnexoPK, String documento) {
        this.coSolAdqAnexoPK = coSolAdqAnexoPK;
        this.documento = documento;
    }

    public CoSolAdqAnexo(short vigencia, int numSolAdq, int secuencia) {
        this.coSolAdqAnexoPK = new CoSolAdqAnexoPK(vigencia, numSolAdq, secuencia);
    }

    public CoSolAdqAnexoPK getCoSolAdqAnexoPK() {
        return coSolAdqAnexoPK;
    }

    public void setCoSolAdqAnexoPK(CoSolAdqAnexoPK coSolAdqAnexoPK) {
        this.coSolAdqAnexoPK = coSolAdqAnexoPK;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        hash += (coSolAdqAnexoPK != null ? coSolAdqAnexoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqAnexo)) {
            return false;
        }
        CoSolAdqAnexo other = (CoSolAdqAnexo) object;
        if ((this.coSolAdqAnexoPK == null && other.coSolAdqAnexoPK != null) || (this.coSolAdqAnexoPK != null && !this.coSolAdqAnexoPK.equals(other.coSolAdqAnexoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqAnexo[ coSolAdqAnexoPK=" + coSolAdqAnexoPK + " ]";
    }
    
}
