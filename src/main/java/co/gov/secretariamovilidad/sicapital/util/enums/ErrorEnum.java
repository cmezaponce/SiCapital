package co.gov.secretariamovilidad.sicapital.util.enums;

/**
 *
 * @author maikol
 */
public enum ErrorEnum {
    //Error de Sistema
    SYSx001("msg.error.sistema"),
    //Error de DB
    DBx001("msg.error.baseDatos");

    private String valor;

    public String getValor() {
        return valor;
    }

    private ErrorEnum(String valor) {
        this.valor = valor;
    }
}
