package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdp;
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
public class CoSolAdqCdpFachada extends AbstractFacade<CoSolAdqCdp> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public CoSolAdqCdpFachada() {
        super(CoSolAdqCdp.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public List<CoSolAdqCdp> retornaListaCdp(int numSolAdq, int vigencia) throws SiCapitalEntidadExcepcion {
        try {
            Query q = getEntityManager().createNamedQuery("CoSolAdqCdp.findByNumSolAdqVigencia");
            q.setParameter("vigencia", vigencia);
            q.setParameter("numSolAdq", numSolAdq);
            List list = q.getResultList();
            if (!list.isEmpty()) {
                return (List<CoSolAdqCdp>) list;
            }
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return null;
    }
}
