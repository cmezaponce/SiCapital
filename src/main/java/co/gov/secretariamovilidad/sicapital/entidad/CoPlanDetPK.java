/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jjvargasa
 */
@Embeddable
public class CoPlanDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAN_CONTRATACION")
    private int idPlanContratacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_COMPANIA")
    private String codigoCompania;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ANO")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DET_PLAN")
    private long idDetPlan;

    public CoPlanDetPK() {
    }

    public CoPlanDetPK(int idPlanContratacion, String codigoCompania, String ano, long idDetPlan) {
        this.idPlanContratacion = idPlanContratacion;
        this.codigoCompania = codigoCompania;
        this.ano = ano;
        this.idDetPlan = idDetPlan;
    }

    public int getIdPlanContratacion() {
        return idPlanContratacion;
    }

    public void setIdPlanContratacion(int idPlanContratacion) {
        this.idPlanContratacion = idPlanContratacion;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public long getIdDetPlan() {
        return idDetPlan;
    }

    public void setIdDetPlan(long idDetPlan) {
        this.idDetPlan = idDetPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPlanContratacion;
        hash += (codigoCompania != null ? codigoCompania.hashCode() : 0);
        hash += (ano != null ? ano.hashCode() : 0);
        hash += (int) idDetPlan;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoPlanDetPK)) {
            return false;
        }
        CoPlanDetPK other = (CoPlanDetPK) object;
        if (this.idPlanContratacion != other.idPlanContratacion) {
            return false;
        }
        if ((this.codigoCompania == null && other.codigoCompania != null) || (this.codigoCompania != null && !this.codigoCompania.equals(other.codigoCompania))) {
            return false;
        }
        if ((this.ano == null && other.ano != null) || (this.ano != null && !this.ano.equals(other.ano))) {
            return false;
        }
        if (this.idDetPlan != other.idDetPlan) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoPlanDetPK[ idPlanContratacion=" + idPlanContratacion + ", codigoCompania=" + codigoCompania + ", ano=" + ano + ", idDetPlan=" + idDetPlan + " ]";
    }
    
}
