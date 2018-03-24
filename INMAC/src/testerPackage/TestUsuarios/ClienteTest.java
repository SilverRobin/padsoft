/**
 * 
 */
package testerPackage.TestUsuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Usuarios.Cliente;

/**
 * @author eps
 *
 */
public class ClienteTest {
	private Cliente c;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Cliente("Fulano", "deTal@gmail.com", "sopadefideos", "0000111122223333");
	}

	@Test
	public void test() {
		assertTrue(c.comprobarTarjeta());
		c.cambiarTarjeta("a");
		assertFalse(c.comprobarTarjeta());
		assertTrue(c.getAvisos().isEmpty());
		c.addAviso("Holo");
		assertFalse(c.getAvisos().isEmpty());
		c.leerAvisos();
	}

}
