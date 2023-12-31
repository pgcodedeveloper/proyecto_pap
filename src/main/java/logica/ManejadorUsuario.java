/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
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
    
    public void actualizaUser (Usuario u){
        System.out.println(u);
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
      public void actualizaProfe (Usuario u){
        System.out.println(u);
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
            
    public void agregarProfesor(Usuario usr){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        InstitucionDeportiva i = ((Profesor)usr).getInstitucionDeportiva();
        i.agregarProfesor(((Profesor)usr));
        try {
            em.getTransaction().begin();
            em.persist(usr);
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
    
    public Usuario buscarUsuarioEmail(String email){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Query q = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
        q.setParameter("email", email);
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
                int size = u.getRegistros().size();
                String[] reg = new String[size];
                int i = 0;
                for(Registro r:u.getRegistros() ){
                    reg[i] = r.toString();
                    i++;
                }
                DtSocio socio = new DtSocio(u.getId(),u.getNickName(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFecha(), u.getPassword(), u.getImagen(),reg);
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
                int size = u.getClases().size();
                String[] clas = new String[size];
                int i = 0;
                for(Clase r: u.getClases()){
                    clas[i] = r.toString();
                    i++;
                }
                DtProfesor prof = new DtProfesor(u.getId(),u.getDescripcion(), u.getBiografia(), u.getSitioWeb(), u.getNickName(), u.getNombre()
                    , u.getApellido(), u.getEmail(), u.getFecha(),u.getInstitucionDeportiva().toString(), u.getPassword(), u.getImagen(),clas);
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
        try {
            Profesor p = em.find(Profesor.class, idProf);
            try {
                List<Clase> l = p.getClases();
                if(!l.isEmpty()){
                    for(Clase c:l){
                        aRetornar.add(c.getNombre());
                    }
                }
                else{
                    aRetornar = null;
                }
            } catch ( NullPointerException e) {
                aRetornar = null;
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
        try {
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
            } catch (NullPointerException e) {
                aRetornar = null;
            }
            

        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
    public ArrayList<Registro> obtenerRegistrosSocio(int idSocio){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        Socio s;
        ArrayList<Registro> aRetornar = new ArrayList<>();
        try {
            s = (Socio) em.find(Socio.class, idSocio);
            List<Registro> li = s.getRegistros();
            for(Registro r:li){
                aRetornar.add(r);
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        
        return aRetornar;
    }
    
    public ArrayList<DtUsuario> obtenerUsuarios(){
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        
        Query q = em.createQuery("select u from Usuario u", Usuario.class);
        ArrayList<DtUsuario> aRetornar = new ArrayList<>();
		
        try {
            List<Usuario> listU = (List<Usuario>)q.getResultList();
            for(Usuario u: listU) {
                DtUsuario usuario = new DtUsuario (u.getId(),u.getNickName(), u.getNombre() , u.getApellido(),u.getEmail(), u.getFecha(), u.getPassword(), u.getImagen() );
                aRetornar.add(usuario);
            }
        } catch (NoResultException e) {
            aRetornar = null;
        }
        return aRetornar;
    }
    
}


