package co.gov.secretariamovilidad.sicapital.util.excepciones;

import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author maikol
 */
public class SiCapitalPresentacionExcepcion extends Exception {
        
    private static final long serialVersionUID = 1L;
    private Log log = LogFactory.getLog(SiCapitalPresentacionExcepcion.class);
    
    /** Atributo aplicacionBundle : ResourceBundle */
    private static ResourceBundle aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();


    /**
    * Constructor de la clase SiCapitalPresentacionExcepcion.java
    * 
    * @param message
    */
    public SiCapitalPresentacionExcepcion(String message) {
        super(message);
        log.error(message);
    }

    /**
    * Constructor de la clase SiCapitalPresentacionExcepcion.java
    * 
    * @param cause
    */
    public SiCapitalPresentacionExcepcion(Throwable cause) {
        super(cause.getMessage(), cause);
        log.error(cause);
    }

    /**
    * Constructor de la clase SiCapitalPresentacionExcepcion.java
    * 
    * @param message
    * @param cause
    */
    public SiCapitalPresentacionExcepcion(String message, Throwable cause) {
        super(message, cause);
        log.error(cause);
    }

    /**
    * Constructor de la clase SiCapitalPresentacionExcepcion.java
    * 
    * @param error
    */
    public SiCapitalPresentacionExcepcion(ErrorEnum error) {
        super(aplicacionBundle.getString(error.getValor()));
	log.error(aplicacionBundle.getString(error.getValor()));
    }

    /**
    * Constructor de la clase SiCapitalPresentacionExcepcion.java
    * 
    * @param error
    * @param cause
    */
    public SiCapitalPresentacionExcepcion(ErrorEnum error, Throwable cause) {
        super(aplicacionBundle.getString(error.getValor()), cause);
	log.error(cause);
    }
}
