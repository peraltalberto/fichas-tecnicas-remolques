package win8.swing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class CellRenderer  extends DefaultTableCellRenderer {
    
    
    private Color color1 = new Color(255,255,255);
    private Color color2 = new Color(204,228,255);
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {    
         super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        setEnabled(table == null || table.isEnabled());
        setBackground(Color.white);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (value.getClass().equals(Date.class)) {
            value = sdf.format(value);
           
        }
        
        if (selected) {
            this.setBackground(new Color(163, 182, 204));
            
        } else {
            setBackground( (row % 2 == 1)?this.color1:this.color2  );
        }
        
       this.setValue(value);
        
        return this;
    }
    
    
}//--> fin clase
