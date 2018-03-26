package Valorables;

import java.io.Serializable;

import Usuarios.Cliente;

/**
 * Clase abstracta que define el objeto ElementoValorable,
 * que esta compuesta de un cliente autor.
 * 
 * @author Antonio Oliva
 *
 */
public abstract class ElementoValorable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente autor;
	
	public ElementoValorable(Cliente nC) {
		autor = nC;
	}
	
	public Cliente getAutor() {
		return autor;
	}
	
	public void setAutor(Cliente nC) {
		autor = nC;
		return;
	}
}
