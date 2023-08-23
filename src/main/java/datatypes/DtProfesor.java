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
    private List<Clase> clases;

    public DtProfesor(String descripcion, String biografia, String sitioWeb, String nickname, String nombre, String apellido, String email, Date fechaNac, InstitucionDeportiva i) {
        super(nickname, nombre, apellido, email, fechaNac);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucionDeportiva = i;
        this.clases = new ArrayList<>();
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

    public List<Clase> getClases() {
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

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
    
    
    
}
