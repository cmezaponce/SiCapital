package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maikol
 */
@Embeddable
public class BinTablasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GRUPO")
    private String grupo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ARGUMENTO")
    private String argumento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIG_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigInicial;

    public BinTablasPK() {
    }

    public BinTablasPK(String grupo, String nombre, Date vigInicial) {
        this.grupo = grupo;
        this.nombre = nombre;
        this.vigInicial = vigInicial;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public Date getVigInicial() {
        return vigInicial;
    }

    public void setVigInicial(Date vigInicial) {
        this.vigInicial = vigInicial;
    }
    
    
}
