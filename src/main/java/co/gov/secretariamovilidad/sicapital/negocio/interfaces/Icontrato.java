/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.negocio.interfaces;

import co.gov.secretariamovilidad.sicapital.entidad.BinTablas;
import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdp;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.entidad.TrcTerceros;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author maikol
 */
public interface Icontrato {
    /**
     * Retorna la lista de CoEntidadesIas
     * @return
     * @throws co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion 
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
    
    /**
     * Retorna el nombre de la dependencia de la solicitud
     * @param dependencia
     * @param codigoCom
     * @param fechaSolicitud
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    String retornaNombreDependencia(String dependencia, String codigoCom, Date fechaSolicitud) throws SiCapitalNegocioExcepcion;
    
    /**
     * Retorna el cargo del interventor
     * @param grupo
     * @param nombre
     * @param internoInterventor
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    BinTablas retornaElaboracionCargo(String grupo, String nombre, int internoInterventor) throws SiCapitalNegocioExcepcion;
    
    /**
     * Retorna una lista de los cdps de acuerdo a:
     * @param numSolAdq
     * @param vigencia
     * @return
     * @throws SiCapitalNegocioExcepcion 
     */
    List<CoSolAdqCdp> retornaListaCdp(int numSolAdq, int vigencia) throws SiCapitalNegocioExcepcion;
    
    /**
     * Verifica si una cedula existe
     * @param codigoIdentificacion
     * @return
     * @throws co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion
     * @throws throws SiCapitalNegocioExcepcion; 
     */
    TrcTerceros obtieneTercerosPorIdentificacion(String codigoIdentificacion) throws SiCapitalNegocioExcepcion;
    
    /**
     * actualiza CoSolElabCon
     * @param CoSolElabCon
     * @throws SiCapitalNegocioExcepcion 
     */
    void actualizarCoSolElabCon(CoSolElabCon CoSolElabCon)throws SiCapitalNegocioExcepcion;

}
