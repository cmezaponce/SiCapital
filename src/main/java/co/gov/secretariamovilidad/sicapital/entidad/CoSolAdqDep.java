/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_DEP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqDep.findAll", query = "SELECT c FROM CoSolAdqDep c"),
    @NamedQuery(name = "CoSolAdqDep.findByVigencia", query = "SELECT c FROM CoSolAdqDep c WHERE c.coSolAdqDepPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqDep.findByNumSolAdq", query = "SELECT c FROM CoSolAdqDep c WHERE c.coSolAdqDepPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqDep.findByDependenciaDestino", query = "SELECT c FROM CoSolAdqDep c WHERE c.coSolAdqDepPK.dependenciaDestino = :dependenciaDestino")})
public class CoSolAdqDep implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqDepPK coSolAdqDepPK;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqDep() {
    }

    public CoSolAdqDep(CoSolAdqDepPK coSolAdqDepPK) {
        this.coSolAdqDepPK = coSolAdqDepPK;
    }

    public CoSolAdqDep(short vigencia, int numSolAdq, String dependenciaDestino) {
        this.coSolAdqDepPK = new CoSolAdqDepPK(vigencia, numSolAdq, dependenciaDestino);
    }

    public CoSolAdqDepPK getCoSolAdqDepPK() {
        return coSolAdqDepPK;
    }

    public void setCoSolAdqDepPK(CoSolAdqDepPK coSolAdqDepPK) {
        this.coSolAdqDepPK = coSolAdqDepPK;
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
        hash += (coSolAdqDepPK != null ? coSolAdqDepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqDep)) {
            return false;
        }
        CoSolAdqDep other = (CoSolAdqDep) object;
        if ((this.coSolAdqDepPK == null && other.coSolAdqDepPK != null) || (this.coSolAdqDepPK != null && !this.coSolAdqDepPK.equals(other.coSolAdqDepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqDep[ coSolAdqDepPK=" + coSolAdqDepPK + " ]";
    }
    
}
