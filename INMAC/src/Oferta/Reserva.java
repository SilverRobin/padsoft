/**
 * 
 */
package Oferta;

import java.util.Date;

import Sistema.FechaSimulada;

/**
 * @author eps
 *
 */
public class Reserva {
	private FechaSimulada fecha;
	private Oferta oferta;
	
		public Reserva(Oferta oferta){
			fecha = new FechaSimulada();
			this.oferta = oferta;
		}
		
		public Boolean isLargaEstancia (){
			if(oferta instanceof LargaEstancia) {
				return true;
			}
			return false;
		}
		
		
}
