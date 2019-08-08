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
@Table(name = "CO_SOL_ADQ_CAR_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqCarC.findAll", query = "SELECT c FROM CoSolAdqCarC c"),
    @NamedQuery(name = "CoSolAdqCarC.findByVigencia", query = "SELECT c FROM CoSolAdqCarC c WHERE c.coSolAdqCarCPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqCarC.findByNumSolAdq", query = "SELECT c FROM CoSolAdqCarC c WHERE c.coSolAdqCarCPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqCarC.findById", query = "SELECT c FROM CoSolAdqCarC c WHERE c.coSolAdqCarCPK.id = :id"),
    @NamedQuery(name = "CoSolAdqCarC.findByConsecutivo", query = "SELECT c FROM CoSolAdqCarC c WHERE c.coSolAdqCarCPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoSolAdqCarC.findByCaracteristica", query = "SELECT c FROM CoSolAdqCarC c WHERE c.coSolAdqCarCPK.caracteristica = :caracteristica"),
    @NamedQuery(name = "CoSolAdqCarC.findByResultado", query = "SELECT c FROM CoSolAdqCarC c WHERE c.resultado = :resultado"),
    @NamedQuery(name = "CoSolAdqCarC.findByUnidadMedida", query = "SELECT c FROM CoSolAdqCarC c WHERE c.unidadMedida = :unidadMedida")})
public class CoSolAdqCarC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqCarCPK coSolAdqCarCPK;
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
    private CoDtlleSolAdqC coDtlleSolAdqC;

    public CoSolAdqCarC() {
    }

    public CoSolAdqCarC(CoSolAdqCarCPK coSolAdqCarCPK) {
        this.coSolAdqCarCPK = coSolAdqCarCPK;
    }

    public CoSolAdqCarC(CoSolAdqCarCPK coSolAdqCarCPK, String resultado) {
        this.coSolAdqCarCPK = coSolAdqCarCPK;
        this.resultado = resultado;
    }

    public CoSolAdqCarC(short vigencia, int numSolAdq, long id, short consecutivo, String caracteristica) {
        this.coSolAdqCarCPK = new CoSolAdqCarCPK(vigencia, numSolAdq, id, consecutivo, caracteristica);
    }

    public CoSolAdqCarCPK getCoSolAdqCarCPK() {
        return coSolAdqCarCPK;
    }

    public void setCoSolAdqCarCPK(CoSolAdqCarCPK coSolAdqCarCPK) {
        this.coSolAdqCarCPK = coSolAdqCarCPK;
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

    public CoDtlleSolAdqC getCoDtlleSolAdqC() {
        return coDtlleSolAdqC;
    }

    public void setCoDtlleSolAdqC(CoDtlleSolAdqC coDtlleSolAdqC) {
        this.coDtlleSolAdqC = coDtlleSolAdqC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqCarCPK != null ? coSolAdqCarCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqCarC)) {
            return false;
        }
        CoSolAdqCarC other = (CoSolAdqCarC) object;
        if ((this.coSolAdqCarCPK == null && other.coSolAdqCarCPK != null) || (this.coSolAdqCarCPK != null && !this.coSolAdqCarCPK.equals(other.coSolAdqCarCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCarC[ coSolAdqCarCPK=" + coSolAdqCarCPK + " ]";
    }
    
}
