package testerPackage;

import org.junit.Assert.*;
import org.junit.Test;

import Inmueble.Caracteristica;

public class CaracteristicaTest {

	@Test
	public void TesterGetSet(){
		Caracteristica c1 = new Caracteristica("Test1", "Desc1");
		Caracteristica c2 = new Caracteristica("Test1", "Desc2");
		
		//assertEquals("Error en getTitulo()", c1.getTitulo(), c2.getTitulo());
		
		return;
	}
}
