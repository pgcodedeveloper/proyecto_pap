/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package publicadores;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.ActividadDException;
import exceptions.ClaseException;
import exceptions.InstitucionRepetidaException;
import exceptions.SocioYaInscriptoException;
import exceptions.UsuarioRepetidoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
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
public interface Controlador {
    
    @WebMethod
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException;
    
    @WebMethod
    public void altaInstitucion(String nombre, String descripcion, String url) throws InstitucionRepetidaException;
    
    @WebMethod
    public String[] obtenerInstituciones();
    
    @WebMethod
    public InstitucionDeportiva obtenerInstitucion(String nom);
    
    @WebMethod
    public DtSocio[] obtenerSocios();
    
    @WebMethod
    public DtProfesor[] obtenerProfes();
    
    @WebMethod
    public String[] obtenerClasesProfe(int idP);
    
    @WebMethod
    public Usuario loginUsuario(String email);
    
    @WebMethod
    public String[] obtenerActivDeporProfe(int idP);

    @WebMethod
    public Clase obtenerInfoClase(String nombre);

    @WebMethod
    public Registro[] obtenerRegistrosSocio(int idS);
    
    @WebMethod
    public void altaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaR, String nomInst, String img) throws ActividadDException;

    @WebMethod
    public boolean existeActividadDepo(String nomAct, String nomInst);

    @WebMethod
    public String[] obtenerActividades(String nom);

    @WebMethod
    public String[] obtenerProfesInst(String nom);

    @WebMethod
    public boolean existeClaseActividad(String clase);
   
    @WebMethod
    public void altaClaseActividad(String inst, String act, String nomC, String prof, String url, Date fechaI, Date fechaA, String img) throws ClaseException;
    
    @WebMethod
    public ActividadDeportiva obtenerActividad(String nom);

    @WebMethod
    public ActividadDeportiva[] obtenerActividadesInstitucion(String institucion);

    @WebMethod
    public String[] obtenerClasesAct(String act);

    @WebMethod
    public Clase[] obtenerClasesDeActividad(String act);

    
    @WebMethod
    public String [] obtenerListaSocios();
    
    @WebMethod
    public String [] obtenerClases(String nomAct);
    
    @WebMethod
    public void altaSocioClase (String nomSocio, String nomClase, Date fecha) throws SocioYaInscriptoException; 
    
    @WebMethod
    public boolean existeSocioClase (Clase c, Socio s);
    
    @WebMethod
    public String obtenerProfesorClase(String nomClase, String nomInst);  
    
    @WebMethod
    public String[] obtenerUsuarios();
    
    
    @WebMethod
    public DtUsuario obtenerUsuario(String nickname);
    
    @WebMethod
    public DtProfesor obtenerProfesor (String nickname);
    
    @WebMethod
    public void actualizarUsuario (String email,String nick, String nombre, String apellido, Date fNac, String img);
    
    @WebMethod
    public void actualizarProfe (String email,String nick, String nombre, String apellido, Date fNac, String img, String bio, String desc, String web);
    
    
    @WebMethod
    public Object[] rankingClases();
    

    @WebMethod
    public void modificarActividadDeportiva(String nombre, String descripcion, int duracion, float costo, String img);

    @WebMethod
    public void modificarInstitucion(String nombre, String descripcion, String url);
    
    
    @WebMethod
    public Object[] rankingActividades();

    @WebMethod
    public void setPassword(String nickname, String mail, String password, String imagen);

    @WebMethod
    public void eliminarSocioRegistro(String clase, Socio s);

    @WebMethod
    public String[] obtenerActividadClase(String clase);
}
