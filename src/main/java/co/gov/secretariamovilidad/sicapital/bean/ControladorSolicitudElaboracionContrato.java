package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.CdpDto;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
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
    List<CdpDto> listaPestCdp;
    private String valor;
    
    @PostConstruct
    @Override
    public void init() {
        System.out.println("Ingresa c");
        System.out.println("Ingresa");
        aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        listaPestCdp = new ArrayList<CdpDto>();
        for(int i = 0; i< 5; i++){
            CdpDto cdpDto = new CdpDto(1,0,new Date(),1000);
            listaPestCdp.add(cdpDto);
        }
        System.out.println("tam"+listaPestCdp.size());
    }

    public void salvar() {
        System.out.println("ingresa salvar");
        FacesContext context = FacesContext.getCurrentInstance();
        SesionUtil.getInstance().addError(valor);
        valor = "";
    }
    
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

      
    
}
