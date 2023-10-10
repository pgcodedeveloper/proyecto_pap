/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.List;
import datatypes.DtFecha;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author PC
 */
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ActividadDeportiva")
public class ActividadDeportiva{
    @Id
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private float costo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaReg;
    @Column (name = "imagen")
    private String imagen;  
    
    @OneToMany
    private List<Clase> clases = new ArrayList<>();
    
    @ManyToOne
    private InstitucionDeportiva inst;

    public ActividadDeportiva(){
        super();
    }
    // Constructor
    public ActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo, Date fechaReg, InstitucionDeportiva ins, String img) {
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
