package co.gov.secretariamovilidad.sicapital.util;

import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalPresentacionExcepcion;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maikol
 */
public class SesionUtil {

    private static SesionUtil sesionUtilidades = null;
    private static final Logger log = LoggerFactory.getLogger(SesionUtil.class);

    /**
     * Atributo aplicacion : ResourceBundle
     */
    private ResourceBundle aplicacion;

    /**
     * Metodo constructor de la clase.
     *
     */
    private SesionUtil() {
        aplicacion = ResourceBundleUtil.getAplicacionBundle();
    }

    public static SesionUtil getInstance() {
        if (sesionUtilidades == null) {
            sesionUtilidades = new SesionUtil();
        }
        return sesionUtilidades;
    }

    /**
     * Metodo encargado de limpiar la sesion de usuario.
     *
     * @param sesion
     * @throws java.lang.Exception
     */
    public void limpiarSesionMenu(HttpSession sesion) throws SiCapitalPresentacionExcepcion {
        try {
            if (sesion != null) {
                // Obtener los atributos de la sesion
                Enumeration<String> atributos = sesion.getAttributeNames();
                while (atributos.hasMoreElements()) {
                    String atributo = atributos.nextElement();
                    if (!atributo.equals("isLogin") && !atributo.equals("usuarioSesion")) {
                        sesion.removeAttribute(atributo);
                    }
                }
            }
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    /**
     * Metodo encargado de cerrar la sesion
     *
     * @throws java.lang.Exception
     */
    public void cerrarSesion() throws SiCapitalPresentacionExcepcion {
        try {
            limpiarSesionMenu(getSession());
        } catch (SiCapitalPresentacionExcepcion spe) {
            throw spe;
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        } finally {
            FacesContext fc = getFacesContext();
            HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
            request.getSession().invalidate();
        }
    }

    /**
     * Metodo encargado de retornar la sesion
     *
     * @return HttpSession
     */
    public HttpSession getSession() throws SiCapitalPresentacionExcepcion {
        try {
            return (HttpSession) getFacesContext().getExternalContext().getSession(true);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    /**
     * Metodo encargado de retornar un atributo de sesion
     *
     * @param key : String - Nombre del atributo de sesion
     * @return Object
     */
    public Object getFromSession(String key) throws SiCapitalPresentacionExcepcion {
        try {
            HttpSession sesion = getSession();
            return sesion.getAttribute(key);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    protected void setIntoSession(final String key, final Object value) throws SiCapitalPresentacionExcepcion {
        try {
            if (getFromSession(key) != null) {
                throw new RuntimeException("Identificador duplicado en sesion: " + key);
            }
            getSession().setAttribute(key, value);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    public void removeFromSession(final String key) throws SiCapitalPresentacionExcepcion {
        try {
            getSession().removeAttribute(key);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    public void setIntoSessionReplace(final String key, final Object value) throws SiCapitalPresentacionExcepcion {
        try {
            if (getFromSession(key) != null) {
                removeFromSession(key);
            }
            getSession().setAttribute(key, value);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    /**
     * Metodo encargado de retornar un bean de sesion
     *
     * @param nameBean : String
     * @return Object
     */
    public Object getSessionManagedBean(String nameBean) throws SiCapitalPresentacionExcepcion {
        try {
            ELContext elContext = getFacesContext().getELContext();
            return getFacesContext().getApplication().getELResolver().getValue(elContext, null, nameBean);
        } catch (Exception e) {
            throw new SiCapitalPresentacionExcepcion(e);
        }
    }

    /**
     * ****** MANEJO DE LOS MENSAJES ******
     */
    /**
     * Método que muestra un mensaje de tipo Info
     *
     * @param msj
     */
    public void addInfo(String msj) {
        try {
            getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msj, msj));
            if (!getFacesContext().getExternalContext().getFlash().isKeepMessages()) {
                getFacesContext().getExternalContext().getFlash().setKeepMessages(true);
            }
        } catch (Exception e) {
            addException(e);
        }
    }

    /**
     * Metodo que muestra un mensaje de tipo Warning
     *
     * @param msj
     */
    public void addWarn(String msj) {
        try {
            getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msj, msj));
        } catch (Exception e) {
            addException(e);
        }
    }

    /**
     * Metodo que muestra un mensaje de tipo Error
     *
     * @param msj
     */
    public void addError(String msj) {
        try {
            getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, ""));
        } catch (Exception e) {
            addException(e);
        }
    }

    /**
     * Método que muestra un mensaje de tipo Info
     *
     * @param value : {ErrorEnum}
     */
    public void addError(ErrorEnum value) {
        try {
            String msj = aplicacion.getString(value.getValor());
            getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, ""));
        } catch (Exception ex) {
            addException(ex);
        }
    }

    /**
     * Metodo que muestra un mensaje de tipo Fatal
     *
     * @param msj
     */
    public void addFatal(String msj) {
        try {
            getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msj, ""));
        } catch (Exception e) {
            addException(e);
        }
    }

    /**
     * Metodo que muestra una excepcion
     *
     * @param excepcion
     */
    public void addException(Throwable excepcion) {
        String mensaje = null;
        try {
            log.error(excepcion.getMessage(), excepcion);
            if (getFacesContext().getMessageList().isEmpty()) {
                mensaje = excepcion.toString();
                getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, mensaje));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * ****** UTILIDADES DE SESSION ******
     */
    public SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    /**
     * Método encargado de cambiar la localización regional de idioma. <br/>
     * La localización por defecto es 'es'
     *
     * @param language {'es', 'en', ...}
     */
    public void setLocale(String language) {
        getFacesContext().getViewRoot().setLocale(new Locale(language));
    }

    /**
     * Método encargado de retornar el contexto
     *
     * @return la instancia del contexto
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Método encargado de agregar un mensaje de error por consola
     *
     * @param msj
     */
    public void addErrorLog(String msj) {
        log.error(msj);
    }

    /**
     * Método encargado de agregar un mensaje por consola
     *
     * @param msj
     */
    public void addInfoLog(String msj) {
        log.info(msj);
    }

    /**
     *  Retorna el valor respectivo a la llave en un archivo de propiedades
     * @param llave, llave con la que se parametrizo el mensaje
     * @param parametros, Arreglo de objetos con los parametros que recibe el mensaje, ejp: Cambio a estado [0]
     * @return
     */
    public String retornaValorDeArchivoDePropiedades(String llave, Object[] parametros){
        String mensaje = "";
        Properties propiedad = new Properties();
        //InputStream entrada = SesionUtil.class.getClassLoader().getResourceAsStream("co/gov/secretariamovilidad/sicapital/util/aplicacion.properties");
        InputStream entrada = SesionUtil.class.getClassLoader().getResourceAsStream("co/gov/secretariamovilidad/sicapital/aplicacion.properties");
        try{
            // Cargar el archivo de propiedades
            propiedad.load(entrada);
            entrada.close();
            // Obtiene el valor de la llave enviada
            mensaje = propiedad.getProperty(llave);
            // Comprobar que se puede devolver el mensaje
            if(mensaje == null || mensaje.trim().equals("")){
                mensaje = "Error inesperado consultando el mensaje parametrizado con la llave "+llave+" en el archivo de propiedades";
                return mensaje;
            }
            // Si el mensaje contiene parametros, se asigna el valor de los mismos de acuerdo con lo recibido
            if(parametros != null){
                mensaje = MessageFormat.format(mensaje, parametros);
            }
        } catch(Exception e){
            addException(e);
        }
        return mensaje;
    }
}
