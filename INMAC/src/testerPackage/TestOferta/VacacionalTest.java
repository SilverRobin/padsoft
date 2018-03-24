/**
 * 
 */
package testerPackage.TestOferta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Oferta.EstadoOferta;
import Oferta.Vacacional;
import Sistema.FechaSimulada;

/**
 * @author laura
 *
 */
public class VacacionalTest {
	private Vacacional v;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		v = new Vacacional(200, 50, new FechaSimulada(), new FechaSimulada());
	}

	/**
	 * Test method for {@link Oferta.Vacacional#modificarOferta(java.lang.String, int, Sistema.FechaSimulada)}.
	 */
	@Test
	public void testModificarOferta() {
		v.rectificar();
		FechaSimulada fecha = new FechaSimulada();
		assertEquals(fecha.getHoy(), v.getInicio().getHoy());
		fecha.avanzarDias(7);
		assertTrue(v.modificarOferta("fechafin", 0, fecha));
		assertTrue(v.modificarOferta("fianza", 150, null));
		assertEquals(150, v.getFianza());
		assertTrue(v.modificarOferta("precio", 400, null));
		assertEquals(400, v.getPrecio());
		v.aprobarOferta();
		assertEquals(EstadoOferta.DISPONIBLE, v.getVisibilidad());
		v.reservar();
		assertEquals(EstadoOferta.RESERVADA, v.getVisibilidad());
	}

}
