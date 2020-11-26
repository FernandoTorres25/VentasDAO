
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;


public class FormaPagoControlador implements ICrud<FormaPago> {
    
     private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    
  
    
    public ArrayList<FormaPago> listar() throws SQLException, Exception{
    
    
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM forma_pago";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<FormaPago> formapagos = new ArrayList();
            
            while(rs.next()){
                
                FormaPago formapago = new FormaPago();
                
                formapago.setDenominacion(rs.getString("denominacion"));
                formapago.setDetalle(rs.getString("detalle"));
                formapago.setId(rs.getInt("id"));
                
                        //System.out.println(cliente);
                
                
                formapagos.add(formapago);
                
            }
            //System.out.println(cont);
            //connection.close();
            return formapagos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    

    
    
    }

    @Override
    public boolean crear(FormaPago entidad) throws SQLException, Exception{
         connection = Conexion.obtenerConexion ();
         String sql = "INSERT INTO forma_pago (denominacion,detalle) VALUES (?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDenominacion());
            ps.setString(2, entidad.getDetalle());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(FormaPago entidad) throws SQLException, Exception{
       connection = Conexion.obtenerConexion ();
         String sql = "delete from forma_pago where id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
           
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    
    public FormaPago extraer(int id) throws SQLException, Exception{
            connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM forma_pago WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            FormaPago formapago = new FormaPago();
            formapago.setId(id);
            formapago.setDenominacion(rs.getString("denominacion"));
            formapago.setDetalle(rs.getString("detalle"));
            return formapago;
    }

    @Override
    
    public boolean modificar(FormaPago entidad) throws SQLException, Exception {
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE forma_pago SET denominacion=?, detalle=? WHERE id=?";
        
       ps = connection.prepareStatement(sql);
       ps.setString(1,entidad.getDenominacion() );
       ps.setString(2,entidad.getDetalle());
       ps.setInt(3, entidad.getId());
       
       ps.executeUpdate();
       connection.close();
       return true;
    }
    
}

    

