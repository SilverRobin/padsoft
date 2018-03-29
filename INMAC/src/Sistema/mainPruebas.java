/**
 * 
 */
package Sistema;

import java.io.File;
import java.io.IOException;

import Usuarios.Cliente;

/**
 * @author laura
 *
 */
public class mainPruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sistema apli = new Sistema("admin", "admin");
		String barras = File.separator;
		String path = System.getProperty("user.dir");
		path += barras + "Datos" + barras;
		
		
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

	}

}
