package parcialMafias;
import grafos.Vertex;
public class Dato {
	Vertex<String>origen; 
	Vertex<String>destino;
	public Dato(Vertex<String> origen, Vertex<String> destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}
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
	
}
