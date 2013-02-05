/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.fichas_a4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class JMetroButton extends JButton implements MouseListener{

    private Color button_pressed = new Color(0,0,0);
    private Color button_released = new Color(6,192,255);
    /** Color para el texto */
    private Color texto_released = new Color(0,0,0);
    private Color texto_pressed = new Color(255,255,255);
    
    private Color border_released = new Color(255,255,255);
    private Color border_pressed = new Color(255,255,255);
    
   public JMetroButton() {
        this.setText("ModernUIButton");
       
        this.setPreferredSize( new Dimension(140,32 ) );
        this.setSize( new Dimension(140,32 ) );
        this.setBorder(javax.swing.BorderFactory.createLineBorder(border_released,3));
        this.setContentAreaFilled(false);
        //this.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setCursor(Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
        this.setFont(new java.awt.Font("Segoe UI", 1, 11));
        this.setBackground( this.button_released );
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }
       public void mouseClicked(MouseEvent e) {}

    /** Cuando se presiona el boton se cambian los colores de fondo y de texto */
    
       public void mousePressed(MouseEvent e) {
        //capturamos valores iniciales
        this.button_released = this.getBackground();
        this.texto_released = this.getForeground();
       
        //se colocan los nuevos colores
        this.setForeground( this.texto_pressed );
        this.setBackground( this.button_pressed );
        
        this.setBorder(javax.swing.BorderFactory.createLineBorder(border_pressed,3));
    }

    /** Cuando se leventa el mouse del jbutton se retoman los colores originales */
    public void mouseReleased(MouseEvent e) {
        this.setBackground( this.button_released);
        this.setForeground( this.texto_released );
        this.setBorder(javax.swing.BorderFactory.createLineBorder(border_released,3));
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}
