package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.negocio.implementacion.ContratoFachada;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.Icontrato;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador base para tomar como ejemplo para los demas
 * @author maikol
 */
@ManagedBean(name = ControladorPrueba.BEAN_NAME)
@SessionScoped
public class ControladorPrueba extends AbstractMB{
    
    /** Logger **/
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorPrueba.class);
    
    /** Alias para el managed bean */
    public static final String BEAN_NAME = "controladorArqitectura";
    
    /** Atributo aplicacionBundle : ResourceBundle */
    private ResourceBundle aplicacionBundle;
    
    /** Atributo tipo interface */
    private Icontrato icontrato;
    
    /**
     * Atributos de la clase 
     */
    private String texto;
    private String message;
    private List <CoEntidadesIas> listaCoEntidades;
    private CoEntidadesIas coEntidadesIas;
    private int codigoEntidad;
    
    @PostConstruct
    public void init(){
        try {
            icontrato = new ContratoFachada();
            coEntidadesIas = new CoEntidadesIas();
            listaCoEntidades = new ArrayList<CoEntidadesIas>();
            listaCoEntidades = icontrato.retornaCoEntidadesIas();
            aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        } catch (Exception e) {
            SesionUtil.getInstance().addException(e);
	}
    }
    
    /**
     * Agregar un nuevo objeto CoEntidadesIas
     * @param actionEvent 
     */
    public void saveMessage(ActionEvent actionEvent) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            String msg2 = aplicacionBundle.getString("msg.ok.sistema");
            SesionUtil.getInstance().addError(msg2);
            icontrato.crearCoEntidades(coEntidadesIas);
            coEntidadesIas = new CoEntidadesIas();
            listaCoEntidades = icontrato.retornaCoEntidadesIas();
        }catch(SiCapitalNegocioExcepcion s){
             SesionUtil.getInstance().addError(s.getMessage());
        }
    }
    
    /**
     * Eliminar un objeto CoEntidadesIas
     * @param actionEvent 
     */
    public void eliminarEntidad(ActionEvent actionEvent) {
        try {
            String idTipoSer = actionEvent.getComponent().getAttributes().get("idCodigo").toString();
            CoEntidadesIas c = icontrato.retornaCoEntidadesIasPorId(Integer.parseInt(idTipoSer));
            icontrato.removerCoEntidades(c);
            coEntidadesIas = new CoEntidadesIas();
            listaCoEntidades = icontrato.retornaCoEntidadesIas();
            codigoEntidad = 0;
        }catch(SiCapitalNegocioExcepcion s){
             SesionUtil.getInstance().addError(s.getMessage());
        }
    }
    
    /*
    * SETTER AND GETTER
    */
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<CoEntidadesIas> getListaCoEntidades() {
        return listaCoEntidades;
    }

    public void setListaCoEntidades(List<CoEntidadesIas> listaCoEntidades) {
        this.listaCoEntidades = listaCoEntidades;
    }

    public CoEntidadesIas getCoEntidadesIas() {
        return coEntidadesIas;
    }

    public void setCoEntidadesIas(CoEntidadesIas coEntidadesIas) {
        this.coEntidadesIas = coEntidadesIas;
    }

    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    
}
