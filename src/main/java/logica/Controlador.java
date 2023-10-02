/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.ActividadDException;
import exceptions.ClaseException;
import exceptions.InstitucionRepetidaException;
import exceptions.SocioYaInscriptoException;
import exceptions.UsuarioRepetidoException;
import interfaces.IControlador;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.mindrot.jbcrypt.BCrypt;
import persistencia.Conexion;

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
            u = new Socio(usr.getNickname(),  usr.getNombre(),  usr.getApellido(),  usr.getEmail(),  usr.getFechaNac(), usr.getPassword(), usr.getImagen());
            mju.agregarUsuario(u);
        }
        
        if(usr instanceof DtProfesor dtProfesor){
            u = new Profesor(usr.getNickname(),  usr.getNombre(),  usr.getApellido(),  usr.getEmail(),  usr.getFechaNac(),dtProfesor.getDescripcion(),dtProfesor.getBiografia(),dtProfesor.getSitioWeb(), dtProfesor.getPassword(), dtProfesor.getImagen());
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
    public void altaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaR, String nomInst) throws ActividadDException{
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nomInst);
        if(this.existeActividadDepo(nombre, nomInst)){
            throw new ActividadDException("Ya existe una actividad con ese nombre");
        }
        else{
            ActividadDeportiva a = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaR, i);
            i.agregarActividad(a);
            mji.agregarActividadDeportiva(a);
        }
        
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
    public String[] obtenerActividades() {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> list;
        list = mji.obtenerActividades();
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
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA) throws ClaseException{
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(inst);
        
        if(this.existeClaseActividad(nomC)){
            throw new ClaseException("Ya existe esa clase");
        }
        else{
            Instant instant = fechaI.toInstant();
            ZoneId zona = ZoneId.systemDefault();
            LocalTime hora = instant.atZone(zona).toLocalTime();
            //System.out.println("La hora es" + hora.);
            Clase c = new Clase(nomC, fechaI, hora, url, fechaA);
             
            
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

    @Override
    public ArrayList<ActividadDeportiva> obtenerActividadesInstitucion(String institucion) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<ActividadDeportiva> aRetornar = mji.obtenerActividadesInst(institucion);
        return aRetornar;
    }

    @Override
    public ArrayList<String> obtenerClasesAct(String act) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> aRetornar = mji.obtenerClasesAct(act);
        return aRetornar;
    }

    @Override
    public ArrayList<Clase> obtenerClasesDeActividad(String act) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<Clase> aRetornar = mji.obtenerClaseDeActividad(act);
        return aRetornar;
    }

    
    @Override
    public String [] obtenerListaSocios(){
        ArrayList<DtSocio> list;
        list = this.obtenerSocios();
        String[] usr_ret = new String[list.size()];
        if(!list.isEmpty()){
            int i=0;
            for(DtSocio u:list) {
                    usr_ret[i]=u.getNickname();
                    i++;
            }
        }
        else{
            usr_ret = new String[1];
            usr_ret[0] = "No hay profesores";
        }
        return usr_ret;
    }
    
    @Override
        public String [] obtenerClases(String nomAct){
         
            ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
            
            List<Clase> cs= (mji.obtenerActividad(nomAct).getClases());
            String[] ret= new String [cs.size()];
            if (!cs.isEmpty()){
                int i = 0;
                for (Clase c:cs){
                    ret[i]= c.getNombre();
                    i++;
                }
            }
            else{
                ret = new String [1];
                ret[0] = "No hay clases";
            }
            return ret;
        }

    @Override
   public void altaSocioClase (String nomSocio, String nomClase, Date fecha) throws SocioYaInscriptoException{
        ManejadorClase mjc = ManejadorClase.getInstancia();
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        
        String email = null;
        for(DtSocio s:obtenerSocios()){
            if (s.getNickname().equals(nomSocio))
                email = s.getEmail();
        }
        
        Socio socio = (Socio) mju.buscarUsuario(email,nomSocio);
        Clase clase = mjc.obtenerInfoClase(nomClase);
        
                  
        if(this.existeSocioClase(clase, socio)){
           throw new SocioYaInscriptoException ("El socio ya esta inscripto en esta clase");
        }
        else{
            clase.agregarRegistro(socio, fecha);
        }
        Conexion con = Conexion.getInstancia();
        EntityManager em = con.getEntityManager();
        em.getTransaction().begin();
        em.persist(clase);
        em.getTransaction().commit();
    }   
    
    @Override
    public boolean existeSocioClase (Clase c, Socio s){
        
        Boolean aRetornar=false;
        for (Registro r:c.getRegistros()){
            if (r.getSocioId().getId() == s.getId())
                    aRetornar = true;
        }
        return aRetornar;
    }
    
    @Override
    public String obtenerProfesorClase(String nomClase, String nomInst){
        
        String aRet = null;
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        List<Profesor> profes = mji.buscarInst(nomInst).getProfesores();
        for (Profesor p:profes){
            for(Clase c:p.getClases()){
                if(c.getNombre().equals(nomClase))
                    aRet = p.getNickName();
            }
        }
        return aRet;
    }   
    
    @Override
    public String[] obtenerUsuarios(){
        
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtUsuario> list;
        list = mju.obtenerUsuarios();
        String[] aRet = new String[list.size()];
        int i = 0;
        for (DtUsuario u:list){
            aRet[i]=u.getNickname();
            i++;
        }
        return aRet;
    }
    
    
    @Override
    public DtUsuario obtenerUsuario(String nickname){
        
        DtUsuario ret = null;
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtUsuario> list;
        list = mju.obtenerUsuarios();
        for (DtUsuario u:list){
            if(u.getNickname().equals(nickname)){
                ret = u;
            }
        }
      
        return ret;
    }
    
    @Override
    public DtProfesor obtenerProfesor (String nickname){
        
        DtProfesor ret = null;
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtProfesor> list;
        list = mju.obtenerUsuariosProfe();
        for (DtProfesor p:list){
            if(p.getNickname().equals(nickname)){
                ret = p;
            }
        }
        return ret;
    }
    
    @Override
    public void actualizarUsuario (String email,String nick, String nombre, String apellido, Date fNac){
        
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        //ArrayList<DtUsuario> list = mju.obtenerUsuarios();
        Usuario u = mju.buscarUsuario(email, nick);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setFechaNac(fNac);
        mju.actualizaUser(u);
        
        /*for (DtUsuario u:list){
            if (u.getNickname().equals(nick)){
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setFechaNac(fNac);
                mju.actualizaUser(u);
            }
        }*/
    }
    
    @Override
    public void actualizarProfe (String email,String nick, String nombre, String apellido, Date fNac, String bio, String desc, String web){
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        //ArrayList<DtProfesor> list = mju.obtenerUsuariosProfe();
        Usuario u = mju.buscarUsuario(email, nick);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setFechaNac(fNac);
        ((Profesor)u).setBiografia(bio);
        ((Profesor)u).setDescripcion(desc);
        ((Profesor)u).setSitioWeb(web);
        mju.actualizaProfe(u);
    }
    
    @Override
    public ArrayList<Object[]> rankingClases(){
        ManejadorClase mjc = ManejadorClase.getInstancia();
        ArrayList<Clase> clases = mjc.listadoClases();
        ArrayList<Object[]> aRet = new ArrayList();
        
        for(Clase c:clases){
            aRet.add(new Object []{c, c.getRegistros().size()});
        }
        
        Collections.sort(aRet, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] pareja1, Object[] pareja2) {
                // Compara las parejas por el valor de int
                int valor1 = (int) pareja1[1];
                int valor2 = (int) pareja2[1];
                return Integer.compare(valor1, valor2);
               }
        });
        
        Collections.reverse(aRet);

        return aRet;
    }

    @Override
    public void modificarActividadDeportiva(String nombre, String descripcion, int duracion, float costo) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ActividadDeportiva a = mji.obtenerActividad(nombre);
        
        a.setDescripcion(descripcion);
        a.setDuracion(duracion);
        a.setCosto(costo);
        mji.modificarActividadDeportiva(a);
    }

    @Override
    public void modificarInstitucion(String nombre, String descripcion, String url) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva ins = mji.buscarInst(nombre);
        ins.setDescripcion(descripcion);
        ins.setUrl(url);
        
        mji.modificarInst(ins);
        
    }
    
    @Override
    public ArrayList<Object[]> rankingActividades(){
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList <Object[]> aRet = new ArrayList();
        ActividadDeportiva actDeportiva;
        
        for(String s : mji.obtenerActividades()){
            actDeportiva = mji.obtenerActividad(s);
            aRet.add(new Object []{actDeportiva, actDeportiva.getClases().size()});
        }

        Collections.sort(aRet, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] pareja1, Object[] pareja2) {
                // Compara las parejas por el valor de int
                int valor1 = (int) pareja1[1];
                int valor2 = (int) pareja2[1];
                return Integer.compare(valor1, valor2);
               }
        });
        
        Collections.reverse(aRet);
        return aRet;
    }

    @Override
    public void setPassword(String nickname, String mail, String password, String imagen) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(mail, nickname);
        u.setPassword(password);
        u.setImagen(imagen);
        mju.actualizaUser(u);
    }

    @Override
    public void eliminarSocioRegistro(String clase, Socio s) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(clase);
        System.out.println("Clase " + c.getNombre());
        System.out.println("Socio " + s.getId());
        
        
        for(Registro r: c.getRegistros()){
            System.out.println("Aca");
            if(r.getClaseId().getNombre().equals(clase) && r.getSocioId().getId() == s.getId()){
                System.out.println("Registro " + r.getSocioId().getId());
                c.eliminarRegistro(r);
                s.eliminarRegistro(r);
                mjc.eliminarSocio(c, s);
                break;
            }
        }
        System.out.println("O termine aca?");
    }

}



 
