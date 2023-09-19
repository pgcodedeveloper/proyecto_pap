/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author PC
 */
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Profesor")
@Table(name = "Profesor")
@PrimaryKeyJoinColumn(name = "profesor_id")
public class Profesor extends Usuario {
    
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "biografia")
    private String biografia;
    @Column(name = "sitio_web")
    private String sitioWeb;
    
    @ManyToOne
    private InstitucionDeportiva institucionDeportiva;
    
    @OneToMany
    private List<Clase> clases = new ArrayList <>();

    public Profesor(){
        super();
    }
    // Constructor
    public Profesor(String nc, String n, String a, String e, Date df, String desc, String bio, String sitioWeb, String p, String img) {
        super(nc, n, a, e, df, p, img);
        this.descripcion = desc;
        this.biografia = bio;
        this.sitioWeb = sitioWeb;
    }

    // Getter y Setter para 'descripcion'
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y Setter para 'biografia'
    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    // Getter y Setter para 'sitioWeb'
    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    // Getter y Setter para 'institucionDeportiva'
    public InstitucionDeportiva getInstitucionDeportiva() {
        return institucionDeportiva;
    }

    public void setInstitucionDeportiva(InstitucionDeportiva institucionDeportiva) {
        this.institucionDeportiva = institucionDeportiva;
    }

    // Getter y Setter para 'clases'
    public List<Clase> getClases() {
        return clases;
    }

    public void agregarClase(Clase c){
        this.clases.add(c);
    }
    
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}
