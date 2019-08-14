package co.gov.secretariamovilidad.sicapital.negocio.implementacion;

import co.gov.secretariamovilidad.sicapital.dao.BinTablasFachada;
import co.gov.secretariamovilidad.sicapital.dao.CoEntidadesIasFachada;
import co.gov.secretariamovilidad.sicapital.dao.CoProveedoresFachada;
import co.gov.secretariamovilidad.sicapital.dao.CoSolAdqCdpFachada;
import co.gov.secretariamovilidad.sicapital.dao.CoSolElabConFachada;
import co.gov.secretariamovilidad.sicapital.dao.CoSolicitudAdqFachada;
import co.gov.secretariamovilidad.sicapital.entidad.BinTablas;
import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.entidad.CoProveedor;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolAdqCdp;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolElabCon;
import co.gov.secretariamovilidad.sicapital.entidad.CoSolicitudAdq;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.Icontrato;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author maikol
 */
public class ContratoFachada implements Icontrato {

    private CoEntidadesIasFachada coEntidadesIasFachada;
    private CoProveedoresFachada coProveedoresFachada;
    private CoSolicitudAdqFachada coSolicitudAdqFachada;
    private CoSolElabConFachada coSolElabConFachada;
    private BinTablasFachada binTablasFachada;
    private CoSolAdqCdpFachada coSolAdqCdpFachada;

    public ContratoFachada() {
        coEntidadesIasFachada = new CoEntidadesIasFachada();
        coProveedoresFachada = new CoProveedoresFachada();
        coSolicitudAdqFachada = new CoSolicitudAdqFachada();
        coSolElabConFachada = new CoSolElabConFachada();
        binTablasFachada = new BinTablasFachada();
        coSolAdqCdpFachada = new CoSolAdqCdpFachada();
    }

    @Override
    public List<CoEntidadesIas> retornaCoEntidadesIas() throws SiCapitalNegocioExcepcion {
        try {
            return coEntidadesIasFachada.retornaCoEntidadesIas();
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public void crearCoEntidades(CoEntidadesIas coEntidadesIas) throws SiCapitalNegocioExcepcion {
        try {
            coEntidadesIasFachada.crearCoEntidades(coEntidadesIas);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public void removerCoEntidades(CoEntidadesIas coEntidadesIas) throws SiCapitalNegocioExcepcion {
        try {
            coEntidadesIasFachada.removerCoEntidades(coEntidadesIas);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public CoEntidadesIas retornaCoEntidadesIasPorId(int id) throws SiCapitalNegocioExcepcion {
        try {
            return coEntidadesIasFachada.retornaCoEntidadesIasPorId(id);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public List<CoProveedor> listaProveedorPorRazonSocial(String razonSocial) throws SiCapitalNegocioExcepcion {
        try {
            return coProveedoresFachada.listaProveedorPorRazonSocial(razonSocial);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public CoProveedor retornaCoProveedorPorNumeroIdentificacion(long numIdentificacion) throws SiCapitalNegocioExcepcion {
        try {
            return coProveedoresFachada.retornaCoProveedorPorNumeroIdentificacion(numIdentificacion);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public CoSolicitudAdq obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(int vigencia, int numSolAdq) throws SiCapitalNegocioExcepcion {
        try {
            return coSolicitudAdqFachada.obtenerCoSolicitudAdqVigenciaNumSolicitudAdq(vigencia, numSolAdq);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public CoSolElabCon retornaElaboracionContratoVigenciaNumSolAdq(int vigencia, int numSolAdq) throws SiCapitalNegocioExcepcion {
        try {
            return coSolElabConFachada.retornaElaboracionContratoVigenciaNumSolAdq(vigencia, numSolAdq);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public String retornaNombreDependencia(String dependencia, String codigoCom, Date fechaSolicitud) throws SiCapitalNegocioExcepcion {
        try {
            return coSolicitudAdqFachada.retornaNombreDependencia(dependencia, codigoCom, fechaSolicitud);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public BinTablas retornaElaboracionCargo(String grupo, String nombre, int internoInterventor) throws SiCapitalNegocioExcepcion {
        try {
            return binTablasFachada.retornaElaboracionCargo(grupo, nombre, internoInterventor);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }

    @Override
    public List<CoSolAdqCdp> retornaListaCdp(int numSolAdq, int vigencia) throws SiCapitalNegocioExcepcion {
        try {
            return coSolAdqCdpFachada.retornaListaCdp(numSolAdq, vigencia);
        } catch (SiCapitalEntidadExcepcion see) {
            throw new SiCapitalNegocioExcepcion(see);
        } catch (Exception e) {
            throw new SiCapitalNegocioExcepcion(e);
        }
    }
}
