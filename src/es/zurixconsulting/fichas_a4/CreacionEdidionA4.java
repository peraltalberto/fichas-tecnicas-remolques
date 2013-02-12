/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.zurixconsulting.fichas_a4;

import es.zurixconsulting.fichas_a4.persistencia.models.CarroceriaModel;
import es.zurixconsulting.fichas_a4.persistencia.models.CategoriaModel;
import es.zurixconsulting.fichas_a4.persistencia.models.Clasificacion1Model;
import es.zurixconsulting.fichas_a4.persistencia.models.Clasificacion2Model;
import es.zurixconsulting.fichas_a4.persistencia.models.ColorModel;
import es.zurixconsulting.fichas_a4.persistencia.models.CombustibleModel;
import es.zurixconsulting.fichas_a4.persistencia.models.ProcedenciaModel;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Carroceria;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Categoria;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Clasificacion1;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Clasificacion2;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Color;

import es.zurixconsulting.fichas_a4.persistencia.pojos.Combustible;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Fichatecnica;
import es.zurixconsulting.fichas_a4.persistencia.pojos.Procedencia;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author aperalta
 */
public class CreacionEdidionA4 extends javax.swing.JDialog {

    Fichatecnica ficha;
    public static Clasificacion1Model c1Model = new Clasificacion1Model();
    public static Clasificacion2Model c2Model = new Clasificacion2Model();
    public static CarroceriaModel carroModel = new CarroceriaModel();
    public static ColorModel colorModel = new ColorModel();
    public static ProcedenciaModel proceModel = new ProcedenciaModel();
    public static CategoriaModel catModel = new CategoriaModel();
    public static CombustibleModel combusModel = new CombustibleModel();
    /**
     * Creates new form CreacionEdidionA4
     */
    public CreacionEdidionA4(Fichatecnica ficha,java.awt.Frame parent, boolean modal) {
       
        super(parent, modal);
        this.parent = (JFrame) parent;
                
        
        if(ficha.getNcertificado() == null){
            ficha.setNcertificado(getCod());
        }
        initComponents();
        this.ficha = ficha;
        cargarDatos();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        
    }
    public CreacionEdidionA4(Fichatecnica ficha,java.awt.Frame parent, boolean modal,boolean plantilla) {
       
        super(parent, modal);
        
        this.parent = (JFrame) parent;
        initComponents();
        if(plantilla){
        this.ficha = ficha;
        cargarDatos();        
        
        this.ficha = new Fichatecnica(getCod());
        
        this.txNCertificado.setText(this.ficha.getNcertificado());
        }else{
        if(ficha.getNcertificado() == null){
            ficha.setNcertificado(getCod());
        }
        
        this.ficha = ficha;
        cargarDatos();
        
        }
        
        
        
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
         
    }
    JFrame parent;
    private void cargarDatos(){
        
        /*
         *  parametros identificacion 
         */
        this.txNCertificado.setText(ficha.getNcertificado()==null?getCod():ficha.getNcertificado());
        this.tx_fecha.setDate(ficha.getFechatarjeta()==null?new Date():ficha.getFechatarjeta());
        this.tx_a1.setText(ficha.getA1()==null?"REMOLQUES BALLESTER, C.B.":ficha.getA1());
        this.tx_a2.setText(ficha.getA2()==null?"C/ NORTE, 9.P.I. EL CANARI -L'ALCUDIA DE CRESPINS-VALENCIA,46690":ficha.getA2());
        this.tx_ci.setText(ficha.getCiitv()==null?"":ficha.getCiitv());
        this.tx_d1.setText(ficha.getD1marca()==null?"REMOLQUES BALLESTER":ficha.getD1marca());
        this.cb_d2T.setSelectedItem(ficha.getD2tipo()==null?"":ficha.getD2tipo());
        this.tx_d2v.setText(ficha.getD2variante()==null?"":ficha.getD2variante());
        this.tx_d2vs.setText(ficha.getD2version()==null?"":ficha.getD2version());
        this.tx_d3.setText(ficha.getD3denom()==null?"":ficha.getD3denom());
       try{
        this.cb_cl1.setSelectedItem(c1Model.busquedaDato(ficha.getCl1()));
       }catch(Exception e){}
       try{
        this.cb_cl2.setSelectedItem(c2Model.busquedaDato(ficha.getCl2()));
        }catch(Exception e){}
       try{
        this.cb_d6.setSelectedItem(this.proceModel.busquedaDato(ficha.getD6()));
        }catch(Exception e){}
       try{
        this.cb_j1.setSelectedItem(this.carroModel.busquedaDato(ficha.getJ1()));
        }catch(Exception e){}
       try{
        this.cb_r.setSelectedItem(this.colorModel.busquedaDato(ficha.getR()));
        }catch(Exception e){}
       try{
        this.cb_j.setSelectedItem(this.catModel.busquedaDato(ficha.getJcateg()));
        }catch(Exception e){}
       
        this.tx_e.setText(ficha.getNbastidor()==null?"":ficha.getNbastidor());
        this.tx_s1.setText(ficha.getS1()==null?"0":String.valueOf(ficha.getS1()));
        this.cb_k.setSelectedItem(ficha.getK()==null?"":ficha.getK());
        this.tx_z.setText(ficha.getZ()==null?"":ficha.getZ());
        this.ta_observaciones.setText(ficha.getObservaciones()==null?"*******************************************************************************************"
                + "\n*******************************************************************************************"
                + "\n*******************************************************************************************"
                + "\n*******************************************************************************************":ficha.getObservaciones());
        this.ta_opciones.setText(ficha.getOpciones()==null?"*******************************************************************************************"
                + "\n*******************************************************************************************"
                + "\n*******************************************************************************************"
                + "\n*******************************************************************************************":ficha.getOpciones());
        this.tx_cv.setText(ficha.getCv()==null?"":ficha.getCv());
        /****************************************************************************
         * Parametros MASAS
         */
         
        this.tx_lnr.setText(ficha.getLnr()==null?"":String.valueOf(ficha.getLnr()));
        this.tx_lne.setText(ficha.getLne()==null?"":String.valueOf(ficha.getLne()));
        this.tx_l0.setText(ficha.getL0()==null?"":String.valueOf(ficha.getL0()));
        this.tx_l1.setText(ficha.getL1()==null?"":String.valueOf(ficha.getL1()));
        this.tx_l2.setText(ficha.getL2()==null?"":String.valueOf(ficha.getL2()));
        this.tx_g.setText(ficha.getG()==null?"":String.valueOf(ficha.getG()));
        this.tx_f1.setText(ficha.getF1()==null?"":String.valueOf(ficha.getF1()));
        this.tx_f11.setText(ficha.getF11()==null?"":String.valueOf(ficha.getF11()));
        
        this.tx_f2.setText(ficha.getF2()==null?"0":String.valueOf(ficha.getF2()));
        this.tx_f21.setText(ficha.getF21()==null?"0":String.valueOf(ficha.getF21()));
        
        
        /*
         *  Parametros Dimensiones 
         */
        
        this.tx_m1.setText(ficha.getM1()==null?"":String.valueOf(ficha.getM1()));
        
        this.tx_f4.setText(ficha.getF4()==null?"":String.valueOf(ficha.getF4()));
        this.tx_f5.setText(ficha.getF5()==null?"":String.valueOf(ficha.getF5()));
        this.tx_f6.setText(ficha.getF6()==null?"":String.valueOf(ficha.getF6()));
        this.tx_f7.setText(ficha.getF7()==null?"":String.valueOf(ficha.getF7()));
        this.tx_f71.setText(ficha.getF71()==null?"":String.valueOf(ficha.getF71()));
        this.tx_f8.setText(ficha.getF8()==null?"":String.valueOf(ficha.getF8()));
        
        /*
         *  Parametros Motor 
         */
        this.tx_p51.setText(ficha.getP51()==null?"":String.valueOf(ficha.getP51()));
        this.tx_p5.setText(ficha.getP5()==null?"":String.valueOf(ficha.getP5()));
        try{
        this.cb_p3.setSelectedItem(this.combusModel.busquedaDato(ficha.getP3()));
        }catch(Exception e){}
        this.tx_p11.setText(ficha.getP11()==null?"":String.valueOf(ficha.getP11()));
        this.tx_p1.setText(ficha.getP1()==null?"":String.valueOf(ficha.getP1()));
        this.tx_p2.setText(ficha.getP2()==null?"":String.valueOf(ficha.getP2()));
        this.tx_p21.setText(ficha.getP21()==null?"":String.valueOf(ficha.getP21()));
        this.tx_v9.setText(ficha.getV9()==null?"":String.valueOf(ficha.getV9()));
        //this.tx_u1.setText(ficha.getU1()==null?"":String.valueOf(ficha.getU1()));
        //this.tx_u2.setText(ficha.getU2()==null?"":String.valueOf(ficha.getU2()));
        this.tx_v7.setText(ficha.getV7()==null?"":String.valueOf(ficha.getV7()));
        
    }
    
