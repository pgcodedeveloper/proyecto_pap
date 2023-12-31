/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.IControlador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.Registro;

/**
 *
 * @author PC
 */
public class ConsultarUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form ConsultarUsuarios
     */
    private IControlador icon;
    public ConsultarUsuarios(IControlador con) {
        initComponents();
        this.icon = con;
        
        tablaProfes();
        tablaSocios();
    }
    
    public void tablaSocios(){
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<DtSocio> list;
        list = icon.obtenerSocios();
        modelo.addColumn("Id");
        modelo.addColumn("NickName");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");
        
        for (DtSocio dtSocio : list) {
            modelo.addRow(new Object[]{dtSocio.getId(),dtSocio.getNickname(),dtSocio.getNombre(), dtSocio.getApellido(), dtSocio.getEmail()});
        }
        
        tablaSocios.setModel(modelo);
    }
    public void tablaProfes(){
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<DtProfesor> list;
        list = icon.obtenerProfes();
        modelo.addColumn("Id");
        modelo.addColumn("NickName");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");
        
        for (DtProfesor dtProfe : list) {
            modelo.addRow(new Object[]{dtProfe.getId(),dtProfe.getNickname(),dtProfe.getNombre(), dtProfe.getApellido(), dtProfe.getEmail()});
        }
        
        tablaProfes.setModel(modelo);
    }
    
    public void mostrarConsultas(boolean flag){
        tablaProfes();
        tablaSocios();
        this.setVisible(flag);
    }
    
    public void mostrarClases(int idP){
       listClases.clearSelection();
       //listClases.setModel(null);
       ArrayList<String> li;
       li = icon.obtenerClasesProfe(idP);
       DefaultListModel<String> model = new DefaultListModel<>();
       if(li != null && !li.isEmpty()){
            for(String i:li){
                model.addElement(i);
            }
       }
       else{
           model.addElement("No dicta clases aún");
       }
       
       listClases.setModel(model);
    }
    
    public void mostrarActividades(int idP){
       listActDepo.clearSelection();
       //listActDepo.setModel(null);
       ArrayList<String> li;
       li = icon.obtenerActivDeporProfe(idP);
       DefaultListModel<String> model = new DefaultListModel<>();
       if(li != null && !li.isEmpty()){
            for(String i:li){
                model.addElement(i);
            }
       }
       else{
           model.addElement("No hay actividades aún");
       }
       
       listActDepo.setModel(model);
    }
    
    public void registrosAClases(int idS){
        txtPaneSocio.setText("");
        ArrayList<Registro> li = new ArrayList<>();
        li = icon.obtenerRegistrosSocio(idS);
        infoExtra.setText("");
        String datos;
        int cont = 1;
        if(li != null && !li.isEmpty()){
            datos = "INFORMACIÓN DE REGISTROS";
            for(Registro r:li){
                datos = datos + "\n\n" + "+--- Registro Nº" + cont + " ---+";
                datos = datos + "\n\n" + "Nombre de la Clase: " + r.getClaseId().getNombre();
                datos = datos + "\n\n" + "Fecha de Registro: " + r.getFechaReg().toString();
                datos = datos + "\n\n" + "Nombre del Socio: " + r.getSocioId().getNombre() + " " + r.getSocioId().getApellido();
                cont++;
            }
        }
        else{
            datos = "No está registrado a ningúna clase aún";
        }
        
        txtPaneSocio.setText(datos);
        
    }
    
    public void mostrarInfoClase(String nombre){
        infoExtra.setText("");
        Clase c;
        c = icon.obtenerInfoClase(nombre);
        infoExtra.setText("");
        String datos = "INFORMACIÓN DE CLASES";
        datos = datos + "\n\n" + "Nombre: " + c.getNombre();
        datos = datos + "\n\n" + "Fecha: " + c.getFecha().toString();
        datos = datos + "\n\n" + "Fecha Registro: " + c.getFechaReg().toString();
        datos = datos + "\n\n" + "Hora inicio: " + c.getHoraInicio();
        datos = datos + "\n\n" + "URL: " + c.getUrl();
        infoExtra.setText(datos);
    }
    
    public void mostrarInfoActividad(String act){
        infoExtra.setText("");
        ActividadDeportiva a;
        a = icon.obtenerActividad(act);
        String datos = "INFORMACIÓN DE ACTIVIDAD";
        datos = datos + "\n\n" + "Nombre: " + a.getNombre();
        datos = datos + "\n\n" + "Descripcion: " + a.getDescripcion();
        datos = datos + "\n\n" + "Costo: " + a.getCosto();
        datos = datos + "\n\n" + "Duración: " + a.getDuracion();
        datos = datos + "\n\n" + "Fecha Registro: " + a.getFechaReg().toString();
        datos = datos + "\n\n" + "--- CLASES ---";
        for(Clase c: a.getClases()){
            datos = datos + "\n\n" + "Nombre: " + c.getNombre();
            datos = datos + "\n\n" + "Fecha: " + c.getFecha().toString();
            datos = datos + "\n\n" + "Hora inicio: " + c.getHoraInicio();
        }
        infoExtra.setText(datos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbUsuarios = new javax.swing.JTabbedPane();
        panelSocios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSocios = new javax.swing.JTable();
        lblInfoExtra = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPaneSocio = new javax.swing.JTextPane();
        panelProfes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProfes = new javax.swing.JTable();
        lblInfoExtra2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        infoExtra = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        listClases = new javax.swing.JList<>();
        lblClases = new javax.swing.JLabel();
        lblActDeport = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listActDepo = new javax.swing.JList<>();
        lblInicio = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1120, 830));

        tablaSocios.setBackground(new java.awt.Color(214, 217, 223));
        tablaSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NickName", "Nombre", "Apellido", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSocios.setCellSelectionEnabled(true);
        tablaSocios.setGridColor(new java.awt.Color(40, 69, 108));
        tablaSocios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaSocios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaSocios.setShowGrid(true);
        tablaSocios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSociosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSocios);

        lblInfoExtra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInfoExtra.setText("Información Extra:");

        txtPaneSocio.setEditable(false);
        jScrollPane3.setViewportView(txtPaneSocio);

        javax.swing.GroupLayout panelSociosLayout = new javax.swing.GroupLayout(panelSocios);
        panelSocios.setLayout(panelSociosLayout);
        panelSociosLayout.setHorizontalGroup(
            panelSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addGroup(panelSociosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panelSociosLayout.createSequentialGroup()
                        .addComponent(lblInfoExtra)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelSociosLayout.setVerticalGroup(
            panelSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSociosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoExtra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        tabbUsuarios.addTab("Socios", panelSocios);

        tablaProfes.setBackground(new java.awt.Color(214, 217, 223));
        tablaProfes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "NickName", "Nombre", "Apellido", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProfes.setGridColor(new java.awt.Color(40, 69, 108));
        tablaProfes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProfes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProfes.setShowGrid(true);
        tablaProfes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProfes);

        lblInfoExtra2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInfoExtra2.setText("Información Extra:");

        infoExtra.setEditable(false);
        jScrollPane4.setViewportView(infoExtra);

        listClases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClasesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listClases);

        lblClases.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClases.setText("Clases que dicta:");

        lblActDeport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblActDeport.setText("Actividades deportivas de la institución:");

        listActDepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listActDepoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listActDepo);

        javax.swing.GroupLayout panelProfesLayout = new javax.swing.GroupLayout(panelProfes);
        panelProfes.setLayout(panelProfesLayout);
        panelProfesLayout.setHorizontalGroup(
            panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addGroup(panelProfesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClases)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblActDeport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProfesLayout.createSequentialGroup()
                        .addComponent(lblInfoExtra2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        panelProfesLayout.setVerticalGroup(
            panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClases)
                    .addComponent(lblActDeport)
                    .addGroup(panelProfesLayout.createSequentialGroup()
                        .addComponent(lblInfoExtra2)
                        .addGap(16, 16, 16)
                        .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        tabbUsuarios.addTab("Profesores", panelProfes);

        lblInicio.setBackground(new java.awt.Color(25, 104, 157));
        lblInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setText("Usuarios del Sistema");
        lblInicio.setToolTipText("");
        lblInicio.setOpaque(true);

        btnSalir.setBackground(new java.awt.Color(25, 104, 157));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-eliminar-16.png"))); // NOI18N
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setOpaque(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabbUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.mostrarConsultas(false);
        infoExtra.setText("");
        listActDepo.clearSelection();
        //listActDepo.setModel(null);
        listClases.clearSelection();
        //listClases.setModel(null);
        
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        btnSalir.setBackground(Color.RED);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:
        btnSalir.setBackground(new Color(25, 104, 157));
    }//GEN-LAST:event_btnSalirMouseExited

    private void tablaProfesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesMouseClicked
        // TODO add your handling code here:
        System.out.println(tablaProfes.getValueAt(tablaProfes.getSelectedRow(), 0).toString());
        
        int idP = Integer.parseInt(tablaProfes.getValueAt(tablaProfes.getSelectedRow(), 0).toString());
        
        if(tablaProfes.getSelectedRow() >= 0){
            mostrarClases(idP);
            mostrarActividades(idP);
        }
    }//GEN-LAST:event_tablaProfesMouseClicked

    private void listClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClasesMouseClicked
        // TODO add your handling code here:
        if(!listClases.getSelectedValue().equals("No hay actividades aún")){
            String clase = listClases.getSelectedValue();
            mostrarInfoClase(clase);
        }
    }//GEN-LAST:event_listClasesMouseClicked

    private void tablaSociosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSociosMouseClicked
        // TODO add your handling code here:
        System.out.println(tablaSocios.getValueAt(tablaSocios.getSelectedRow(), 0).toString());
        int idS = Integer.parseInt(tablaSocios.getValueAt(tablaSocios.getSelectedRow(), 0).toString());
        
        if(tablaSocios.getSelectedRow() >= 0){
            this.registrosAClases(idS);
        }
    }//GEN-LAST:event_tablaSociosMouseClicked

    private void listActDepoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listActDepoMouseClicked
        // TODO add your handling code here:
        if(!listActDepo.getSelectedValue().equals("No hay actividades aún")){
            String actividad = listActDepo.getSelectedValue();
            mostrarInfoActividad(actividad);
        }
    }//GEN-LAST:event_listActDepoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSalir;
    private javax.swing.JTextPane infoExtra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblActDeport;
    private javax.swing.JLabel lblClases;
    private javax.swing.JLabel lblInfoExtra;
    private javax.swing.JLabel lblInfoExtra2;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JList<String> listActDepo;
    private javax.swing.JList<String> listClases;
    private javax.swing.JPanel panelProfes;
    private javax.swing.JPanel panelSocios;
    private javax.swing.JTabbedPane tabbUsuarios;
    private javax.swing.JTable tablaProfes;
    private javax.swing.JTable tablaSocios;
    private javax.swing.JTextPane txtPaneSocio;
    // End of variables declaration//GEN-END:variables
}
