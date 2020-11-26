
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.TipoCliente;


public class GrillaTipo_Cliente extends AbstractTableModel{
    
    private ArrayList<TipoCliente> tipo_cliente = new ArrayList<>();

    public GrillaTipo_Cliente(ArrayList<TipoCliente> datos) {
        this.tipo_cliente = datos;
    }

    @Override
    public int getRowCount() {
        return tipo_cliente.size(); 
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
             TipoCliente tc = tipo_cliente.get(rowIndex);
                
          switch(columnIndex){
              case 0: return tc.getId();
              case 1: return tc.getNombre();
              case 2: return tc.getDescripcion();
              default: return "";
          }

    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "DESCRIPCION";
            default: return "";
        
        
        }
        
    }
    
   public TipoCliente getTipoClienteFromRow(int rowIndex){
   
            return tipo_cliente.get(rowIndex);
   }
    
 
    
}
