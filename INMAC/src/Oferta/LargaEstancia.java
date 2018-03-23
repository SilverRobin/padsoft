/**
 * 
 */
package Oferta;

import Sistema.FechaSimulada;

/**
 * @author eps
 *
 */
public class LargaEstancia extends Oferta {
	private int minimaEstancia; 
	/**
	 * @param nP
	 * @param nF
	 * @param nD
	 */
	public LargaEstancia(int nP, int nF, FechaSimulada nD, int minimaEstancia) {
		super(nP, nF, nD);
		this.minimaEstancia = minimaEstancia;
	}

	/* (non-Javadoc)
	 * @see Oferta.Oferta#modificarOferta(java.lang.String, int, Sistema.FechaSimulada)
	 */
	@Override
	public boolean modificarOferta(String dato, int precio, FechaSimulada fecha) {
		if(this.getVisibilidad() != EstadoOferta.A_MODIFICAR) {
			return false;
		}
		switch (dato.toLowerCase()) {
		case "fechainicio":
			this.setInicio(fecha);
			break;
		case "minimaestancia":
			this.setMinimaEstancia(precio);
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

	public int getMinimaEstancia() {
		return minimaEstancia;
	}

	public void setMinimaEstancia(int minimaEstancia) {
		this.minimaEstancia = minimaEstancia;
	}
	
	

}
