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

	public Ofertante(String nombre, String correo, String password, String creditCard) {
		super(nombre, correo, password, creditCard);
		// TODO Auto-generated constructor stub
	}

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
