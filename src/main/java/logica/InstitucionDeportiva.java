/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "InstitucionDeportiva")
public class InstitucionDeportiva implements Serializable{
    @Id
    private String nombre;
    private String descripcion;
    private String url;
    
    @OneToMany
    private List<ActividadDeportiva> actividadesDeportiva;
    @OneToMany
    private List<Profesor> profesores;

    public InstitucionDeportiva(){
        super();
    }
    // Constructor
    public InstitucionDeportiva(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividadesDeportiva = new ArrayList<>();
        this.profesores = new ArrayList<>();
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

    // Getter y Setter para 'url'
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getter y Setter para 'actividadesDeportiva'
    public List<ActividadDeportiva> getActividadesDeportiva() {
        return actividadesDeportiva;
    }

    public void setActividadesDeportiva(List<ActividadDeportiva> actividadesDeportiva) {
        this.actividadesDeportiva = actividadesDeportiva;
    }
    
    public void agregarActividad(ActividadDeportiva act){
        this.actividadesDeportiva.add(act);
    }
    
    public void agregarProfesor(Profesor p){
        this.profesores.add(p);
        p.setInstitucionDeportiva(this);
    }
}
