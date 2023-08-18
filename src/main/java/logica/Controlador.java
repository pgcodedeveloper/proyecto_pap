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

/**
 *
 * @author PC
 */
public class Controlador implements IControlador {

    public Controlador() {
        super();
    }
    
    @Override
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException{
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(usr.getNickname(), usr.getNombre(), usr.getEmail());
        if(u != null){
            throw new UsuarioRepetidoException("El usuario con los datos ingresados ya existe");
        }
        if(usr instanceof DtSocio){
            u = new Socio(usr.getNickname(),usr.getNombre(),usr.getApellido(),usr.getEmail(),usr.getFechaNac());
        }
        if(usr instanceof DtProfesor){
            u = new Profesor(usr.getNickname(),usr.getNombre(),usr.getApellido(),usr.getEmail(),usr.getFechaNac(), ((DtProfesor) usr).getDescripcion()
                    , ((DtProfesor) usr).getBiografia(), ((DtProfesor) usr).getSitioWeb(), ((DtProfesor) usr).getInstitucionDeportiva(), ((DtProfesor) usr).getClases());
        }
        
        mju.agregarUsuario(u);
    }
    
}
