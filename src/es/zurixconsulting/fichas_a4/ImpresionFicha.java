/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.fichas_a4;

import es.zurixconsulting.fichas_a4.persistencia.pojos.Categoria;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Fichatecnica;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author aperalta
 */
public class ImpresionFicha {
    
  
    
    public static void print(Fichatecnica ficha,JFrame parent){
    
     Map parameters = new HashMap();
            parameters.put("FECHATARJETA",ficha.getFechatarjeta());
            parameters.put("ncertificado",ficha.getNcertificado());
            parameters.put("clasificacion1",ficha.getCl1());
            parameters.put("CL1",ficha.getCl1());
            parameters.put("CL2",ficha.getCl2());
            //parameters.put("CB1",ficha.getCB1());
            //parameters.put("CB2",ficha.getCB2());
            parameters.put("CB1","");
            parameters.put("CB2","");
            parameters.put("D1",ficha.getD1marca());
            parameters.put("NBASTIDOR",ficha.getNbastidor());
            parameters.put("D3DENOM",ficha.getD3denom());
            parameters.put("E",ficha.getNbastidor());
            parameters.put("J",ficha.getJcateg());
            parameters.put("KHOMOL", ficha.getK());
            parameters.put("OBSERVACIONES", ficha.getObservaciones());
            parameters.put("OPCIONES", ficha.getOpciones());
            parameters.put("Z", ficha.getZ());
            parameters.put("G", ficha.getG());
            parameters.put("Z", ficha.getZ());
            parameters.put("F1", ficha.getF1());
            parameters.put("F11", ficha.getF11());
            parameters.put("F15", ficha.getF15());
            parameters.put("F2", ficha.getF2());
            parameters.put("F21", ficha.getF21());
            parameters.put("F21", ficha.getF21());
            parameters.put("O13", ficha.getO13());
            parameters.put("O14", ficha.getO14());
            parameters.put("F4", ficha.getF4());
            parameters.put("F5", ficha.getF5());
            parameters.put("F6", ficha.getF6());
            parameters.put("F7", ficha.getF7());
            parameters.put("F71", ficha.getF71());
            parameters.put("F8", ficha.getF8());
            parameters.put("LNR", ficha.getLnr());
            parameters.put("LNE", ficha.getLne());
            parameters.put("L0", ficha.getL0());
            parameters.put("L1", ficha.getL1ne());
            parameters.put("L1PE", ficha.getL1pe());
            parameters.put("L2", ficha.getL2());
            parameters.put("P51", ficha.getP51());
            parameters.put("P5", ficha.getP5());
            parameters.put("P3", ficha.getP3());
            parameters.put("P1", ficha.getP1());
            parameters.put("P11", ficha.getP11());
            parameters.put("P2", ficha.getP2());
            parameters.put("P21", ficha.getP21());
            parameters.put("FABRICANTE", ficha.getA1());
            parameters.put("D2TIPO", ficha.getD2tipo());
            parameters.put("D2VARIANTE", ficha.getD2variante());
            parameters.put("D2VERSION", ficha.getD2version());
            parameters.put("A1", ficha.getA1());
            parameters.put("A2", ficha.getA2());
            parameters.put("J1", ficha.getJ1());
            parameters.put("rutafirma", System.getProperty("user.dir")+"/img/firma.jpg");
            parameters.put("rutalogo", System.getProperty("user.dir")+"/img/logo1.jpg");

 try {
     String master =  System.getProperty("user.dir")+"/informe/report1.jasper";//paquete donde esta el jasper compilado
     //JOptionPane.showConfirmDialog(rootPane, master);
    JasperReport masterReport = null;
try{
masterReport = (JasperReport) JRLoader.loadObject(master);
}catch (JRException e){
JOptionPane.showMessageDialog(null,"Error cargando el reporte maestro: " + e.getMessage());
//System.exit(0);
}
     //JasperReport report = JasperCompileManager.compileReport("src/gitv/reports/1nchecklist.jrxml");
     JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parameters,new JREmptyDataSource());
     JFileChooser chooser = new JFileChooser();
     FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Pdf","pdf");
     chooser.setFileFilter(filter);
     chooser.showSaveDialog(chooser);
     
     JasperExportManager.exportReportToPdfFile(jasperPrint,chooser.getSelectedFile().getAbsolutePath());//System.getProperty("user.dir")+"/temp/temp_ficha.pdf" );
     
     
     //this.remove(this.jPanel2);
    // this.add(jrv,BorderLayout.CENTER);
     //this.jPanel2.updateUI();//JasperViewer.viewReport(jasperPrint, false);
     //System.out.println("GENERADO CON EXITO EL INFORME");
            // TODO add your handling code here:
        } catch (JRException ex) {
            ex.printStackTrace();
             System.out.println("fallo generando informe ");
             JOptionPane.showMessageDialog(null,"Error cargando el reporte maestro: " + ex.getMessage());
        }
// this.setSize(this.getToolkit().getScreenSize());
    }
    
    
    
}
