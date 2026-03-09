package parcialGrafosCovid.src;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

import grafos.Edge;
import grafos.Graph;
import grafos.Vertex;
public class Parcial {
	
	public List<String>resolver (Graph <Ciudad>ciudades, String origen, String destino){
		List<String>camino= new LinkedList<String>(); 
		if (!ciudades.isEmpty()) {
			//modificar el buscar
			Vertex<Ciudad>ori= this.buscar(ciudades, origen); 
			Vertex<Ciudad>dest= this. buscar(ciudades, destino); 
			
			if (ori != null && dest != null) {
				boolean[] visitados= new boolean[ciudades.getSize()]; 
				this.marcarRestringidos(ciudades, visitados);
				this.resolver (ciudades, visitados, camino, ori, dest); 
			}
		}
		return camino; 
	}
	// hacer un objeto?? Verices(vertex<Ciudad> origen, Vertex<Ciudad> destino)
	private Vertex<Ciudad> buscar (Graph<Ciudad>ciudades, String nom){
		List<Vertex<Ciudad>>vertices= ciudades.getVertices(); 
		Iterator <Vertex<Ciudad>>it= vertices.iterator(); 
		boolean econtreDestino=false; 
		boolean encontreOrigen= false; 
		while (it.hasNext()) {
			Vertex<Ciudad>v = it.next(); 
			if (v.getData().getNombre().equals(nom) ) {
				return v; 
			}
		}
		return null; 
	}
	private void marcarRestringidos( Graph<Ciudad> grafo, boolean []visitados) {
		
		for (Vertex<Ciudad> v: grafo.getVertices()) {
			if( v.getData().getFase() == 1) {
				visitados[v.getPosition()]= true; 
			}
		}
	}
		
	private boolean resolver (Graph<Ciudad>ciudades, boolean [] visitados, List<String> camino, Vertex<Ciudad>origen, Vertex<Ciudad>destino) {
		boolean seguir = true; 
		camino.add(origen.getData().getNombre()); 
		visitados[origen.getPosition()]= true; 
		
		if (origen== destino) {
			seguir = false; 
		}else {
			List<Edge<Ciudad>>ady=ciudades.getEdges(origen);  
			Iterator<Edge<Ciudad>>it= ady.iterator(); 
			while (it.hasNext() && seguir) {
				Edge<Ciudad>ari= it.next(); 
				Vertex<Ciudad>prox= ari.getTarget(); 
				if (!visitados[prox.getPosition()]){
					seguir = resolver( ciudades, visitados, camino, prox, destino); 
					
				}
			}
		}
		if (seguir) {
			camino.remove(camino.size()-1); 
			visitados[origen.getPosition()]= false; 
		}
		return seguir ;
	}
}
