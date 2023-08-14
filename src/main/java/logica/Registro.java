/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtFecha;
/**
 *
 * @author PC
 */
public class Registro {
    private DtFecha fechaReg;
    private Socio socio;

    // Constructor
    public Registro(DtFecha fechaReg, Socio socio) {
        this.fechaReg = fechaReg;
        this.socio = socio;
    }

    // Getter y Setter para 'fechaReg'
    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Getter y Setter para 'socio'
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
