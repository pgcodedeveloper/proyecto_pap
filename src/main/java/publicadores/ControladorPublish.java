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
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.ManejadorClase;
import logica.ManejadorInstitucion;
import logica.ManejadorUsuario;
import logica.Profesor;
import logica.Registro;
import logica.Socio;
import logica.Usuario;
import persistencia.Conexion;


@WebService(name = "Controlador")
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
    
    @WebMethod(operationName = "operation")
    public String operation() {
        //TODO write your implementation code here:
        return null;
    }
    
    @WebMethod(operationName = "altaUsuario")
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
    
    @WebMethod(operationName = "altaInstitucion")
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
    @WebMethod(operationName = "obtenerInstituciones")
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
    @WebMethod(operationName = "obtenerInstitucion")
    public InstitucionDeportiva obtenerInstitucion(String nom){
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nom);
        return i;
    }
    @WebMethod(operationName = "obtenerSocios")
    public DtSocio[] obtenerSocios() {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtSocio> list;
        list = mju.obtenerUsuariosSocio();
        DtSocio[] ret = new DtSocio[list.size()];
        int i = 0;
        for(DtSocio s : list) {
            ret[i]=s;
            i++;
        }
        return ret;
    }
    @WebMethod(operationName = "obtenerProfes")
    public DtProfesor[] obtenerProfes() {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtProfesor> list;
        list = mju.obtenerUsuariosProfe();
        DtProfesor[] ret = new DtProfesor[list.size()];
        int i = 0;
        for(DtProfesor s : list) {
            ret[i]=s;
            i++;
        }
        return ret;
    }
    @WebMethod(operationName = "obtenerClasesProfe")
    public String[] obtenerClasesProfe(int idP) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<String> li;
        li = mju.obtenerClases(idP);
        int i = 0;
        String[] ret = new String[li.size()];
        for(String s: li){
            ret[i] = s;
            i++;
        }
        return ret;
    }
    
    @WebMethod
    public String[] obtenerActivDeporProfe(int idP) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<String> li;
        li = mju.obtenerActividadesD(idP);
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
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(nombre);
        return c;
    }

    @WebMethod
    public Registro[] obtenerRegistrosSocio(int idS) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<Registro> list;
        list = mju.obtenerRegistrosSocio(idS);
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
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva i = mji.buscarInst(nomInst);
        if(this.existeActividadDepo(nombre, nomInst)){
            throw new ActividadDException("Ya existe una actividad con ese nombre");
        }
        else{
            ActividadDeportiva a = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaR, i, img);
            i.agregarActividad(a);
            mji.agregarActividadDeportiva(a);
        }
        
    }

    @WebMethod
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

    @WebMethod
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

    @WebMethod
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

    @WebMethod
    public boolean existeClaseActividad(String clase) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(clase);
        boolean aRetornar = false;
        if(c != null){
            aRetornar = true;
        }
        return aRetornar;
    }
   
    @WebMethod
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA, String img) throws ClaseException{
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
            Clase c = new Clase(nomC, fechaI, hora, url, fechaA, img);
             
            
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
    
    @WebMethod
    public ActividadDeportiva obtenerActividad(String nom) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ActividadDeportiva a = mji.obtenerActividad(nom);
        return a;
    }

    @WebMethod
    public ActividadDeportiva[] obtenerActividadesInstitucion(String institucion) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<ActividadDeportiva> aRetornar = mji.obtenerActividadesInst(institucion);
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
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<String> aRetornar = mji.obtenerClasesAct(act);
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
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ArrayList<Clase> aRetornar = mji.obtenerClaseDeActividad(act);
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
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        ArrayList<DtSocio> list;
        list = mju.obtenerUsuariosSocio();
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
    
    @WebMethod
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
    
    @WebMethod
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
    
    @WebMethod
    public boolean existeSocioClase (Clase c, Socio s){
        
        Boolean aRetornar=false;
        for (Registro r:c.getRegistros()){
            if (r.getSocioId().getId() == s.getId())
                    aRetornar = true;
        }
        return aRetornar;
    }
    
    @WebMethod
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
    
    @WebMethod
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
    
    
    @WebMethod
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
    
    @WebMethod
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
    
    @WebMethod
    public void actualizarUsuario (String email,String nick, String nombre, String apellido, Date fNac, String img){
        
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(email, nick);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setFechaNac(fNac);
        u.setImagen(img);
        mju.actualizaUser(u);

    }
    
    @WebMethod
    public void actualizarProfe (String email,String nick, String nombre, String apellido, Date fNac, String img, String bio, String desc, String web){
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(email, nick);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setFechaNac(fNac);
        u.setImagen(img);
        ((Profesor)u).setBiografia(bio);
        ((Profesor)u).setDescripcion(desc);
        ((Profesor)u).setSitioWeb(web);
        mju.actualizaProfe(u);
    }
    
    /*
    @WebMethod
    public Object[] rankingClases(){
        ManejadorClase mjc = ManejadorClase.getInstancia();
        ArrayList<Clase> clases = mjc.listadoClases();
        Object[] aRet = new Object[clases.size()];
        int i = 0;
        for(Clase c:clases){
            aRet[i] = (new Object []{c, c.getRegistros().size()});
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
    */

    @WebMethod
    public void modificarActividadDeportiva(String nombre, String descripcion, int duracion, float costo, String img) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        ActividadDeportiva a = mji.obtenerActividad(nombre);
        
        a.setDescripcion(descripcion);
        a.setDuracion(duracion);
        a.setCosto(costo);
        a.setImagen(img);
        mji.modificarActividadDeportiva(a);
    }

    @WebMethod
    public void modificarInstitucion(String nombre, String descripcion, String url) {
        ManejadorInstitucion mji = ManejadorInstitucion.getInstancia();
        InstitucionDeportiva ins = mji.buscarInst(nombre);
        ins.setDescripcion(descripcion);
        ins.setUrl(url);
        
        mji.modificarInst(ins);
        
    }
    
    /*
    @WebMethod
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
    }*/

    @WebMethod
    public void setPassword(String nickname, String mail, String password, String imagen) {
        ManejadorUsuario mju = ManejadorUsuario.getInstancia();
        Usuario u = mju.buscarUsuario(mail, nickname);
        u.setPassword(password);
        u.setImagen(imagen);
        mju.actualizaUser(u);
    }

    @WebMethod
    public void eliminarSocioRegistro(String clase, Socio s) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(clase);
  
        for(Registro r: c.getRegistros()){
            if(r.getClaseId().getNombre().equals(clase) && r.getSocioId().getId() == s.getId()){
                c.eliminarRegistro(r);
                s.eliminarRegistro(r);
                mjc.eliminarSocio(c, s);
                break;
            }
        }
    }

    @WebMethod
    public String[] obtenerActividadClase(String clase) {
        ManejadorClase mjc = ManejadorClase.getInstancia();
        Clase c = mjc.obtenerInfoClase(clase);
        ArrayList <ActividadDeportiva> list = mjc.obtenerActividadClase();
        String[] aRet = new String[list.size()];
        int i = 0;
        for (ActividadDeportiva a: list){
            if (a.getClases().contains(c)){
               String[] datos = new String[3];
               datos[0] = a.getNombre();
               datos[1] = "" + a.getCosto();
               datos[2] = "" + a.getDuracion();
               aRet[i] = datos.toString();
               i++;
            }
        }
        return aRet;
    }
    
}
