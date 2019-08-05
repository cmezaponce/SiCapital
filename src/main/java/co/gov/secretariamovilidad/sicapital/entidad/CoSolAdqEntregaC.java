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
@Table(name = "CO_SOL_ADQ_ENTREGA_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqEntregaC.findAll", query = "SELECT c FROM CoSolAdqEntregaC c"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByVigencia", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByNumSolAdq", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByNumEntrega", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.numEntrega = :numEntrega"),
    @NamedQuery(name = "CoSolAdqEntregaC.findById", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.id = :id"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByConsecutivo", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByItem", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.coSolAdqEntregaCPK.item = :item"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByCantidad", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByDependencia", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.dependencia = :dependencia"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.codigoUnidadEjecutora = :codigoUnidadEjecutora"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByTipoPlan", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByRubroInterno", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.rubroInterno = :rubroInterno"),
    @NamedQuery(name = "CoSolAdqEntregaC.findByNumeroDisponibilidad", query = "SELECT c FROM CoSolAdqEntregaC c WHERE c.numeroDisponibilidad = :numeroDisponibilidad")})
public class CoSolAdqEntregaC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqEntregaCPK coSolAdqEntregaCPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "DEPENDENCIA")
    private String dependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_UNIDAD_EJECUTORA")
    private String codigoUnidadEjecutora;
    @Size(max = 30)
    @Column(name = "TIPO_PLAN")
    private String tipoPlan;
    @Column(name = "RUBRO_INTERNO")
    private Long rubroInterno;
    @Column(name = "NUMERO_DISPONIBILIDAD")
    private Integer numeroDisponibilidad;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "CONSECUTIVO", referencedColumnName = "CONSECUTIVO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoDtlleSolAdqC coDtlleSolAdqC;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_ENTREGA", referencedColumnName = "NUM_ENTREGA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolAdqEntrega coSolAdqEntrega;

    public CoSolAdqEntregaC() {
    }

    public CoSolAdqEntregaC(CoSolAdqEntregaCPK coSolAdqEntregaCPK) {
        this.coSolAdqEntregaCPK = coSolAdqEntregaCPK;
    }

    public CoSolAdqEntregaC(CoSolAdqEntregaCPK coSolAdqEntregaCPK, int cantidad, String dependencia, String codigoUnidadEjecutora) {
        this.coSolAdqEntregaCPK = coSolAdqEntregaCPK;
        this.cantidad = cantidad;
        this.dependencia = dependencia;
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    public CoSolAdqEntregaC(short vigencia, int numSolAdq, short numEntrega, long id, short consecutivo, short item) {
        this.coSolAdqEntregaCPK = new CoSolAdqEntregaCPK(vigencia, numSolAdq, numEntrega, id, consecutivo, item);
    }

    public CoSolAdqEntregaCPK getCoSolAdqEntregaCPK() {
        return coSolAdqEntregaCPK;
    }

    public void setCoSolAdqEntregaCPK(CoSolAdqEntregaCPK coSolAdqEntregaCPK) {
        this.coSolAdqEntregaCPK = coSolAdqEntregaCPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCodigoUnidadEjecutora() {
        return codigoUnidadEjecutora;
    }

    public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Long getRubroInterno() {
        return rubroInterno;
    }

    public void setRubroInterno(Long rubroInterno) {
        this.rubroInterno = rubroInterno;
    }

    public Integer getNumeroDisponibilidad() {
        return numeroDisponibilidad;
    }

    public void setNumeroDisponibilidad(Integer numeroDisponibilidad) {
        this.numeroDisponibilidad = numeroDisponibilidad;
    }

    public CoDtlleSolAdqC getCoDtlleSolAdqC() {
        return coDtlleSolAdqC;
    }

    public void setCoDtlleSolAdqC(CoDtlleSolAdqC coDtlleSolAdqC) {
        this.coDtlleSolAdqC = coDtlleSolAdqC;
    }

    public CoSolAdqEntrega getCoSolAdqEntrega() {
        return coSolAdqEntrega;
    }

    public void setCoSolAdqEntrega(CoSolAdqEntrega coSolAdqEntrega) {
        this.coSolAdqEntrega = coSolAdqEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqEntregaCPK != null ? coSolAdqEntregaCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntregaC)) {
            return false;
        }
        CoSolAdqEntregaC other = (CoSolAdqEntregaC) object;
        if ((this.coSolAdqEntregaCPK == null && other.coSolAdqEntregaCPK != null) || (this.coSolAdqEntregaCPK != null && !this.coSolAdqEntregaCPK.equals(other.coSolAdqEntregaCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntregaC[ coSolAdqEntregaCPK=" + coSolAdqEntregaCPK + " ]";
    }
    
}
