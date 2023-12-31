package publicadores;

import configuracion.WebServiceConfiguracion;
import datatypes.DtActividadDeportiva;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.ActividadDException;
import exceptions.ClaseException;
import exceptions.InstitucionRepetidaException;
import exceptions.SocioYaInscriptoException;
import exceptions.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControlador;
import jakarta.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.ManejadorInstitucion;
import logica.ManejadorUsuario;
import logica.Profesor;
import logica.Registro;
import logica.Socio;
import logica.Usuario;

@WebService(name = "ControladorPublish")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED,style = SOAPBinding.Style.RPC)
public class ControladorPublish{
    private final Fabrica fabrica = Fabrica.getInstancia();
    private final IControlador icon = fabrica.getIControlador();
    private final WebServiceConfiguracion configuracion = new WebServiceConfiguracion();
    private Endpoint endpoint;
    
    public ControladorPublish(){
        
    }
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:3001/controlador", this);
    }
    
    @WebMethod
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException{
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(usr.getEmail(), usr.getNickname());
        if(u != null){
            throw new UsuarioRepetidoException("El usuario con los datos ingresados ya existe");
        }
        icon.altaUsuario(usr);
    }
    
    
    @WebMethod
    public void altaInstitucion(String nombre, String descripcion, String url) throws InstitucionRepetidaException {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva ins = mji.buscarInst(nombre);
        
        if(ins != null){
            throw new InstitucionRepetidaException("La institucion: " + nombre + " ya existe");
        }
        else{
            icon.altaInstitucion(nombre, descripcion, url);
        }
    }
    
    @WebMethod
    public String[] obtenerInstituciones() {
        String[] inst_ret = icon.obtenerInstituciones();
        return inst_ret;
    }
    
   @WebMethod
    public InstitucionDeportiva obtenerInstitucion(String nom){
        InstitucionDeportiva i = icon.obtenerInstitucion(nom);
        return i;
    }
    
    @WebMethod
    public DtSocio[] obtenerSocios() {
        ArrayList<DtSocio> list;
        list = icon.obtenerSocios();
        DtSocio[] ret = new DtSocio[list.size()];
        int i = 0;
        for(DtSocio s : list) {
            ret[i]=s;
            i++;
        }
        return ret;
    }
    
    @WebMethod
    public DtProfesor[] obtenerProfes() {
        ArrayList<DtProfesor> list;
        list = icon.obtenerProfes();
        DtProfesor[] ret = new DtProfesor[list.size()];
        int i = 0;
        for(DtProfesor s : list) {
            ret[i]=s;
            i++;
        }
        return ret;
    }

    @WebMethod
    public String[] obtenerClasesProfe(int idP) {
        ArrayList<String> li;
        li = icon.obtenerClasesProfe(idP);
        int i = 0;
        String[] ret = new String[li.size()];
        for(String s: li){
            ret[i] = s;
            i++;
        }
        return ret;
    }
    
    
    @WebMethod
    public String[] obtenerClasesProfesor(String idP) {
        Usuario u = icon.obtenerClaseProfe(idP);
        int i = 0;
        String[] ret = new String[((Profesor)u).getClases().size()];
        for(Clase s: ((Profesor)u).getClases()){
            ret[i] = s.toString();
            i++;
        }
        return ret;
    }
    

    @WebMethod
    public DtUsuario loginUsuario(String email) {
        DtUsuario u = icon.loginUsuario(email);
        
        //System.out.println();
        if(u instanceof DtProfesor dtProfesor){
            System.out.println(dtProfesor.getClases().length);
            System.out.println(dtProfesor.getBiografia());
            System.out.println(dtProfesor.getDescripcion());
            System.out.println(dtProfesor.getInst());
            System.out.println(dtProfesor.getSitioWeb());
            for(String s: dtProfesor.getClases()){
                System.out.println(s);
            }
        }
        return u;
    }
    
 
    @WebMethod
    public String[] obtenerActivDeporProfe(int idP) {
        ArrayList<String> li;
        li = icon.obtenerActivDeporProfe(idP);
        int i = 0;
        String[] ret = new String[li.size()];
        for(String s: li){
            ret[i] = s;
            i++;
        }
        return ret;
    }

    @WebMethod
    public String[] obtenerInfoClase(String nombre) {
        Clase c = icon.obtenerInfoClase(nombre);
        String [] clase = new String[7];
        clase[0] = c.getNombre();
        clase[1] = c.getFecha().toString();
        clase[2] = c.getHoraInicio().toString();
        clase[3] = c.getUrl();
        clase[4] = c.getFechaReg().toString();
        clase[5] = c.getImagen();
        List <Registro> list = c.getRegistros();
        String[] reg = new String[list.size()];
        int i = 0;
        for(Registro r: list){
            reg[i] = r.getSocioId().getNickName();
            i++;
        }
        clase[6] = Arrays.toString(reg);
        return clase;
    }


    @WebMethod
    public String[] obtenerRegistrosSocio(String idS) {
        ArrayList<Registro> list;
        DtUsuario u = icon.obtenerUsuario(idS);
        System.out.println(u.getId());
        list = icon.obtenerRegistrosSocio(u.getId());
        int i = 0;
        String[] ret = new String[list.size()];
        for(Registro r : list){
            String [] d = new String[3];
            d[0] = r.getClaseId().getNombre();
            d[1] = r.getFechaReg().toString();
            d[2] = r.getSocioId().getNombre() + " " + r.getSocioId().getApellido();
            //System.out.println(d);
            ret[i] = Arrays.deepToString(d);
            i++;
        }
        System.out.println(ret[0]);
        return ret;
    }
    

    @WebMethod
    public void altaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaR, String nomInst, String img) throws ActividadDException{
        icon.altaActividadDeportiva(nombre, descripcion, duracion, costo, fechaR, nomInst, img);
    }


    @WebMethod
    public boolean existeActividadDepo(String nomAct, String nomInst) {
        boolean aRetornar = icon.existeActividadDepo(nomAct, nomInst);
        return aRetornar;
    }


    @WebMethod
    public String[] obtenerActividades(String nom) {
        String[] inst_ret = icon.obtenerActividades(nom);
        return inst_ret;
    }


    @WebMethod
    public String[] obtenerProfesInst(String nom) {
        String[] inst_ret = icon.obtenerProfesInst(nom);
        return inst_ret;
    }


    @WebMethod
    public boolean existeClaseActividad(String clase) {
        boolean aRetornar = icon.existeClaseActividad(clase);
        return aRetornar;
    }
   

    @WebMethod
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA, String img) throws ClaseException{
        icon.altaClaseActividad(inst, act, nomC, prof, url, fechaI, fechaA, img);
    }
    
    @WebMethod
    public String[] obtenerActividad(String nom) {
        DtActividadDeportiva a = new DtActividadDeportiva(icon.obtenerActividad(nom));
        System.out.println(a.getNombre());
        String[] act = new String[7];
        act[0] = a.getNombre();
        act[1] = a.getDescripcion();
        act[2] = "" + a.getDuracion();
        act[3] = "" + a.getCosto();
        act[4] = a.getFechaReg().toString();
        act[5] = a.getImagen();
        act[6] = a.getInst().getNombre();
        return act;
    }
    
    @WebMethod
    public String[] obtenerActividadDatos(String nom) {
        ActividadDeportiva a = icon.obtenerActividad(nom);
        System.out.println(a.getNombre());
        String[] act = new String[7];
        act[0] = a.getDescripcion();
        act[1] = a.getFechaReg().toString();
        act[2] = a.getInst().getNombre();
        act[3] = "" + a.getCosto();
        act[4] = "" + a.getDuracion();
        String[] clases = new String[a.getClases().size()];
        int i = 0;
        for(Clase c: a.getClases()){
            clases[i] = c.getNombre();
            i++;
        }
        act[5] = clases.toString();
        return act;
    }
    
    @WebMethod
    public String[] obtenerActividadClases(String nom) {
        ActividadDeportiva a = icon.obtenerActividad(nom);
        String[] clases = new String[a.getClases().size()];
        int i = 0;
        for(Clase c: a.getClases()){
            clases[i] = c.getNombre();
            i++;
        }
        return clases;
    }

    @WebMethod
    public ActividadDeportiva[] obtenerActividadesInstitucion(String institucion) {
        ArrayList<ActividadDeportiva> aRetornar = icon.obtenerActividadesInstitucion(institucion);
        int i = 0;
        ActividadDeportiva[] ret = new ActividadDeportiva[aRetornar.size()];
        for(ActividadDeportiva a: aRetornar){
            ret[i] = a;
            i++;
        }
        return ret;
    }

    @WebMethod
    public String[] obtenerClasesAct(String act) {
        ArrayList<String> aRetornar = icon.obtenerClasesAct(act);
        int i = 0;
        String[] ret = new String[aRetornar.size()];
        for(String s: aRetornar){
            ret[i] = s;
            i++;
        }
        return ret;
    }

    @WebMethod
    public Clase[] obtenerClasesDeActividad(String act) {
        ArrayList<Clase> aRetornar = icon.obtenerClasesDeActividad(act);
        int i = 0;
        Clase[] ret = new Clase[aRetornar.size()];
        for(Clase c: aRetornar){
            ret[i] = c;
            i++;
        }
        return ret;
    }

    
   @WebMethod
    public String [] obtenerListaSocios(){
        String[] usr_ret = icon.obtenerListaSocios();
        return usr_ret;
    }
    
    @WebMethod
    public String [] obtenerClases(String nomAct){
        String[] ret = icon.obtenerClases(nomAct);
        return ret;
    }
    
    @WebMethod
    public void altaSocioClase (String nomSocio, String nomClase, Date fecha) throws SocioYaInscriptoException{
        icon.altaSocioClase(nomSocio, nomClase, fecha);
    }   
    
   @WebMethod
    public boolean existeSocioClase (Clase c, Socio s){
        boolean aRetornar = icon.existeSocioClase(c, s);
        return aRetornar;
    }
    
    @WebMethod
    public String obtenerProfesorClase(String nomClase, String nomInst){
        String aRet = icon.obtenerProfesorClase(nomClase, nomInst);
        return aRet;
    }   
    
    @WebMethod
    public String[] obtenerUsuarios(){
        String[] aRet = icon.obtenerUsuarios();
        return aRet;
    }
    
    
    @WebMethod
    public DtUsuario obtenerUsuario(String nickname){
        DtUsuario ret = icon.obtenerUsuario(nickname);
        return ret;
    }
    
    @WebMethod
    public DtProfesor obtenerProfesor (String nickname){
        DtProfesor ret = icon.obtenerProfesor(nickname);
        return ret;
    }
    
    @WebMethod
    public void actualizarUsuario (String email,String nick, String nombre, String apellido, Date fNac, String img){
        icon.actualizarUsuario(email, nick, nombre, apellido, fNac, img);

    }
    
   @WebMethod
    public void actualizarProfe (String email,String nick, String nombre, String apellido, Date fNac, String img, String bio, String desc, String web){
        icon.actualizarProfe(email, nick, nombre, apellido, fNac, img, bio, desc, web);
    }
    
    
    @WebMethod
    public Object[] rankingClases(){
        ArrayList<Object[]> clases = icon.rankingClases();
        int i = 0;
        String [] aRet = new String [clases.size()];
         
        for(Object[] cs: clases){
            Clase c = (Clase)cs[0];
            aRet[i] = c.getNombre() + ",," + c.getFecha().toString() + ",," + c.getUrl() + ",," + cs[1];
            i++;
        }
        return aRet;
    }
    

    @WebMethod
    public void modificarActividadDeportiva(String nombre, String descripcion, int duracion, float costo, String img) {
        icon.modificarActividadDeportiva(nombre, descripcion, duracion, costo, img);
    }

   @WebMethod
    public void modificarInstitucion(String nombre, String descripcion, String url) {
        icon.modificarInstitucion(nombre, descripcion, url); 
    }
    
    
    @WebMethod
    public Object[] rankingActividades(){
        ArrayList<Object[]> act = icon.rankingActividades();
        //nombre, costo, descripcion, clases
        int i = 0;
        String [] aRet = new String [act.size()];
        for(Object[] a: act){
            ActividadDeportiva ad = (ActividadDeportiva) a[0];
            aRet[i] = ad.getNombre() + ",," + ad.getCosto() + ",," + ad.getDescripcion() + ",," + a[1];
            i++;
        }
        return aRet;
    }

    @WebMethod
    public void setPassword(String nickname, String mail, String password, String imagen) {
        icon.setPassword(nickname, mail, password, imagen);
    }

    @WebMethod
    public void eliminarSocioRegistro(String clase, DtUsuario socio) {
        Socio s = icon.obtenerSocio(socio.getNickname(), socio.getEmail());
        icon.eliminarSocioRegistro(clase, s);
    }

    @WebMethod
    public String[] obtenerActividadClase(String clase) {
        List <String[]> list = icon.obtenerActividadClase(clase);
        String[] aRet = new String[list.size()];
        int i = 0;
        //System.out.println(list.size());
        for (String[] a: list){
            String[] datos = new String[3];         
            datos[0] = a[0];
            datos[1] = a[1];
            datos[2] = a[2];
            aRet[i] = Arrays.toString(datos);
            //System.out.println(Arrays.toString(datos));
            i++; 
        }
        return aRet;
    }
    
}
