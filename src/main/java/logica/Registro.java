/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import persistencia.RegistroID;
import datatypes.DtFecha;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
public class Registro{
    @Id
    @ManyToOne
    @JoinColumn(nullable = true, name = "socio_id", foreignKey = @ForeignKey(name = "SOCIO_FK"))
    private Socio socio;
    
    @Id
    @ManyToOne
    @JoinColumn(nullable = true, name = "clase_id", foreignKey = @ForeignKey(name = "CLASE_FK"))
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
    public Socio getSocioId() {
        return socio;
    }

    public void setSocioId(Socio socio) {
        this.socio = socio;
    }

    public Clase getClaseId() {
        return clase;
    }

    public void setClaseId(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return socio.getNombre() + " " + socio.getApellido() + "," + clase.getNombre() + "," + fechaReg + "," + clase.getHoraInicio();
    }
    
    
    
}
