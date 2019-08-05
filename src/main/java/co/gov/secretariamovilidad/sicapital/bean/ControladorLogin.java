package co.gov.secretariamovilidad.sicapital.bean;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador que tiene toda la logica de la vista de login
 * @author jjvargasa
 */
@ManagedBean(name = ControladorLogin.BEAN_NAME)
@SessionScoped
public class ControladorLogin extends AbstractMB implements Serializable{
       
    private static final long serialVersionUID = 1L;

    /** Logger **/
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorLogin.class);
     
    
    /** Alias para el managed bean */
    public static final String BEAN_NAME = "controladorLogin";
    
    /** Atributo aplicacionBundle : ResourceBundle */
    private ResourceBundle aplicacionBundle;
    
    /**
     * Atributos de la clase 
     */ 
    String login;
    String password;
    String database;
    
    
    
    @PostConstruct
    @Override
    public void init() {
        this.database = "sicapitalprueba";
    
    }

    public void ingresar(){

        
        
        FacesContext context = FacesContext.getCurrentInstance();
        
       // SesionUtil.getInstance().addError(valor);
        
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

}
