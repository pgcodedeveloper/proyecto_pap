/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import persistencia.Conexion;

/**
 *
 * @author PC
 */
public class ManejadorUsuario {
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
    }
    
    public static ManejadorUsuario getInstancia() {
        if (instancia == null)
                instancia = new ManejadorUsuario();
        return instancia;
    }
    
    
    public void agregarUsuario(Usuario usr){
        System.out.println(usr);
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
        
            System.out.println(em);
            em.persist(usr);

            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void agregarProfesor(Usuario usr){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        em.getTransaction().begin();
        em.persist(usr);
        em.getTransaction().commit();
    }
    
    public Usuario buscarUsuario(int id){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Usuario urs = em.find(Usuario.class, id);
        return urs;
    }
    
}
