package Inmueble;

import java.util.ArrayList;
import java.util.List;

import Oferta.Oferta;

/**
 * 
 * @author Antonio Oliva
 *
 */
public class Inmueble {
	
	private static int GLOBAL_ID = 0;

	private String descripcion;
	private int id;
	private List<Caracteristica> caracteristicas;
	private Direccion direccion;
	private ArrayList<Oferta> ofertas;
	
	public Inmueble(String nD, Direccion nDir) {
		this.descripcion = nD;
		this.id = GLOBAL_ID+1;
		GLOBAL_ID++;
		this.caracteristicas = new ArrayList<>();
		this.direccion = nDir;
		this.ofertas = new ArrayList<Oferta>();
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public String getDesc() {
		return descripcion;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setDesc(String nD) {
		descripcion = nD;
		return;
	}
	
	public void addCaracteristica(Caracteristica nC) {
		caracteristicas.add(nC);
		return;
	}
	
	public void deleteCaracteristica(Caracteristica nC) {
		caracteristicas.remove(nC);
		return;
	}
	
	public boolean isInmueble() {
		return this instanceof Inmueble;
	}
	
	public boolean addOferta(Oferta e) {
		return ofertas.add(e);
	}
	
}
