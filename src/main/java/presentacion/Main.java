/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import interfaces.Fabrica;
import interfaces.IControlador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author PC
 */
public class Main extends JFrame {
    int xMouse, yMouse;
    private RegistroClientes clientes;
    private RegistroProfesores profesores;
    private RegistroActividadDeportiva actDeportiva;  
    private RegistroDictadoClase dictClase;
    private RegistroInstitucion inst;
    private RegistroSocioDictadoClase regDictClase;
    private ConsultarUsuarios conUsr;
    private ConsultaActividadD conAct;
    private ModificarUsuarios modUsr;
    private ModificarActividadDeportiva modAct;
    private ModificarInstitucion modIns;
    private RankingClases rankCl;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        Fabrica fab = Fabrica.getInstancia();
        IControlador con = fab.getIControlador();
        clientes = new RegistroClientes(con);
        Dimension desktopSize = panelContenido.getSize();
        Dimension jInternalFrameSize;
        jInternalFrameSize = clientes.getSize();
        clientes.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(clientes);
        clientes.setVisible(false);
        
        
        profesores = new RegistroProfesores(con);
        jInternalFrameSize = profesores.getSize();
        profesores.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(profesores);
        profesores.setVisible(false);
        
        actDeportiva  = new RegistroActividadDeportiva(con);
        jInternalFrameSize = actDeportiva.getSize();
        actDeportiva.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(actDeportiva);
        actDeportiva.setVisible(false);
        
        dictClase  = new RegistroDictadoClase(con);
        jInternalFrameSize = dictClase.getSize();
        dictClase.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(dictClase);
        dictClase.setVisible(false);
        
        inst = new RegistroInstitucion(con);
        jInternalFrameSize = inst.getSize();
        inst.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(inst);
        inst.setVisible(false);
        
        regDictClase = new RegistroSocioDictadoClase (con);
        jInternalFrameSize = regDictClase.getSize();
        regDictClase.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(regDictClase);
        regDictClase.setVisible(false);
        
        modAct  = new ModificarActividadDeportiva(con);
        jInternalFrameSize = modAct.getSize();
        modAct.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(modAct);
        modAct.setVisible(false);
        
        conUsr = new ConsultarUsuarios(con);
        conUsr.setSize(panelContenido.getSize());
        panelContenido.add(conUsr);
        conUsr.setVisible(false);
        
        conAct = new ConsultaActividadD(con);
        conAct.setSize(panelContenido.getSize());
        panelContenido.add(conAct);
        conAct.setVisible(false);
        
        modUsr = new ModificarUsuarios(con);
        jInternalFrameSize = modUsr.getSize();
        modUsr.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(modUsr);
        modUsr.setVisible(false);
        
        modIns  = new ModificarInstitucion(con);
        jInternalFrameSize = modIns.getSize();
        modIns.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(modIns);
        modIns.setVisible(false);
        
