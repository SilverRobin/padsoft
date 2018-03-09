package Inmueble;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author eps
 *
 */
public class Inmueble {

	private String descripcion;
	private int id;
	private List<Caracteristica> caracteristicas;
	private Direccion direccion;
	
	public Inmueble(String nD, int nID, Direccion nDir) {
		this.descripcion = nD;
		this.id = nID;
		this.caracteristicas = new ArrayList<>();
		this.direccion = nDir;
	}
	
	public int getId() {
		return id;
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
	
}
