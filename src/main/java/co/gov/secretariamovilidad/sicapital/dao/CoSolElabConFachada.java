/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
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
public class CoSolElabConFachada extends AbstractFacade<CoSolElabCon> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoSolElabConFachada() {
        super(CoSolElabCon.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public CoSolElabCon retornaElaboracionContratoVigenciaNumSolAdq (int vigencia, int numSolAdq)throws SiCapitalEntidadExcepcion{
        try {
            StringBuilder sql = new StringBuilder("SELECT c FROM CoSolElabCon c, CoSolicitudAdq csa where c.coSolElabConPK.codigoCompania = csa.codigoCompania ");
            sql.append(" and c.coSolElabConPK.vigencia = csa.coSolicitudAdqPK.vigencia");
            sql.append(" and c.coSolElabConPK.numSolAdq = csa.coSolicitudAdqPK.numSolAdq");
            sql.append(" and csa.coSolicitudAdqPK.vigencia = ").append(vigencia);
            sql.append(" and csa.coSolicitudAdqPK.numSolAdq = ").append(numSolAdq);
            Query query = getEntityManager().createQuery(sql.toString());
            if (!query.getResultList().isEmpty()) {
                return (CoSolElabCon)query.getSingleResult();
            }
            
            /*return (CoSolElabCon)getEntityManager().createNamedQuery("CoSolElabCon.findByVigenciaNumSolAdqCodigoComp")
                   .setParameter("vigencia", vigencia)
                   .setParameter("numSolAdq", numSolAdq).getSingleResult();*/
        }catch (PersistenceException pe) {
            System.out.println("Error :"+pe.getMessage());
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return  null;
    }
}
