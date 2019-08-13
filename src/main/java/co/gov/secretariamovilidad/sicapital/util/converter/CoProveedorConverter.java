/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.util.converter;

import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author maikol
 */
@FacesConverter("coProveedorConverter")
public class CoProveedorConverter implements Converter {

    public static List<CoProveedor> proveedor;

    /**
     * Metodo encargado de retornar el atributo funcionarios
     *
     * @return proveedor : List<CoProveedor>
     */
    public static List<CoProveedor> getProveedor() {
        return proveedor;
    }

    /**
     * Metodo encargado de modificar el atributo funcionarios
     *
     * @param proveedor : List<CoProveedor>
     */
    public static void setFuncionarios(List<CoProveedor> proveedor) {
        CoProveedorConverter.proveedor = proveedor;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if ((submittedValue == null) || (submittedValue.trim().equals("")) || proveedor == null) {
            return null;
        }
        try {
            Long number = Long.parseLong(submittedValue);
            for (CoProveedor s : proveedor) {
                if (new Long(s.getNumIdentificacion()).equals(number)) {
                    return s;
                }
            }
        } catch (NumberFormatException nfe) {
            //new SipsePresentacionExcepcion(nfe);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        }
        return String.valueOf(((CoProveedor) value).getNumIdentificacion());
    }

}
