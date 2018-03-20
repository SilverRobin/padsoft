/**
 * 
 */
package Oferta;



import Sistema.*;

/**
 * @author eps
 *
 */
public class Vacacional extends Oferta {
	
	private FechaSimulada fechaFin;
	/**
	 * @param nP
	 * @param nF
	 * @param nD
	 */
	public Vacacional(int nP, int nF, FechaSimulada nD, FechaSimulada fechaFin) {
		super(nP, nF, nD);
		this.fechaFin = fechaFin;
	}
	@Override
	public Boolean modificarOferta(String dato, int precio, FechaSimulada fecha) {
		if(this.getVisibilidad() != EstadoOferta.A_MODIFICAR) {
			return false;
		}
		switch (dato.toLowerCase()) {
		case "fechainicio":
			this.setInicio(fecha);
			break;
		case "fechafin":
			this.setFin(fecha);
			break;
		case "fianza":
			this.setFianza(precio);
			break;
		case "precio":
			this.setPrecio(precio);
			break;
		default:
			return false;
		}
		return true;
		
	}
	public void setFin(FechaSimulada fecha) {
		this.fechaFin = fecha;
		
	}
	public FechaSimulada getFin() {
		return fechaFin;
	}
	

}
