/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ManejadorUsuario {
    private static ManejadorUsuario instancia = null;
    private List<Usuario> usuarios = new ArrayList<>();

    private ManejadorUsuario() {
    }
    
    public static ManejadorUsuario getInstancia() {
        if (instancia == null)
                instancia = new ManejadorUsuario();
        return instancia;
    }
    
    
    public void agregarUsuario(Usuario usr){
        usuarios.add(usr);
    }
    
    public Usuario buscarUsuario(String nickname, String nombre, String email){
        Usuario retorno = null;
        for (Usuario usuario : usuarios) {
            if(usuario.getNickName() == nickname && usuario.getNombre() == nombre && usuario.getEmail() == email){
                retorno = usuario;
            }
            else {
                retorno = null;
            }
        }
        return retorno;
    }
    
}
