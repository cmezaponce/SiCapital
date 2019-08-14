/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.dao;

import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.util.DataBaseUtil;
import co.gov.secretariamovilidad.sicapital.util.enums.ErrorEnum;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
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
            Query q = getEntityManager().createNamedQuery("CoSolicitudAdq.findByVigenciaNumSiscoNum");
                   q.setParameter("vigencia", vigencia);
                   q.setParameter("numSolAdq", numSolAdq);
            List list = q.getResultList();
            if (!list.isEmpty()) {
                return (CoSolicitudAdq) list.get(0);
            }
        }catch (PersistenceException pe) {
            throw new SiCapitalEntidadExcepcion(pe);
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        }
        return null;
    }
    
    public String retornaNombreDependencia(String dependencia, String codigoCom, Date fechaSolicitud) throws SiCapitalEntidadExcepcion {
        String mensajeSalida = null;
        Connection connection = null;
        // Inicializa el contexto y carga el origen de datos
        CallableStatement callableStatement = null;
        try {
            connection = DataBaseUtil.getConnection();
            String query = "{? = call co_pk_estudios_previos.fn_pre_traer_desc_depen(?, ?, ?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, dependencia);
            callableStatement.setString(3, codigoCom);
            callableStatement.setDate(4, new java.sql.Date(((Date) fechaSolicitud).getTime()));
            callableStatement.execute();

            mensajeSalida = callableStatement.getString(1);
        } catch (SQLException sqle) {
            throw new SiCapitalEntidadExcepcion(sqle);
        } catch (SiCapitalEntidadExcepcion see) {
            throw see;
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(ErrorEnum.SYSx001, e);
        } finally {
            DataBaseUtil.closeCallableStatement(callableStatement);
            DataBaseUtil.closeConnection(connection);
        }
        return mensajeSalida;
    }
}
