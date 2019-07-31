package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author maikol
 */
@Stateless
public class CoEntidadesIasFachada extends AbstractFacade<CoEntidadesIas> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoEntidadesIasFachada() {
        super(CoEntidadesIas.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    /**
     * Retorna la lista de CoEntidadesIas
     * @return
     * @throws SiCapitalEntidadExcepcion 
     */
    public List<CoEntidadesIas> retornaCoEntidadesIas() throws SiCapitalEntidadExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery("CoEntidadesIas.findAll");
            if (!query.getResultList().isEmpty()) {
                return query.getResultList();
            }
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return null;
    }
    
    public void crearCoEntidades(CoEntidadesIas coEntidadesIas)throws SiCapitalEntidadExcepcion {
         try {
             /*getEntityManager().getTransaction().begin();
             create(coEntidadesIas);
             getEntityManager().getTransaction().commit();*/
             createFreeResorces(coEntidadesIas);
        } catch (PersistenceException pe) {
             System.out.println(pe.getMessage());
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
    }
    
     public void removerCoEntidades(CoEntidadesIas coEntidadesIas)throws Exception {
         try {
            getEntityManager().getTransaction().begin();             
             remove(coEntidadesIas);
             getEntityManager().getTransaction().commit();
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
    }
     
     public CoEntidadesIas retornaCoEntidadesIasPorId(int id)throws Exception {
         try {
           Query query = getEntityManager().createNamedQuery("CoEntidadesIas.findById").setParameter("id", id);
           CoEntidadesIas coEntidadesIas = (CoEntidadesIas) query.getSingleResult();
            if (coEntidadesIas != null) {
                return coEntidadesIas;
            }
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
         return null;
     }
}