    private void guardarFicha(){
        
        // IDENTIFICACION
        
        ficha.setNcertificado(this.txNCertificado.getText());
        ficha.setNbastidor(this.tx_e.getText());
        ficha.setFechatarjeta(this.tx_fecha.getDate());
        ficha.setJcateg(this.cb_j.getSelectedItem().getId());
        ficha.setA1(this.tx_a1.getText());
        ficha.setA2(this.tx_a2.getText());
        
        ficha.setD1marca(this.tx_d1.getText());
        ficha.setD2tipo(this.cb_d2T.getSelectedItem());
        ficha.setD2variante(this.tx_d2v.getText());
        ficha.setD2version(this.tx_d2vs.getText());
        ficha.setD3denom(this.tx_d3.getText());
        ficha.setCiitv(this.tx_ci.getText());
        ficha.setCl1(this.cb_cl1.getSelectedItem().getId());
        ficha.setCl2(this.cb_cl2.getSelectedItem().getId());
        ficha.setJ1(this.cb_j1.getSelectedItem().getId());
        ficha.setD6(this.cb_d6.getSelectedItem().getId());
        ficha.setR(this.cb_r.getSelectedItem().getId());
        try{
        ficha.setS1(Integer.parseInt(this.tx_s1.getText()));
        }catch(NumberFormatException e){
        ficha.setS1(0);
    }
        ficha.setK(this.cb_k.getSelectedItem());
        ficha.setObservaciones(this.ta_observaciones.getText());
        ficha.setOpciones(this.ta_opciones.getText());
        ficha.setCv(this.tx_cv.getText());
        
        //  MASAS
    try{
        ficha.setLne(Integer.parseInt(this.tx_lne.getText()));
    }catch(NumberFormatException e){
        ficha.setLne(0);
    } try{
        ficha.setLnr(Integer.parseInt(this.tx_lnr.getText()));
        }catch(NumberFormatException e){
        ficha.setLnr(0);
    } try{
        ficha.setL0(Integer.parseInt(this.tx_l0.getText()));
        }catch(NumberFormatException e){
        ficha.setL0(0);
    }
        ficha.setL1(this.tx_l1.getText());
        ficha.setL2(this.tx_l2.getText());
        ficha.setG(this.tx_g.getText());
        ficha.setF1(this.tx_f1.getText());
        ficha.setF11(this.tx_f11.getText());
      ;
        ficha.setF2(this.tx_f2.getText());
        ficha.setF21(this.tx_f21.getText());
      
        
        // DIMENSIONES 
        
        ficha.setM1(this.tx_m1.getText());
       
        ficha.setF4(this.tx_f4.getText());
        ficha.setF5(this.tx_f5.getText());
        ficha.setF6(this.tx_f6.getText());
        ficha.setF7(this.tx_f7.getText());
        ficha.setF71(this.tx_f71.getText());
        ficha.setF8(this.tx_f8.getText());
        
        // MOTOR
        
        ficha.setP51(this.tx_p51.getText());
        ficha.setP5(this.tx_p5.getText());
        ficha.setP3(this.cb_p3.getSelectedItem().getId());
        ficha.setP11(this.tx_p11.getText());
        ficha.setP1(this.tx_p1.getText());
        ficha.setP2(this.tx_p2.getText());
        ficha.setP21(this.tx_p21.getText());
        ficha.setV9(this.tx_v9.getText());
        //ficha.setU1(this.tx_u1.getText());
        //ficha.setU2(this.tx_u2.getText());
        ficha.setV7(this.tx_v7.getText());
    }
    
