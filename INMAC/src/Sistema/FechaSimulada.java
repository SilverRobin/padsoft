package Sistema;

import java.time.LocalDate;

/**
 * Esta clase genera una fecha virtual
 * que se puede adelantar o atrasar
 * con motivos de simulacion del
 * programa
 * 
 * @author Antonio Oliva Hernandez
 *
 */
public class FechaSimulada {

	private LocalDate fecha;
	
	public FechaSimulada() {
		fecha = LocalDate.now();
	}
	
	/**
	 * Devuelve el valor de fecha
	 * 
	 * @return Fecha guardada
	 */
	public LocalDate getHoy() {
		return fecha;
	}
	
	/**
	 * Avanza la fecha un numero de
	 * dias pasado por argumento
	 * 
	 * @param dias Dias a adelantar
	 */
	public void avanzarDias(int dias) {
		fecha = fecha.plusDays(dias);
		return;
	}
	
	/**
	 * Actualiza el valor de fecha
	 * al dia de hoy
	 */
	public void reestablecerHoy(){
		fecha = LocalDate.now();
		return;
	}
}
