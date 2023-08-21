/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtFecha;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author PC
 */
@Entity
@IdClass(RegistroID.class)
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(
        insertable = false,
        updatable = false
    )
    private Socio socio;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(
        insertable = false,
        updatable = false
    )
    private Clase clase;
    
    @Temporal(TemporalType.DATE)
    private Date fechaReg;
    
    public Registro(){
        super();
    }
    // Constructor
    public Registro(Date fechaReg, Socio socio, Clase clase) {
        this.fechaReg = fechaReg;
        this.clase = clase;
        this.socio = socio;
    }

    public Registro(Socio socio, Clase clase) {
        this.socio = socio;
        this.clase = clase;
    }

    public Registro(Date fechaReg) {
        this.fechaReg = fechaReg;
    }
    
    

    // Getter y Setter para 'fechaReg'
    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Getter y Setter para 'socio'
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
}
