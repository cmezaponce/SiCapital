package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.BinTablas;
import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdp;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqInterventor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqInterventorPK;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdqPK;
import co.gov.secretariamovilidad.sicapital.negocio.implementacion.ContratoFachada;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.Icontrato;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import co.gov.secretariamovilidad.sicapital.util.converter.CoProveedorConverter;
import co.gov.secretariamovilidad.sicapital.util.enums.ElaboracionContratoEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador que tiene toda la logica de la vista de solicitud de elaboracion de contrato
 * @author maikol
 */
@ManagedBean(name = ControladorSolicitudElaboracionContrato.BEAN_NAME)
@SessionScoped
public class ControladorSolicitudElaboracionContrato extends AbstractMB implements Serializable{
    
    private static final long serialVersionUID = 1L;

    /** Logger **/
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorSolicitudElaboracionContrato.class);
    
    /** Alias para el managed bean */
    public static final String BEAN_NAME = "controladorElabContrato";
    
     /** Atributo aplicacionBundle : ResourceBundle */
    private ResourceBundle aplicacionBundle;
    
    /**
     * Atributos de la clase 
     */
    /** ATRIBUTOS TIPO INTERFACE */
    private Icontrato icontrato;
    
    /** ATRIBUTOS TIPO ENTIFAD/OBJETO **/
    private CoProveedor coProveedorAutocompletar;
    private CoProveedor coProveedorSeleccionado;
    private CoSolicitudAdq coSolicitudAdqConsulta;
    private CoSolElabCon coSolElabCon;
    
    /** ATRIBUTOS TIPO LISTA **/
    private List<CoProveedor> listaProveedorAutocompletar;
    private List<CoSolAdqCdp>listaPestCdp;
    
    /** ATRIBUTOS TIPO BOOLEAN **/
    private boolean muestraCampoSeleccionarProveedor;
    private boolean muestraBotonCancelarBusSisco;
    
    /** ATRIBUTOS TIPO STRING **/
    private String valor;
    private String vigencia;
    private String numeroSisco;
    
    @PostConstruct
    @Override
    public void init() {
        aplicacionBundle = ResourceBundleUtil.getRecursosBundleSolicitudElaboracionContrato();
        icontrato = new ContratoFachada();
        coProveedorAutocompletar = new CoProveedor();
        coSolElabCon = new CoSolElabCon();
        listaProveedorAutocompletar = new ArrayList<CoProveedor>();
        muestraCampoSeleccionarProveedor = true;
        muestraBotonCancelarBusSisco = false;
        
        coSolicitudAdqConsulta = new  CoSolicitudAdq();
        coSolicitudAdqConsulta.setCoSolicitudAdqPK(new CoSolicitudAdqPK());
        coSolicitudAdqConsulta.setValorContratacion(BigDecimal.ZERO);
        coSolicitudAdqConsulta.setCoSolAdqInterventor(new CoSolAdqInterventor(new CoSolAdqInterventorPK()));
        listaPestCdp = new ArrayList<CoSolAdqCdp>();
    }
    
    /**
     * Verifica si existe el numero de sol adq
     */
    public void verificarExistenciaNumSolAdqVigencia(){
        try { 
            muestraBotonCancelarBusSisco = false;
            if(vigencia.equals("")) {
                SesionUtil.getInstance().addError(aplicacionBundle.getString("general_mensaje_campo_vigencia")); 
            } else if( numeroSisco.equals("")){
                SesionUtil.getInstance().addError(aplicacionBundle.getString("general_mensaje_campo_numero"));
            }else {               
                coSolicitudAdqConsulta = icontrato.obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(Integer.parseInt(vigencia)
                                                                                                ,Integer.parseInt(numeroSisco));
                if(coSolicitudAdqConsulta == null){                    
                    coSolicitudAdqConsulta = new  CoSolicitudAdq();
                    coSolicitudAdqConsulta.setCoSolicitudAdqPK(new CoSolicitudAdqPK());
                    coSolicitudAdqConsulta.setValorContratacion(BigDecimal.ZERO);
                    coSolicitudAdqConsulta.setCoSolAdqInterventor(new CoSolAdqInterventor(new CoSolAdqInterventorPK()));
                    listaPestCdp = new ArrayList<CoSolAdqCdp>();
                    SesionUtil.getInstance().addError(aplicacionBundle.getString("general_mensaje_sin_resultados"));
                                         
                } else if(coSolicitudAdqConsulta.getEstado().equalsIgnoreCase(ElaboracionContratoEnum.ESTADO_APROBADA.getValor())){
                    coSolElabCon = icontrato.retornaElaboracionContratoVigenciaNumSolAdq(coSolicitudAdqConsulta.getCoSolicitudAdqPK().getVigencia(), 
                                                                                         coSolicitudAdqConsulta.getCoSolicitudAdqPK().getNumSolAdq());
                    muestraBotonCancelarBusSisco = true;
                    String dependenciaSolicitud = icontrato.retornaNombreDependencia(coSolicitudAdqConsulta.getDependencia()
                                                                                     ,coSolicitudAdqConsulta.getCodigoCompania()
                                                                                     ,coSolicitudAdqConsulta.getFechaSolicitud());
                    if(dependenciaSolicitud != null) 
                        coSolicitudAdqConsulta.setDependenciaSolicitud(dependenciaSolicitud);
                    if(coSolicitudAdqConsulta.getCoSolAdqInterventorList() != null &&
                       coSolicitudAdqConsulta.getCoSolAdqInterventorList().size()>0){
                       CoSolAdqInterventor c = coSolicitudAdqConsulta.getCoSolAdqInterventorList().get(0);
                       BinTablas binTablas = icontrato.retornaElaboracionCargo(ElaboracionContratoEnum.ESTADO_CONTRATACION.getValor()
                                                                               ,ElaboracionContratoEnum.ESTADO_CARGOS.getValor()
                                                                               ,c.getCoSolAdqInterventorPK().getInternoInterventor().intValue());
                       c.setCargo(binTablas.getResultado());
                       coSolicitudAdqConsulta.setCoSolAdqInterventor(c);
                    }
                    listaPestCdp = icontrato.retornaListaCdp(coSolicitudAdqConsulta.getCoSolicitudAdqPK().getNumSolAdq()
                                                             ,coSolicitudAdqConsulta.getCoSolicitudAdqPK().getVigencia());
                } else if(!coSolicitudAdqConsulta.getEstado().equalsIgnoreCase(ElaboracionContratoEnum.ESTADO_APROBADA.getValor())) {
                   SesionUtil.getInstance().addInfo(aplicacionBundle.getString("general_mensaje_no_es_aprobado")); 
                }
            }            
               
        } catch (SiCapitalNegocioExcepcion ex) {
            SesionUtil.getInstance().addException(ex);
        }
    }
    
    /**
     * Cancela la busqueda por numero sisco y deja la vista en modo entrada
     */
    public void cancelarBuscarSisco(){
        coSolicitudAdqConsulta = new CoSolicitudAdq();        
        coSolicitudAdqConsulta.setCoSolicitudAdqPK(new CoSolicitudAdqPK());
        coSolElabCon = new CoSolElabCon();
        vigencia = "";
        numeroSisco= "";
        muestraBotonCancelarBusSisco = false;
        listaPestCdp = new ArrayList<CoSolAdqCdp>();
    }
    
    public void salvar() {
        valor = "";
    }
    
    /**
     * Metodo que retorna una lista para el autocompletar
     * @param query
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */    
    public List<CoProveedor> nameSuggestions(String query) throws SiCapitalNegocioExcepcion {
        try {
            CoProveedorConverter.setFuncionarios(new ArrayList<CoProveedor>());
            if (query != null && query.length() >= 3 && query.split(" ").length <= 2) {
                CoProveedorConverter.setFuncionarios(icontrato.listaProveedorPorRazonSocial(query.toUpperCase()));
            }
            return CoProveedorConverter.getProveedor();
	} catch (SiCapitalNegocioExcepcion sne) {
            SesionUtil.getInstance().addException(sne);
	} catch (Exception e) {
            SesionUtil.getInstance().addException(e);
	}
	return null;
    }
    
    /**
     * Cancelar seleccion proveedor
     */
    public void cancelarSeleccionarProveedor(){
        coProveedorAutocompletar = new CoProveedor();
        listaProveedorAutocompletar = new ArrayList<CoProveedor>();
        muestraCampoSeleccionarProveedor = true;
        coProveedorSeleccionado = new CoProveedor();
    }
    
    public String minutaContrato(){
        System.out.println("Devolver elaboracion contrato");
        return "minutaContrato";
    }
    
    /**
     * Selecciona un nombre de la lista de seleccion de proveedores
     * @param event 
     */
    public void onItemSelect(SelectEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();        
            coProveedorSeleccionado = icontrato.retornaCoProveedorPorNumeroIdentificacion(coProveedorAutocompletar.getNumIdentificacion());
            coProveedorAutocompletar = new CoProveedor();
            listaProveedorAutocompletar = new ArrayList<CoProveedor>();
            muestraCampoSeleccionarProveedor = false;
        } catch (SiCapitalNegocioExcepcion ex) {
            SesionUtil.getInstance().addError(ex.getMessage());
        }
    }
  
    /**
     * GETTER AND SETTER   
     * @return 
     */
    public List<CoSolAdqCdp> getListaPestCdp() {
        return listaPestCdp;
    }

    public void setListaPestCdp(List<CoSolAdqCdp> listaPestCdp) {
        this.listaPestCdp = listaPestCdp;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<CoProveedor> getListaProveedorAutocompletar() {
        return listaProveedorAutocompletar;
    }

    public void setListaProveedorAutocompletar(List<CoProveedor> listaProveedorAutocompletar) {
        this.listaProveedorAutocompletar = listaProveedorAutocompletar;
    }

    public CoProveedor getCoProveedorAutocompletar() {
        return coProveedorAutocompletar;
    }

    public void setCoProveedorAutocompletar(CoProveedor coProveedorAutocompletar) {
        this.coProveedorAutocompletar = coProveedorAutocompletar;
    }

    public boolean isMuestraCampoSeleccionarProveedor() {
        return muestraCampoSeleccionarProveedor;
    }

    public void setMuestraCampoSeleccionarProveedor(boolean muestraCampoSeleccionarProveedor) {
        this.muestraCampoSeleccionarProveedor = muestraCampoSeleccionarProveedor;
    }

    public CoProveedor getCoProveedorSeleccionado() {
        return coProveedorSeleccionado;
    }

    public void setCoProveedorSeleccionado(CoProveedor coProveedorSeleccionado) {
        this.coProveedorSeleccionado = coProveedorSeleccionado;
    }

    public CoSolicitudAdq getCoSolicitudAdqConsulta() {
        return coSolicitudAdqConsulta;
    }

    public void setCoSolicitudAdqConsulta(CoSolicitudAdq coSolicitudAdqConsulta) {
        this.coSolicitudAdqConsulta = coSolicitudAdqConsulta;
    }

    public CoSolElabCon getCoSolElabCon() {
        return coSolElabCon;
    }

    public void setCoSolElabCon(CoSolElabCon coSolElabCon) {
        this.coSolElabCon = coSolElabCon;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getNumeroSisco() {
        return numeroSisco;
    }

    public void setNumeroSisco(String numeroSisco) {
        this.numeroSisco = numeroSisco;
    }

    public boolean isMuestraBotonCancelarBusSisco() {
        return muestraBotonCancelarBusSisco;
    }

    public void setMuestraBotonCancelarBusSisco(boolean muestraBotonCancelarBusSisco) {
        this.muestraBotonCancelarBusSisco = muestraBotonCancelarBusSisco;
    }
    
    
}
