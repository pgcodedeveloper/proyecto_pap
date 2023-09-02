/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
    
    public void modificarInst(InstitucionDeportiva ins){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
        
            em.merge(ins);

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
            i = (InstitucionDeportiva) em.find(InstitucionDeportiva.class, nom);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;
    }
    
    public ArrayList<String> obtenerInst(){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();
        Query query = em.createQuery("select i from InstitucionDeportiva i");
		
        try {
            List<InstitucionDeportiva> listInst = (List<InstitucionDeportiva>) query.getResultList();
            for(InstitucionDeportiva i: listInst) {
                    aRetornar.add(i.getNombre());
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerAct(String nom){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();
    	
        try {
            InstitucionDeportiva ins = (InstitucionDeportiva)em.find(InstitucionDeportiva.class, nom);
            for(ActividadDeportiva a: ins.getActividadesDeportiva()) {
                    aRetornar.add(a.getNombre());
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerActividades(){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();
    	Query query = em.createQuery("select a from ActividadDeportiva a");
        try {
            List<ActividadDeportiva> list = (List<ActividadDeportiva>)query.getResultList();
            for(ActividadDeportiva a: list) {
                    aRetornar.add(a.getNombre());
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ActividadDeportiva obtenerActividad(String nom){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ActividadDeportiva aRetornar = null;
    	
        try {
            aRetornar = (ActividadDeportiva)em.find(ActividadDeportiva.class, nom);
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerProfes(String nom){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();

        try {
            InstitucionDeportiva ins = (InstitucionDeportiva)em.find(InstitucionDeportiva.class, nom);
            for(Profesor p: ins.getProfesores()) {
                    aRetornar.add(p.getNickName());
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public void agregarActividadDeportiva(ActividadDeportiva act){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        try {
            em.getTransaction().begin();
        
            em.persist(act);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarActividadDeportiva(ActividadDeportiva a){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
        
            em.persist(a);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public ArrayList<ActividadDeportiva> obtenerActividadesInst(String inst){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<ActividadDeportiva> list = new ArrayList<>();
        try {
            InstitucionDeportiva i = (InstitucionDeportiva) em.find(InstitucionDeportiva.class, inst);
            for(ActividadDeportiva a: i.getActividadesDeportiva()){
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<String> obtenerClasesAct(String act){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> list = new ArrayList<>();
        try {
            ActividadDeportiva acti = (ActividadDeportiva)em.find(ActividadDeportiva.class, act);
            for(Clase c: acti.getClases()){
                list.add(c.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Clase> obtenerClaseDeActividad(String act){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<Clase> list = new ArrayList<>();
        try {
            ActividadDeportiva acti = (ActividadDeportiva)em.find(ActividadDeportiva.class, act);
            for(Clase c: acti.getClases()){
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
   
    public void agregarClase(Clase c){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        //System.out.println(c);
        try {
            em.getTransaction().begin();
            
            em.merge(c);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
