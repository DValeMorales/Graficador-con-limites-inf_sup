package tarea1;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.Timer;

public class grafos extends javax.swing.JFrame {

    int X=0, f=0, Y=0,cuenta=-1; // x =dato; f=bandera
    int limite1=0,limite2=0, bandera=0;
    int novedad=0, normal=0;
    String limite;
    long tiempo=0;
    
    String [] registros = new String[5];
    
    WriterPort  emisor;
    ReaderPort  reader;
    String a ="",e="1000000000";
               
    Timer Reloj; //incorporar elemento timpo timer 
    pincel lienzo;
      
    public grafos() {
        
        initComponents();
        lienzo = new pincel ();
        this.emisor= WriterPort.getInstance();
        this.reader = ReaderPort.getInstance();
        
        this.reader.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ActionEventPort actionEventPort = (ActionEventPort)evt;
                evento_de_Lectura(actionEventPort);
            }
        }
        );
        
        lienzo.setBackground(new java.awt.Color(255,255,255));
        lienzo.setBounds(0,0,601,313); // en pixeles 
        jPanel_grafica.add(lienzo);
        
     
        Reloj = new Timer(120, new java.awt.event.ActionListener() { //en milis
            public void actionPerformed(ActionEvent ae) {
               evento_reloj(ae);// 
            }
        }); // debe finalizar en ;
       
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sensor = new javax.swing.JScrollBar();
        jPanel_grafica = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_definir = new javax.swing.JButton();
        jTextField_LimitesSuperior = new javax.swing.JTextField();
        jTextField_LimiteInferior = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Registros = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jButton_Borrar = new javax.swing.JButton();
        jButton_Consultar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton_Ver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_NumeroRegistro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VISUALIZACIÓN GRÁFICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 11))); // NOI18N

        sensor.setBackground(new java.awt.Color(255, 255, 255));
        sensor.setForeground(new java.awt.Color(255, 255, 255));
        sensor.setMaximum(310);
        sensor.setValue(156);
        sensor.setVisibleAmount(0);

        jPanel_grafica.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_grafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel_grafica.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_grafica, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_grafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 690, 370);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 11))); // NOI18N

        jLabel2.setText("LIMITE SUPERIOR");

        jLabel4.setText("LIMITE INFERIOR");

        jButton_definir.setText("DEFINIR");
        jButton_definir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_definirActionPerformed(evt);
            }
        });

        jTextField_LimitesSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LimitesSuperiorActionPerformed(evt);
            }
        });

        jTextField_LimiteInferior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LimiteInferiorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_LimitesSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_LimiteInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_definir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_definir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_LimitesSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_LimiteInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 380, 410, 110);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 11))); // NOI18N

        jTextArea_Registros.setColumns(2);
        jTextArea_Registros.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea_Registros.setRows(5);
        jTextArea_Registros.setTabSize(12);
        jTextArea_Registros.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextArea_Registros);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(420, 380, 280, 270);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL REGISTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 11))); // NOI18N

        jButton_Borrar.setText("BORRAR");
        jButton_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BorrarActionPerformed(evt);
            }
        });

        jButton_Consultar.setText("CONSULTAR");
        jButton_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jButton_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Consultar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton_Borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 570, 410, 80);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL REGISTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 11))); // NOI18N

        jButton_Ver.setText("VER");
        jButton_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VerActionPerformed(evt);
            }
        });

        jLabel1.setText("INGRESE POSICION");

        jTextField_NumeroRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NumeroRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_NumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Ver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Ver, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jTextField_NumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 490, 410, 80);

        setBounds(0, 0, 730, 694);
    }// </editor-fold>//GEN-END:initComponents

     public void evento_de_Lectura(ActionEventPort actionEventPort){
         
        a = actionEventPort.getReaded();         
                     
    }
    private void evento_reloj(java.awt.event.ActionEvent evt) {
        String b,d;
        int c;  
        e=a;
        b=a.substring(0, 1);
                
        if (b.equals("9")&&(e.length()==6)) {          
            d=e.substring(1, e.length());//identificador dato sensor
            c = Integer.parseInt(d);
            X++;
            if (X < 600) {
                Y = (-((c - 32767) * 156) / 32767) + 156;
                System.out.println("" + Y);
                lienzo.transferencia(X, Y);
                lienzo.repaint();
            } else {
                X = 0;
                lienzo.borrar(1);
                lienzo.repaint();
            }
            if (c<=((Integer.parseInt(jTextField_LimiteInferior.getText())*32767/156)+32767)){
                
                limite="I";                
            }
            else if (c>=((Integer.parseInt(jTextField_LimitesSuperior.getText())*32767/156)+32767)){
                
                limite="S";                
            }
            
        }
        else if ((b.equals("1"))&&(e.length()>9)) {   
                           
            switch (bandera){
                case 0:{
                    novedad=Integer.parseInt(e);
                    bandera=1;
                }break;
                case 1: {
                    if (cuenta < 4) {
                        cuenta++;
                        normal = Integer.parseInt(e);
                        bandera = 0;
                        tiempo = normal - novedad;
                        jTextArea_Registros.setText(ConvertirFecha(e));
                        jTextArea_Registros.setText("" + String.valueOf(normal) + "....." + String.valueOf(novedad) + "..." + cuenta+ "..."+e);
                        registros[cuenta] = String.valueOf(cuenta) + ". " + limite + " " + ConvertirFecha(e) + String.valueOf(tiempo) + " seg";
                    } else {
                        jTextArea_Registros.setText("");
                        jTextArea_Registros.setText("REGISTRO LLENO!");
                    }
                }break;
                
            }
            
        }
    }
    
