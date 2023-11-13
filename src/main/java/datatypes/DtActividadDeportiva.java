/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author PC
 */
import java.util.List;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;

public class DtActividadDeportiva{

    private String nombre;
    private String descripcion;
    private Integer duracion;
    private float costo;
    private Date fechaReg;
    private String imagen;

    private List<Clase> clases = new ArrayList<>();

    private InstitucionDeportiva inst;

    public DtActividadDeportiva(){
        super();
    }
    
    public DtActividadDeportiva(ActividadDeportiva a){
        this.nombre = a.getNombre();
        this.descripcion = a.getDescripcion();
        this.duracion = a.getDuracion();
        this.costo = a.getCosto();
        this.fechaReg = a.getFechaReg();
        this.inst = a.getInst();
        this.imagen = a.getImagen();
    }
    // Constructor
    public DtActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo, Date fechaReg, InstitucionDeportiva ins, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaReg = fechaReg;
        this.inst = ins;
        this.imagen = img;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'descripcion'
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y Setter para 'duracion'
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    // Getter y Setter para 'costo'
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    // Getter y Setter para 'fechaReg'
    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Getter y Setter para 'clases'
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
    
    public void altaClase(Clase c){
        this.clases.add(c);
    }

    public InstitucionDeportiva getInst() {
        return inst;
    }

    public void setInst(InstitucionDeportiva inst) {
        this.inst = inst;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

}
