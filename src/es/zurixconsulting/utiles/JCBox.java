/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.utiles;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author aperalta
 */
public class JCBox <T> extends JComboBox {

     public JCBox() {
       
    }
    public JCBox(ArrayList<T> listado) {
        
        
        
        for(T ob : listado){
            this.addItem(ob);
        }
    }

    @Override
    public T getSelectedItem() {
        return (T)super.getSelectedItem();
    }

   
    
    
}
