package Valorables;

import Usuarios.Cliente;

/**
 * Clase abstracta que define el objeto ElementoValorable,
 * que esta compuesta de un cliente autor.
 * 
 * @author Antonio Oliva
 *
 */
public abstract class ElementoValorable {

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
