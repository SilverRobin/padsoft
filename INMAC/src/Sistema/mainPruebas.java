/**
 * 
 */
package Sistema;

import java.io.File;
import java.io.IOException;

import Usuarios.Cliente;

/**
 * @author Laura Ramirez
 *
 */
public class mainPruebas {

	/**
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		Sistema apli = new Sistema("admin", "admin");
		String barras = File.separator;
		String path = System.getProperty("user.dir");
		path += barras + "Datos" + barras;
		Cliente dummy = Cliente.generarClienteTest();
		
		
		try {
			apli.leerFichero("clientes.txt"); //Leemos del fichero
		}catch (IOException e) {
			System.out.println("Error en archivo");
		}
		
		for(Cliente c : apli.getClientes()) {
			apli.guardarCliente(c);
		}
		
		apli = new Sistema("admin", "admin"); //Reiniciamos la aplicacion
		
		try {
			apli.recuperarClientes(); //Cargamos los clientes de las carpetas
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(apli.getClientes().isEmpty()); //En este momento esto deberia devolver false
		
		System.out.println("Iniciando sesion con cliente " + dummy.getNombre() + ".");
		dummy.addDemandante();
		apli.addNuevoCliente(dummy);
		apli.logIn(dummy.getNIF(), dummy.getPassword(), Sistema.TipoCliente.DEMANDANTE);
		System.out.println("Sesion iniciada con exito: " + apli.getLogged() != null);
		
		System.out.println("Cerrando sesion.");
		apli.logOut();
		System.out.println("Sesion cerrada con exito: " + apli.getLogged() == null);

	}

}
