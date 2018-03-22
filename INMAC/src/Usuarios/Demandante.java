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
 * @author eps
 *
 */
public class Demandante extends Cliente{
	
	private ArrayList<Reserva> reservas;

	public Demandante(String nombre, String correo, String password, String creditCard) {
		super(nombre, correo, password, creditCard);
		reservas = new ArrayList<Reserva>();
	}
	
	public Boolean realizarPago(Double cantidad, String subject) {
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
					addAviso("Fallo de conexión. Inténtalo más tarde");
					break;
				}
			} catch (InvalidCardNumberException e) {
				addAviso("Tarjeta inválida. Contacta con el administrador");
				break;
			} catch (OrderRejectedException e) {
				addAviso("Transaccion rechazada");
				break;
			}
		}
		return false;
	}
	
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

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
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
				reservas.add(r); //Podemos añadir nueva reserva
				r.getOferta().reservar();
				return true;
			}
			return false;
		}
	}
	
	public boolean comprobarReserva(Reserva r) {
		if(reservas.contains(r))
			return true;
		return false;
	}
	
	public void eliminarReserva(Reserva r) {
		r.getOferta().cancelar();
		reservas.remove(r);	
	}
	
	public void eliminarReservaCaducada() {
		int i;
		for(i = 0; i<reservas.size(); i++) {
			if(reservas.get(i).getFecha().hanPasado5dias()) {
				eliminarReserva(reservas.get(i));
			}
		}
	}
	
	
	

}
