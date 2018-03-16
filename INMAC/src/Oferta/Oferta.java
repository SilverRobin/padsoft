package Oferta;

import java.util.Date;

import Usuarios.*;

/**
 * 
 * @author Antonio Oliva
 *
 */
public abstract class Oferta {
	
	private int precio;
	private int fianza;
	private Date fechaInicio;
	private EstadoOferta visibilidad;
	
	public Oferta (int nP, int nF, Date nD) {
		this.precio = nP;
		this.fianza = nF;
		this.fechaInicio = nD;
		visibilidad = EstadoOferta.NO_APROBADA;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public int getFianza() {
		return fianza;
	}
	
	public Date getInicio() {
		return fechaInicio;
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
		return 0;
	}
	
	public void modificarOferta() {
		if(visibilidad != EstadoOferta.NO_APROBADA) {
			return;
		}
		//Modificar fecha y precio?
	}
	
	public Boolean reservar(Demandante usr) {
		return null;
		
	}
}
