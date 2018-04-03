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
	private String nif;
	private String password;
	private Ofertante ofertante;
	private Demandante demandante;
	private String creditCard;
	private ArrayList<Aviso> avisos;
	
	/**
	 * @param nombre nombre
	 * @param nif NIF
	 * @param password contrase�a
	 * @param creditCard tarjeta de credito
	 */
	public Cliente(String nombre, String nif, String password, String creditCard) {
		this.nombre = nombre;
		this.nif = nif;
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
		return nif;
	}
	
	
	public void addDemandante() {
		demandante = new Demandante();
		return;
	}
	
	public void addOfertante() {
		ofertante = new Ofertante();
		return;
	}
	
	/**
	 * Obtiene la tarjeta
	 * @return la tarjeta de credito
	 */
	public String getCreditCard() {
		return creditCard;
	}
	
	/**
	 * A�ade un aviso con un mensaje y la fecha en la que se genera
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
	
	public boolean realizarPago(Double cantidad, String subject) {
		int cont = 0;
		int maxIntentos = 4;
		
		while(true) {
			try {
				TeleChargeAndPaySystem.charge(creditCard, subject, cantidad);
				return true;
			} catch(FailedInternetConnectionException e){
				cont++;
				if(cont == maxIntentos) {
					addAviso("Fallo de conexi�n. Int�ntalo m�s tarde");
					break;
				}
			} catch (InvalidCardNumberException e) {
				addAviso("Tarjeta inv�lida. Contacta con el administrador");
				break;
			} catch (OrderRejectedException e) {
				addAviso("Transaccion rechazada");
				break;
			}
		}
		return false;
	}


	/**
	 * Genera un cliente de prueba
	 * @return cliente generado
	 */
	public static Cliente generarClienteTest() {
		return new Cliente("Ernesto Leal", "01256477p",
				"alpaca", "0000111122223333");
	}
	
}
