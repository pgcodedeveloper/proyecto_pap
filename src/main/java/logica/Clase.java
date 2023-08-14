/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datatypes.DtFecha;
import datatypes.DtHora;
import java.util.List;
/**
 *
 * @author PC
 */
import java.util.List;

public class Clase {
    private String nombre;
    private DtFecha fecha;
    private DtHora horaInicio;
    private String url;
    private DtFecha fechaReg;
    private List<Registro> registros;

    // Constructor
    public Clase(String nombre, DtFecha fecha, DtHora horaInicio, String url, DtFecha fechaReg, List<Registro> registros) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.url = url;
        this.fechaReg = fechaReg;
        this.registros = registros;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'fecha'
    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para 'horaInicio'
    public DtHora getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(DtHora horaInicio) {
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
    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Getter y Setter para 'registros'
    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
