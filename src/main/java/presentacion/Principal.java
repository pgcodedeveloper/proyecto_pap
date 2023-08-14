/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;
import java.awt.Dimension;
import java.awt.EventQueue;

/**
 *
 * @author PC
 */
public class Principal extends javax.swing.JFrame {
    private RegistroClientes registraCliente;
    
    public Principal() {
        initComponents();
        
        registraCliente = new RegistroClientes();
        Dimension desktopSize = panelInicio.getSize();
        Dimension jInternalFrameSize;
        jInternalFrameSize = registraCliente.getSize();
        registraCliente.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelInicio.add(registraCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        softBevelBorder1 = new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED);
        panelInicio = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        mnInicio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnRegistros = new javax.swing.JMenu();
        mnItemCliente = new javax.swing.JMenuItem();
        mnItemProf = new javax.swing.JMenuItem();
        mnConsultas = new javax.swing.JMenu();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setName("frmPrincipal"); // NOI18N
        setType(java.awt.Window.Type.POPUP);

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu.setName("mnPrincipal"); // NOI18N

        mnInicio.setText("Inicio");
        mnInicio.setName("itemInicio"); // NOI18N

        jMenuItem1.setText("jMenuItem1");
        mnInicio.add(jMenuItem1);

        menu.add(mnInicio);

        mnRegistros.setText("Registros");
        mnRegistros.setName("itemRegistros"); // NOI18N

        mnItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mnItemCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        mnItemCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\PAp\\entrenamosuy\\src\\main\\java\\presentacion\\icons\\icons8-registro-25.png")); // NOI18N
        mnItemCliente.setText("Registrar Cliente");
        mnItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemClienteActionPerformed(evt);
            }
        });
        mnRegistros.add(mnItemCliente);

        mnItemProf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mnItemProf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        mnItemProf.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\PAp\\entrenamosuy\\src\\main\\java\\presentacion\\icons\\icons8-registro-25.png")); // NOI18N
        mnItemProf.setText("Registrar Profesor");
        mnItemProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProfActionPerformed(evt);
            }
        });
        mnRegistros.add(mnItemProf);

        menu.add(mnRegistros);

        mnConsultas.setText("Consultas");
        mnConsultas.setName("ItemConsultas"); // NOI18N
        menu.add(mnConsultas);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemClienteActionPerformed
        // TODO add your handling code here:
        registraCliente.setVisible(true);
    }//GEN-LAST:event_mnItemClienteActionPerformed

    private void mnItemProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnItemProfActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu mnConsultas;
    private javax.swing.JMenu mnInicio;
    private javax.swing.JMenuItem mnItemCliente;
    private javax.swing.JMenuItem mnItemProf;
    private javax.swing.JMenu mnRegistros;
    private javax.swing.JPanel panelInicio;
    private javax.swing.border.SoftBevelBorder softBevelBorder1;
    // End of variables declaration//GEN-END:variables
}
