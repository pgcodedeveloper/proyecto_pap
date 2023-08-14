/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

/**
 *
 * @author PC
 */
public class DtFecha {
    private int dia;
    private int mes;
    private int anio;
    
    
    public DtFecha(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.anio = a;
    }
    public int getDia() {
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    public void setDia(int d){
        this.dia = d;
    }
    public void setMes(int m){
        this.mes = m;
    }
    public void setAnio(int a){
        this.anio = a;
    }
}
