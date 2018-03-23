package Oferta;

import java.util.ArrayList;
import Sistema.FechaSimulada;
import Valorables.Valoracion;

/**
 * 
 * @author Antonio Oliva
 *
 */
public abstract class Oferta {
	
	private int precio;
	private int fianza;
	private FechaSimulada fechaInicio;
	private EstadoOferta visibilidad;
	private ArrayList<Valoracion> valoraciones;
	
	public Oferta (int nP, int nF, FechaSimulada nD) {
		this.precio = nP;
		this.fianza = nF;
		this.fechaInicio = nD;
		visibilidad = EstadoOferta.NO_APROBADA;
	}
	
	public int getPrecio() {
		return precio;
	}
	public EstadoOferta getVisibilidad() {
		return visibilidad;
	}
	
	public int getFianza() {
		return fianza;
	}
	
	public FechaSimulada getInicio() {
		return fechaInicio;
	}
	public void setInicio(FechaSimulada fecha) {
		this.fechaInicio = fecha;
	}
	
	public void setPrecio(int nP) {
		this.precio = nP;
		return;
	}
	
	public void setFianza(int nF) {
		this.fianza = nF;
		return;
	}
	
	public boolean isOferta() {
		return this instanceof Oferta;
	}
	
	public void aprobarOferta() {
		this.visibilidad = EstadoOferta.DISPONIBLE;
	}
	
	public double calcularMediaValoraciones() {
		int i, suma = 0;
		for(i=0; i<valoraciones.size(); i++) {
			suma += valoraciones.get(i).getValor();
		}
		return suma/valoraciones.size();
	}
	
	public abstract boolean modificarOferta(String dato, int precio, FechaSimulada fecha);
	
	public void reservar() {
		visibilidad = EstadoOferta.RESERVADA;
		
	}
	public void contratar() {
		visibilidad = EstadoOferta.CONTRATADA;
	}
	public void cancelar() {
		visibilidad = EstadoOferta.DISPONIBLE;
	}
	public void rectificar() {
		visibilidad = EstadoOferta.A_MODIFICAR;
	}
}
