
package ventasdao.objetos;


public class FormaPago {
    
    private Integer Id;
    private String Denominacion;
    private String Detalle;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    @Override
    public String toString() {
        return  Denominacion;
    }

    
    
}
