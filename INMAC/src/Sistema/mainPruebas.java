/**
 * 
 */
package Sistema;

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
		
		System.out.println("Ha fallado la carga de datos?");
		System.out.println(apli.getClientes().isEmpty()); //En este momento esto deberia devolver false
		
		System.out.println("\nIniciando sesion con cliente " + dummy.getNombre() + ".");
		dummy.addDemandante();
		apli.addNuevoCliente(dummy);
		apli.logIn(dummy.getNIF(), dummy.getPassword(), Sistema.TipoCliente.DEMANDANTE);
		System.out.print("Sesion iniciada con exito: ");
		System.out.println(apli.getLogged() != null);
		
		System.out.println("\nCerrando sesion.");
		apli.logOut();
		System.out.print("Sesion cerrada con exito: ");
		System.out.println(apli.getLogged() == null);
		

	}

}
