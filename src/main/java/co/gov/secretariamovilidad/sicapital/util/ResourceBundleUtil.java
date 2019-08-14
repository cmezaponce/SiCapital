package co.gov.secretariamovilidad.sicapital.util;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 *
 * @author maikol
 */
public class ResourceBundleUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Método encargado de retornar el archivo de propiedades generales de la
     * aplicacion
     *
     * @return ResourceBundle
     */
    public static ResourceBundle getAplicacionBundle() {
        return ResourceBundle.getBundle("co.gov.secretariamovilidad.sicapital.aplicacion");
    }

    /* Método encargado de retornar el archivo de propiedades para los recursos
    * 
    * @return ResourceBundle
     */
    public static ResourceBundle getRecursosBundle() {
        return ResourceBundle.getBundle("co.gov.secretariamovilidad.sicapital.recursos");
    }
    
    /* Método encargado de retornar el archivo de propiedades para los recursos
    * 
    * @return ResourceBundle
     */
    public static ResourceBundle getRecursosBundleSolicitudElaboracionContrato() {
        return ResourceBundle.getBundle("co.gov.secretariamovilidad.sicapital.solicitudElaboracionContrato");
    }
}
