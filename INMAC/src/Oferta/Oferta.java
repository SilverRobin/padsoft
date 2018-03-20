package Oferta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Sistema.FechaSimulada;
import Usuarios.*;

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
		//TODO hacer esto
		return 0;
	}
	
	public abstract Boolean modificarOferta(String dato, int precio, FechaSimulada fecha);
	
	public Boolean reservar(Demandante usr) {
		return null;
		
	}
}
