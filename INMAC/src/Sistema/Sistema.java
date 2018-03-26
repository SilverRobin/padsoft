package Sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Inmueble.*;
import Usuarios.*;

public class Sistema implements Serializable{
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Inmueble> inmuebles;
	private Cliente logeado;

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	protected static String gerPass;
	protected static String gerID;
	
	public Sistema singleton;
	
	protected Sistema(String id, String pass) {
		gerID = id;
		gerPass = pass;
		clientes = new ArrayList<Cliente>();
		inmuebles = new ArrayList<Inmueble>();
		logeado = null;
	}
	
	/**
	 * Busca un cliente por correo
	 * @param email correo del cliente
	 * @return Cliente
	 */
	public Cliente buscarCliente(String email) {
		if(email == null) {
			return null;
		}
		for(Cliente c : this.clientes) {
			if(c.getCorreo().equals(email))
				return c;
		}
			return null;
		
	}
	
	/**
	 * Guarda un cliente en disco
	 * @param c Cliente que guardar
	 */
	public void guardarCliente(Cliente c) {
		String path = System.getProperty("user.dir");
		String barras = File.separator;
		if (c instanceof Demandante) {
			path += barras + "Datos" + barras + "Clientes" + barras + "Demandantes"
					+ c.getCorreo() + barras;
		}else if (c instanceof Ofertante){
			path += barras + "Datos" + barras + "Clientes" + barras + "Ofertantes"
					+ c.getCorreo() + barras;
		}else {
			return;
		}
		File folder = new File(path);
		if(!folder.exists()) {
			folder.mkdirs();
			
			try {
				FileOutputStream file = new FileOutputStream(path + "user.ser");
				ObjectOutputStream obj = new ObjectOutputStream(file);
				obj.writeObject(c);
				obj.close();
				file.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			File borrado = new File(path + "user.ser");
			borrado.delete();
			try {
				FileOutputStream file = new FileOutputStream(path + "user.ser");
				ObjectOutputStream obj = new ObjectOutputStream(file);
				obj.writeObject(c);
				obj.close();
				file.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * Carga los clientes del disco
	 * @return Lista de clientes
	 * @throws IOException excepcion de E/S
	 * @throws ClassNotFoundException excepcion de clase
	 */
	public ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException {
		String path = System.getProperty("user.dir");
		String barras = File.separator;
		String directorio = path;
		ArrayList<Cliente> aux = new ArrayList<Cliente>();
		Cliente objeto = null;
		FileInputStream fichero = null;
		ObjectInputStream ois = null;
		
		//Directorio de clientes
		directorio  += barras + "Datos" + barras + "Clientes" + barras + "Ofertantes";
		
		File dirOfertantes = new File(directorio);
		
		if(dirOfertantes.exists()) {
			File[] verCarpetas = dirOfertantes.listFiles();
			
			for(int x = 0; x < verCarpetas.length; x++) {
				String direccion = directorio;
				direccion += verCarpetas[x].getName();
				File carpe = new File(direccion);
				File[] ficheros = carpe.listFiles();
				
				for(File obj : ficheros) {
					fichero = new FileInputStream(obj);
					ois = new ObjectInputStream(fichero);
					objeto = (Ofertante) ois.readObject();
					ois.close();
					aux.add(objeto);
				}
			}
		}
		
		//Directorio de Demandantes
		directorio  += barras + "Datos" + barras + "Clientes" + barras + "Demandantes";
		
		File dirDemandantes = new File(directorio);
		
		if(dirDemandantes.exists()) {
			File[] verCarpetas = dirDemandantes.listFiles();
			
			for(int x = 0; x < verCarpetas.length; x++) {
				String direccion = directorio;
				direccion += verCarpetas[x].getName();
				File carpe = new File(direccion);
				File[] ficheros = carpe.listFiles();
				
				for(File obj : ficheros) {
					fichero = new FileInputStream(obj);
					ois = new ObjectInputStream(fichero);
					objeto = (Demandante) ois.readObject();
					ois.close();
					aux.add(objeto);
				}
			}
		}
		
		return aux;
	}
}
