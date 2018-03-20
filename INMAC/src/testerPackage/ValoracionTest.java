package testerPackage;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import Usuarios.Cliente;
import Valorables.Valoracion;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Valoracion
 * 
 * @author Antonio Oliva
 *
 */
public class ValoracionTest {

	private Valoracion v1;
	
	@Before
	public void setup() {
		v1 = new Valoracion(6, Cliente.generarClienteTest());
	}
	
	@Test
	public void testValoracion() {
		Assert.assertEquals("Error en getValor()", v1.getValor(), 6, 0.1);
		v1.setValor(3);
		Assert.assertEquals("Error en setValor()", v1.getValor(), 3, 0.1);
		
		Assert.assertEquals("Error en getAutor()", v1.getAutor(), Cliente.generarClienteTest());
		v1.setAutor(null);
		Assert.assertNull("Error en setAutor()", v1.getAutor());
	}
}
