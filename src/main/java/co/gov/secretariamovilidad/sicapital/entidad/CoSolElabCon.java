/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maikol
 */
@Entity
@Table(name = "CO_SOL_ELAB_CON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoSolElabCon.findAll", query = "SELECT c FROM CoSolElabCon c")})
public class CoSolElabCon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoSolElabConPK coSolElabConPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CEDULA_PROVEEDOR")
    private String cedulaProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Size(max = 20)
    @Column(name = "CONSULTA_SICE")
    private String consultaSice;
    @Size(max = 100)
    @Column(name = "NUMERO_PROCESO")
    private String numeroProceso;
    @Column(name = "INTERNO_PROVEEDOR")
    private BigInteger internoProveedor;

    public CoSolElabCon() {
    }

    public CoSolElabCon(CoSolElabConPK coSolElabConPK) {
        this.coSolElabConPK = coSolElabConPK;
    }

    public CoSolElabCon(CoSolElabConPK coSolElabConPK, Date fecha, String cedulaProveedor, String nombreProveedor) {
        this.coSolElabConPK = coSolElabConPK;
        this.fecha = fecha;
        this.cedulaProveedor = cedulaProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public CoSolElabCon(String codigoCompania, short vigencia, int numSolAdq) {
        this.coSolElabConPK = new CoSolElabConPK(codigoCompania, vigencia, numSolAdq);
    }

    public CoSolElabConPK getCoSolElabConPK() {
        return coSolElabConPK;
    }

    public void setCoSolElabConPK(CoSolElabConPK coSolElabConPK) {
        this.coSolElabConPK = coSolElabConPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCedulaProveedor() {
        return cedulaProveedor;
    }

    public void setCedulaProveedor(String cedulaProveedor) {
        this.cedulaProveedor = cedulaProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getConsultaSice() {
        return consultaSice;
    }

    public void setConsultaSice(String consultaSice) {
        this.consultaSice = consultaSice;
    }

    public String getNumeroProceso() {
        return numeroProceso;
    }

    public void setNumeroProceso(String numeroProceso) {
        this.numeroProceso = numeroProceso;
    }

    public BigInteger getInternoProveedor() {
        return internoProveedor;
    }

    public void setInternoProveedor(BigInteger internoProveedor) {
        this.internoProveedor = internoProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSolElabConPK != null ? coSolElabConPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoSolElabCon)) {
            return false;
        }
        CoSolElabCon other = (CoSolElabCon) object;
        if ((this.coSolElabConPK == null && other.coSolElabConPK != null) || (this.coSolElabConPK != null && !this.coSolElabConPK.equals(other.coSolElabConPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon[ coSolElabConPK=" + coSolElabConPK + " ]";
    }
    
}
