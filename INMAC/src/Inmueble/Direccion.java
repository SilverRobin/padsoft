/**
 * 
 */
package Inmueble;

/**
 * @author eps
 *
 */
public class Direccion {
	private String codigoPostal;
	private String localidad;
	private String calle;
	
	/**
	 * @param codigoPostal codigo postal
	 * @param localidad localidad
	 * @param calle calle
	 */
	public Direccion(String codigoPostal, String localidad, String calle) {
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.calle = calle;
	}
	
	public String getCP() {
		return codigoPostal;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public static Direccion generarTestDir1() {
		return new Direccion("28040", "Madrid", "Fermines 13");
	}
	
	public static Direccion generarTestDir2() {
		return new Direccion("03700", "Denia", "Andrés Ponte 24");
	}
	
	public boolean isDireccion() {
		return this instanceof Direccion;
	}
	
	@Override
	public boolean equals (Object e) {
		
		if(!(e instanceof Direccion))
			return false;
		
		Direccion d = (Direccion) e;
		
		if(!(d.calle.equals(this.calle))
				|| !(d.codigoPostal.equals(this.codigoPostal))
				|| !(d.localidad.equals(this.localidad)))
			return false;
		
		return true;
	}
}
