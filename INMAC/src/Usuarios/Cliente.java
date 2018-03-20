/**
 * 
 */
package Usuarios;
import java.util.ArrayList;
import java.util.Date;

import Sistema.Aviso;
import es.uam.eps.padsof.telecard.*;

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
	private ArrayList<Aviso> avisos;
	
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
		avisos = new ArrayList<Aviso>();
	}
	
	public Boolean comprobarTarjeta() {	
		return TeleChargeAndPaySystem.isValidCardNumber(creditCard);
	}
	
	public void realizarPago(Double cantidad, String subject) {
		int cont = 0;
		int maxIntentos = 4;
		
		while(true) {
			try {
				TeleChargeAndPaySystem.charge(creditCard, subject, cantidad);
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
	}
	
	/**
	 * Añade un aviso con un mensaje y la fecha en la que se genera
	 * @param mensaje contenido del aviso
	 */
	public void addAviso(String mensaje) {
		Aviso aviso = new Aviso(mensaje, new Date());
		avisos.add(aviso);
	}

	public ArrayList<Aviso> getAvisos() {
		return avisos;
	}
	
	public void leerAvisos() {
		int i;
		for (i=0;i<=avisos.size();i++) {
			System.out.println(avisos.get(i)); //Get o print?
		}
		avisos.clear(); //Limpiamos array porque ya se han leido todos
	}
	
	public void cambiarTarjeta(String tarjeta) {
		this.creditCard = tarjeta;
	}
	
	public static Cliente generarClienteTest() {
		return new Cliente("Ernesto Leal", "ernesto@gmail.com",
				"alpaca", "723548726");
	}


	

	
	
}
