/**
 * 
 */
package Usuarios;

import java.util.ArrayList;

import Oferta.Reserva;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;

/**
 * @author Laura Ramirez
 *
 */
public class Demandante extends Cliente{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Reserva> reservas;

	/**
	 * @param nombre nombre del demandante
	 * @param correo correo del demandante
	 * @param password contrase�a del demandante
	 * @param creditCard tarjeta de credito
	 */
	public Demandante(String nombre, String NIF, String password, String creditCard) {
		super(nombre, NIF, password, creditCard);
		reservas = new ArrayList<Reserva>();
	}
	
	/** Realiza un pago
	 * @param cantidad a pagar
	 * @param subject texto
	 * @return true o false
	 */
	public boolean realizarPago(Double cantidad, String subject) {
		int cont = 0;
		int maxIntentos = 4;
		cantidad *= -1;
		
		while(true) {
			try {
				TeleChargeAndPaySystem.charge(this.getCreditCard(), subject, cantidad);
				return true;
			} catch(FailedInternetConnectionException e){
				cont++;
				if(cont == maxIntentos) {
					addAviso("Fallo de conexi�n. Int�ntalo m�s tarde");
					break;
				}
			} catch (InvalidCardNumberException e) {
				addAviso("Tarjeta inv�lida. Contacta con el administrador");
				break;
			} catch (OrderRejectedException e) {
				addAviso("Transaccion rechazada");
				break;
			}
		}
		return false;
	}
	
	/**
	 * Determina si se ha alcanzado el limite de una reserva de cada tipo
	 * @return true o false
	 */
	public boolean limiteAlcanzado() {
		if(reservas.size()!=2) {
			return false;
		}else if(!reservas.get(0).isLargaEstancia() && reservas.get(1).isLargaEstancia()) {
			return true;
		}else if(reservas.get(0).isLargaEstancia() && !reservas.get(1).isLargaEstancia()) {
			return true;
		}
		return true;
	}

	/**
	 * Obtiene la lista de reservas
	 * @return reservas
	 */
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * a�ade una nueva reserva
	 * @param r reserva
	 * @return true o false
	 */
	public boolean addReserva(Reserva r) {
		if(limiteAlcanzado()) {
			return false;
		}if(reservas.isEmpty()) {
			reservas.add(r);
			return true;
		}if(r.isLargaEstancia()) {//Nueva reserva larga estancia
			if(reservas.get(0).isLargaEstancia()) //Reserva larga estancia ya realizada
				return false;
			reservas.add(r);
			r.getOferta().reservar();
			return true;
		}else { //Nueva reserva vacacional
			if(reservas.get(0).isLargaEstancia()) { //Reserva larga estancia ya realizada
				reservas.add(r); //Podemos a�adir nueva reserva
				r.getOferta().reservar();
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Comprueba si el demandante ya ha realizado una reserva
	 * @param r reserva a comprobar
	 * @return true o false
	 */
	public boolean comprobarReserva(Reserva r) {
		if(reservas.contains(r))
			return true;
		return false;
	}
	
	/**
	 * Elimina una reserva
	 * @param r reserva
	 */
	public void eliminarReserva(Reserva r) {
		r.getOferta().cancelar();
		reservas.remove(r);	
	}
	
	/**
	 * Elimina las reservas caducadas
	 */
	public void eliminarReservaCaducada() {
		int i;
		for(i = 0; i<reservas.size(); i++) {
			if(reservas.get(i).getFecha().hanPasado5dias()) {
				eliminarReserva(reservas.get(i));
			}
		}
	}
	
	
	

}
