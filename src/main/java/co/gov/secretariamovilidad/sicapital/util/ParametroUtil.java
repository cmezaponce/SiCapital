package co.gov.secretariamovilidad.sicapital.util;

import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.negocio.implementacion.ParametroFachada;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.IparametroGeneral;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades de la clase parametro general
 * @author maikol
 */
public class ParametroUtil {
    private static ParametroUtil util;
    private List<String> listaParametro;
    private IparametroGeneral IparametroGeneral;
    
    public ParametroUtil(){
        listaParametro = new ArrayList<String>();
        IparametroGeneral = new ParametroFachada();
    }
    
    public static ParametroUtil getInstance() {
        if (util == null) {
            util = new ParametroUtil();
        }
        return util;
    }
    
    public List<String> retornaParametroLista(String identificador)throws SiCapitalNegocioExcepcion{
        try {
            CoParametroGeneral coParametroGeneral = IparametroGeneral.retornaCoProveedorPorNumeroIdentificacion(identificador);
            if(coParametroGeneral != null){
                String[] valor = coParametroGeneral.getValor().split(",");
                for(String s : valor){
                    listaParametro.add(s);
                }
            }
            return listaParametro;
        } catch (SiCapitalNegocioExcepcion ex) {
            new SiCapitalNegocioExcepcion(ex);
        }
        return null;
    }
}
