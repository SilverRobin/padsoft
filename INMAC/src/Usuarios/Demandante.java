/**
 * 
 */
package Usuarios;

import java.util.ArrayList;

import Oferta.Reserva;

/**
 * @author eps
 *
 */
public class Demandante extends Cliente{
	
	private ArrayList<Reserva> reservas;

	public Demandante(String nombre, String correo, String password, String creditCard) {
		super(nombre, correo, password, creditCard);
		reservas = new ArrayList<Reserva>();
	}
	
	public Boolean limiteAlcanzado() {
		return null;
		//Ver si se ha llegado al limite maximo de ofertas reservadas
	}


}
