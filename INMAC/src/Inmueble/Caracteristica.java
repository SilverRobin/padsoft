/**
 * 
 */
package Inmueble;

/**
 * @author Antonio Oliva
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
	
	public static Caracteristica generarTestCara1() {
		return new Caracteristica("Test1", "Desc1");
	}
	
	public static Caracteristica generarTestCara2() {
		return new Caracteristica("Test1", "Desc2");
	}
	
	public boolean isCaracteristica() {
		return this instanceof Caracteristica;
	}
	
	@Override
	public boolean equals(Object e) {
		
		if(!(e instanceof Caracteristica))
			return false;
		
		Caracteristica c = (Caracteristica) e;
		
		if(!(c.descripcion.equals(this.descripcion))
				|| !(c.titulo.equals(this.titulo)))
			return false;
		
		return true;
	}
}
