package co.gov.secretariamovilidad.sicapital.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author maikol
 */
@Entity  
@Table(name = "CO_ENTIDADES_IAS")
@NamedQueries({ 
    @NamedQuery(name = "CoEntidadesIas.findAll",query = "SELECT a FROM CoEntidadesIas a")
})  
public class CoEntidadesIas implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO")
    private int codigo;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
