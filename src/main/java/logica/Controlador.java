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
import java.util.ArrayList;
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
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException{
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(usr.getEmail(), usr.getNickname());
        if(u != null){
            throw new UsuarioRepetidoException("El usuario con los datos ingresados ya existe");
        }
        
        if(usr instanceof DtSocio){
            u = new Socio(usr.getNickname(),  usr.getNombre(),  usr.getApellido(),  usr.getEmail(),  usr.getFechaNac());
            mju.agregarUsuario(u);
        }
        
        if(usr instanceof DtProfesor){
            u = new Profesor(usr.getNickname(),  usr.getNombre(),  usr.getApellido(),  usr.getEmail(),  usr.getFechaNac(),((DtProfesor)usr).getDescripcion(),((DtProfesor) usr).getBiografia(),((DtProfesor) usr).getSitioWeb());
            ((Profesor) u).setInstitucionDeportiva(((DtProfesor)usr).getInstitucionDeportiva());
            mju.agregarUsuario(u);
        }
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

    @Override
    public String[] obtenerInstituciones() {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> list;
        list = mji.obtenerInst();
        String[] inst_ret = new String[list.size()];
        if(!list.isEmpty()){
            int i=0;
            inst_ret[0] = "Seleccione"; //Para que en el combo box aparezca seleccionada esta opción
            for(String name:list) {
                    inst_ret[i]=name;
                    i++;
            }
        }
        else{
            inst_ret[0] = "No hay instituciones";
        }
        return inst_ret;
    }
    
    public InstitucionDeportiva obtenerInstitucion(String nom){
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nom);
        return i;
    }

    @Override
    public ArrayList<DtSocio> obtenerSocios() {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtSocio> list;
        list = mju.obtenerUsuariosSocio();
        return list;
    }

    @Override
    public ArrayList<DtProfesor> obtenerProfes() {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtProfesor> list;
        list = mju.obtenerUsuariosProfe();
        return list;
    }
    
    
}
