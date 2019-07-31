package co.gov.secretariamovilidad.sicapital.util.excepciones;

import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author maikol
 */
public class SiCapitalEntidadExcepcion extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Atributo log : Log
     */
    private Log log = LogFactory.getLog(SiCapitalEntidadExcepcion.class);

    /**
     * Atributo aplicacionBundle : ResourceBundle
     */
    private static ResourceBundle aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();

    /**
     * Constructor de la clase SipseEntidadExcepcion.java
     *
     * @param message
     */
    public SiCapitalEntidadExcepcion(String message) {
        super(message);
        log.error(message);
    }

    /**
     * Constructor de la clase SipseEntidadExcepcion.java
     *
     * @param cause
     */
    public SiCapitalEntidadExcepcion(Throwable cause) {
        super(aplicacionBundle.getString(ErrorEnum.DBx001.getValor()), cause);
        log.error(cause);
    }

    /**
     * Constructor de la clase SipseEntidadExcepcion.java
     *
     * @param message
     * @param cause
     */
    public SiCapitalEntidadExcepcion(String message, Throwable cause) {
        super(message, cause);
        log.error(cause);
    }

    /**
     * Constructor de la clase SipseEntidadExcepcion.java
     *
     * @param error
     */
    public SiCapitalEntidadExcepcion(ErrorEnum error) {
        super(aplicacionBundle.getString(error.getValor()));
        log.error(aplicacionBundle.getString(error.getValor()));
    }

    /**
     * Constructor de la clase SipseEntidadExcepcion.java
     *
     * @param error
     * @param cause
     */
    public SiCapitalEntidadExcepcion(ErrorEnum error, Throwable cause) {
        super(aplicacionBundle.getString(error.getValor()), cause);
        log.error(cause);
    }
}
