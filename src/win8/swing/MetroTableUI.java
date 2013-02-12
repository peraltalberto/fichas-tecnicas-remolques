package win8.swing;
import es.timmp.componets.JTableArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class MetroTableUI extends JTableArrayList {
 
    /**
     * Constructor de clase
     */
    public MetroTableUI(){
        
        this.setAutoCreateColumnsFromModel(true);
        this.setAutoscrolls(true);
        this.setVisible(true);
        /** propiedades para el header */
        JTableHeader jtableHeader = this.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        this.setTableHeader(  jtableHeader );
        /** propiedades para las celdas */
        this.setSelectionBackground( new Color( 231, 247 , 252) );
        this.setSelectionForeground( new Color( 0,0,0) );        
        this.setGridColor(new java.awt.Color(221, 221, 221));        
        this.setDefaultRenderer (Object.class, new CellRenderer());       
        
        this.setVisible(true);
    }
    
     public boolean isCellEditable(int rowIndex, int colIndex) { 
         return false;
     }
}

