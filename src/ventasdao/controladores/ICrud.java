
package ventasdao.controladores;


import java.sql.SQLException;
import java.util.List;


public interface ICrud<T> {
    
    public boolean crear(T entidad) throws SQLException, Exception;
    public boolean eliminar(T entidad)throws SQLException, Exception;
    public T extraer(int id)throws SQLException, Exception;
    public boolean modificar(T entidad)throws SQLException, Exception;
    public List <T> listar() throws SQLException, Exception;
    
}
