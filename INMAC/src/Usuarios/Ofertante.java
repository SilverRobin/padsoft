/**
 * 
 */
package Usuarios;

import java.util.ArrayList;
import Inmueble.Inmueble;

/**
 * @author Laura Ramirez
 *
 */
public class Ofertante{
	
	private ArrayList<Inmueble> inmuebles;

	/**
	 * @param nombre del ofertante
	 * @param correo del ofertante
	 * @param password contraseña del ofertante
	 * @param creditCard tarjeta de credito del ofertante
	 */
	public Ofertante() {
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

}
