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
public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;
    
    
    public Usuario(String nc, String n, String a, String e, DtFecha df){
        this.nickname = nc;
        this.nombre = n;
        this.apellido = a;
        this.email = e;
        this.fechaNac = df;
    }
    
    public String getNickName(){
        return this.nickname;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public DtFecha getFecha(){
        return this.fechaNac;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(DtFecha fechaNac) {
        this.fechaNac = fechaNac;
    }
  
}
