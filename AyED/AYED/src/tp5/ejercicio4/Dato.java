package tp5.ejercicio4;

import ayed2024.src.tp5.ejercicio1.Vertex;

public class Dato {
	private Vertex<String> origen; 
	private Vertex<String> destino;
	
	
	public Vertex<String> getOrigen() {
		return origen;
	}

	public void setOrigen(Vertex<String> origen) {
		this.origen = origen;
	}

	public Vertex<String> getDestino() {
		return destino;
	}

	public void setDestino(Vertex<String> destino) {
		this.destino = destino;
	}

	public Dato(Vertex<String> origen, Vertex<String> destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	} 
	
	
}
