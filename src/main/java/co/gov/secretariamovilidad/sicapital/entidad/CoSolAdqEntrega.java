/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_SOL_ADQ_ENTREGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolAdqEntrega.findAll", query = "SELECT c FROM CoSolAdqEntrega c"),
    @NamedQuery(name = "CoSolAdqEntrega.findByVigencia", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.coSolAdqEntregaPK.vigencia = :vigencia"),
    @NamedQuery(name = "CoSolAdqEntrega.findByNumSolAdq", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.coSolAdqEntregaPK.numSolAdq = :numSolAdq"),
    @NamedQuery(name = "CoSolAdqEntrega.findByNumEntrega", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.coSolAdqEntregaPK.numEntrega = :numEntrega"),
    @NamedQuery(name = "CoSolAdqEntrega.findByTiempoEntrega", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.tiempoEntrega = :tiempoEntrega"),
    @NamedQuery(name = "CoSolAdqEntrega.findByTipoTiempoEntrega", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.tipoTiempoEntrega = :tipoTiempoEntrega"),
    @NamedQuery(name = "CoSolAdqEntrega.findByEventoInicia", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.eventoInicia = :eventoInicia"),
    @NamedQuery(name = "CoSolAdqEntrega.findByObservaciones", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CoSolAdqEntrega.findByNumPago", query = "SELECT c FROM CoSolAdqEntrega c WHERE c.numPago = :numPago")})
public class CoSolAdqEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolAdqEntregaPK coSolAdqEntregaPK;
    @Column(name = "TIEMPO_ENTREGA")
    private Short tiempoEntrega;
    @Size(max = 30)
    @Column(name = "TIPO_TIEMPO_ENTREGA")
    private String tipoTiempoEntrega;
    @Size(max = 30)
    @Column(name = "EVENTO_INICIA")
    private String eventoInicia;
    @Size(max = 4000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "NUM_PAGO")
    private Short numPago;
    @JoinColumns({
        @JoinColumn(name = "VIGENCIA", referencedColumnName = "VIGENCIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_SOL_ADQ", referencedColumnName = "NUM_SOL_ADQ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CoSolicitudAdq coSolicitudAdq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolAdqEntrega")
    private Collection<CoSolAdqEntregaC> coSolAdqEntregaCCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolAdqEntrega")
    private Collection<CoSolAdqEntregaD> coSolAdqEntregaDCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSolAdqEntrega")
    private Collection<CoSolAdqEntregaS> coSolAdqEntregaSCollection;

    public CoSolAdqEntrega() {
    }

    public CoSolAdqEntrega(CoSolAdqEntregaPK coSolAdqEntregaPK) {
        this.coSolAdqEntregaPK = coSolAdqEntregaPK;
    }

    public CoSolAdqEntrega(short vigencia, int numSolAdq, short numEntrega) {
        this.coSolAdqEntregaPK = new CoSolAdqEntregaPK(vigencia, numSolAdq, numEntrega);
    }

    public CoSolAdqEntregaPK getCoSolAdqEntregaPK() {
        return coSolAdqEntregaPK;
    }

    public void setCoSolAdqEntregaPK(CoSolAdqEntregaPK coSolAdqEntregaPK) {
        this.coSolAdqEntregaPK = coSolAdqEntregaPK;
    }

    public Short getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Short tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getTipoTiempoEntrega() {
        return tipoTiempoEntrega;
    }

    public void setTipoTiempoEntrega(String tipoTiempoEntrega) {
        this.tipoTiempoEntrega = tipoTiempoEntrega;
    }

    public String getEventoInicia() {
        return eventoInicia;
    }

    public void setEventoInicia(String eventoInicia) {
        this.eventoInicia = eventoInicia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Short getNumPago() {
        return numPago;
    }

    public void setNumPago(Short numPago) {
        this.numPago = numPago;
    }

    public CoSolicitudAdq getCoSolicitudAdq() {
        return coSolicitudAdq;
    }

    public void setCoSolicitudAdq(CoSolicitudAdq coSolicitudAdq) {
        this.coSolicitudAdq = coSolicitudAdq;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaC> getCoSolAdqEntregaCCollection() {
        return coSolAdqEntregaCCollection;
    }

    public void setCoSolAdqEntregaCCollection(Collection<CoSolAdqEntregaC> coSolAdqEntregaCCollection) {
        this.coSolAdqEntregaCCollection = coSolAdqEntregaCCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaD> getCoSolAdqEntregaDCollection() {
        return coSolAdqEntregaDCollection;
    }

    public void setCoSolAdqEntregaDCollection(Collection<CoSolAdqEntregaD> coSolAdqEntregaDCollection) {
        this.coSolAdqEntregaDCollection = coSolAdqEntregaDCollection;
    }

    @XmlTransient
    public Collection<CoSolAdqEntregaS> getCoSolAdqEntregaSCollection() {
        return coSolAdqEntregaSCollection;
    }

    public void setCoSolAdqEntregaSCollection(Collection<CoSolAdqEntregaS> coSolAdqEntregaSCollection) {
        this.coSolAdqEntregaSCollection = coSolAdqEntregaSCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolAdqEntregaPK != null ? coSolAdqEntregaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolAdqEntrega)) {
            return false;
        }
        CoSolAdqEntrega other = (CoSolAdqEntrega) object;
        if ((this.coSolAdqEntregaPK == null && other.coSolAdqEntregaPK != null) || (this.coSolAdqEntregaPK != null && !this.coSolAdqEntregaPK.equals(other.coSolAdqEntregaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqEntrega[ coSolAdqEntregaPK=" + coSolAdqEntregaPK + " ]";
    }
    
}
