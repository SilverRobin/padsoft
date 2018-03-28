package testerPackage.TestOferta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Oferta.*;
import Sistema.FechaSimulada;
import Usuarios.Demandante;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Reserva
 * 
 * @author Laura Ramirez
 *
 */
public class ReservaTest {
	private Reserva r;
	private LargaEstancia l;
	private Demandante d;

	@Before
	public void setUp() throws Exception {
		l = new LargaEstancia(200, 100, new FechaSimulada(), 2);
		r = new Reserva(l);
		d = new Demandante("Fulano", "fulano@gmail.com", "sopadefideos", "0000111122223333");
	}

	@Test
	public void testGetFecha() {
		assertEquals(new FechaSimulada().getHoy(), r.getFecha().getHoy());
	}

	@Test
	public void testSetFecha() {
		FechaSimulada f = new FechaSimulada();
		f.retrasarDias(5);
		r.setFecha(f);
		assertEquals(f.getHoy(), r.getFecha().getHoy());
	}

	@Test
	public void testIsLargaEstancia() {
		assertTrue(r.isLargaEstancia());
	}

	@Test
	public void testGetOferta() {
		assertEquals(l, r.getOferta());
	}

	@Test
	public void testPagarReserva() {
		assertFalse(r.pagarReserva(d));
	}

	@Test
	public void testCancelarReserva() {
		assertFalse(r.cancelarReserva(d));
	}

}
