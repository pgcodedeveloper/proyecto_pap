/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author PC
 */
public class DtUsuario {
    private int id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String password;
    private String imagen;

    public DtUsuario(int id,String nickname, String nombre, String apellido, String email, Date fechaNac, String password, String imagen) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        if(password == null){
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            this.password = hashedPassword; 
        }
        else{
            this.password = password;
        }
        this.imagen = imagen;
    }
    
    public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String password, String imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        if(password == null){
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            this.password = hashedPassword; 
        }
        else{
            this.password = password;
        }
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNac() {
        return fechaNac;
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

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