    public CreacionEdidionA4(java.awt.Frame parent, boolean modal) {
        this(new Fichatecnica(),parent,modal);
    }
    private String getCod(){
    SimpleDateFormat anyo = new SimpleDateFormat("yy");
    int cont = MainUI.bbdd_Fichas.getContadorAnual();
    String am ="";
     
    if(cont<1000){
        am = "0";
    }
     if(cont<100){
        am = "00";
    }
    if(cont<10){
        am = "000";
    }
    
   
        String cod = anyo.format(new Date())+"-"+am+cont;
        return cod;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blackTabbedPaneUI1 = new org.matrix.BlackTabbedPaneUI();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        blackTabbedPane1 = new org.matrix.BlackTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        txNCertificado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tx_e = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tx_a2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tx_a1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tx_fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel13 = new javax.swing.JLabel();
        tx_representante = new javax.swing.JTextField();
        tx_d1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tx_d2vs = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tx_d2v = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tx_ci = new javax.swing.JTextField();
        tx_d3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tx_s1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tx_z = new javax.swing.JTextField();
        cb_cl1 = new es.zurixconsulting.utiles.JCBox(this.c1Model.getLista());
        cb_cl2 = new es.zurixconsulting.utiles.JCBox(this.c2Model.getLista());
        cb_j1 = new es.zurixconsulting.utiles.JCBox(this.carroModel.getLista());
        cb_r = new es.zurixconsulting.utiles.JCBox(this.colorModel.getLista());
        cb_d6 = new es.zurixconsulting.utiles.JCBox(this.proceModel.getLista());
        cb_j = new es.zurixconsulting.utiles.JCBox<Categoria>(this.catModel.getLista());
        cb_d2T = new es.zurixconsulting.utiles.JCBox<String>();
        cb_k = new es.zurixconsulting.utiles.JCBox<String>();
        jMetroButton3 = new es.zurixconsulting.fichas_a4.JMetroButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_observaciones = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_opciones = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        tx_cv = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        tx_lnr = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        tx_l1 = new javax.swing.JTextField();
        tx_f11 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        tx_f1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tx_l2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tx_f21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        tx_g = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        tx_f2 = new javax.swing.JTextField();
        tx_l0 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tx_lne = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        tx_f4 = new javax.swing.JTextField();
        tx_f5 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        tx_f6 = new javax.swing.JTextField();
        tx_f7 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        tx_f71 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        tx_f8 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        tx_m1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        tx_p51 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        tx_p5 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        tx_p11 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        tx_p1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        tx_p2 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        tx_p21 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        tx_v9 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        tx_u1 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        tx_u2 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        tx_v7 = new javax.swing.JTextField();
        cb_p3 = new es.zurixconsulting.utiles.JCBox<Combustible>(this.combusModel.getLista());
        jMetroButton1 = new es.zurixconsulting.fichas_a4.JMetroButton();
        jMetroButton6 = new es.zurixconsulting.fichas_a4.JMetroButton();
        jMetroButton2 = new es.zurixconsulting.fichas_a4.JMetroButton();
        bt_plantilla = new es.zurixconsulting.fichas_a4.JMetroButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("- FICHAS A4 -");
        setMinimumSize(new java.awt.Dimension(1020, 720));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("B");

        blackTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txNCertificado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txNCertificado.setForeground(new java.awt.Color(0, 153, 255));
        txNCertificado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNCertificado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        txNCertificado.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Nº Certificado Interno");

        tx_e.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_e.setForeground(new java.awt.Color(0, 153, 255));
        tx_e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_e.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_e.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("(E) Nº Identificacion Vehiculo Base");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Fecha Tarjeta");

        tx_a2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_a2.setForeground(new java.awt.Color(0, 153, 255));
        tx_a2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_a2.setText("C/ NORTE, 9.P.I. EL CANARI -L'ALCUDIA DE CRESPINS-VALENCIA,46690");
        tx_a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_a2.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("(A.2) Fabricante Base (Dir Completa)");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText("(J) Categoria");

        tx_a1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_a1.setForeground(new java.awt.Color(0, 153, 255));
        tx_a1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_a1.setText("REMOLQUES BALLESTER, C.B.");
        tx_a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_a1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 204));
        jLabel12.setText("(A.1) Fabricante Base (Razon Social)");

        tx_fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_fecha.setForeground(new java.awt.Color(0, 153, 255));
        tx_fecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 204));
        jLabel13.setText("Representante (Razon Social)");

        tx_representante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_representante.setForeground(new java.awt.Color(0, 153, 255));
        tx_representante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_representante.setText("REMOLQUES BALLESTER");
        tx_representante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_representante.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_d1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_d1.setForeground(new java.awt.Color(0, 153, 255));
        tx_d1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_d1.setText("REMOLQUES BALLESTER");
        tx_d1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_d1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        tx_d1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_d1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("(D.1)Marca");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("(D.2)Tipo");

        tx_d2vs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_d2vs.setForeground(new java.awt.Color(0, 153, 255));
        tx_d2vs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_d2vs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_d2vs.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 204));
        jLabel16.setText("(D.2)Versión");

        tx_d2v.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_d2v.setForeground(new java.awt.Color(0, 153, 255));
        tx_d2v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_d2v.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_d2v.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 204));
        jLabel17.setText("(D.2)Variante");

        tx_ci.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_ci.setForeground(new java.awt.Color(0, 153, 255));
        tx_ci.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_ci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_ci.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_d3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_d3.setForeground(new java.awt.Color(0, 153, 255));
        tx_d3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_d3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_d3.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 204));
        jLabel18.setText("(C.I) Cod. ITV");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 204));
        jLabel19.setText("(D.3)Denominacion Comercial");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 204));
        jLabel20.setText("(C.L) Clasificaion 1ª parte");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 204));
        jLabel21.setText("(J.1) Carroceria 2007/46");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 204));
        jLabel22.setText("(C.L) Clasificaion 2ª parte");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 204));
        jLabel23.setText("(D.6) Procedencia");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 204));
        jLabel24.setText("(R) Color(solo M1)");

        tx_s1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_s1.setForeground(new java.awt.Color(0, 153, 255));
        tx_s1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_s1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_s1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 204));
        jLabel25.setText("(S.1) Nº Plazas");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 204));
        jLabel26.setText("(K) Contraseña Vehic. Base.");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 204));
        jLabel27.setText("(Z) Año y orden serie corta");

        tx_z.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_z.setForeground(new java.awt.Color(0, 153, 255));
        tx_z.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_z.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_z.setMargin(new java.awt.Insets(20, 20, 20, 20));

        cb_cl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_cl1.setForeground(new java.awt.Color(0, 153, 255));
        cb_cl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cb_cl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_cl2.setForeground(new java.awt.Color(0, 153, 255));
        cb_cl2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cb_j1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_j1.setForeground(new java.awt.Color(0, 153, 255));
        cb_j1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cb_r.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_r.setForeground(new java.awt.Color(0, 153, 255));
        cb_r.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cb_d6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_d6.setForeground(new java.awt.Color(0, 153, 255));
        cb_d6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_d6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_d6ActionPerformed(evt);
            }
        });

        cb_j.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_j.setForeground(new java.awt.Color(0, 153, 255));
        cb_j.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_j.setOpaque(false);

        cb_d2T.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_d2T.setForeground(new java.awt.Color(0, 153, 255));
        cb_d2T.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RBES01", "RBET01", "RBET02" }));
        cb_d2T.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_d2T.setOpaque(false);

        cb_k.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_k.setForeground(new java.awt.Color(0, 153, 255));
        cb_k.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "e9*2007/46*0334*00", "e9*2007/46*0332*00", "e9*2007/46*0333*00" }));
        cb_k.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_k.setOpaque(false);

        jMetroButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/zurixconsulting/fichas_a4/numerosMetro/search24.png"))); // NOI18N
        jMetroButton3.setText("");
        jMetroButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMetroButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_k, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tx_z))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                        .addComponent(tx_s1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb_j1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cb_cl1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tx_d3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tx_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cb_d6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cb_cl2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txNCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tx_e, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMetroButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_j, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tx_representante))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tx_a1)
                                        .addComponent(tx_a2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)))))
                        .addContainerGap(309, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tx_d2v, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tx_d1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tx_d2vs, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(cb_d2T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tx_e, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jMetroButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(cb_j, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tx_a1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tx_a2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tx_representante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tx_d1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cb_d2T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tx_d2v, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tx_d2vs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tx_d3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(tx_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cb_cl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cb_cl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cb_j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cb_d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cb_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(tx_s1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(tx_z, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        jScrollPane1.setViewportView(jPanel2);

        blackTabbedPane1.addTab("IDENTIFICACION", jScrollPane1);

        ta_observaciones.setColumns(20);
        ta_observaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ta_observaciones.setForeground(new java.awt.Color(0, 153, 255));
        ta_observaciones.setRows(5);
        ta_observaciones.setText("*******************************************************************************************\n*******************************************************************************************\n*******************************************************************************************\n*******************************************************************************************");
        ta_observaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        jScrollPane3.setViewportView(ta_observaciones);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 204));
        jLabel28.setText("Observaciones: ");

        ta_opciones.setColumns(20);
        ta_opciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ta_opciones.setForeground(new java.awt.Color(0, 153, 255));
        ta_opciones.setRows(5);
        ta_opciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        jScrollPane4.setViewportView(ta_opciones);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 153, 204));
        jLabel29.setText("Opciones: ");

        tx_cv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_cv.setForeground(new java.awt.Color(0, 153, 255));
        tx_cv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_cv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_cv.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 204));
        jLabel30.setText("(CV) Control Vin");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(tx_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        blackTabbedPane1.addTab("IDENTIFICACION/2", jScrollPane2);

        tx_lnr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_lnr.setForeground(new java.awt.Color(0, 153, 255));
        tx_lnr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_lnr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_lnr.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 204));
        jLabel32.setText("(L) Nº de Ruedas/elementos rodadura");

        tx_l1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_l1.setForeground(new java.awt.Color(0, 153, 255));
        tx_l1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_l1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_f11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f11.setForeground(new java.awt.Color(0, 153, 255));
        tx_f11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f11.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 153, 204));
        jLabel35.setText("(L.0) Nº de ejes con ruedas gemelas");

        tx_f1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f1.setForeground(new java.awt.Color(0, 153, 255));
        tx_f1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 204));
        jLabel38.setText("(L.1) Posicion Ejes motores");

        tx_l2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_l2.setForeground(new java.awt.Color(0, 153, 255));
        tx_l2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_l2.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 153, 204));
        jLabel39.setText("(F.1.1) MMTA Eje 1º (Kg)");

        tx_f21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f21.setForeground(new java.awt.Color(0, 153, 255));
        tx_f21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f21.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 204));
        jLabel40.setText("(L.2) Neumaticos Nº/dimension/indices min carga y vel (continuar en Obs.)");

        tx_g.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_g.setForeground(new java.awt.Color(0, 153, 255));
        tx_g.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_g.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_g.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 204));
        jLabel41.setText("(F.2) MMA (Kg)");

        tx_f2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f2.setForeground(new java.awt.Color(0, 153, 255));
        tx_f2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f2.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_l0.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_l0.setForeground(new java.awt.Color(0, 153, 255));
        tx_l0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_l0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_l0.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 204));
        jLabel43.setText("(F.2.1) MMA Ejes (Kg)");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 153, 204));
        jLabel45.setText("(G) Masa en orden de marcha");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 153, 204));
        jLabel46.setText("(F.1) MMTA (Kg)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("/");

        tx_lne.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_lne.setForeground(new java.awt.Color(0, 153, 255));
        tx_lne.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_lne.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_lne.setMargin(new java.awt.Insets(20, 20, 20, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40))
                .addGap(125, 125, 125)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tx_l0, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_l1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_l2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_g, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_f1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_f11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_f2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_f21, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tx_lnr, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tx_lne)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel32, jLabel35, jLabel38, jLabel39, jLabel41, jLabel43, jLabel45, jLabel46});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(tx_lnr, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tx_lne, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(tx_l0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_l1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_l2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(tx_g, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(tx_f1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tx_f11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_f2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(tx_f21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel4);

        blackTabbedPane1.addTab("MASAS", jScrollPane5);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 153, 204));
        jLabel51.setText("(F.4) ALTURA (mm)");

        tx_f4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f4.setForeground(new java.awt.Color(0, 153, 255));
        tx_f4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f4.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_f5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f5.setForeground(new java.awt.Color(0, 153, 255));
        tx_f5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f5.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 153, 204));
        jLabel52.setText("(F.5) ANCHURA (mm) ");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 153, 204));
        jLabel53.setText("(F.6) LONGITUD (mm)");

        tx_f6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f6.setForeground(new java.awt.Color(0, 153, 255));
        tx_f6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f6.setMargin(new java.awt.Insets(20, 20, 20, 20));

        tx_f7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f7.setForeground(new java.awt.Color(0, 153, 255));
        tx_f7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f7.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 153, 204));
        jLabel54.setText("(F.7) VIA 1er EJE (mm)");

        tx_f71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f71.setForeground(new java.awt.Color(0, 153, 255));
        tx_f71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f71.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 153, 204));
        jLabel55.setText("(F.7.1) VIA ULTIMO EJE (mm)");

        tx_f8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_f8.setForeground(new java.awt.Color(0, 153, 255));
        tx_f8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_f8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_f8.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 204));
        jLabel56.setText("(F.8) VOLADIZO TRASERO (mm)");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 153, 204));
        jLabel68.setText("(M.1) DISTANCIADISTANCIA ENTRE EJES (mm) e1-2/e2-3/e3-4... ");

        tx_m1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_m1.setForeground(new java.awt.Color(0, 153, 255));
        tx_m1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_m1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_m1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f71, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_f8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_m1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(tx_m1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(tx_f4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(tx_f5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(tx_f6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(tx_f7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(tx_f71, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(tx_f8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel5);

        blackTabbedPane1.addTab("DIMENSIONES", jScrollPane6);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 153, 204));
        jLabel57.setText("(P.5.1) MOTOR FABRICANTE ó MARCA");

        tx_p51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p51.setForeground(new java.awt.Color(0, 153, 255));
        tx_p51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p51.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 153, 204));
        jLabel58.setText("(P.5) MOTOR CODIGO IDENTIFICACION");

        tx_p5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p5.setForeground(new java.awt.Color(0, 153, 255));
        tx_p5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p5.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 153, 204));
        jLabel59.setText("(P.3) COMBUSTIBLE");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 153, 204));
        jLabel60.setText("(P.1.1) NUMERO Y DISPOSICION CILINDROS");

        tx_p11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p11.setForeground(new java.awt.Color(0, 153, 255));
        tx_p11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p11.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 153, 204));
        jLabel61.setText("(P.1) CILINDRADA (cm3) ");

        tx_p1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p1.setForeground(new java.awt.Color(0, 153, 255));
        tx_p1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 204));
        jLabel62.setText("(P.2) POTENCIA MOTOR HOMOLOGADA (KW) ");

        tx_p2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p2.setForeground(new java.awt.Color(0, 153, 255));
        tx_p2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p2.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 153, 204));
        jLabel63.setText("(P.2.1) POTENCIA FISCAL (CVF)");

        tx_p21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_p21.setForeground(new java.awt.Color(0, 153, 255));
        tx_p21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_p21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_p21.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 153, 204));
        jLabel64.setText("(V.9) NIVEL EMISIONES");

        tx_v9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_v9.setForeground(new java.awt.Color(0, 153, 255));
        tx_v9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_v9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_v9.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 153, 204));
        jLabel65.setText("(U.1) NIVEL SONORO PARADO (dBA) ");

        tx_u1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_u1.setForeground(new java.awt.Color(0, 153, 255));
        tx_u1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_u1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_u1.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 153, 204));
        jLabel66.setText("(U.2) NIVEL SONORO PARADO (RPM)");

        tx_u2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_u2.setForeground(new java.awt.Color(0, 153, 255));
        tx_u2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_u2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_u2.setMargin(new java.awt.Insets(20, 20, 20, 20));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 153, 204));
        jLabel67.setText("(V.7) CO2 MIXTO (M1,N1) / CO2 REGLAMENTO 2 (L) (g/Km) si procede");

        tx_v7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tx_v7.setForeground(new java.awt.Color(0, 153, 255));
        tx_v7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_v7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        tx_v7.setMargin(new java.awt.Insets(20, 20, 20, 20));

        cb_p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3));
        cb_p3.setForeground(new java.awt.Color(0, 153, 255));
        cb_p3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_p3.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_p51, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_p11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_p21, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_v9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tx_u1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_u2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_v7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tx_p5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(cb_p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(100, 100, 100))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(tx_p51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(tx_p5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(cb_p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(tx_p11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(tx_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(tx_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(tx_p21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(tx_v9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tx_u1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(tx_u2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(tx_v7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel6);

        blackTabbedPane1.addTab("MOTOR", jScrollPane7);

        jMetroButton1.setBackground(new java.awt.Color(0, 153, 255));
        jMetroButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jMetroButton1.setForeground(new java.awt.Color(255, 255, 255));
        jMetroButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/zurixconsulting/fichas_a4/numerosMetro/cancel.png"))); // NOI18N
        jMetroButton1.setText("CANCELAR");
        jMetroButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMetroButton1ActionPerformed(evt);
            }
        });

        jMetroButton6.setBackground(new java.awt.Color(0, 153, 255));
        jMetroButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jMetroButton6.setForeground(new java.awt.Color(255, 255, 255));
        jMetroButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/zurixconsulting/fichas_a4/numerosMetro/printer.png"))); // NOI18N
        jMetroButton6.setText("IMPRIMIR FICHA");
        jMetroButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMetroButton6ActionPerformed(evt);
            }
        });

        jMetroButton2.setBackground(new java.awt.Color(0, 153, 255));
        jMetroButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jMetroButton2.setForeground(new java.awt.Color(255, 255, 255));
        jMetroButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/zurixconsulting/fichas_a4/numerosMetro/save.png"))); // NOI18N
        jMetroButton2.setText("GUARDAR");
        jMetroButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMetroButton2ActionPerformed(evt);
            }
        });

        bt_plantilla.setBackground(new java.awt.Color(0, 153, 255));
        bt_plantilla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        bt_plantilla.setForeground(new java.awt.Color(255, 255, 255));
        bt_plantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/zurixconsulting/fichas_a4/numerosMetro/favs.png"))); // NOI18N
        bt_plantilla.setText("NO SOY PLANTILLA");
        bt_plantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_plantillaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jMetroButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_plantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(jMetroButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMetroButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(blackTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blackTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jMetroButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(jMetroButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_plantilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jMetroButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_d6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_d6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_d6ActionPerformed

    private void tx_d1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_d1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_d1ActionPerformed

    private void jMetroButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMetroButton2ActionPerformed
       try{
        this.guardarFicha();
       MainUI.bbdd_Fichas.saveDato(this.ficha);
       
       this.dispose();
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage(), "Atencion!!",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jMetroButton2ActionPerformed

    private void jMetroButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMetroButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMetroButton1ActionPerformed

    private void jMetroButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMetroButton6ActionPerformed
        // ImpresionFicha print = new ImpresionFicha();

        ImpresionFicha.print(ficha, parent);
    }//GEN-LAST:event_jMetroButton6ActionPerformed

    private void jMetroButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMetroButton3ActionPerformed
        final PanelBastidores pb = new PanelBastidores(this);
        for(Fichatecnica f : MainUI.bbdd_Fichas.getBastidores()){
            pb.addBst(new BastidorDet(f));
        }
        Point p = MouseInfo.getPointerInfo().getLocation();
        pb.setBounds(p.x,p.y, 350, 300);
        pb.setVisible(true);
        
        
    }//GEN-LAST:event_jMetroButton3ActionPerformed

    Boolean plantilla = false;
    private final java.awt.Color AZUL = new java.awt.Color(0,153,255);
    private final java.awt.Color ROJO = new java.awt.Color(255,51,51);
    private void bt_plantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_plantillaActionPerformed
        if(plantilla){
            plantilla = false;
            this.ficha.setPlantilla(0);
            this.bt_plantilla.setText("NO SOY PALNTILLA");
            this.bt_plantilla.setBackground(AZUL);
        }else{
            plantilla = true;
            this.ficha.setPlantilla(1);
            this.bt_plantilla.setText("SOY PLANTILLA");
            this.bt_plantilla.setBackground(ROJO);
        }
    }//GEN-LAST:event_bt_plantillaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreacionEdidionA4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionEdidionA4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionEdidionA4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionEdidionA4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreacionEdidionA4 dialog = new CreacionEdidionA4(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.matrix.BlackTabbedPane blackTabbedPane1;
    private org.matrix.BlackTabbedPaneUI blackTabbedPaneUI1;
    private es.zurixconsulting.fichas_a4.JMetroButton bt_plantilla;
    private es.zurixconsulting.utiles.JCBox<Clasificacion1> cb_cl1;
    private es.zurixconsulting.utiles.JCBox<Clasificacion2> cb_cl2;
    private es.zurixconsulting.utiles.JCBox<String> cb_d2T;
    private es.zurixconsulting.utiles.JCBox<Procedencia> cb_d6;
    private es.zurixconsulting.utiles.JCBox<Categoria> cb_j;
    private es.zurixconsulting.utiles.JCBox<Carroceria> cb_j1;
    private es.zurixconsulting.utiles.JCBox<String> cb_k;
    private es.zurixconsulting.utiles.JCBox<Combustible> cb_p3;
    private es.zurixconsulting.utiles.JCBox<Color> cb_r;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private es.zurixconsulting.fichas_a4.JMetroButton jMetroButton1;
    private es.zurixconsulting.fichas_a4.JMetroButton jMetroButton2;
    private es.zurixconsulting.fichas_a4.JMetroButton jMetroButton3;
    private es.zurixconsulting.fichas_a4.JMetroButton jMetroButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea ta_observaciones;
    private javax.swing.JTextArea ta_opciones;
    private javax.swing.JTextField txNCertificado;
    private javax.swing.JTextField tx_a1;
    private javax.swing.JTextField tx_a2;
    private javax.swing.JTextField tx_ci;
    private javax.swing.JTextField tx_cv;
    private javax.swing.JTextField tx_d1;
    private javax.swing.JTextField tx_d2v;
    private javax.swing.JTextField tx_d2vs;
    private javax.swing.JTextField tx_d3;
    private javax.swing.JTextField tx_e;
    private javax.swing.JTextField tx_f1;
    private javax.swing.JTextField tx_f11;
    private javax.swing.JTextField tx_f2;
    private javax.swing.JTextField tx_f21;
    private javax.swing.JTextField tx_f4;
    private javax.swing.JTextField tx_f5;
    private javax.swing.JTextField tx_f6;
    private javax.swing.JTextField tx_f7;
    private javax.swing.JTextField tx_f71;
    private javax.swing.JTextField tx_f8;
    private org.jdesktop.swingx.JXDatePicker tx_fecha;
    private javax.swing.JTextField tx_g;
    private javax.swing.JTextField tx_l0;
    private javax.swing.JTextField tx_l1;
    private javax.swing.JTextField tx_l2;
    private javax.swing.JTextField tx_lne;
    private javax.swing.JTextField tx_lnr;
    private javax.swing.JTextField tx_m1;
    private javax.swing.JTextField tx_p1;
    private javax.swing.JTextField tx_p11;
    private javax.swing.JTextField tx_p2;
    private javax.swing.JTextField tx_p21;
    private javax.swing.JTextField tx_p5;
    private javax.swing.JTextField tx_p51;
    private javax.swing.JTextField tx_representante;
    private javax.swing.JTextField tx_s1;
    private javax.swing.JTextField tx_u1;
    private javax.swing.JTextField tx_u2;
    private javax.swing.JTextField tx_v7;
    private javax.swing.JTextField tx_v9;
    private javax.swing.JTextField tx_z;
    // End of variables declaration//GEN-END:variables
}
