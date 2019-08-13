package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.CdpDto;
import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.negocio.implementacion.ParametroFachada;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.IparametroGeneral;
import co.gov.secretariamovilidad.sicapital.util.ParametroUtil;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maikol
 */
@ManagedBean(name = ControladorMinutaContrato.BEAN_NAME)
@SessionScoped
public class ControladorMinutaContrato extends AbstractMB implements Serializable{
    
    private static final long serialVersionUID = 1L;

    /** Logger **/
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorMinutaContrato.class);
    
    /** Alias para el managed bean */
    public static final String BEAN_NAME = "controladorMinutaContrato";
    
     /** Atributo aplicacionBundle : ResourceBundle */
    private ResourceBundle aplicacionBundle;
    
    /** Atributo prueba*/
    private String valor;
    
    private IparametroGeneral IparametroGeneral;

    
    private List<CdpDto> listaPestCdp;
    private List<String> listaValor;
    private List<String> listaNivelEducativo;
    private List<String> listaGenero;
    private List<String> listaNacionalidad;
    private List<String> listaRegimenReteFuente;
    private List<String> listaNaturaleza;
    private List<String> listaTipoProveedor;
    private List<String> listaBanco;
    private List<String> listaTipoDocumento;
    private List<String> listaClaseContratista;
    private List<String> listaProfesion;
    private List<String> listaCiudad;
    private List<String> listaRegimenIva;
    
    @PostConstruct
    @Override
    public void init() {
        IparametroGeneral = new ParametroFachada();
        aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        listaPestCdp = new ArrayList<CdpDto>();
        listaValor = new ArrayList<String>();
        listaNivelEducativo = new ArrayList<String>();
        listaGenero = new ArrayList<String>();
        listaNacionalidad = new ArrayList<String>();
        listaRegimenReteFuente = new ArrayList<String>();
        listaNaturaleza = new ArrayList<String>();
        listaTipoProveedor = new ArrayList<String>();
        listaBanco = new ArrayList<String>();
        listaTipoDocumento = new ArrayList<String>();
        listaClaseContratista = new ArrayList<String>();
        listaProfesion = new ArrayList<String>();
        listaCiudad = new ArrayList<String>();
        listaRegimenIva = new ArrayList<String>();
        listaValor.add("uno");
        listaValor.add("Dos");
    }
    
    public void enviar(){
        System.out.println("ingresa------");
        SesionUtil.getInstance().addInfo(valor);
        listaPestCdp.add(new CdpDto());
        valor = "";
    }
    
    public String elaboracionContrato(){
        return "elaboracionContrato";
    }
    
    public void retornaParametroLista(String identificador, List<String> lista)throws SiCapitalNegocioExcepcion{
        try {
            System.out.println("identificador: "+identificador);
            //lista = new ArrayList<String>();
            CoParametroGeneral coParametroGeneral = IparametroGeneral.retornaCoProveedorPorNumeroIdentificacion(identificador);
            if(coParametroGeneral != null){
                String[] valor = coParametroGeneral.getValor().split(",");
                for(String s : valor){
                    lista.add(s);
                }
            }
        } catch (SiCapitalNegocioExcepcion ex) {
            new SiCapitalNegocioExcepcion(ex);
        }
    }
    
    /**
     * GETTER AND SETTER
     * @return 
     */
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<CdpDto> getListaPestCdp() {
        return listaPestCdp;
    }

    public void setListaPestCdp(List<CdpDto> listaPestCdp) {
        this.listaPestCdp = listaPestCdp;
    }

    public List<String> getListaValor() {
        return listaValor;
    }

    public void setListaValor(List<String> listaValor) {
        this.listaValor = listaValor;
    }

    public List<String> getListaNivelEducativo() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("NIVEL_EDUCATIVO", this.listaNivelEducativo);
        return listaNivelEducativo;
    }

    public void setListaNivelEducativo(List<String> listaNivelEducativo) {
        this.listaNivelEducativo = listaNivelEducativo;
    }

    public List<String> getListaGenero() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("GENERO", this.listaGenero);
        return listaGenero;
    }

    public void setListaGenero(List<String> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public List<String> getListaNacionalidad() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("NACIONALIDAD", this.listaNacionalidad);
        return listaNacionalidad;
    }

    public void setListaNacionalidad(List<String> listaNacionalidad) {
        this.listaNacionalidad = listaNacionalidad;
    }

    public List<String> getListaRegimenReteFuente() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("REGIMEN_RETEFUENTE", this.listaRegimenReteFuente);
        //listaRegimenReteFuente = ParametroUtil.getInstance().retornaParametroLista("REGIMEN_RETEFUENTE");
        return listaRegimenReteFuente;
    }

    public void setListaRegimenReteFuente(List<String> listaRegimenReteFuente) {
        this.listaRegimenReteFuente = listaRegimenReteFuente;
    }

    public List<String> getListaNaturaleza() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("NARUTALEZA", this.listaNaturaleza);
        return listaNaturaleza;
    }

    public void setListaNaturaleza(List<String> listaNaturaleza) {
        this.listaNaturaleza = listaNaturaleza;
    }

    public List<String> getListaTipoProveedor() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("TIPO_PROVEEDOR", this.listaTipoProveedor);
        return listaTipoProveedor;
    }

    public void setListaTipoProveedor(List<String> listaTipoProveedor) {
        this.listaTipoProveedor = listaTipoProveedor;
    }

    public List<String> getListaBanco() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("BANCO", this.listaBanco);
        return listaBanco;
    }

    public void setListaBanco(List<String> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public List<String> getListaTipoDocumento() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("TIPO_DOC", this.listaTipoDocumento);
        return listaTipoDocumento;
    }

    public void setListaTipoDocumento(List<String> listaTipoDocumento) throws SiCapitalNegocioExcepcion {        
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public List<String> getListaClaseContratista() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("CLASE_CONTRATISTA", this.listaClaseContratista);
        return listaClaseContratista;
    }

    public void setListaClaseContratista(List<String> listaClaseContratista) {
        this.listaClaseContratista = listaClaseContratista;
    }

    public List<String> getListaProfesion() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("PROFESION", this.listaProfesion);
        return listaProfesion;
    }

    public void setListaProfesion(List<String> listaProfesion) {
        this.listaProfesion = listaProfesion;
    }

    public List<String> getListaCiudad() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("CIUDAD", this.listaCiudad);
        return listaCiudad;
    }

    public void setListaCiudad(List<String> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public List<String> getListaRegimenIva() throws SiCapitalNegocioExcepcion {
        retornaParametroLista("REGIMEN_IVA", this.listaRegimenIva);
        return listaRegimenIva;
    }

    public void setListaRegimenIva(List<String> listaRegimenIva) {
        this.listaRegimenIva = listaRegimenIva;
    }
    
    
}
