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
@Table(name = "CO_SOL_ADQ_CAR_D")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqCarD.findAll", query = "SELECT c FROM CoSolAdqCarD c"),
    @NamedQuery(name = "CoSolAdqCarD.findByVigencia", query = "SELECT c FROM CoSolAdqCarD c WHERE c.coSolAdqCarDPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqCarD.findByNumSolAdq", query = "SELECT c FROM CoSolAdqCarD c WHERE c.coSolAdqCarDPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqCarD.findById", query = "SELECT c FROM CoSolAdqCarD c WHERE c.coSolAdqCarDPK.id = :id"),
    @NamedQuery(name = "CoSolAdqCarD.findByConsecutivo", query = "SELECT c FROM CoSolAdqCarD c WHERE c.coSolAdqCarDPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoSolAdqCarD.findByCaracteristica", query = "SELECT c FROM CoSolAdqCarD c WHERE c.coSolAdqCarDPK.caracteristica = :caracteristica"),
    @NamedQuery(name = "CoSolAdqCarD.findByResultado", query = "SELECT c FROM CoSolAdqCarD c WHERE c.resultado = :resultado"),
    @NamedQuery(name = "CoSolAdqCarD.findByUnidadMedida", query = "SELECT c FROM CoSolAdqCarD c WHERE c.unidadMedida = :unidadMedida")})
public class CoSolAdqCarD implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqCarDPK coSolAdqCarDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RESULTADO")
    private String resultado;
    @Size(max = 30)
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "CONSECUTIVO", referencedColumnName = "CONSECUTIVO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoDtlleSolAdqD coDtlleSolAdqD;

    public CoSolAdqCarD() {
    }

    public CoSolAdqCarD(CoSolAdqCarDPK coSolAdqCarDPK) {
        this.coSolAdqCarDPK = coSolAdqCarDPK;
    }

    public CoSolAdqCarD(CoSolAdqCarDPK coSolAdqCarDPK, String resultado) {
        this.coSolAdqCarDPK = coSolAdqCarDPK;
        this.resultado = resultado;
    }

    public CoSolAdqCarD(short vigencia, int numSolAdq, long id, short consecutivo, String caracteristica) {
        this.coSolAdqCarDPK = new CoSolAdqCarDPK(vigencia, numSolAdq, id, consecutivo, caracteristica);
    }

    public CoSolAdqCarDPK getCoSolAdqCarDPK() {
        return coSolAdqCarDPK;
    }

    public void setCoSolAdqCarDPK(CoSolAdqCarDPK coSolAdqCarDPK) {
        this.coSolAdqCarDPK = coSolAdqCarDPK;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public CoDtlleSolAdqD getCoDtlleSolAdqD() {
        return coDtlleSolAdqD;
    }

    public void setCoDtlleSolAdqD(CoDtlleSolAdqD coDtlleSolAdqD) {
        this.coDtlleSolAdqD = coDtlleSolAdqD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqCarDPK != null ? coSolAdqCarDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqCarD)) {
            return false;
        }
        CoSolAdqCarD other = (CoSolAdqCarD) object;
        if ((this.coSolAdqCarDPK == null && other.coSolAdqCarDPK != null) || (this.coSolAdqCarDPK != null && !this.coSolAdqCarDPK.equals(other.coSolAdqCarDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCarD[ coSolAdqCarDPK=" + coSolAdqCarDPK + " ]";
    }
    
}
