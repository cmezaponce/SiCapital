/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_AMPARO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqAmparo.findAll", query = "SELECT c FROM CoSolAdqAmparo c"),
    @NamedQuery(name = "CoSolAdqAmparo.findByVigencia", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.coSolAdqAmparoPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqAmparo.findByNumSolAdq", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.coSolAdqAmparoPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqAmparo.findByGarantia", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.coSolAdqAmparoPK.garantia = :garantia"),
    @NamedQuery(name = "CoSolAdqAmparo.findByAmparo", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.coSolAdqAmparoPK.amparo = :amparo"),
    @NamedQuery(name = "CoSolAdqAmparo.findByPorcentaje", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.porcentaje = :porcentaje"),
    @NamedQuery(name = "CoSolAdqAmparo.findByBase", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.base = :base"),
    @NamedQuery(name = "CoSolAdqAmparo.findByVigenciaAmparo", query = "SELECT c FROM CoSolAdqAmparo c WHERE c.vigenciaAmparo = :vigenciaAmparo")})
public class CoSolAdqAmparo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqAmparoPK coSolAdqAmparoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAJE")
    private BigDecimal porcentaje;
    @Size(max = 30)
    @Column(name = "BASE")
    private String base;
    @Size(max = 500)
    @Column(name = "VIGENCIA_AMPARO")
    private String vigenciaAmparo;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "GARANTIA", referencedColumnName = "GARANTIA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolAdqGarantia coSolAdqGarantia;

    public CoSolAdqAmparo() {
    }

    public CoSolAdqAmparo(CoSolAdqAmparoPK coSolAdqAmparoPK) {
        this.coSolAdqAmparoPK = coSolAdqAmparoPK;
    }

    public CoSolAdqAmparo(short vigencia, int numSolAdq, String garantia, String amparo) {
        this.coSolAdqAmparoPK = new CoSolAdqAmparoPK(vigencia, numSolAdq, garantia, amparo);
    }

    public CoSolAdqAmparoPK getCoSolAdqAmparoPK() {
        return coSolAdqAmparoPK;
    }

    public void setCoSolAdqAmparoPK(CoSolAdqAmparoPK coSolAdqAmparoPK) {
        this.coSolAdqAmparoPK = coSolAdqAmparoPK;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getVigenciaAmparo() {
        return vigenciaAmparo;
    }

    public void setVigenciaAmparo(String vigenciaAmparo) {
        this.vigenciaAmparo = vigenciaAmparo;
    }

    public CoSolAdqGarantia getCoSolAdqGarantia() {
        return coSolAdqGarantia;
    }

    public void setCoSolAdqGarantia(CoSolAdqGarantia coSolAdqGarantia) {
        this.coSolAdqGarantia = coSolAdqGarantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqAmparoPK != null ? coSolAdqAmparoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqAmparo)) {
            return false;
        }
        CoSolAdqAmparo other = (CoSolAdqAmparo) object;
        if ((this.coSolAdqAmparoPK == null && other.coSolAdqAmparoPK != null) || (this.coSolAdqAmparoPK != null && !this.coSolAdqAmparoPK.equals(other.coSolAdqAmparoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqAmparo[ coSolAdqAmparoPK=" + coSolAdqAmparoPK + " ]";
    }
    
}
