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
    
    public ArrayList<List> rankClases(){
                
            ArrayList<List> aRet = new ArrayList<>();
            ArrayList<String> nomC = new ArrayList(); 
            ArrayList<String> cantS = new ArrayList(); 
            
            Conexion con = Conexion.getInstancia();
            EntityManager em = con.getEntityManager();
     
            String jpql = "SELECT COUNT(r), r.clase.id FROM Registro r GROUP BY r.clase.id ORDER BY COUNT(r) DESC";

            Query q = em.createQuery(jpql, Object[].class);

            // Ejecuta la consulta
            List<Object[]> resultados = q.getResultList();
                
            // Itera a través de los resultados y los agrega a la lista correspondiente
            int i=0;
            for (Object[] resultado : resultados) {
                cantS.add(i, resultado[0].toString());
                nomC.add(i, resultado[1].toString());
            }
            
            aRet.add(0, cantS);
            aRet.add(1, nomC);
            return aRet;    
    }
            
}
