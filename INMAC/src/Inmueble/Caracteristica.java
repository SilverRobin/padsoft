/**
 * 
 */
package Inmueble;

/**
 * @author eps
 *
 */
public class Caracteristica {
	private String titulo;
	private String descripcion;
	
	public Caracteristica(String nT, String nD) {
		this.titulo = nT;
		this.descripcion = nD;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getDesc() {
		return descripcion;
	}
	
	public void setTitulo(String nT) {
		titulo = nT;
		return;
	}
	
	public void setDesc(String nD) {
		descripcion = nD;
		return;
	}
}
