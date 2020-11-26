
package ventasdao.objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    
    private Integer id;
    
    private Date fecha_creacion;
    
    private Producto producto_id;
    
    private Cliente cliente_id;
    
    private FormaPago formapago_id;
    
    private Integer numero;
    
    private String observacion;
    
    private Float cantidad_producto;
    
    private Float total_factura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    
    

   
    

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }

    public Float getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(Float cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Float getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(Float total_factura) {
        this.total_factura = total_factura;
    }

    
    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public FormaPago getFormapago_id() {
        return formapago_id;
    }

    public void setFormapago_id(FormaPago formapago_id) {
        this.formapago_id = formapago_id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
    
    

   
}