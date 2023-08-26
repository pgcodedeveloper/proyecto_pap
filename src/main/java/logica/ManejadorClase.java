/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import persistencia.Conexion;

/**
 *
 * @author PC
 */
public class ManejadorClase {
    private static ManejadorClase instancia = null;

    private ManejadorClase() {
    }
    
    public static ManejadorClase getInstancia() {
        if (instancia == null)
                instancia = new ManejadorClase();
        return instancia;
    }
    
    public Clase obtenerInfoClase(String nombre){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        Clase c;
        try {
            c = em.find(Clase.class, nombre);
        } catch (NoResultException e) {
            c = null;
        }
        
        return c;
    }
}
