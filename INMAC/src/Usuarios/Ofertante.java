/**
 * 
 */
package Usuarios;

import java.util.ArrayList;

import Inmueble.Inmueble;

/**
 * @author eps
 *
 */
public class Ofertante{

	/**
	 * @param nombre
	 * @param correo
	 * @param password
	 * @param rol
	 * @param creditCard
	 */
	
	private ArrayList<Inmueble> inmuebles;
	
	
	public Boolean addInmueble(Inmueble inmueble) {
		return inmuebles.add(inmueble);
	}
	

}
