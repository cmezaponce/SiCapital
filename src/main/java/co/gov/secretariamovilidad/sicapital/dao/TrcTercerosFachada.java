package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.TrcTerceros;
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
public class TrcTercerosFachada extends AbstractFacade<TrcTerceros> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public TrcTercerosFachada() {
        super(TrcTerceros.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public TrcTerceros obtieneTercerosPorIdentificacion(String codigoIdentificacion) throws SiCapitalEntidadExcepcion {
        try {
            Query q = getEntityManager().createNamedQuery("TrcTerceros.findByCodigoIdentificacion");
            q.setParameter("codigoIdentificacion", codigoIdentificacion);
            List list = q.getResultList();
            if (!list.isEmpty()) {
                return (TrcTerceros) list.get(0);
            }
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return null;
    }
}
