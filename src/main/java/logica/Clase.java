/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author PC
 */
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity(name = "clase")
public class Clase{
    @Id
    @Column(name = "clase_name")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    @Column(name = "clase_url")
    private String url;
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaReg;
     @Column (name = "imagen")
    private String imagen;  
    
    @OneToMany(mappedBy = "clase",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Registro> registros = new ArrayList<>();

    public Clase(){
        super();
    }
    // Constructor
    public Clase(String nombre, Date fecha, LocalTime horaInicio, String url, Date fechaReg, String img) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.url = url;
        this.fechaReg = fechaReg;
        this.imagen = img;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter y Setter para 'fecha'
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para 'horaInicio'
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    // Getter y Setter para 'url'
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getter y Setter para 'fechaReg'
    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Getter y Setter para 'registros'
    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    
    public void agregarRegistro(Socio s, Date fecha){
        Registro r = new Registro(fecha,s,this);
        this.registros.add(r);
        s.altaRegistro(r);
    }
    
    public void eliminarRegistro(Registro r){
        System.out.println("Desde clase " + r.getSocioId().getId());
        this.registros.remove(r);
        r.getSocioId().eliminarRegistro(r);
        System.out.println("O estoy aca?");
    }

    @Override
    public String toString() {
        return "Clase{" + "nombre=" + nombre + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", url=" + url + ", fechaReg=" + fechaReg + ", registros=" + registros + '}';
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
