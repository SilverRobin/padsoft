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
		if(reservas.size()!=2) {
			return false;
		}else if(reservas.get(0).isLargaEstancia() && reservas.get(1).isLargaEstancia()) {
			return false;
		}else if(!reservas.get(0).isLargaEstancia() && !reservas.get(1).isLargaEstancia()) {
			return false;
		}
		return true;
	}


}
