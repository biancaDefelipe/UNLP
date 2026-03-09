package parcialEstadios;

import java.util.List;

import grafos.Edge;
import grafos.Graph;
import grafos.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
public class Parcial {
	
	
	public List<String>estadios(Graph<Estadio>mapaEstadios, String estadioOrigen, int cantKm){
		List<String>caminoMax= new LinkedList<String>(); 
		if (!mapaEstadios.isEmpty()&& cantKm>0) {
			Vertex<Estadio>origen= this.buscar(mapaEstadios, estadioOrigen); 
			if (origen != null) {
				estadios(mapaEstadios, origen, caminoMax, new LinkedList<String>(), new boolean [mapaEstadios.getSize()], cantKm); 
			}
			
		}
		return caminoMax; 
	}
	private void estadios(Graph<Estadio>mapa, Vertex<Estadio>origen,List<String>caminoMax, LinkedList<String>caminoAct, boolean[] visitados, int cantKm) {
		
		caminoAct.add(origen.getData().getNombre()); 
		visitados[origen.getPosition()]= true; 
		if (cantKm> 0) {
			for (Edge<Estadio>a: mapa.getEdges(origen)) {
				int peso= a.getWeight(); 
				Vertex<Estadio>prox= a.getTarget(); 
				if (peso <= cantKm && !visitados[prox.getPosition()]) {
					estadios(mapa, prox, caminoMax, caminoAct, visitados, cantKm-peso); 
				}
			}
		}
		if (caminoAct.size()> caminoMax.size()) {
			caminoMax.clear(); caminoMax.addAll(caminoAct); 
		}
		caminoAct.remove(caminoAct.size()-1); 
		visitados[origen.getPosition()]= false; 

		
		
	}
	private Vertex<Estadio> buscar(Graph<Estadio>mapa, String nom){
		Iterator<Vertex<Estadio>>it= mapa.getVertices().iterator(); 
		while (it.hasNext()) {
			Vertex<Estadio>v= it.next(); 
			if(v.getData().getNombre().equals(nom)) {
				return v; 
			}
		}
		return null; 
	}
}
