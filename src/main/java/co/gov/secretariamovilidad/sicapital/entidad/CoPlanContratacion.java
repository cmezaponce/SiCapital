/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_PLAN_CONTRATACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoPlanContratacion.findAll", query = "SELECT c FROM CoPlanContratacion c"),
    @NamedQuery(name = "CoPlanContratacion.findByIdPlanContratacion", query = "SELECT c FROM CoPlanContratacion c WHERE c.idPlanContratacion = :idPlanContratacion"),
    @NamedQuery(name = "CoPlanContratacion.findByCodigoCompania", query = "SELECT c FROM CoPlanContratacion c WHERE c.codigoCompania = :codigoCompania"),
    @NamedQuery(name = "CoPlanContratacion.findByVigencia", query = "SELECT c FROM CoPlanContratacion c WHERE c.vigencia = :vigencia"),
    @NamedQuery(name = "CoPlanContratacion.findByVersion", query = "SELECT c FROM CoPlanContratacion c WHERE c.version = :version"),
    @NamedQuery(name = "CoPlanContratacion.findByFechaPlan", query = "SELECT c FROM CoPlanContratacion c WHERE c.fechaPlan = :fechaPlan")})
public class CoPlanContratacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAN_CONTRATACION")
    private Integer idPlanContratacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_COMPANIA")
    private String codigoCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIGENCIA")
    private short vigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coPlanContratacion")
    private Collection<CoPlanDet> coPlanDetCollection;

    public CoPlanContratacion() {
    }

    public CoPlanContratacion(Integer idPlanContratacion) {
        this.idPlanContratacion = idPlanContratacion;
    }

    public CoPlanContratacion(Integer idPlanContratacion, String codigoCompania, short vigencia, int version, Date fechaPlan) {
        this.idPlanContratacion = idPlanContratacion;
        this.codigoCompania = codigoCompania;
        this.vigencia = vigencia;
        this.version = version;
        this.fechaPlan = fechaPlan;
    }

    public Integer getIdPlanContratacion() {
        return idPlanContratacion;
    }

    public void setIdPlanContratacion(Integer idPlanContratacion) {
        this.idPlanContratacion = idPlanContratacion;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    public short getVigencia() {
        return vigencia;
    }

    public void setVigencia(short vigencia) {
        this.vigencia = vigencia;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getFechaPlan() {
        return fechaPlan;
    }

    public void setFechaPlan(Date fechaPlan) {
        this.fechaPlan = fechaPlan;
    }

    @XmlTransient
    public Collection<CoPlanDet> getCoPlanDetCollection() {
        return coPlanDetCollection;
    }

    public void setCoPlanDetCollection(Collection<CoPlanDet> coPlanDetCollection) {
        this.coPlanDetCollection = coPlanDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanContratacion != null ? idPlanContratacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoPlanContratacion)) {
            return false;
        }
        CoPlanContratacion other = (CoPlanContratacion) object;
        if ((this.idPlanContratacion == null && other.idPlanContratacion != null) || (this.idPlanContratacion != null && !this.idPlanContratacion.equals(other.idPlanContratacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoPlanContratacion[ idPlanContratacion=" + idPlanContratacion + " ]";
    }
    
}
