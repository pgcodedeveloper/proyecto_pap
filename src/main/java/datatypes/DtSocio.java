/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

import java.util.Date;

/**
 *
 * @author PC
 */
public class DtSocio extends DtUsuario {

    
    
    public DtSocio(int id,String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String img) {
        super(id,nickname, nombre, apellido, email, fechaNac, pass, img);
    }
    
    public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String img) {
        super(nickname, nombre, apellido, email, fechaNac, pass, img);
    }
}
