/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjvargasa
 */
@Entity
@Table(name = "CO_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoUsuarios.findAll", query = "SELECT c FROM CoUsuarios c"),
    @NamedQuery(name = "CoUsuarios.findByUsuario", query = "SELECT c FROM CoUsuarios c WHERE c.coUsuariosPK.usuario = :usuario"),
    @NamedQuery(name = "CoUsuarios.findByInternoPersona", query = "SELECT c FROM CoUsuarios c WHERE c.coUsuariosPK.internoPersona = :internoPersona"),
    @NamedQuery(name = "CoUsuarios.findByModulo", query = "SELECT c FROM CoUsuarios c WHERE c.coUsuariosPK.modulo = :modulo"),
    @NamedQuery(name = "CoUsuarios.findByEstado", query = "SELECT c FROM CoUsuarios c WHERE c.coUsuariosPK.estado = :estado")})
public class CoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoUsuariosPK coUsuariosPK;

    public CoUsuarios() {
    }

    public CoUsuarios(CoUsuariosPK coUsuariosPK) {
        this.coUsuariosPK = coUsuariosPK;
    }

    public CoUsuarios(String usuario, long internoPersona, String modulo, String estado) {
        this.coUsuariosPK = new CoUsuariosPK(usuario, internoPersona, modulo, estado);
    }

    public CoUsuariosPK getCoUsuariosPK() {
        return coUsuariosPK;
    }

    public void setCoUsuariosPK(CoUsuariosPK coUsuariosPK) {
        this.coUsuariosPK = coUsuariosPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coUsuariosPK != null ? coUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoUsuarios)) {
            return false;
        }
        CoUsuarios other = (CoUsuarios) object;
        if ((this.coUsuariosPK == null && other.coUsuariosPK != null) || (this.coUsuariosPK != null && !this.coUsuariosPK.equals(other.coUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.secretariamovilidad.sicapital.entidad.CoUsuarios[ coUsuariosPK=" + coUsuariosPK + " ]";
    }
    
}
