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
public class Profesor extends Usuario {
    
    private String descripcion;
    private String biografia;
    private String sitioWeb;

    public Profesor(String descripcion, String biografia, String sitioWeb, String nc, String n, String a, String e, DtFecha df) {
        super(nc, n, a, e, df);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    
    
    
}
