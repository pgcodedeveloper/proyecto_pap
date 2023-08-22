/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Socio")
@Table(name = "Socio")
@PrimaryKeyJoinColumn(name = "socio_id")
public class Socio extends Usuario{
    
    @OneToMany(mappedBy = "socio",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Registro> registros;

    public Socio(){
        super();
    }
    public Socio(String nc, String n, String a, String e, Date df ) {
        super(nc, n, a, e, df);
        this.registros = new ArrayList<>();
    }
    
    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    
    public void altaRegistro(Registro r){
        this.registros.add(r);
    }
    
    
}
