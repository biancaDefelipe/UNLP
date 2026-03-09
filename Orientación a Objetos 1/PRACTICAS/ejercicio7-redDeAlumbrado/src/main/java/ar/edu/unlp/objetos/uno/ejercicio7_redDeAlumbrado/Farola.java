package ar.edu.unlp.objetos.uno.ejercicio7_redDeAlumbrado;

import java.util.List;
import java.util.LinkedList;
public class Farola {
	private boolean on ;
	private List<Farola> neighbors; 
	
	
	public Farola () {
		/*
		* Crear una farola. Debe inicializarla como apagada
		*/
		this.neighbors= new LinkedList<Farola>(); 
		this.on=false; 
	}
	public void pairWithNeighbor( Farola otraFarola ) {
		/*
		* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
		*/
		if (!(this.getNeighbors().contains(otraFarola))) {
			this.neighbors.add(otraFarola); 
			otraFarola.pairWithNeighbor(this);
		}
	
	}
	
	public List<Farola> getNeighbors (){
		/*
		* Retorna sus farolas vecinas
		*/
		return this.neighbors; 
	}
	public void turnOn() {
		/*
		* Si la farola no está encendida, la enciende y propaga la acción.
		*/
		if (!this.isOn()) {
			this.on=true; 
			//this.neighbors.stream().map(f -> f.turnOn()) op intermedia ¿como seria?
			//this.getNeighbors().forEach(f-> f.turnOn());
			for (Farola f: this.getNeighbors()) {
				f.turnOn();
			}
	}
	}



	public void turnOff() {
	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
		if (this.isOn()) {
			this.on=false; 
			//this.neighbors.stream().map(f -> f.turnOn()) op intermedia ¿como seria?
		//	this.getNeighbors().forEach(f->f.turnOn());
			for (Farola f: this.getNeighbors()) {
				f.turnOff();
			}
	}
	}
/*
* Retorna true si la farola está encendida.
*/
	public boolean isOn() {
		return this.on;
	}


}
