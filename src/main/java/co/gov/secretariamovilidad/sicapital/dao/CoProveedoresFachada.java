package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author maikol
 */
public class CoProveedoresFachada extends AbstractFacade<CoProveedor> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoProveedoresFachada() {
        super(CoProveedor.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public List<CoProveedor> listaProveedorPorRazonSocial(String razonSocial) throws SiCapitalEntidadExcepcion {
        try {
            StringBuilder sql = new StringBuilder("select c from CoProveedor c where c.razonSocial ");
            sql.append("like '%").append(razonSocial).append("%' order by c.razonSocial");
            Query query = getEntityManager().createQuery(sql.toString());
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
    
    public CoProveedor retornaCoProveedorPorNumeroIdentificacion(long numIdentificacion) throws SiCapitalEntidadExcepcion {
        try {
            return (CoProveedor)getEntityManager().createNamedQuery("CoProveedor.findNumIdentificacion", CoProveedor.class)
                   .setParameter("numIdentificacion", numIdentificacion).getSingleResult();
        }catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
    }
    
}
