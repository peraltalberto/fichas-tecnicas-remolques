package es.zurixconsulting.fichas_a4;
import java.awt.*;
import java.awt.SplashScreen;
import javax.swing.JOptionPane;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public final class ScreenSplash {

  final SplashScreen splash ;
  //texto que se muestra a medida que se va cargando el screensplah
  String[] texto = {"librerias" ,"configuration", "base de datos",
                          "modulos","informes","formularios","properties"
                          };

  public ScreenSplash() {
	 splash = SplashScreen.getSplashScreen();
  }
MainUI ventana;
   public void animar()
   {
       try {
         
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            System.out.println(texto);
            for(int i=1; i<texto.length; i++)
            {                       
                //se pinta texto del array
                g.setColor( new Color(4,52,101));//color de fondo
	        g.fillRect(203, 328,280,12);//para tapar texto anterior
                g.setColor(Color.white);//color de texto	        
                g.drawString("Loading "+texto[i-1]+"...", 203, 338);                
                g.setColor(Color.green);//color de barra de progeso
                g.fillRect(204, 308,(i*307/texto.length), 12);//la barra de progreso
                //se pinta una linea segmentada encima de la barra verde
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.GREEN);//color de barra de progeso
                g.setColor( new Color(4,52,101));
                g.drawLine(205,314, 510, 314);                
                //se actualiza todo
                splash.update();
                System.out.println("valor de I: "+i);
                if(i ==3){
                    ventana =   new MainUI();
                }
		try {
		 Thread.sleep(321);
		} catch(InterruptedException e) { }
            }
	   splash.close();
           ventana.setVisible(true);
	}else{
         new MainUI().setVisible(true);
        
        }
        //una vez terminada la animación se muestra la aplicación principal
         
          
         }
	catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),"Atencion!!!",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
   }
    
}
