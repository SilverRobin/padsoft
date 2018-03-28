package Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * Busca un cliente por nif
	 * @param nif  del cliente
	 * @return Cliente
	 */
	public Cliente buscarCliente(String nif) {
		if(nif == null) {
			return null;
		}
		for(Cliente c : this.clientes) {
			if(c.getNIF().equalsIgnoreCase(nif))
				return c;
		}
			return null;
		
	}
	
	public boolean addNuevoCliente(Cliente c) {
		if(c == null) {
			return false;
		}
		if(this.clientes.contains(c)) {
			return false;
		}
		for(Cliente p : this.clientes) {
			if(c.getNIF().equalsIgnoreCase(p.getNIF())) {
				return false;
			}
		}
		 return this.clientes.add(c);
	}
	
	public boolean leerCliente(String linea) {
		String rol, NIF, name, pass, ccn;
		
		Scanner l;
		
		l = new Scanner(linea);
		
		l.useDelimiter("\\n");
		rol = l.next();
		
		String[] aux = rol.split("\\;");
		rol = aux[0];
		NIF = aux[1];
		name =aux[2];
		pass = aux[3];
		ccn = aux[4];
		
		l.close();
		
		switch (rol) {
		case "O":
			return addNuevoCliente(new Ofertante (name, NIF, pass, ccn));
		case "D":
			return addNuevoCliente (new Demandante(name, NIF, pass, ccn));
		case "OD":
			return addNuevoCliente(new Ofertante (name, NIF, pass, ccn)) &&
					addNuevoCliente (new Demandante(name, NIF, pass, ccn));
			
		default:
			return false;
		}
		
		
	}
	
	public boolean leerFichero(String fichero) throws IOException {
		String datos;
		
		if(fichero==null) {
			return false;
		}
		FileReader file = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(file);
		
		while((datos = buffer.readLine()) != null) {
			leerCliente(datos);
			
		}
		
		if(buffer != null) {
			buffer.close();
		}
		return true;
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
					+ c.getNIF() + barras;
		}else if (c instanceof Ofertante){
			path += barras + "Datos" + barras + "Clientes" + barras + "Ofertantes"
					+ c.getNIF() + barras;
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
	 * Recupera los clientes del archivo y los carga en el sistema
	 * @throws ClassNotFoundException Excepcion
	 * @throws IOException Excepcion
	 */
	public void recuperarClientes() throws ClassNotFoundException, IOException {
		this.clientes.addAll(cargarClientes());
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
