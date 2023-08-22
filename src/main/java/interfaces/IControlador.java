/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;
import exceptions.InstitucionRepetidaException;
import java.util.Date;

/**
 *
 * @author PC
 */
public interface IControlador {
    
    //Crear un nuevo usuario
    public void altaUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException;
    
    public void altaProfesor(String nc, String n, String a, String e, Date df, String desc, String bio, String sitioWeb) throws UsuarioRepetidoException;
    
    public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionRepetidaException;
}
