/**
 * 
 */
package Oferta;

import java.util.Date;

/**
 * @author eps
 *
 */
public class Reserva {
	private Date fecha;
	private Oferta oferta;
	
		public Reserva(Oferta oferta){
			fecha = new Date();
			this.oferta = oferta; //Creo que necesitamos esto para poder diferenciar entre los
			//distintos tipos de reservas (vacacional/largo plazo
		}
		
		
}
