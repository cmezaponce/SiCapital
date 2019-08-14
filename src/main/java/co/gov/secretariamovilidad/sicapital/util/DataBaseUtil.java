package co.gov.secretariamovilidad.sicapital.util;

import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author maikol
 */
public class DataBaseUtil {

    private static ResourceBundle recursosBundle;

    private static String nombreDataSource;

    static {
        init();
    }

    /**
     * Método encargado de inicializar variables
     */
    private static void init() {
        try {
            recursosBundle = ResourceBundleUtil.getRecursosBundle();
            nombreDataSource = recursosBundle.getString("dataSource");
        } catch (Exception exception) {
            SesionUtil.getInstance().addException(exception);
        }
    }

    /**
     * Metodo encargado de obtener una conexion de base de datos.
     *
     * @return Connection
     */
    public static Connection getConnection() throws SiCapitalEntidadExcepcion {
        Connection connection = null;
        StringBuffer query;
        try {
            InitialContext initialContext = new InitialContext();
            // IT JBoss cambiar por java:jboss/datasources/ o jdbc/ para weblogic
            final DataSource dataSource = (DataSource) initialContext.lookup("jdbc/" + nombreDataSource);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        } 

        return connection;
    }

    /**
     * Metodo encargado de cerrar una conexion de base de datos
     *
     * @param connection : Connection
     */
    public static void closeConnection(Connection connection) throws SiCapitalEntidadExcepcion {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        } finally {
            connection = null;
        }
    }

    /**
     * Metodo encargado de hacer rollBack a una transaccion de una conexion de
     * la base de datos.
     *
     * @param connection
     */
    public static void rollBackConnection(Connection connection) throws SiCapitalEntidadExcepcion {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        }
    }

    /**
     * Metodo encargado de cerrar un callableStatement
     *
     * @param callableStatement
     */
    public static void closeCallableStatement(CallableStatement callableStatement) throws SiCapitalEntidadExcepcion {
        try {
            if (callableStatement != null) {
                callableStatement.close();
            }
        } catch (Exception e) {
            throw new SiCapitalEntidadExcepcion(e);
        } finally {
            callableStatement = null;
        }
    }
}
