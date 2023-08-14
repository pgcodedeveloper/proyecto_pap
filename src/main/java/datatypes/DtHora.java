/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

/**
 *
 * @author PC
 */
public class DtHora {
    private int hora;
    private int minutos;
    
    public DtHora(int h, int m){
        this.hora = h;
        this.minutos = m;
    }
    
    public int getHora(){
        return this.hora;
    }
    
    public int getMinutos(){
         return this.minutos;
    }
    
    public void setHora(int h){
        this.hora = h;
    }
    
    public void setMinutos(int m){
        this.minutos = m;
    }
}
