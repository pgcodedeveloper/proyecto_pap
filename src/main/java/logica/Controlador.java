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
import java.util.List;

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
        
        if(usr instanceof DtProfesor dtProfesor){
            u = new Profesor(usr.getNickname(),  usr.getNombre(),  usr.getApellido(),  usr.getEmail(),  usr.getFechaNac(),dtProfesor.getDescripcion(),dtProfesor.getBiografia(),dtProfesor.getSitioWeb());
            ((Profesor) u).setInstitucionDeportiva(dtProfesor.getInstitucionDeportiva());
            mju.agregarProfesor(u);
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
            inst_ret = new String[1];
            inst_ret[0] = "No hay instituciones";
        }
        return inst_ret;
    }
    
    @Override
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

    @Override
    public ArrayList<String> obtenerClasesProfe(int idP) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<String> li;
        li = mju.obtenerClases(idP);
        return li;
    }

    @Override
    public ArrayList<String> obtenerActivDeporProfe(int idP) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<String> li;
        li = mju.obtenerActividadesD(idP);
        return li;
    }

    @Override
    public Clase obtenerInfoClase(String nombre) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(nombre);
        return c;
    }

    @Override
    public ArrayList<Registro> obtenerRegistrosSocio(int idS) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<Registro> list;
        list = mju.obtenerRegistrosSocio(idS);
        return list;
    }

    @Override
    public void altaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaR, String nomInst) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nomInst);
        ActividadDeportiva a = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaR, i);
        i.agregarActividad(a);
        mji.agregarActividadDeportiva(a);
    }

    @Override
    public boolean existeActividadDepo(String nomAct, String nomInst) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nomInst);
        List<ActividadDeportiva> act = i.getActividadesDeportiva();
        boolean aRetornar = false;
        for(ActividadDeportiva a:act){
            if(a.getNombre().equals(nomAct)){
                aRetornar = true;
            }
        }
        
        return aRetornar;
    }

    @Override
    public String[] obtenerActividades(String nom) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> list;
        list = mji.obtenerAct(nom);
        String[] inst_ret = new String[list.size()];
        if(!list.isEmpty()){
            int i=0;
            //inst_ret[0] = "Seleccione"; //Para que en el combo box aparezca seleccionada esta opción
            for(String name:list) {
                    inst_ret[i]=name;
                    i++;
            }
        }
        else{
            inst_ret = new String[1];
            inst_ret[0] = "No hay actividades";
        }
        return inst_ret;
    }

    @Override
    public String[] obtenerProfesInst(String nom) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> list;
        list = mji.obtenerProfes(nom);
        String[] inst_ret = new String[list.size()];
        if(!list.isEmpty()){
            int i=0;
            //inst_ret[0] = "Seleccione"; //Para que en el combo box aparezca seleccionada esta opción
            for(String name:list) {
                    inst_ret[i]=name;
                    i++;
            }
        }
        else{
            inst_ret = new String[1];
            inst_ret[0] = "No hay profesores";
        }
        return inst_ret;
    }

    @Override
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        Clase c = new Clase(nomC, fechaI, fechaI, url, fechaA);
        InstitucionDeportiva i = mji.buscarInst(inst);
        for(ActividadDeportiva a: i.getActividadesDeportiva()) {
            if(a.getNombre().equals(act)){
                a.altaClase(c);
            }
        }
        for(Profesor p: i.getProfesores()){
            if(p.getNickName().equals(prof)){
                p.agregarClase(c);
            }
        }
        mji.agregarClase(c);
    }
    
    @Override
    public boolean existeClaseActividad(String clase) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(clase);
        boolean aRetornar = false;
        if(c != null){
            aRetornar = true;
        }
        return aRetornar;
    }

    @Override
    public ActividadDeportiva obtenerActividad(String nom) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ActividadDeportiva a = mji.obtenerActividad(nom);
        return a;
    }
    
    
    
    
    
    
}
