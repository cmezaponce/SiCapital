package co.gov.secretariamovilidad.sicapital.util;

import java.util.ResourceBundle;

/**
 *
 * @author maikol
 */
public class ResourceBundleUtil {
    
    /**
    * Método encargado de retornar el archivo de propiedades generales de la aplicacion
    * 
    * @return ResourceBundle
    */
    public static ResourceBundle getAplicacionBundle() {
        return ResourceBundle.getBundle("co.gov.secretariamovilidad.sicapital.aplicacion");
    }
}
