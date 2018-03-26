package Sistema;

import java.io.Serializable;

/**
 * 
 * @author Laura Ramírez
 *
 */
public class Aviso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	private FechaSimulada fecha;
	
	
	public Aviso(String texto, FechaSimulada fecha) {
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public FechaSimulada getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return texto + ". Enviado el " + fecha.getHoy();
		
	}
	
	
	
}
