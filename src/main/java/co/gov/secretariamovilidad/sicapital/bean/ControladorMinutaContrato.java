package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.entidad.CdpDto;
import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.SesionUtil;
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
    
    List<CdpDto> listaPestCdp;
    
    @PostConstruct
    @Override
    public void init() {
        aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
        listaPestCdp = new ArrayList<CdpDto>();
    }
    
    public void enviar(){
        System.out.println("ingresa------");
        FacesContext context = FacesContext.getCurrentInstance();
        SesionUtil.getInstance().addInfo(valor);
        listaPestCdp.add(new CdpDto());
        valor = "";
    }

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
    
    
}
