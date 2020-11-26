
package ventasdao.ui.grilla;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;


public class GrillaFactura extends AbstractTableModel{
    
    private ArrayList<Factura> facturas = new ArrayList<>();
    
    public GrillaFactura(ArrayList<Factura> datos) {
        this.facturas = datos;
    }
    
    @Override
    public int getRowCount() {
        return facturas.size(); 
    }

    @Override
    public int getColumnCount() {
         return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura factura = facturas.get(rowIndex);
        switch(columnIndex){
              case 0: return factura.getId();
              case 1: return factura.getProducto_id();
              case 2: return factura.getFormapago_id();
              case 3: return factura.getCliente_id();
              case 4: return factura.getFecha_creacion();
              case 5: return factura.getNumero();
              case 6: return factura.getObservacion();
              case 7: return factura.getCantidad_producto();
              case 8: return factura.getTotal_factura();
              
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Producto";
            case 2: return "Forma_Pago";
            case 3: return "Cliente";
            case 4: return "Fecha_Creacion";
            case 5: return "Numero de Factura";
            case 6: return "Observacion";
            case 7: return "Cantidad";
            case 8: return "Total_Factura";
            default: return "";
        }
    }
    
    public Factura getFacturaFromRow(int rowIndex)
   {
       return facturas.get(rowIndex);
   }
}