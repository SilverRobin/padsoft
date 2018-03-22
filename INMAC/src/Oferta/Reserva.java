/**
 * 
 */
package Oferta;

import java.util.Date;

import Sistema.FechaSimulada;
import Usuarios.Demandante;

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
		
		public FechaSimulada getFecha() {
			return fecha;
		}
		public void setFecha(FechaSimulada fecha) {
			this.fecha = fecha;
		}
		
		public Boolean isLargaEstancia (){
			if(oferta instanceof LargaEstancia) {
				return true;
			}
			return false;
		}
		
		public Oferta getOferta() {
			return oferta;
		}
		
		public boolean pagarReserva(Demandante d) {
			if(!d.comprobarReserva(this)) {
				return false;
			}
			
			if(!d.realizarPago((double) (oferta.getPrecio() + oferta.getFianza()), "Pago de reserva")) {
				return false;
			}
			this.oferta.contratar();
			return true;
		}
		
		public void cancelarReserva(Demandante d) {
			if(d.comprobarReserva(this))
				d.eliminarReserva(this);
		}
		
		
}
