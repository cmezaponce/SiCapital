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
@Table(name = "CO_SOL_ADQ_ENTREGA_S")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqEntregaS.findAll", query = "SELECT c FROM CoSolAdqEntregaS c"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByVigencia", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByNumSolAdq", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByNumEntrega", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.numEntrega = :numEntrega"),
    @NamedQuery(name = "CoSolAdqEntregaS.findById", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.id = :id"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByConsecutivo", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.consecutivo = :consecutivo"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByItem", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.coSolAdqEntregaSPK.item = :item"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByCantidad", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByCodigoUnidadEjecutora", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.codigoUnidadEjecutora = :codigoUnidadEjecutora"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByDependencia", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.dependencia = :dependencia"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByTipoPlan", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByRubroInterno", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.rubroInterno = :rubroInterno"),
    @NamedQuery(name = "CoSolAdqEntregaS.findByNumeroDisponibilidad", query = "SELECT c FROM CoSolAdqEntregaS c WHERE c.numeroDisponibilidad = :numeroDisponibilidad")})
public class CoSolAdqEntregaS implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqEntregaSPK coSolAdqEntregaSPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_UNIDAD_EJECUTORA")
    private String codigoUnidadEjecutora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "DEPENDENCIA")
    private String dependencia;
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
    private CoDtlleSolAdqS coDtlleSolAdqS;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_ENTREGA", referencedColumnName = "NUM_ENTREGA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolAdqEntrega coSolAdqEntrega;

    public CoSolAdqEntregaS() {
    }

    public CoSolAdqEntregaS(CoSolAdqEntregaSPK coSolAdqEntregaSPK) {
        this.coSolAdqEntregaSPK = coSolAdqEntregaSPK;
    }

    public CoSolAdqEntregaS(CoSolAdqEntregaSPK coSolAdqEntregaSPK, int cantidad, String codigoUnidadEjecutora, String dependencia) {
        this.coSolAdqEntregaSPK = coSolAdqEntregaSPK;
        this.cantidad = cantidad;
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
        this.dependencia = dependencia;
    }

    public CoSolAdqEntregaS(short vigencia, int numSolAdq, short numEntrega, long id, short consecutivo, short item) {
        this.coSolAdqEntregaSPK = new CoSolAdqEntregaSPK(vigencia, numSolAdq, numEntrega, id, consecutivo, item);
    }

    public CoSolAdqEntregaSPK getCoSolAdqEntregaSPK() {
        return coSolAdqEntregaSPK;
    }

    public void setCoSolAdqEntregaSPK(CoSolAdqEntregaSPK coSolAdqEntregaSPK) {
        this.coSolAdqEntregaSPK = coSolAdqEntregaSPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoUnidadEjecutora() {
        return codigoUnidadEjecutora;
    }

    public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
        this.codigoUnidadEjecutora = codigoUnidadEjecutora;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
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

    public CoDtlleSolAdqS getCoDtlleSolAdqS() {
        return coDtlleSolAdqS;
    }

    public void setCoDtlleSolAdqS(CoDtlleSolAdqS coDtlleSolAdqS) {
        this.coDtlleSolAdqS = coDtlleSolAdqS;
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
        hash += (coSolAdqEntregaSPK != null ? coSolAdqEntregaSPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntregaS)) {
            return false;
        }
        CoSolAdqEntregaS other = (CoSolAdqEntregaS) object;
        if ((this.coSolAdqEntregaSPK == null && other.coSolAdqEntregaSPK != null) || (this.coSolAdqEntregaSPK != null && !this.coSolAdqEntregaSPK.equals(other.coSolAdqEntregaSPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntregaS[ coSolAdqEntregaSPK=" + coSolAdqEntregaSPK + " ]";
    }
    
}
