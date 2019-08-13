/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.negocio.implementacion;

import co.gov.secretariamovilidad.sicapital.dao.CoParametroGeneralFachada;
import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.IparametroGeneral;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;

/**
 *
 * @author maikol
 */
public class ParametroFachada implements IparametroGeneral{
    
    CoParametroGeneralFachada coParametroGeneralFachada;
    
    public ParametroFachada(){
        coParametroGeneralFachada = new CoParametroGeneralFachada();
    }

    @Override
    public CoParametroGeneral retornaCoProveedorPorNumeroIdentificacion(String identificador) throws SiCapitalNegocioExcepcion {
        try {
            return coParametroGeneralFachada.retornaCoProveedorPorNumeroIdentificacion(identificador);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }    
    }
}
