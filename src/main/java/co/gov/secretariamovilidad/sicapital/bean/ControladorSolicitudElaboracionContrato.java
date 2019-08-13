package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.CdpDto;
import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdqPK;
import co.gov.secretariamovilidad.sicapital.negocio.implementacion.ContratoFachada;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.Icontrato;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import co.gov.secretariamovilidad.sicapital.util.converter.CoProveedorConverter;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
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
    
     /** Atributo tipo interface */
    private Icontrato icontrato;
    
    /**
     * Atributos de la clase 
     */
    private CoProveedor coProveedorAutocompletar;
    private CoProveedor coProveedorSeleccionado;
    private CoSolicitudAdq coSolicitudAdqConsulta;
    private CoSolElabCon coSolElabCon;
    private List<CoProveedor> listaProveedorAutocompletar;
    private boolean muestraCampoSeleccionarProveedor;
    
    List<CdpDto> listaPestCdp;
    private String valor;
    private String vigencia;
    private String numeroSisco;
    
    @PostConstruct
    @Override
    public void init() {
        aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        icontrato = new ContratoFachada();
        coProveedorAutocompletar = new CoProveedor();
        coSolElabCon = new CoSolElabCon();
        listaProveedorAutocompletar = new ArrayList<CoProveedor>();
        muestraCampoSeleccionarProveedor = true;
        coSolicitudAdqConsulta = new CoSolicitudAdq();
        coSolicitudAdqConsulta.setCoSolicitudAdqPK(new CoSolicitudAdqPK());
        listaPestCdp = new ArrayList<CdpDto>();
        for(int i = 0; i< 5; i++){
            CdpDto cdpDto = new CdpDto(1,0,new Date(),1000);
            listaPestCdp.add(cdpDto);
        }
    }
    
    public void verificarExistenciaNumSolAdqVigencia(){
        try {
            coSolicitudAdqConsulta = icontrato.obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(Integer.parseInt(vigencia)
                                                                                            ,Integer.parseInt(numeroSisco));
            if(coSolicitudAdqConsulta == null){
                SesionUtil.getInstance().addError("No existe"); 
            } else if(coSolicitudAdqConsulta.getEstado().equalsIgnoreCase("APROBADA")){
                System.out.println("Encuentra");        
                coSolElabCon = icontrato.retornaElaboracionContratoVigenciaNumSolAdq(coSolicitudAdqConsulta.getCoSolicitudAdqPK().getVigencia(), 
                                                                                     coSolicitudAdqConsulta.getCoSolicitudAdqPK().getNumSolAdq());
                if(coSolElabCon != null) 
                System.out.println("Encuentra 2 "+coSolElabCon.getNombreProveedor()); 
            } else if(!coSolicitudAdqConsulta.getEstado().equalsIgnoreCase("APROBADA")) {
               SesionUtil.getInstance().addInfo("no tiene un estado valido"); 
            }
               
        } catch (SiCapitalNegocioExcepcion ex) {
            SesionUtil.getInstance().addException(ex);
        }
    }
    
    public void salvar() {
        SesionUtil.getInstance().addInfo("Metodo para salvar");
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
            System.out.println("Ingresa name");
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
            System.out.println("INgresa onItemSelect");
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
    public List<CdpDto> getListaPestCdp() {
        return listaPestCdp;
    }

    public void setListaPestCdp(List<CdpDto> listaPestCdp) {
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
}
