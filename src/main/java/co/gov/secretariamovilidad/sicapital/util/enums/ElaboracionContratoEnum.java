package co.gov.secretariamovilidad.sicapital.util.enums;

/**
 *
 * @author maikol
 */
public enum ElaboracionContratoEnum {

    /**
     * Enumerados para solicitud elaboracion contrato
     */
    ESTADO_APROBADA("APROBADA"),
    ESTADO_CONTRATACION("CONTRATACION"),
    ESTADO_CARGOS("CARGOS");
    
    
    private String valor;

    public String getValor() {
        return valor;
    }

    private ElaboracionContratoEnum(String valor) {
        this.valor = valor;
    }
}
