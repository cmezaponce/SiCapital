package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maikol
 */
@Entity
@Table(name = "CO_PARAMETRO_GENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoParametroGeneral.findAll", query = "SELECT c FROM CoParametroGeneral c"),
    @NamedQuery(name = "CoParametroGeneral.findIdentificador", query = "SELECT c FROM CoParametroGeneral c where c.identificador = :identificador")
})
public class CoParametroGeneral implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARAMETRO")
    private int idParametro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "VALOR")
    private String valor;
     
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPCION_PARAMETRO")
    private String descripcionParametro;

    public CoParametroGeneral() {
    }
    
    public CoParametroGeneral(int idParametro, String identificador, String valor, String descripcionParametro) {
        this.idParametro = idParametro;
        this.identificador = identificador;
        this.valor = valor;
        this.descripcionParametro = descripcionParametro;
    }
    
    
    
    
    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcionParametro() {
        return descripcionParametro;
    }

    public void setDescripcionParametro(String descripcionParametro) {
        this.descripcionParametro = descripcionParametro;
    }
    
    
}
