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
public class SiCapitalNegocioExcepcion extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Atributo log : Log
     */
    private Log log = LogFactory.getLog(SiCapitalNegocioExcepcion.class);

    /**
     * Atributo aplicacionBundle : ResourceBundle
     */
    private static ResourceBundle aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();

    /**
     * Constructor de la clase SipseNegocioExcepcion.java
     *
     * @param message
     */
    public SiCapitalNegocioExcepcion(String message) {
        super(message);
        log.error(message);
    }

    /**
     * Constructor de la clase SipseNegocioExcepcion.java
     *
     * @param cause
     */
    public SiCapitalNegocioExcepcion(Throwable cause) {
        super(cause.getMessage(), cause);
        log.error(cause);
    }

    /**
     * Constructor de la clase SipseNegocioExcepcion.java
     *
     * @param message
     * @param cause
     */
    public SiCapitalNegocioExcepcion(String message, Throwable cause) {
        super(message, cause);
        log.error(cause);
    }

    /**
     * Constructor de la clase SipseNegocioExcepcion.java
     *
     * @param error
     */
    public SiCapitalNegocioExcepcion(ErrorEnum error) {
        super(aplicacionBundle.getString(error.getValor()));
        log.error(aplicacionBundle.getString(error.getValor()));
    }

    /**
     * Constructor de la clase SipseNegocioExcepcion.java
     *
     * @param error
     * @param cause
     */
    public SiCapitalNegocioExcepcion(ErrorEnum error, Throwable cause) {
        super(aplicacionBundle.getString(error.getValor()), cause);
        log.error(cause);
    }

}
