/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import logica.Controlador;

/**
 *
 * @author PC
 */
public class Fabrica {
    private static Fabrica instancia = null;
    
    private Fabrica(){}
	
    public static Fabrica getInstancia() {
            if (instancia == null)
                    instancia = new Fabrica();
            return instancia;
    }

    public IControlador getIControlador() {
            return new Controlador();
    }
}
