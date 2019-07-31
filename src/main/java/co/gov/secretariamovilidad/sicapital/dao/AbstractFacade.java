package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import java.util.List;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maikol
 */
public abstract class AbstractFacade<T> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFacade.class);

    /**
     * Atributo aplicacionBundle : ResourceBundle
     */
    protected ResourceBundle aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();

    /**
     * Atributo entityClass : Class<T>
     */
    private Class<T> entityClass;

    /**
     * Metodo encargado de
     *
     * @return una entidad
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * Metodo constructor de la clase AbstractFacade.java
     *
     * @param entityClass
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Metodo abstracto
     *
     * @return EntityManager
     */
    protected abstract EntityManager getEntityManager();

    /**
     * @param entity
     * @throws SipseEntidadExcepcion
     */
    public void create(T entity) throws SiCapitalEntidadExcepcion {
        try {
            getEntityManager().persist(entity);
            //this.registrarLogAuditoria();
            getEntityManager().flush();
        } catch (PersistenceException pe) {
            LOGGER.error("Error en create", pe);
            throw new SiCapitalEntidadExcepcion(pe);
        }
    }
    
    /**
     * @param entity
     * @throws SipseEntidadExcepcion
     */
    public void createFreeResorces(T entity) throws SiCapitalEntidadExcepcion {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            //this.registrarLogAuditoria();
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
        } catch (PersistenceException pe) {
            LOGGER.error("Error en create", pe);
            throw new SiCapitalEntidadExcepcion(pe);
        }
    }

    /**
     * @param entity
     * @throws SipseEntidadExcepcion
     */
    public void edit(T entity) throws SiCapitalEntidadExcepcion {
        try {
            getEntityManager().merge(entity);
            //this.registrarLogAuditoria();
        } catch (Exception e) {
            LOGGER.error("Error en edit", e);
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @param entity
     * @throws SipseEntidadExcepcion
     */
    public void remove(T entity) throws SiCapitalEntidadExcepcion {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            //this.registrarLogAuditoria();
        } catch (Exception e) {
            LOGGER.error("Error en remove", e);
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @param id
     * @return T
     * @throws SipseEntidadExcepcion
     */
    public T find(Object id) throws SiCapitalEntidadExcepcion {
        try {
            return getEntityManager().find(entityClass, id);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @return List<T>
     * @throws SipseEntidadExcepcion
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findAll() throws SiCapitalEntidadExcepcion {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return getEntityManager().createQuery(cq).getResultList();
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @param range
     * @return List<T>
     * @throws SipseEntidadExcepcion
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findRange(int[] range) throws SiCapitalEntidadExcepcion {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @return int
     * @throws SipseEntidadExcepcion
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public int count() throws SiCapitalEntidadExcepcion {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            Query q = getEntityManager().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * @param secuencia
     * @return un objeto
     * @throws SipseEntidadExcepcion
     */
    public Object secuenciaId(String secuencia) throws SiCapitalEntidadExcepcion {
        try {
            Query q = getEntityManager().createNativeQuery("SELECT " + secuencia + ".nextval FROM dual");
            return q.getSingleResult();
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

}
