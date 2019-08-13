/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author maikol
 */
public class CoSolicitudAdqFachada extends AbstractFacade<CoSolicitudAdq> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoSolicitudAdqFachada() {
        super(CoSolicitudAdq.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public CoSolicitudAdq obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(int vigencia, int numSolAdq)throws SiCapitalEntidadExcepcion{
        try {
            return (CoSolicitudAdq)getEntityManager().createNamedQuery("CoSolicitudAdq.findByVigenciaNumSisconum_sol_adq")
                   .setParameter("vigencia", vigencia)
                   .setParameter("numSolAdq", numSolAdq).getSingleResult();
        }catch (PersistenceException pe) {
            System.out.println("Error: "+pe.getMessage());
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
    }
    
}
