/**
 * 
 */
package Usuarios;

import java.util.ArrayList;
import es.uam.eps.padsof.telecard.*;
import Inmueble.Inmueble;

/**
 * @author eps
 *
 */
public class Ofertante extends Cliente{
	
	private ArrayList<Inmueble> inmuebles;

	public Ofertante(String nombre, String correo, String password, String creditCard) {
		super(nombre, correo, password, creditCard);
		// TODO Auto-generated constructor stub
		inmuebles = new ArrayList<Inmueble>();
	}
	
	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}
	public boolean addInmueble(Inmueble inmueble) {
		return inmuebles.add(inmueble);
	}
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
