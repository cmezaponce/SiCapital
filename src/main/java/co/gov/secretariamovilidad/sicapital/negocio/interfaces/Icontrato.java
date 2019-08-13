/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.negocio.interfaces;

import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
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
    
    CoEntidadesIas retornaCoEntidadesIasPorId(int id) throws SiCapitalNegocioExcepcion;
    
    void removerCoEntidades(CoEntidadesIas coEntidadesIas)throws SiCapitalNegocioExcepcion;
    
    /**
     * Retorna una lista de proveedor filtrando por la razon social
     * @param razonSocial
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    List<CoProveedor> listaProveedorPorRazonSocial(String razonSocial)throws SiCapitalNegocioExcepcion;
    
    /**
     * Retorna un objeto tipo CoProveedor por numero de identificacion
     * @param numIdentificacion
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    CoProveedor retornaCoProveedorPorNumeroIdentificacion(long numIdentificacion) throws SiCapitalNegocioExcepcion;
    
    /**
     * Obtiene un objeto CoSolicitudAdq
     * @param vigencia
     * @param numSolAdq
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    CoSolicitudAdq obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(int vigencia, int numSolAdq) throws SiCapitalNegocioExcepcion;
    
    /**
     * Retorna un objeto CoSolElabCon
     * @param vigencia
     * @param numSolAdq
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    CoSolElabCon retornaElaboracionContratoVigenciaNumSolAdq (int vigencia, int numSolAdq)throws SiCapitalNegocioExcepcion;

}
