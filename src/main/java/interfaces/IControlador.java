/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;

/**
 *
 * @author PC
 */
public interface IControlador {
    
    //Crear un nuevo usuario
    public void altaUsuario(DtUsuario usr) throws UsuarioRepetidoException;
}
