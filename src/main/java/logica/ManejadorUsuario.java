/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import java.util.ArrayList;
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
    
    public Usuario buscarUsuario(String email, String nick){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Query q = em.createQuery("select u from Usuario u where u.email = :email and u.nickname = :nick", Usuario.class);
        q.setParameter("email", email);
        q.setParameter("nick", nick);
        Usuario usr = null;
        
        try {
            usr = (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            usr = null;
        }
        return usr;
    }
    
    public ArrayList<DtSocio> obtenerUsuariosSocio(){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Query q = em.createQuery("select u from Usuario u, Socio s where u.id = s.id", Usuario.class);
        ArrayList<DtSocio> aRetornar = new ArrayList<>();
		
        try {
            List<Socio> listU = (List<Socio>) q.getResultList();
            for(Socio u: listU) {
                DtSocio socio = new DtSocio(u.getNickName(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFecha());
                socio.setId(u.getId());
                aRetornar.add(socio);
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<DtProfesor> obtenerUsuariosProfe(){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Query q = em.createQuery("select p from Profesor p", Profesor.class);
        ArrayList<DtProfesor> aRetornar = new ArrayList<>();
		
        try {
            List<Profesor> listU = (List<Profesor>) q.getResultList();
            for(Profesor u: listU) {
                DtProfesor prof = new DtProfesor(u.getDescripcion(), u.getDescripcion(), u.getSitioWeb(), u.getNickName(), u.getNombre()
                    , u.getApellido(), u.getEmail(), u.getFecha(), u.getInstitucionDeportiva());
                prof.setId(u.getId());
                aRetornar.add(prof);
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerClases(int idProf){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();
        Profesor p = em.find(Profesor.class, idProf);
        try {
            List<Clase> l = p.getClases();
            for(Clase c:l){
                aRetornar.add(c.getNombre());
            }
 
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerActividadesD(int idProf){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        ArrayList<String> aRetornar = new ArrayList<>();
        Profesor p = em.find(Profesor.class, idProf);
        try {
            InstitucionDeportiva ins = p.getInstitucionDeportiva();
            if(!ins.getActividadesDeportiva().isEmpty()){
                List<ActividadDeportiva> act = ins.getActividadesDeportiva();
                for(ActividadDeportiva a:act){
                    aRetornar.add(a.getNombre());
                }
            }
            else{
                aRetornar = null;
            }

        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
}


