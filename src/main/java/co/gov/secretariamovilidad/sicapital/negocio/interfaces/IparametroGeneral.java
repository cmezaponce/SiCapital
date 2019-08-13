/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.negocio.interfaces;

import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;

/**
 *
 * @author maikol
 */
public interface IparametroGeneral {
    
    /**
     * Retorna un parametro de la tabla parametro general
     * @param identificador
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    CoParametroGeneral retornaCoProveedorPorNumeroIdentificacion(String identificador) throws SiCapitalNegocioExcepcion;

}
