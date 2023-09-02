/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;
import exceptions.InstitucionRepetidaException;
import exceptions.SocioYaInscriptoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Profesor;
import logica.Registro;
import logica.Socio;

/**
 *
 * @author PC
 */
public interface IControlador {
    
    //Crear un nuevo usuario
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException;
    
    public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionRepetidaException;
    
    public void altaActividadDeportiva(String nombre, String descripcion,int duracion,float costo, Date fechaR, String nomInst);
    
    public void altaSocioClase (String socio, String clase, Date fecha) throws SocioYaInscriptoException;
    
    public String[] obtenerInstituciones();
    
    public String[] obtenerActividades(String nom);
    
    public String[] obtenerProfesInst(String nom);
    
    public String [] obtenerListaSocios();
    
    public String[] obtenerUsuarios();
    
    public String [] obtenerClases(String nomAct);
    
    public String obtenerProfesorClase(String nomClase, String nomInst);
    
    public boolean existeActividadDepo(String nomAct,String nomInst);
    
    public InstitucionDeportiva obtenerInstitucion(String nom);
    
    public ArrayList<DtSocio> obtenerSocios();
    
    public ArrayList<DtProfesor> obtenerProfes();
       
    public ArrayList<String> obtenerClasesProfe(int idP);
    
    public ArrayList<String> obtenerActivDeporProfe(int idP);
    
    public Clase obtenerInfoClase(String nombre);
    
    public ArrayList<Registro> obtenerRegistrosSocio(int idS);
    
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA);
    
    public boolean existeClaseActividad(String clase);
    
    public boolean existeSocioClase (Clase c, Socio s);
    
    public ActividadDeportiva obtenerActividad(String nom);
    
    public ArrayList<ActividadDeportiva> obtenerActividadesInstitucion(String institucion);
    
    public ArrayList<String> obtenerClasesAct(String act);
    
    public ArrayList<Clase> obtenerClasesDeActividad(String act);
    
    public DtUsuario obtenerUsuario(String nickname); 
    
    public DtProfesor obtenerProfesor (String nickname); 
    
    public void actualizarUsuario (String email,String nick, String nombre, String apellido, Date fNac);
    
    public void actualizarProfe (String email,String nick, String nombre, String apellido, Date fNac, String bio, String desc, String web);
    
    public ArrayList<List> rankingClases();

}
