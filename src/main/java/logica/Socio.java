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
import javax.persistence.OneToMany;

@Entity
public class Socio extends Usuario {
    
    @OneToMany(mappedBy = "socio",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Registro> registros = new ArrayList<>();

    public Socio(){
        super();
    }
    public Socio(String nc, String n, String a, String e, Date df ) {
        super(nc, n, a, e, df);
        this.registros = null;
    }
    
    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    
}
