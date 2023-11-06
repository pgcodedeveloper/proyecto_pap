package publicadores;

import configuracion.WebServiceConfiguracion;
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
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.ManejadorInstitucion;
import logica.ManejadorUsuario;
import logica.Profesor;
import logica.Registro;
import logica.Socio;
import logica.Usuario;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ControladorPublish{
    private Fabrica fabrica = Fabrica.getInstancia();
    private IControlador icon = fabrica.getIControlador();
    private WebServiceConfiguracion configuracion = new WebServiceConfiguracion();
    private Endpoint endpoint;
    
    public ControladorPublish() {
        fabrica = Fabrica.getInstancia();
        icon = fabrica.getIControlador();
        configuracion = new WebServiceConfiguracion();
    }

    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
        System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
    }
	
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
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
    public Usuario loginUsuario(String email) {
        Usuario u = icon.loginUsuario(email);
        if(u != null){         
            if(u instanceof Socio){
                u = new Socio(u.getNickName(),u.getNombre(),u.getApellido(),u.getEmail(),u.getFecha(),u.getPassword(),u.getImagen());
            }
            else if(u instanceof Profesor){
                u = new Profesor(u.getNickName(),u.getNombre(),u.getApellido(),u.getEmail(),u.getFecha(),((Profesor)u).getDescripcion(),((Profesor)u).getBiografia(),((Profesor)u).getSitioWeb(),u.getPassword(),u.getImagen());
            }
        }
        else{
            u = null;
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
    public Clase obtenerInfoClase(String nombre) {
        Clase c = icon.obtenerInfoClase(nombre);
        return c;
    }

    @WebMethod
    public Registro[] obtenerRegistrosSocio(int idS) {
        ArrayList<Registro> list;
        list = icon.obtenerRegistrosSocio(idS);
        int i = 0;
        Registro[] ret = new Registro[list.size()];
        for(Registro r : list){
            ret[i] = r;
            i++;
        }
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
        String[] inst_ret = icon.obtenerActividades();
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
    public ActividadDeportiva obtenerActividad(String nom) {
        ActividadDeportiva a = icon.obtenerActividad(nom);
        return a;
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
        ArrayList<Object[]> act = icon.rankingClases();
        
        int i = 0;
        Object[] obj = new Object[act.size()];
        for(Object[] a: act){
            obj[i] = new Object[]{a[0],a[1]};
            i++;
        }
        return obj;
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
        
        int i = 0;
        Object[] obj = new Object[act.size()];
        for(Object[] a: act){
            obj[i] = new Object[]{a[0],a[1]};
            i++;
        }
        return obj;
    }

    @WebMethod
    public void setPassword(String nickname, String mail, String password, String imagen) {
        icon.setPassword(nickname, mail, password, imagen);
    }

    @WebMethod
    public void eliminarSocioRegistro(String clase, Socio s) {
        icon.eliminarSocioRegistro(clase, s);
    }

    @WebMethod
    public String[] obtenerActividadClase(String clase) {
        List <String[]> list = icon.obtenerActividadClase(clase);
        String[] aRet = new String[list.size()];
        int i = 0;
        for (String[] a: list){
            String[] datos = new String[3];         
            datos[0] = a[0];
            datos[1] = a[1];
            datos[2] = a[2];
            aRet[i] = Arrays.toString(datos);
            i++; 
        }
        return aRet;
    }
    
}
