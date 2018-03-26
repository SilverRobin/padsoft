/**
 * 
 */
package Usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import es.uam.eps.padsof.telecard.*;
import Inmueble.Inmueble;

/**
 * @author eps
 *
 */
public class Ofertante extends Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Inmueble> inmuebles;

	/**
	 * @param nombre del ofertante
	 * @param correo del ofertante
	 * @param password contraseña del ofertante
	 * @param creditCard tarjeta de credito del ofertante
	 */
	public Ofertante(String nombre, String correo, String password, String creditCard) {
		super(nombre, correo, password, creditCard);
		// TODO Auto-generated constructor stub
		inmuebles = new ArrayList<Inmueble>();
	}
	
	/**
	 * Obtiene la lista de inmuebles
	 * @return inmuebles
	 */
	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}
	/**
	 * Añade un nuevo inmueble
	 * @param inmueble nuevo
	 * @return true o false
	 */
	public boolean addInmueble(Inmueble inmueble) {
		return inmuebles.add(inmueble);
	}
	/**
	 * Recibe un cobro de una reserva
	 * @param cantidad a recibir
	 * @param subject texto
	 * @return true o false
	 */
	public boolean recibirCobro(Double cantidad, String subject) {
		int cont = 0;
		int maxIntentos = 4;
		
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
	
	

}
