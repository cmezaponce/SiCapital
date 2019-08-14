package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.BinTablas;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
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
public class BinTablasFachada extends AbstractFacade<BinTablas> {

    /**
     * Atributo entityManager : EntityManager
     */
    //@PersistenceContext(unitName = "sicapital")
    private EntityManager entityManager;

    public BinTablasFachada() {
        super(BinTablas.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sicapital");
        entityManager = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public BinTablas retornaElaboracionCargo(String grupo, String nombre, int internoInterventor) throws SiCapitalEntidadExcepcion {
        try {
            StringBuilder sql;
            sql = new StringBuilder("SELECT c FROM BinTablas c ");
            sql.append(" where c.binTablasPK.grupo = '").append(grupo).append("'");
            sql.append(" and c.binTablasPK.nombre = '").append(nombre).append("'");
            sql.append(" and c.vigFinal is null ");
            sql.append(" and c.binTablasPK.argumento = ").append(internoInterventor);
            Query query = getEntityManager().createQuery(sql.toString());
            if (!query.getResultList().isEmpty()) {
                return (BinTablas) query.getSingleResult();
            }
        } catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return null;
    }
}
