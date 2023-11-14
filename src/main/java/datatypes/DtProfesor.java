/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.Clase;
import logica.InstitucionDeportiva;

/**
 *
 * @author PC
 */
public class DtProfesor extends DtUsuario {
    private String descripcion;
    private String biografia;
    private String sitioWeb;
    private InstitucionDeportiva institucionDeportiva;
    private String inst;
    private String[] clases;

    public DtProfesor(){
        super();
    }
    public DtProfesor(int id,String descripcion, String biografia, String sitioWeb, String nickname, String nombre, String apellido, String email, Date fechaNac,String i, String password, String imagen, String[] c) {
        super(id,nickname, nombre, apellido, email, fechaNac, password , imagen);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.inst = i;
        this.clases = c;
    }
    
    public DtProfesor(String descripcion, String biografia, String sitioWeb, String nickname, String nombre, String apellido, String email, Date fechaNac, InstitucionDeportiva i, String password, String imagen) {
        super(nickname, nombre, apellido, email, fechaNac, password , imagen);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucionDeportiva = i;
        this.clases = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public InstitucionDeportiva getInstitucionDeportiva() {
        return institucionDeportiva;
    }

    public String[] getClases() {
        return clases;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public void setInstitucionDeportiva(InstitucionDeportiva institucionDeportiva) {
        this.institucionDeportiva = institucionDeportiva;
    }

    public void setClases(String[] clases) {
        this.clases = clases;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }
    
    
    
}
