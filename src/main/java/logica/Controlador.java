/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.InstitucionRepetidaException;
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

    @Override
    public void altaProfesor(String nc, String n, String a, String e, Date df, String desc, String bio, String sitioWeb) throws UsuarioRepetidoException{
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u;
        
        u = new Profesor(nc,n,a,e,df,desc,bio,sitioWeb);
    }

    @Override
    public void altaInstitucion(String nombre, String descripcion, String url) throws InstitucionRepetidaException {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva ins = mji.buscarInst(nombre);
        
        if(ins != null){
            throw new InstitucionRepetidaException("La institucion: " + nombre + " ya existe");
        }
        else{
            ins = new InstitucionDeportiva(nombre, descripcion, url);
            mji.agregarInstitucion(ins);
        }
        
        
    }
    
    
    
    
    
    
}
