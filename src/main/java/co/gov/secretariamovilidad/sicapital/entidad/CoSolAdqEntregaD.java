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
@Table(name = "CO_SOL_ADQ_ENTREGA_D")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqEntregaD.findAll", query = "SELECT c FROM CoSolAdqEntregaD c"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByVigencia", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByNumSolAdq", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByNumEntrega", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.numEntrega = :numEntrega"),
    @NamedQuery(name = "CoSolAdqEntregaD.findById", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.id = :id"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByConsecutivo", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByItem", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.coSolAdqEntregaDPK.item = :item"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByCantidad", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByDependencia", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.dependencia = :dependencia"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.codigoUnidadEjecutora = :codigoUnidadEjecutora"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByTipoPlan", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByRubroInterno", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.rubroInterno = :rubroInterno"),
    @NamedQuery(name = "CoSolAdqEntregaD.findByNumeroDisponibilidad", query = "SELECT c FROM CoSolAdqEntregaD c WHERE c.numeroDisponibilidad = :numeroDisponibilidad")})
public class CoSolAdqEntregaD implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqEntregaDPK coSolAdqEntregaDPK;
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
    private CoDtlleSolAdqD coDtlleSolAdqD;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_ENTREGA", referencedColumnName = "NUM_ENTREGA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolAdqEntrega coSolAdqEntrega;

    public CoSolAdqEntregaD() {
    }

    public CoSolAdqEntregaD(CoSolAdqEntregaDPK coSolAdqEntregaDPK) {
        this.coSolAdqEntregaDPK = coSolAdqEntregaDPK;
    }

    public CoSolAdqEntregaD(CoSolAdqEntregaDPK coSolAdqEntregaDPK, int cantidad, String dependencia, String codigoUnidadEjecutora) {
        this.coSolAdqEntregaDPK = coSolAdqEntregaDPK;
        this.cantidad = cantidad;
        this.dependencia = dependencia;
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    public CoSolAdqEntregaD(short vigencia, int numSolAdq, short numEntrega, long id, short consecutivo, short item) {
        this.coSolAdqEntregaDPK = new CoSolAdqEntregaDPK(vigencia, numSolAdq, numEntrega, id, consecutivo, item);
    }

    public CoSolAdqEntregaDPK getCoSolAdqEntregaDPK() {
        return coSolAdqEntregaDPK;
    }

    public void setCoSolAdqEntregaDPK(CoSolAdqEntregaDPK coSolAdqEntregaDPK) {
        this.coSolAdqEntregaDPK = coSolAdqEntregaDPK;
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

    public CoDtlleSolAdqD getCoDtlleSolAdqD() {
        return coDtlleSolAdqD;
    }

    public void setCoDtlleSolAdqD(CoDtlleSolAdqD coDtlleSolAdqD) {
        this.coDtlleSolAdqD = coDtlleSolAdqD;
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
        hash += (coSolAdqEntregaDPK != null ? coSolAdqEntregaDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntregaD)) {
            return false;
        }
        CoSolAdqEntregaD other = (CoSolAdqEntregaD) object;
        if ((this.coSolAdqEntregaDPK == null && other.coSolAdqEntregaDPK != null) || (this.coSolAdqEntregaDPK != null && !this.coSolAdqEntregaDPK.equals(other.coSolAdqEntregaDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntregaD[ coSolAdqEntregaDPK=" + coSolAdqEntregaDPK + " ]";
    }
    
}
