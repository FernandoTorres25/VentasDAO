
package ventasdao.objetos;

import java.util.Date;


public class Cliente {
    
    private Integer id;
    
    private String documento;
    
    private String nombre;
    
    private String apellido;
    
    private TipoCliente tipoCliente;
    
    private Date fechaNacimiento;

    private String cuil;

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDocumento() { return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre +  apellido ;
    }

    

    

   

 
    
}
