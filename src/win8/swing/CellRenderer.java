package win8.swing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class CellRenderer  extends DefaultTableCellRenderer {
    
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Color color1 = new Color(255,255,255);
    private Color color2 = new Color(249,249,249);
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {    
        setEnabled(table == null || table.isEnabled());
        setBackground(Color.white);
        table.setFont(normal);
        
        setBackground( (row % 2 == 1)?this.color1:this.color2  );
        
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        return this;
    }
    
    
}//--> fin clase
