package co.gov.secretariamovilidad.sicapital.negocio.implementacion;

import co.gov.secretariamovilidad.sicapital.dao.CoEntidadesIasFachada;
import co.gov.secretariamovilidad.sicapital.entidad.CoEntidadesIas;
import co.gov.secretariamovilidad.sicapital.negocio.interfaces.Icontrato;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalEntidadExcepcion;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalNegocioExcepcion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;

/**
 *
 * @author maikol
 */
public class ContratoFachada implements Icontrato {

    private CoEntidadesIasFachada coEntidadesIasFachada;

    public ContratoFachada() {
        coEntidadesIasFachada = new CoEntidadesIasFachada();
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

}
