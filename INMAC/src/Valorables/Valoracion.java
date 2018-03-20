package Valorables;

import Usuarios.Cliente;

/**
 * Clase que define el objeto Valoracion,
 * clase que consta de un valor y un Cliente Autor.
 * 
 * @author Antonio Oliva
 *
 */
public class Valoracion extends ElementoValorable{
	
	private double valor;
	
	public Valoracion(double nV, Cliente nC) {
		super(nC);
		valor = nV;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double nV) {
		valor = nV;
		return;
	}

}
