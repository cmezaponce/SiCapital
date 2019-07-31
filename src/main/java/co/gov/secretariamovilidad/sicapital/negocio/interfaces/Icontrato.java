/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.negocio.interfaces;

import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.List;

/**
 *
 * @author maikol
 */
public interface Icontrato {
    /**
     * Retorna la lista de CoEntidadesIas
     * @return
     * @throws SiCapitalEntidadExcepcion 
     */
    List<CoEntidadesIas> retornaCoEntidadesIas() throws SiCapitalNegocioExcepcion;
    
    void crearCoEntidades(CoEntidadesIas coEntidadesIas)throws SiCapitalNegocioExcepcion;
    
    void removerCoEntidades(CoEntidadesIas coEntidadesIas)throws SiCapitalNegocioExcepcion;
}
