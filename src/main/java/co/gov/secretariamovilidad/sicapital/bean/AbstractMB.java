/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.secretariamovilidad.sicapital.bean;

import co.gov.secretariamovilidad.sicapital.util.ResourceBundleUtil;
import co.gov.secretariamovilidad.sicapital.util.excepciones.SiCapitalPresentacionExcepcion;
import java.util.ResourceBundle;

/**
 *
 * @author maikol
 */
public abstract class AbstractMB {

    protected ResourceBundle aplicacionBundle;

    public AbstractMB() {
        //this.usuario = SesionUtil.getInstance().getUsuario();

        this.aplicacionBundle = ResourceBundleUtil.getAplicacionBundle();
    }

    /**
     *
     * Método Post-Constructor de una Managed Bean
     *
     * @since 17/12/2015
     */
    public abstract void init();
}
