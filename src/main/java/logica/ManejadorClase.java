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
    
    public ArrayList<Clase> listadoClases(){

            Conexion con = Conexion.getInstancia();
            EntityManager em = con.getEntityManager();
     
            Query q = em.createQuery("SELECT c FROM clase c", Clase.class);
            ArrayList<Clase> aRet = new ArrayList<>(q.getResultList());
            
            return aRet;    
    }
    
    public List<Registro> buscarRegistroClase(String nomb){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        List<Registro> list = null;
        
        try {
            Clase c = em.find(Clase.class, nomb);
            
            if(c != null){
                list = c.getRegistros();
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void eliminarSocio(Clase clase, Socio idS){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createQuery("delete from Registro r where r.clase = :clase and r.socio = :idS");
            q.setParameter("clase", clase);
            q.setParameter("idS", idS);
            
            int deletedCount = q.executeUpdate();

            em.getTransaction().commit();

            System.out.println("Registros eliminados: " + deletedCount);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
            
}
