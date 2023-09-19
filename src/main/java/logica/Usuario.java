/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;


@Entity(name = "Usuario")
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario{
    
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nick_name", unique = true)
    private String nickname;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email" , unique = true)
    private String email;
    @Column(name = "fecha_nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    @Column (name = "password")
    private String password;
    @Column (name = "imagen")
    private String imagen;  

    public Usuario() {
        super();
    }
    
    public Usuario(String nc, String n, String a, String e, Date df, String password, String imagen){
        this.nickname = nc;
        this.nombre = n;
        this.apellido = a;
        this.email = e;
        this.fechaNac = df;
        this.imagen = imagen;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public Date getFecha(){
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
    
    @Override
    public String toString() {
        return "Usuario{" + "nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNac=" + fechaNac + '}';
    }
    
    
  
}
