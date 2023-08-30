/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package presentacion;

import exceptions.SocioYaInscriptoException;
import interfaces.IControlador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import logica.Clase;

/**
 *
 * @author PC
 */
public class RegistroSocioDictadoClase extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroClientes
     */
    private IControlador icon;
    public RegistroSocioDictadoClase(IControlador con) {
        initComponents();
        this.icon = con;
        limpiar();
        iniciarCombo();
    }

    
    public void iniciarCombo(){
        DefaultComboBoxModel<String> modelInst = new DefaultComboBoxModel<String>(icon.obtenerInstituciones());
        comboBoxInstitucion.addItem("Seleccione");
	comboBoxInstitucion.setModel(modelInst);
 
    }
    
    public void iniciarComboAct(){
        DefaultComboBoxModel<String> modelAct = new DefaultComboBoxModel<String>(icon.obtenerActividades(comboBoxInstitucion.getSelectedItem().toString()));
        comboBoxActDeportiva.setEnabled(true);
        comboBoxActDeportiva.addItem("Seleccione");
	comboBoxActDeportiva.setModel(modelAct);
    }
    
    public void iniciarComboClase(){
        DefaultComboBoxModel<String> modelAct = new DefaultComboBoxModel<String>(icon.obtenerClases(comboBoxActDeportiva.getSelectedItem().toString()));
        comboBoxNomClase.setEnabled(true);
        comboBoxNomClase.addItem("Seleccione");
	comboBoxNomClase.setModel(modelAct);
    }
    
 
    
    public void iniciarComboUsr(){
        DefaultComboBoxModel<String> modelP = new DefaultComboBoxModel<String>(icon.obtenerListaSocios());
        comboBoxSocio.addItem("Seleccione");
        comboBoxSocio.setModel(modelP);
        comboBoxSocio.setEnabled(true);
    }
    
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        lblInstitucion = new javax.swing.JLabel();
        comboBoxInstitucion = new javax.swing.JComboBox<>();
        lblActividadDeportiva = new javax.swing.JLabel();
        comboBoxActDeportiva = new javax.swing.JComboBox<>();
        lblNombreClase = new javax.swing.JLabel();
        comboBoxNomClase = new javax.swing.JComboBox<>();
        lblProfesor = new javax.swing.JLabel();
        txtProfesor = new javax.swing.JTextField();
        lblURL = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        lblFechaIninio = new javax.swing.JLabel();
        txtFechaIni = new javax.swing.JTextField();
        lblFechaAlta = new javax.swing.JLabel();
        txtFechaAlta = new javax.swing.JTextField();
        lblSocio = new javax.swing.JLabel();
        comboBoxSocio = new javax.swing.JComboBox<>();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        dateFechaReg = new com.toedter.calendar.JDateChooser();
        txtFechaReg = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro a Dictado Clase");
        setToolTipText("");
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(735, 640));
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 163, 239), 2, true)), "Registro a Dictado Clase", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(2, 163, 239))); // NOI18N
        panelRegistro.setOpaque(false);

        lblInstitucion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInstitucion.setText("Institución:");

        comboBoxInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxInstitucion.setPreferredSize(new java.awt.Dimension(39, 9));
        comboBoxInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxInstitucionActionPerformed(evt);
            }
        });

        lblActividadDeportiva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblActividadDeportiva.setText("Actividad Deportiva:");

        comboBoxActDeportiva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxActDeportiva.setEnabled(false);
        comboBoxActDeportiva.setPreferredSize(new java.awt.Dimension(39, 9));
        comboBoxActDeportiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActDeportivaActionPerformed(evt);
            }
        });

        lblNombreClase.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreClase.setText("Nombre Clase:");

        comboBoxNomClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxNomClase.setEnabled(false);
        comboBoxNomClase.setPreferredSize(new java.awt.Dimension(39, 9));
        comboBoxNomClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNomClaseActionPerformed(evt);
            }
        });

        lblProfesor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProfesor.setLabelFor(lblSocio);
        lblProfesor.setText("Profesor:");

        txtProfesor.setBackground(new java.awt.Color(214, 217, 223));
        txtProfesor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtProfesor.setEnabled(false);
        txtProfesor.setMargin(new java.awt.Insets(10, 2, 10, 2));

        lblURL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblURL.setLabelFor(txtURL);
        lblURL.setText("URL:");

        txtURL.setBackground(new java.awt.Color(214, 217, 223));
        txtURL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtURL.setEnabled(false);
        txtURL.setMargin(new java.awt.Insets(10, 2, 10, 2));

        lblFechaIninio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFechaIninio.setText("Fecha de Inicio");

        txtFechaIni.setBackground(new java.awt.Color(214, 217, 223));
        txtFechaIni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtFechaIni.setEnabled(false);
        txtFechaIni.setMargin(new java.awt.Insets(10, 2, 10, 2));

        lblFechaAlta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFechaAlta.setText("Fecha de Alta:");

        txtFechaAlta.setBackground(new java.awt.Color(214, 217, 223));
        txtFechaAlta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtFechaAlta.setEnabled(false);
        txtFechaAlta.setMargin(new java.awt.Insets(10, 2, 10, 2));

        lblSocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSocio.setLabelFor(lblSocio);
        lblSocio.setText("Socio:");

        comboBoxSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSocio.setEnabled(false);

        txtFechaReg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFechaReg.setLabelFor(lblSocio);
        txtFechaReg.setText("Fecha de Registro:");

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(lblNombreClase)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxActDeportiva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxInstitucion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(comboBoxNomClase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActividadDeportiva)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblInstitucion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaAlta)
                            .addComponent(lblSocio)
                            .addComponent(lblURL)
                            .addComponent(lblFechaIninio)
                            .addComponent(lblProfesor)
                            .addComponent(txtFechaReg))
                        .addGap(43, 43, 43)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxSocio, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtURL)
                            .addComponent(txtFechaIni)
                            .addComponent(txtFechaAlta)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtProfesor)
                            .addComponent(dateFechaReg, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblActividadDeportiva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxActDeportiva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(comboBoxNomClase, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblURL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaIninio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFechaReg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechaReg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panelRegistroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblFechaAlta, lblFechaIninio});

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 153, 100), 2, true));
        btnGuardar.setIconTextGap(2);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(205, 73, 69), 2, true));
        btnCancelar.setMinimumSize(new java.awt.Dimension(83, 30));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        panelRegistro.getAccessibleContext().setAccessibleName("Alta Dictado de Clase ");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void limpiar(){
        txtProfesor.setText("");
        txtURL.setText("");
        txtFechaAlta.setText("");
        txtFechaIni.setText("");
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(!comboBoxSocio.getSelectedItem().toString().equals("Seleccione") && !comboBoxNomClase.getSelectedItem().toString().equals("Seleccione")) {
            try{
                icon.altaSocioClase(comboBoxSocio.getSelectedItem().toString(), comboBoxNomClase.getSelectedItem().toString(), dateFechaReg.getDate());           
                JOptionPane.showMessageDialog(null, "Socio registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                this.setVisible(false);
            }catch (SocioYaInscriptoException e){
                 JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar una clase y un socio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboBoxNomClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNomClaseActionPerformed
        // TODO add your handling code here:
        Clase c = icon.obtenerInfoClase(this.comboBoxNomClase.getSelectedItem().toString());
        this.txtProfesor.setText(c.getNombre());
        this.txtURL.setText(c.getUrl());
        String horaIni = c.getFecha().toString();
        horaIni = horaIni.concat(" ");
        horaIni= horaIni.concat(c.getHoraInicio().toString());
        this.txtFechaIni.setText(horaIni);
        this.txtFechaAlta.setText(c.getFechaReg().toString());
        
        this.iniciarComboUsr();
        
    }//GEN-LAST:event_comboBoxNomClaseActionPerformed

    private void comboBoxInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxInstitucionActionPerformed
        // TODO add your handling code here:
        this.iniciarComboAct();
    }//GEN-LAST:event_comboBoxInstitucionActionPerformed

    private void comboBoxActDeportivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActDeportivaActionPerformed
        // TODO add your handling code here:
        this.iniciarComboClase();
    }//GEN-LAST:event_comboBoxActDeportivaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboBoxActDeportiva;
    private javax.swing.JComboBox<String> comboBoxInstitucion;
    private javax.swing.JComboBox<String> comboBoxNomClase;
    private javax.swing.JComboBox<String> comboBoxSocio;
    private com.toedter.calendar.JDateChooser dateFechaReg;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel lblActividadDeportiva;
    private javax.swing.JLabel lblFechaAlta;
    private javax.swing.JLabel lblFechaIninio;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblNombreClase;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblSocio;
    private javax.swing.JLabel lblURL;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTextField txtFechaAlta;
    private javax.swing.JTextField txtFechaIni;
    private javax.swing.JLabel txtFechaReg;
    private javax.swing.JTextField txtProfesor;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
