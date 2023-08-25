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
import java.util.ArrayList;
import java.util.Date;
import logica.InstitucionDeportiva;

/**
 *
 * @author PC
 */
public interface IControlador {
    
    //Crear un nuevo usuario
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException;
    
    public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionRepetidaException;
    
    public String[] obtenerInstituciones();
    
    public InstitucionDeportiva obtenerInstitucion(String nom);
    
    public ArrayList<DtSocio> obtenerSocios();
    
    public ArrayList<DtProfesor> obtenerProfes();
    
    public ArrayList<String> obtenerClasesProfe(int idP);
    
    public ArrayList<String> obtenerActivDeporProfe(int idP);
}
