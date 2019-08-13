package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoParametroGeneral;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Fachada que tiene la logica de parametro general
 * @author maikol
 */
public class CoParametroGeneralFachada  extends AbstractFacade<CoParametroGeneralFachada> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoParametroGeneralFachada() {
        super(CoParametroGeneralFachada.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    
    public CoParametroGeneral retornaCoProveedorPorNumeroIdentificacion(String identificador) throws SiCapitalEntidadExcepcion {
        try {
            return (CoParametroGeneral)getEntityManager().createNamedQuery("CoParametroGeneral.findIdentificador")
                   .setParameter("identificador", identificador).getSingleResult();
            
            /*System.out.println("Ingresa retornaCoProveedorPorNumeroIdentificacion");
            Query query = getEntityManager().createNamedQuery("CoParametroGeneral.findIdentificador");
            query.setParameter("identificador", identificador);
            System.out.println("Ingresa retornaCoProveedorPorNumeroIdentificacion 1");
            if(query.getSingleResult() == null) {
                return new CoParametroGeneral();
            } else {
                            System.out.println("Ingresa retornaCoProveedorPorNumeroIdentificacion 2");

                CoParametroGeneral c = (CoParametroGeneral) query.getSingleResult();
                System.out.println("Ingresa retornaCoProveedorPorNumeroIdentificacion 3");
                return c;
            }*/
        }catch (PersistenceException pe) {
            System.out.println("Error PersistenceException: "+pe.getMessage());
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            System.out.println("Error Exception: "+e.getMessage());
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
    }
}
