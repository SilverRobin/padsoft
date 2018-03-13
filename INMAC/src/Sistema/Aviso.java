package Sistema;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aviso {
	private String texto;
	private Date fecha;
	
	
	public Aviso(String texto, Date fecha) {
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat ft = new SimpleDateFormat("E dd/MM/yyyy");
		return texto + ". Enviado el " + ft.format(fecha);
		
	}
	
	
	
}
