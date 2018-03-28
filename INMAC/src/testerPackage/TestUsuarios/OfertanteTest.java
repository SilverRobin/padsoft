package testerPackage.TestUsuarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Inmueble.Direccion;
import Inmueble.Inmueble;
import Usuarios.Ofertante;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Ofertante
 * 
 * @author Laura Ramirez
 *
 */
public class OfertanteTest {
	private Ofertante o, o2;
	private Inmueble i;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		o = new Ofertante("Fulano", "fulano@gmail.com", "sopadefideos", "0000111122223333");
		o2 = new Ofertante("Fulano2", "fulano2@gmail.com", "sopadefideos", "a");
		i = new Inmueble("Soleado, muy grande", Direccion.generarTestDir2());
		
	}

	@Test
	public void test() {
		assertTrue(o.getInmuebles().isEmpty());
		assertTrue(o.addInmueble(i));
		assertTrue(o.recibirCobro((double) 200, "cobro reserva"));
		assertFalse(o2.recibirCobro((double) 200, "cobro")); //Error por tarjeta invalida
		assertFalse(o.recibirCobro((double) 200, "w")); //Error por conexion fallida y genera aviso
		assertFalse(o.getAvisos().isEmpty()); //Tenemos un aviso
		
	}

}
