package parcialMafias;

import java.util.List;

import grafos.Graph;
import grafos.Vertex;
import grafos.Edge;

import java.util.LinkedList;

public class Parcial {
	
	public List<String>caminoMasSeguro(Graph<String>ciudad){
		List <String>camino= new LinkedList<String>(); 
		if (! ciudad.isEmpty()) {
			
			Dato d = this.buscar(ciudad, "Casa del Intendente", "Municipalidad"); 
			if (d.getOrigen()!= null && d.getDestino() != null) {
				boolean[]visitados= new boolean[ciudad.getSize()];
				this.marcarRestringidos(ciudad, visitados);// esta bien hacer 2 metodos separados? 
				this.caminoMasSeguro(ciudad, visitados, d.getOrigen(), d.getDestino(), camino); 
				
			}
			
		}return camino; 
		
	}
	private Dato buscar (Graph<String>ciudad, String origen, String destino) {
		Dato d= null; 
		for (Vertex<String>v:ciudad.getVertices() ) {
			if (v.getData().equals("Casa del Intendente")){
				d.setOrigen(v); 
			}else {
				if (v.getData().equals(destino)){
					d.setDestino(v);
				}
			}
		}
		return d; 
	}
	private void marcarRestringidos(Graph<String>ciudad, boolean[] visitados) {
		for (Vertex<String>v:ciudad.getVertices() ) {
			if (v.getData().equals("M")) {
				visitados[v.getPosition()]= true; 
			}
		}
	}
	private void caminoMasSeguro (Graph<String>ciudad, boolean[] visitados, Vertex<String>origen,Vertex<String>destino,  LinkedList<String>camino) {
		boolean seguir = true; 
		camino.add(origen.getData()); 
		visitados[origen.getPosition()]=true; 
		
		if (origen== destino) {
			seguir= false; 
		}else {
			List <Edge<String>>ady= ciudad.getEdges(origen); 
			for (Edge<String>ari:ciudad.getEdges(origen)) {
				String w= ari.getWeight(); 
				//CONSULTAR!!!!
			}
			
		}
		
		
		return seguir; 
		
	}

}
