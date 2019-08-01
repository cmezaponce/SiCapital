package co.gov.secretariamovilidad.sicapital.entidad;

import java.util.Date;

/**
 *
 * @author maikol
 */
public class CdpDto {
    private int codigoCdp;
    private int ue;
    private Date fecha;
    private int valor;

    public CdpDto() {
    }

    public CdpDto(int codigoCdp, int ue, Date fecha, int valor) {
        this.codigoCdp = codigoCdp;
        this.ue = ue;
        this.fecha = fecha;
        this.valor = valor;
    }
    
    public int getCodigoCdp() {
        return codigoCdp;
    }

    public void setCodigoCdp(int codigoCdp) {
        this.codigoCdp = codigoCdp;
    }

    public int getUe() {
        return ue;
    }

    public void setUe(int ue) {
        this.ue = ue;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
