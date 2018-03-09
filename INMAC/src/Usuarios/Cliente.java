/**
 * 
 */
package Usuarios;

/**
 * @author Laura Ramirez
 *
 */
public class Cliente {
	private String nombre;
	private String correo;
	private String password;
	private Ofertante ofertante;
	private Demandante demandante;
	private String creditCard;
	
	/**
	 * @param nombre
	 * @param correo
	 * @param password
	 * @param rol
	 * @param creditCard
	 */
	public Cliente(String nombre, String correo, String password, String creditCard) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.creditCard = creditCard;
	}
	
	public Boolean comprobarTarjeta() {
		//comprueba validez tarjeta
		return true;
	}

	

	
	
}
