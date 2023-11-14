/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatypes;

import java.util.Date;
import java.util.List;
import logica.Registro;

/**
 *
 * @author PC
 */
public class DtSocio extends DtUsuario {

    private String[] registros;
    
    public DtSocio(){
        super();
    }
    
    public DtSocio(int id,String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String img,String[] reg) {
        super(id,nickname, nombre, apellido, email, fechaNac, pass, img);
        this.registros = reg;
    }
    
    public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String img) {
        super(nickname, nombre, apellido, email, fechaNac, pass, img);
    }

    public String[] getRegistros() {
        return registros;
    }

    public void setRegistros(String[] registros) {
        this.registros = registros;
    }
    
    
}