public String ConvertirFecha(String datoSegundos) {
    Long segundos = Long.parseLong(datoSegundos) * 1000;
    String fecha = new java.text.SimpleDateFormat("dd/MM HH:mm:ss ").format(new java.util.Date(segundos));
    return fecha;
}
    
    
    private void jButton_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BorrarActionPerformed
                 
        cuenta=-1;
        for (int i = 0; i < 5; i++) {
            registros[i] = "";
        }
        jTextArea_Registros.setText("");
        bandera=0;
        
    }//GEN-LAST:event_jButton_BorrarActionPerformed

    private void jButton_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConsultarActionPerformed
        // TODO add your handling code here:
        
        jTextArea_Registros.setText("");
        for (int i=0;i<5;i++){
            jTextArea_Registros.setText(jTextArea_Registros.getText()+ registros [i]+"\n");  
        }
        
        
    }//GEN-LAST:event_jButton_ConsultarActionPerformed

    private void jButton_definirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_definirActionPerformed
                
        try {
            String lim1, lim2; 
            lim2=jTextField_LimitesSuperior.getText();
            emisor.escribir(lim2+"#");   
            lim1=jTextField_LimiteInferior.getText();
            emisor.escribir(lim1+"#");  
            
        }
        catch(IOException iOException){
            System.out.println("1");
        }
        
        Reloj.start();
        
        limite1 = -(Integer.parseInt(jTextField_LimiteInferior.getText())-156);
        limite2 = -(Integer.parseInt(jTextField_LimitesSuperior.getText())-156);
        lienzo.transferencialim(limite1, limite2);
        
        
        
    }//GEN-LAST:event_jButton_definirActionPerformed

    private void jTextField_LimitesSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LimitesSuperiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LimitesSuperiorActionPerformed

    private void jTextField_LimiteInferiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LimiteInferiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LimiteInferiorActionPerformed

    private void jButton_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VerActionPerformed
        // TODO add your handling code here:
        jTextArea_Registros.setText("");
        jTextArea_Registros.setText(jTextArea_Registros.getText()+ registros [Integer.parseInt(jTextField_NumeroRegistro.getText())]+"\n");  
        
    }//GEN-LAST:event_jButton_VerActionPerformed

    private void jTextField_NumeroRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NumeroRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NumeroRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Borrar;
    private javax.swing.JButton jButton_Consultar;
    private javax.swing.JButton jButton_Ver;
    private javax.swing.JButton jButton_definir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_grafica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Registros;
    private javax.swing.JTextField jTextField_LimiteInferior;
    private javax.swing.JTextField jTextField_LimitesSuperior;
    private javax.swing.JTextField jTextField_NumeroRegistro;
    private javax.swing.JScrollBar sensor;
    // End of variables declaration//GEN-END:variables
}
