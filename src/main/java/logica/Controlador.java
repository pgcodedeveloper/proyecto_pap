/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;
import interfaces.IControlador;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Controlador implements IControlador {

    public Controlador() {
        super();
    }
    
    @Override
    public void altaUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException{
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u;
        // mju.buscarUsuario(usr.getId());
        /*if(u != null){
            throw new UsuarioRepetidoException("El usuario con los datos ingresados ya existe");
        }*/
        
        u = new Socio(nickname,  nombre,  apellido,  email,  fechaNac);
        mju.agregarUsuario(u);
    }
    
}
