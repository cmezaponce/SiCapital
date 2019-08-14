package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
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
@Table(name = "BINTABLAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoUsuarios.findAll", query = "SELECT c FROM CoUsuarios c")})

public class BinTablas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BinTablasPK binTablasPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RESULTADO")
    private String resultado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIG_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigFinal;

    public BinTablas() {
    }
    
    public BinTablas(BinTablasPK binTablasPK, String resultado, Date vigFinal) {
        this.binTablasPK = binTablasPK;
        this.resultado = resultado;
        this.vigFinal = vigFinal;
    }
    
    public BinTablasPK getBinTablasPK() {
        return binTablasPK;
    }

    public void setBinTablasPK(BinTablasPK binTablasPK) {
        this.binTablasPK = binTablasPK;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getVigFinal() {
        return vigFinal;
    }

    public void setVigFinal(Date vigFinal) {
        this.vigFinal = vigFinal;
    }
    
    
}
