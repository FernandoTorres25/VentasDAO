
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Producto;


public class FacturaControlador implements ICrud<Factura>{
    
    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private String sql;
    private SimpleDateFormat simpleDateFormat;
    private FormaPagoControlador formaPagoControlador;
    private ProductoControlador productoControlador;
    private ClienteControlador clienteControlador;

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        this.sql = "INSERT INTO facturas(producto_id, cantidad_producto, cliente_id, formas_pago_id, fecha, observacion, total) VALUES (?, ?, ?, ?, ?, ?, ?);";
        Date fecha = new Date(entidad.getFecha_creacion().getTime());
        
        ps = connection.prepareStatement(sql);
        
        ps.setInt(1, entidad.getProducto_id().getId());
        ps.setFloat(2, entidad.getCantidad_producto());
        ps.setInt(3, entidad.getCliente_id().getId());
        ps.setInt(4, entidad.getFormapago_id().getId());
        ps.setDate(5, fecha);
        ps.setString(6, entidad.getObservacion());
        ps.setFloat(7, entidad.getTotal_factura());
        
        ps.executeUpdate();
        connection.close();
        
        return false;
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM facturas WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        sql = "UPDATE facturas SET producto_id=?, cantidad_producto=?, cliente_id=?, formas_pago_id=?, numero_factura=?, fecha=?, observacion=?, total=? WHERE id=?";
       Date fecha = new Date(entidad.getFecha_creacion().getTime()); 
        
        ps = connection.prepareStatement(sql);
        
        ps.setInt(1, entidad.getProducto_id().getId());
        ps.setFloat(2,entidad.getCantidad_producto());
        ps.setInt(3,entidad.getCliente_id().getId());
        ps.setInt(4,entidad.getFormapago_id().getId());
        ps.setInt(5,entidad.getNumero()); 
        ps.setDate(6, fecha);
        ps.setString(7, entidad.getObservacion());
        ps.setFloat(8, entidad.getTotal_factura());
        ps.setInt(9, entidad.getId());
        
        ps.executeUpdate();        
        connection.close();
        
        return true;
    }

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        try{            
            this.statementmt = connection.createStatement();
            this.sql = "SELECT * FROM facturas";
            this.resultSet   = statementmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Factura> facturas = new ArrayList();
            
            while(resultSet.next())
            {                
                Factura factura = new Factura();
                
                factura.setId(resultSet.getInt("id"));
                factura.setProducto_id(getProducto(resultSet.getInt("producto_id")));
                factura.setCantidad_producto(resultSet.getFloat("cantidad_producto"));
                factura.setCliente_id(getCliente(resultSet.getInt("cliente_id")));
                factura.setFormapago_id(getFormaPago(resultSet.getInt("formas_pago_id")));
                factura.setNumero(resultSet.getInt("numero_factura"));
                factura.setFecha_creacion(resultSet.getDate("fecha"));
                factura.setObservacion(resultSet.getString("observacion"));
                factura.setTotal_factura(resultSet.getFloat("total"));

                facturas.add(factura);                
            }
            return facturas;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private FormaPago getFormaPago(Integer id) throws Exception
    {
     this.formaPagoControlador = new FormaPagoControlador();
     
     FormaPago formaPago = formaPagoControlador.extraer(id);
     
     return formaPago;
    }  
    
    private Producto getProducto(Integer id) throws Exception
    {
     this.productoControlador = new ProductoControlador();
     
     Producto producto = productoControlador.extraer(id);
     
     return producto;
    }  
    
    private Cliente getCliente(Integer id) throws Exception
    {
     this.clienteControlador = new ClienteControlador();
     
     Cliente cliente = clienteControlador.extraer(id);
     
     return cliente;
    }  
}