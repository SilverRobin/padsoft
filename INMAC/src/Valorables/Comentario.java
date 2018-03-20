package Valorables;

import java.util.ArrayList;
import java.util.List;

import Usuarios.Cliente;

/**
 * Clase que define el objeto Comentario, que contiene
 * un Cliente autor, un texto, y un conjunto de valoraciones
 * y comentarios.
 * 
 * @author Antonio Oliva 
 *
 */
public class Comentario extends ElementoValorable{

	private String texto;
	private List<ElementoValorable> valorables;
	
	public Comentario(String nT, Cliente nC) {
		super(nC);
		texto = nT;
		valorables = new ArrayList<>();
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String nT) {
		texto = nT;
		return;
	}
	
	public void addValorable(ElementoValorable e) {
		valorables.add(e);
		return;
	}
	
	public List<ElementoValorable> getValorables(){
		return valorables;
	}
}
