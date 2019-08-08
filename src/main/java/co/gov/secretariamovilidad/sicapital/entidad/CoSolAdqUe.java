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
@Table(name = "CO_SOL_ADQ_UE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqUe.findAll", query = "SELECT c FROM CoSolAdqUe c"),
    @NamedQuery(name = "CoSolAdqUe.findByVigencia", query = "SELECT c FROM CoSolAdqUe c WHERE c.coSolAdqUePK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqUe.findByNumSolAdq", query = "SELECT c FROM CoSolAdqUe c WHERE c.coSolAdqUePK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqUe.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqUe c WHERE c.coSolAdqUePK.codigoUnidadEjecutora = :codigoUnidadEjecutora")})
public class CoSolAdqUe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqUePK coSolAdqUePK;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;

    public CoSolAdqUe() {
    }

    public CoSolAdqUe(CoSolAdqUePK coSolAdqUePK) {
        this.coSolAdqUePK = coSolAdqUePK;
    }

    public CoSolAdqUe(short vigencia, int numSolAdq, String codigoUnidadEjecutora) {
        this.coSolAdqUePK = new CoSolAdqUePK(vigencia, numSolAdq, codigoUnidadEjecutora);
    }

    public CoSolAdqUePK getCoSolAdqUePK() {
        return coSolAdqUePK;
    }

    public void setCoSolAdqUePK(CoSolAdqUePK coSolAdqUePK) {
        this.coSolAdqUePK = coSolAdqUePK;
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
        hash += (coSolAdqUePK != null ? coSolAdqUePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqUe)) {
            return false;
        }
        CoSolAdqUe other = (CoSolAdqUe) object;
        if ((this.coSolAdqUePK == null && other.coSolAdqUePK != null) || (this.coSolAdqUePK != null && !this.coSolAdqUePK.equals(other.coSolAdqUePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqUe[ coSolAdqUePK=" + coSolAdqUePK + " ]";
    }
    
}
