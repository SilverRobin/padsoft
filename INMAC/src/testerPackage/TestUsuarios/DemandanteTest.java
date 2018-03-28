package testerPackage.TestUsuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Oferta.*;
import Sistema.FechaSimulada;
import Usuarios.Demandante;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Demandante
 * 
 * @author Laura Ramirez
 *
 */
public class DemandanteTest {
	
	private Demandante d;
	private Vacacional v, v2;
	private LargaEstancia le, le2;
	private Reserva r1, r2, r3, r4;
	private FechaSimulada fecha;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new Demandante("Fulano", "fulano@gmail.com", "sopadefideos", "0000111122223333");
		v = new Vacacional(200, 50, new FechaSimulada(), new FechaSimulada());
		v.getFin().avanzarDias(7);
		v2 = new Vacacional(100, 50, new FechaSimulada(), new FechaSimulada());
		v2.getFin().avanzarDias(10);
		le = new LargaEstancia(300, 150, new FechaSimulada(), 5);
		le2 = new LargaEstancia(400, 100, new FechaSimulada(), 3);
		r1 = new Reserva(v);
		r2 = new Reserva(le);
		r3 = new Reserva(v2);
		r4 = new Reserva(le2);
		fecha = new FechaSimulada();
		fecha.retrasarDias(5);
		r3.setFecha(fecha);
	}

	@Test
	public void testGet() {
		assertEquals("0000111122223333", d.getCreditCard());
		assertTrue(d.getReservas().isEmpty());
		assertTrue(fecha.hanPasado5dias());

	}
	
	@Test
	public void testReserva() {
		assertTrue(d.addReserva(r1));
		assertTrue(d.addReserva(r2));
		assertTrue(d.limiteAlcanzado());
		assertFalse(d.addReserva(r3));
		assertFalse(d.comprobarReserva(r4));
		assertTrue(d.comprobarReserva(r1));
		d.eliminarReserva(r1); //Eliminamos una reserva
		assertEquals(1, d.getReservas().size()); //Ahora solo hay una (r2)
		assertFalse(d.addReserva(r4)); //No podemos reservar otra de larga estancia
		assertTrue(d.getReservas().get(0).pagarReserva(d)); //Contratamos r2
		assertEquals(EstadoOferta.CONTRATADA, r2.getOferta().getVisibilidad()); //La oferta esta pagada
		d.addReserva(r3); //Añadimos la reserva vacacional caducada
		assertEquals(2, d.getReservas().size());//Ahora hay dos reservas
		d.eliminarReservaCaducada(); //Eliminamos reserva caducada
		assertEquals(1, d.getReservas().size());//Ahora solo hay una
		d.eliminarReserva(r2);
		assertTrue(d.getReservas().isEmpty());
		

		
		
	}

}
