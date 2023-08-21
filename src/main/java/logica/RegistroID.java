/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class RegistroID implements Serializable{
    
    private static final long serialVersionUID = 1L;
	
	private int clase;
	private int socio;
	
	//Tiene que tener constructor por defecto
	public RegistroID() {
		super();
	}

	//Tiene que implementar los getters y setters
	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public int getSocio() {
		return socio;
	}

	public void setSocio(int socio) {
		this.socio = socio;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.clase;
        hash = 23 * hash + this.socio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroID other = (RegistroID) obj;
        if (this.clase != other.clase) {
            return false;
        }
        return this.socio == other.socio;
    }
	
	
    
    
}
