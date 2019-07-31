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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maikol
 */
@ManagedBean(name = ControladorPrueba.BEAN_NAME)
@RequestScoped
public class ControladorPrueba extends AbstractMB{
    
    /** Logger **/
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorPrueba.class);
    
    /** Alias para el managed bean */
    public static final String BEAN_NAME = "controladorArqitectura";
    
    /** Atributo aplicacionBundle : ResourceBundle */
    private ResourceBundle aplicacionBundle;
    
    private Icontrato icontrato;
    /**
     * Atributos de la clase 
     */
    private String texto;
    private String message;
    private String saveMessage;


    private List <CoEntidadesIas> listaCoEntidades;
    private CoEntidadesIas coEntidadesIas;
    private CoEntidadesIas coEntidadesIasEliminar;
    
    @PostConstruct
    public void init(){
        try {
            icontrato = new ContratoFachada();
            coEntidadesIas = new CoEntidadesIas();
            coEntidadesIasEliminar = new CoEntidadesIas();
            listaCoEntidades = new ArrayList<CoEntidadesIas>();
            listaCoEntidades = icontrato.retornaCoEntidadesIas();
            aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        } catch (Exception e) {
            SesionUtil.getInstance().addException(e);
	}
    }
     
    public void saveMessage(ActionEvent actionEvent) throws SiCapitalNegocioExcepcion {
        FacesContext context = FacesContext.getCurrentInstance();
        String msg2 = aplicacionBundle.getString("msg.error.sistema");
        SesionUtil.getInstance().addError(msg2);
        icontrato.crearCoEntidades(coEntidadesIas);
        coEntidadesIas = new CoEntidadesIas();
        listaCoEntidades = icontrato.retornaCoEntidadesIas();
    }
    
    public void eliminarEntidad(ActionEvent event) throws SiCapitalNegocioExcepcion{
        icontrato.removerCoEntidades(coEntidadesIasEliminar);
        coEntidadesIas = new CoEntidadesIas();
        listaCoEntidades = icontrato.retornaCoEntidadesIas();
    }
    
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

    public CoEntidadesIas getCoEntidadesIasEliminar() {
        return coEntidadesIasEliminar;
    }

    public void setCoEntidadesIasEliminar(CoEntidadesIas coEntidadesIasEliminar) {
        this.coEntidadesIasEliminar = coEntidadesIasEliminar;
    }
        public String getSaveMessage() {
        return saveMessage;
    }

    public void setSaveMessage(String saveMessage) {
        this.saveMessage = saveMessage;
    }
    
}
