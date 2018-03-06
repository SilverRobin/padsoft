/**
 * 
 */
package Usuarios;

/**
 * @author Laura Ramirez
 *
 */
public abstract class usuario {
	private String nombre;
	private String correo;
	private String password;
	private String rol;
	private String creditCard;
	
	/**
	 * @param nombre
	 * @param correo
	 * @param password
	 * @param rol
	 * @param creditCard
	 */
	public usuario(String nombre, String correo, String password, String rol, String creditCard) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.creditCard = creditCard;
	}

	

	
	
}
