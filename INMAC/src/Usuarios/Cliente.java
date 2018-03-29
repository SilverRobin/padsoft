package Usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import Sistema.Aviso;
import Sistema.FechaSimulada;
import es.uam.eps.padsof.telecard.*;

/**
 * @author Laura Ramirez
 *
 */
public class Cliente implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String correo;
	private String password;
	private Ofertante ofertante;
	private Demandante demandante;
	private String creditCard;
	private ArrayList<Aviso> avisos;
	
	/**
	 * @param nombre nombre
	 * @param correo correo
	 * @param password contraseña
	 * @param creditCard tarjeta de credito
	 */
	public Cliente(String nombre, String correo, String password, String creditCard) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.creditCard = creditCard;
		avisos = new ArrayList<Aviso>();
	}
	
	/**
	 * Devuelve el nombre del Cliente
	 * 
	 * @return Nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la contrasenia del cliente
	 * @return Contrasenia del cliente
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Devuelve el posible demandante del cliente
	 * @return Perfil demandante
	 */
	public Demandante getDemandante() {
		return demandante;
	}
	
	/**
	 * Devuelve el posible ofertante del cliente
	 * @return Perfil ofertante
	 */
	public Ofertante getOfertante() {
		return ofertante;
	}
	
	/**
	 * Comprueba la validez de la tarjeta de credito
	 * @return true si la tarjeta es valida o false en caso contrario
	 */
	public boolean comprobarTarjeta() {	
		return TeleChargeAndPaySystem.isValidCardNumber(creditCard);
	}
	
	public String getNIF() {
		return correo;
	}
	
	/**
	 * Obtiene la tarjeta
	 * @return la tarjeta de credito
	 */
	public String getCreditCard() {
		return creditCard;
	}
	
	/**
	 * Añade un aviso con un mensaje y la fecha en la que se genera
	 * @param mensaje contenido del aviso
	 */
	public void addAviso(String mensaje) {
		Aviso aviso = new Aviso(mensaje, new FechaSimulada());
		avisos.add(aviso);
	}

	/**
	 * Obtiene la lista de avisos
	 * @return lista de avisos
	 */
	public ArrayList<Aviso> getAvisos() {
		return avisos;
	}
	
	/**
	 * Lee los avisos guardados
	 */
	public void leerAvisos() {
		int i;
		for (i=0;i<avisos.size();i++) {
			System.out.println(avisos.get(i));
		}
		avisos.clear(); //Limpiamos array porque ya se han leido todos
	}
	
	/**
	 * Cambia el numero de tarjeta
	 * @param tarjeta nueva tarjeta
	 */
	public void cambiarTarjeta(String tarjeta) {
		this.creditCard = tarjeta;
	}
	
	/**
	 * Genera un cliente de prueba
	 * @return cliente generado
	 */
	public static Cliente generarClienteTest() {
		return new Cliente("Ernesto Leal", "01256477p",
				"alpaca", "723548726");
	}


	

	
	
}