        rankCl  = new RankingClases(con);
        jInternalFrameSize = rankCl.getSize();
        rankCl.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);
        panelContenido.add(rankCl);
        rankCl.setVisible(false);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        panelHeading = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        panelAcciones = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        panelLogo = new javax.swing.JPanel();
        lblAdmin = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        lblConsultas = new javax.swing.JLabel();
        lblModificaciones = new javax.swing.JLabel();
        lblRankings = new javax.swing.JLabel();
        btnCliente = new javax.swing.JLabel();
        btnProfesor = new javax.swing.JLabel();
        btnRegActDeportiva = new javax.swing.JLabel();
        btnRankDictadoClase = new javax.swing.JLabel();
        btnRegInstitucion = new javax.swing.JLabel();
        btnRegClase = new javax.swing.JLabel();
        btnConsultaUsr = new javax.swing.JLabel();
        btnConsultaActividad = new javax.swing.JLabel();
        btnModificaUsr = new javax.swing.JLabel();
        btnModActDeportiva = new javax.swing.JLabel();
        btnModInstitucion = new javax.swing.JLabel();
        btnRankActDeportiva = new javax.swing.JLabel();
        btnRegDictadoClase = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setBounds(new java.awt.Rectangle(1, 1, 1, 1));
        setLocation(new java.awt.Point(0, 0));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setName("frmMain"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        panelInicio.setBackground(new java.awt.Color(153, 153, 153));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeader.setBackground(new java.awt.Color(46, 124, 209));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotones.setBackground(new java.awt.Color(46, 124, 209));
        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(46, 124, 209));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-eliminar-16.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        panelBotones.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 30));

        btnMinimizar.setBackground(new java.awt.Color(46, 124, 209));
        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons14-minimizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setMaximumSize(new java.awt.Dimension(16, 5));
        btnMinimizar.setOpaque(true);
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseExited(evt);
            }
        });
        panelBotones.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 30));

        panelHeader.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 120, 30));

        panelHeading.setOpaque(false);

        lblIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-gym-26.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Principal");

        javax.swing.GroupLayout panelHeadingLayout = new javax.swing.GroupLayout(panelHeading);
        panelHeading.setLayout(panelHeadingLayout);
        panelHeadingLayout.setHorizontalGroup(
            panelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadingLayout.createSequentialGroup()
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelHeadingLayout.setVerticalGroup(
            panelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelHeader.add(panelHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 30));

        panelInicio.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 30));

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAcciones.setBackground(new java.awt.Color(25, 104, 157));
        panelAcciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelAcciones.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 123, 180, 10));

        panelLogo.setOpaque(false);
        panelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("Administrador");
        panelLogo.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 30));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-engranaje-50.png"))); // NOI18N
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelLogo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 100));

        panelAcciones.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        lblRegistros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRegistros.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistros.setText("REGISTROS");
        lblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegistrosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblRegistrosMouseReleased(evt);
            }
        });
        panelAcciones.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 36));

        lblConsultas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConsultas.setForeground(new java.awt.Color(255, 255, 255));
        lblConsultas.setText("CONSULTAS");
        panelAcciones.add(lblConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 36));

        lblModificaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblModificaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblModificaciones.setText("MODIFICACIONES");
        panelAcciones.add(lblModificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 160, 36));

        lblRankings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRankings.setForeground(new java.awt.Color(255, 255, 255));
        lblRankings.setText("RANKINGS");
        panelAcciones.add(lblRankings, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 160, 36));

        btnCliente.setBackground(new java.awt.Color(25, 104, 157));
        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-añadir-usuario-tipo-de-piel-masculina-7-16.png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCliente.setIconTextGap(20);
        btnCliente.setOpaque(true);
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });
        panelAcciones.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 30));

        btnProfesor.setBackground(new java.awt.Color(25, 104, 157));
        btnProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProfesor.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-profesor-16.png"))); // NOI18N
        btnProfesor.setText("Profesores");
        btnProfesor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfesor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProfesor.setIconTextGap(20);
        btnProfesor.setOpaque(true);
        btnProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfesorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfesorMouseExited(evt);
            }
        });
        panelAcciones.add(btnProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 30));

        btnRegActDeportiva.setBackground(new java.awt.Color(25, 104, 157));
        btnRegActDeportiva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegActDeportiva.setForeground(new java.awt.Color(255, 255, 255));
        btnRegActDeportiva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegActDeportiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-strength-16.png"))); // NOI18N
        btnRegActDeportiva.setText("Actividad Deportiva");
        btnRegActDeportiva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegActDeportiva.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegActDeportiva.setIconTextGap(20);
        btnRegActDeportiva.setOpaque(true);
        btnRegActDeportiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegActDeportivaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegActDeportivaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegActDeportivaMouseExited(evt);
            }
        });
        panelAcciones.add(btnRegActDeportiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 180, 30));

        btnRankDictadoClase.setBackground(new java.awt.Color(25, 104, 157));
        btnRankDictadoClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRankDictadoClase.setForeground(new java.awt.Color(255, 255, 255));
        btnRankDictadoClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRankDictadoClase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-aula-de-google-16.png"))); // NOI18N
        btnRankDictadoClase.setText("Dictado de Clase");
        btnRankDictadoClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRankDictadoClase.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRankDictadoClase.setIconTextGap(20);
        btnRankDictadoClase.setOpaque(true);
        btnRankDictadoClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRankDictadoClaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRankDictadoClaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRankDictadoClaseMouseExited(evt);
            }
        });
        panelAcciones.add(btnRankDictadoClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 180, 30));

        btnRegInstitucion.setBackground(new java.awt.Color(25, 104, 157));
        btnRegInstitucion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegInstitucion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegInstitucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegInstitucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-colegio-16.png"))); // NOI18N
        btnRegInstitucion.setText("Institución Deportiva");
        btnRegInstitucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegInstitucion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegInstitucion.setIconTextGap(20);
        btnRegInstitucion.setOpaque(true);
        btnRegInstitucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegInstitucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegInstitucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegInstitucionMouseExited(evt);
            }
        });
        panelAcciones.add(btnRegInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 180, 30));

        btnRegClase.setBackground(new java.awt.Color(25, 104, 157));
        btnRegClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegClase.setForeground(new java.awt.Color(255, 255, 255));
        btnRegClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegClase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-aula-de-google-16.png"))); // NOI18N
        btnRegClase.setText("Registro a Clase");
        btnRegClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegClase.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegClase.setIconTextGap(20);
        btnRegClase.setOpaque(true);
        btnRegClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegClaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegClaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegClaseMouseExited(evt);
            }
        });
        panelAcciones.add(btnRegClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 30));

        btnConsultaUsr.setBackground(new java.awt.Color(25, 104, 157));
        btnConsultaUsr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaUsr.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaUsr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultaUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-clientes-16.png"))); // NOI18N
        btnConsultaUsr.setText("Usuarios");
        btnConsultaUsr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultaUsr.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnConsultaUsr.setIconTextGap(20);
        btnConsultaUsr.setOpaque(true);
        btnConsultaUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaUsrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultaUsrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultaUsrMouseExited(evt);
            }
        });
        panelAcciones.add(btnConsultaUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 180, 30));

        btnConsultaActividad.setBackground(new java.awt.Color(25, 104, 157));
        btnConsultaActividad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaActividad.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultaActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-colegio-16.png"))); // NOI18N
        btnConsultaActividad.setText("Actividades y Clases");
        btnConsultaActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultaActividad.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnConsultaActividad.setIconTextGap(20);
        btnConsultaActividad.setOpaque(true);
        btnConsultaActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaActividadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultaActividadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultaActividadMouseExited(evt);
            }
        });
        panelAcciones.add(btnConsultaActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 180, 30));

        btnModificaUsr.setBackground(new java.awt.Color(25, 104, 157));
        btnModificaUsr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificaUsr.setForeground(new java.awt.Color(255, 255, 255));
        btnModificaUsr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificaUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-clientes-16.png"))); // NOI18N
        btnModificaUsr.setText("Usuarios");
        btnModificaUsr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificaUsr.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnModificaUsr.setIconTextGap(20);
        btnModificaUsr.setOpaque(true);
        btnModificaUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificaUsrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificaUsrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificaUsrMouseExited(evt);
            }
        });
        panelAcciones.add(btnModificaUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 180, 30));

        btnModActDeportiva.setBackground(new java.awt.Color(25, 104, 157));
        btnModActDeportiva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModActDeportiva.setForeground(new java.awt.Color(255, 255, 255));
        btnModActDeportiva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModActDeportiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-strength-16.png"))); // NOI18N
        btnModActDeportiva.setText("Actividad Deportiva");
        btnModActDeportiva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModActDeportiva.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnModActDeportiva.setIconTextGap(20);
        btnModActDeportiva.setOpaque(true);
        btnModActDeportiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModActDeportivaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModActDeportivaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModActDeportivaMouseExited(evt);
            }
        });
        panelAcciones.add(btnModActDeportiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 180, 30));

        btnModInstitucion.setBackground(new java.awt.Color(25, 104, 157));
        btnModInstitucion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModInstitucion.setForeground(new java.awt.Color(255, 255, 255));
        btnModInstitucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModInstitucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-colegio-16.png"))); // NOI18N
        btnModInstitucion.setText("Institución Deportiva");
        btnModInstitucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModInstitucion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnModInstitucion.setIconTextGap(20);
        btnModInstitucion.setOpaque(true);
        btnModInstitucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModInstitucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModInstitucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModInstitucionMouseExited(evt);
            }
        });
        panelAcciones.add(btnModInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 180, 30));

        btnRankActDeportiva.setBackground(new java.awt.Color(25, 104, 157));
        btnRankActDeportiva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRankActDeportiva.setForeground(new java.awt.Color(255, 255, 255));
        btnRankActDeportiva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRankActDeportiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-strength-16.png"))); // NOI18N
        btnRankActDeportiva.setText("Actividad Deportiva");
        btnRankActDeportiva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRankActDeportiva.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRankActDeportiva.setIconTextGap(20);
        btnRankActDeportiva.setOpaque(true);
        btnRankActDeportiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRankActDeportivaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRankActDeportivaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRankActDeportivaMouseExited(evt);
            }
        });
        panelAcciones.add(btnRankActDeportiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 180, 30));

        btnRegDictadoClase.setBackground(new java.awt.Color(25, 104, 157));
        btnRegDictadoClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegDictadoClase.setForeground(new java.awt.Color(255, 255, 255));
        btnRegDictadoClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegDictadoClase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-aula-de-google-16.png"))); // NOI18N
        btnRegDictadoClase.setText("Dictado de Clase");
        btnRegDictadoClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegDictadoClase.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegDictadoClase.setIconTextGap(20);
        btnRegDictadoClase.setOpaque(true);
        btnRegDictadoClase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegDictadoClaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegDictadoClaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegDictadoClaseMouseExited(evt);
            }
        });
        panelAcciones.add(btnRegDictadoClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 30));

        panelPrincipal.add(panelAcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 770));

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1120, 770));

        panelInicio.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1300, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ocultarVentanas(){
        clientes.setVisible(false);
        profesores.mostrarRegistroProfesor(false);
        actDeportiva.mostrarRegistroActividad(false);
        dictClase.mostrarDictadoClase(false);
        inst.setVisible(false);
        regDictClase.mostrarRegistroSocioClase(false);
        conAct.mostrarConsulta(false);
        conUsr.mostrarConsultas(false);
        modUsr.mostrarModificarUsuario(false);
        modAct.mostrarModificarActividad(false);
        modIns.mostrarModificarInst(false);
        rankCl.setVisible(false);
    }
    
    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
        // TODO add your handling code here:
        this.setExtendedState(NORMAL);
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        // TODO add your handling code here:
        btnCerrar.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        // TODO add your handling code here:
        Color c = new Color(46,124,209);
        btnCerrar.setBackground(c);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        clientes.setVisible(true);
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnCliente.setBackground(c);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnCliente.setBackground(c);
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        profesores.mostrarRegistroProfesor(true);
    }//GEN-LAST:event_btnProfesorMouseClicked

    private void btnProfesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnProfesor.setBackground(c);
    }//GEN-LAST:event_btnProfesorMouseEntered

    private void btnProfesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnProfesor.setBackground(c);
    }//GEN-LAST:event_btnProfesorMouseExited

    private void btnConsultaUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaUsrMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        conUsr.mostrarConsultas(true);
    }//GEN-LAST:event_btnConsultaUsrMouseClicked

    private void btnConsultaUsrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaUsrMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnConsultaUsr.setBackground(c);
    }//GEN-LAST:event_btnConsultaUsrMouseEntered

    private void btnConsultaUsrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaUsrMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnConsultaUsr. setBackground(c);
    }//GEN-LAST:event_btnConsultaUsrMouseExited

    private void lblRegistrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrosMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblRegistrosMousePressed

    private void lblRegistrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrosMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblRegistrosMouseReleased

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        // TODO add your handling code here:
        btnMinimizar.setBackground(new Color(40, 69, 108));
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        // TODO add your handling code here:
        btnMinimizar.setBackground(new Color(46,124,209));
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void btnModActDeportivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModActDeportivaMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        modAct.mostrarModificarActividad(true);
    }//GEN-LAST:event_btnModActDeportivaMouseClicked

    private void btnModActDeportivaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModActDeportivaMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnModActDeportiva. setBackground(c);
    }//GEN-LAST:event_btnModActDeportivaMouseEntered

    private void btnModActDeportivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModActDeportivaMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnModActDeportiva. setBackground(c);
    }//GEN-LAST:event_btnModActDeportivaMouseExited

    private void btnRegDictadoClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegDictadoClaseMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        dictClase.mostrarDictadoClase(true);
    }//GEN-LAST:event_btnRegDictadoClaseMouseClicked

    private void btnRegDictadoClaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegDictadoClaseMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRegDictadoClase.setBackground(c);
        
    }//GEN-LAST:event_btnRegDictadoClaseMouseEntered

    private void btnRegDictadoClaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegDictadoClaseMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRegDictadoClase. setBackground(c);
    }//GEN-LAST:event_btnRegDictadoClaseMouseExited

    private void btnModInstitucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModInstitucionMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        modIns.mostrarModificarInst(true);
    }//GEN-LAST:event_btnModInstitucionMouseClicked

    private void btnModInstitucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModInstitucionMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnModInstitucion.setBackground(c);
    }//GEN-LAST:event_btnModInstitucionMouseEntered

    private void btnModInstitucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModInstitucionMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnModInstitucion. setBackground(c);
    }//GEN-LAST:event_btnModInstitucionMouseExited

    private void btnRegClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClaseMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
       this.regDictClase.mostrarRegistroSocioClase(true);
    }//GEN-LAST:event_btnRegClaseMouseClicked

    private void btnRegClaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClaseMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRegClase.setBackground(c);
    }//GEN-LAST:event_btnRegClaseMouseEntered

    private void btnRegClaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClaseMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRegClase. setBackground(c);
    }//GEN-LAST:event_btnRegClaseMouseExited

    private void btnConsultaActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaActividadMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        this.conAct.mostrarConsulta(true);
    }//GEN-LAST:event_btnConsultaActividadMouseClicked

    private void btnConsultaActividadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaActividadMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnConsultaActividad.setBackground(c);
    }//GEN-LAST:event_btnConsultaActividadMouseEntered

    private void btnConsultaActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaActividadMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnConsultaActividad. setBackground(c);
    }//GEN-LAST:event_btnConsultaActividadMouseExited

    private void btnModificaUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificaUsrMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        this.modUsr.setVisible(true);
    }//GEN-LAST:event_btnModificaUsrMouseClicked

    private void btnModificaUsrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificaUsrMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnModificaUsr.setBackground(c);
    }//GEN-LAST:event_btnModificaUsrMouseEntered

    private void btnModificaUsrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificaUsrMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnModificaUsr.setBackground(c);
    }//GEN-LAST:event_btnModificaUsrMouseExited

    private void btnRankActDeportivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankActDeportivaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRankActDeportivaMouseClicked

    private void btnRankActDeportivaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankActDeportivaMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRankActDeportiva.setBackground(c);
    }//GEN-LAST:event_btnRankActDeportivaMouseEntered

    private void btnRankActDeportivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankActDeportivaMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRankActDeportiva.setBackground(c);
    }//GEN-LAST:event_btnRankActDeportivaMouseExited

    private void btnRegInstitucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegInstitucionMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        this.inst.setVisible(true);

    }//GEN-LAST:event_btnRegInstitucionMouseClicked

    private void btnRegInstitucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegInstitucionMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRegInstitucion.setBackground(c);
    }//GEN-LAST:event_btnRegInstitucionMouseEntered

    private void btnRegInstitucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegInstitucionMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRegInstitucion.setBackground(c);
    }//GEN-LAST:event_btnRegInstitucionMouseExited

    private void btnRankDictadoClaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankDictadoClaseMouseClicked
        // TODO add your handling code here:
        this.rankCl.setVisible(true);
    }//GEN-LAST:event_btnRankDictadoClaseMouseClicked

    private void btnRankDictadoClaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankDictadoClaseMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRankDictadoClase.setBackground(c);
    }//GEN-LAST:event_btnRankDictadoClaseMouseEntered

    private void btnRankDictadoClaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankDictadoClaseMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRankDictadoClase.setBackground(c);
    }//GEN-LAST:event_btnRankDictadoClaseMouseExited

    private void btnRegActDeportivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegActDeportivaMouseClicked
        // TODO add your handling code here:
        this.ocultarVentanas();
        this.actDeportiva.mostrarRegistroActividad(true);
    }//GEN-LAST:event_btnRegActDeportivaMouseClicked

    private void btnRegActDeportivaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegActDeportivaMouseEntered
        // TODO add your handling code here:
        Color c = new Color (16,69,104);
        btnRegActDeportiva.setBackground(c);
    }//GEN-LAST:event_btnRegActDeportivaMouseEntered

    private void btnRegActDeportivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegActDeportivaMouseExited
        // TODO add your handling code here:
        Color c = new Color(25,104,157);
        btnRegActDeportiva.setBackground(c);
    }//GEN-LAST:event_btnRegActDeportivaMouseExited

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnCliente;
    private javax.swing.JLabel btnConsultaActividad;
    private javax.swing.JLabel btnConsultaUsr;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel btnModActDeportiva;
    private javax.swing.JLabel btnModInstitucion;
    private javax.swing.JLabel btnModificaUsr;
    private javax.swing.JLabel btnProfesor;
    private javax.swing.JLabel btnRankActDeportiva;
    private javax.swing.JLabel btnRankDictadoClase;
    private javax.swing.JLabel btnRegActDeportiva;
    private javax.swing.JLabel btnRegClase;
    private javax.swing.JLabel btnRegDictadoClase;
    private javax.swing.JLabel btnRegInstitucion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblModificaciones;
    private javax.swing.JLabel lblRankings;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeading;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
