/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import persistencia.Conexion;

/**
 *
 * @author PC
 */
public class ManejadorInstitucion {
    private static ManejadorInstitucion instancia = null;

    private ManejadorInstitucion() {
    }
    
    public static ManejadorInstitucion getInstancia() {
        if (instancia == null)
                instancia = new ManejadorInstitucion();
        return instancia;
    }
    
    public void agregarInstitucion(InstitucionDeportiva ins){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
        
            em.persist(ins);

            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public InstitucionDeportiva buscarInst(String nom){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        InstitucionDeportiva i = null;
        try {
            i = em.find(InstitucionDeportiva.class, nom);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;
    }
    
}
