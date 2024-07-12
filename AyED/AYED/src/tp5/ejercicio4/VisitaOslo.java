package tp5.ejercicio4;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

import ayed2024.src.tp5.ejercicio1.Edge;
import ayed2024.src.tp5.ejercicio1.Graph;
import ayed2024.src.tp5.ejercicio1.Vertex;

public class VisitaOslo {

	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		
		List<String>camino= new LinkedList<String>(); 
		if (!lugares.isEmpty()) {
			//Vertex<String>ori= lugares.search("Ayuntamiento");
			//Vertex<String>dest= lugares.search(destino);
			Dato d= this.buscar(lugares, "Ayuntamiento", destino); 
			//if ((ori!= null) && (dest!= null)&&(maxTiempo>0)){
			if ((d.getOrigen()!= null) &&(d.getDestino() != null )&& (maxTiempo> 0)){
				boolean[] visitados= new boolean[lugares.getSize()];
				this.marcarRestringidos (lugares, visitados, lugaresRestringidos); 
				//this.paseoEnBici(lugares, camino, ori, dest, visitados, maxTiempo); 
				this.paseoEnBici(lugares, camino, d.getOrigen(), d.getDestino(), visitados, maxTiempo); 
			}
			
			
		}
		return camino; 
	}
	private Dato buscar (Graph<String>lugares, String origen, String destino) {
		
		Dato dato= new Dato(null, null); 
		
		List<Vertex<String>>vertices= lugares.getVertices(); 
		Iterator<Vertex<String>>it= vertices.iterator(); 
		while(it.hasNext() && (dato.getOrigen()== null || (dato.getDestino()== null))){
			Vertex<String>v= it.next(); 
			if (v.getData().equals(origen)) {
				dato.setOrigen(v);
			}
			else {
				if (v.getData().equals(destino)) {
					dato.setDestino(v);
				}
			}
		}
		return dato; 
		
		
		
	}
	
	private void marcarRestringidos(Graph<String>lugares,boolean[] visitados, List<String>lugaresRestringidos) {
		
		for (String l: lugaresRestringidos) {
			Vertex<String> v= lugares.search(l); 		
			if (v!= null) {
				visitados[v.getPosition()]= true; 
			}
	}
	}
	private boolean paseoEnBici(Graph<String> lugares,List<String>camino,Vertex<String>origen, Vertex<String>destino,boolean[]visitados, int maxTiempo ) {
		boolean sigo= true; 
		visitados[origen.getPosition()]= true; 
		camino.add(origen.getData());
		
		if (origen== destino) {
			sigo= false; 
		}
		else {
			while (sigo) {
				List<Edge<String>>aristas= lugares.getEdges(origen);
				Iterator< Edge<String>> it = aristas.iterator(); 
				while (sigo && it.hasNext()) {
					
					Edge<String>a= it.next();
					Vertex<String>proximo= a.getTarget(); 
					int tiempo= maxTiempo-a.getWeight(); 
					if (!visitados[proximo.getPosition()]&& tiempo >0) {
						sigo= paseoEnBici(lugares, camino, proximo, destino, visitados, tiempo); 
					}
				}
			}
		}
		visitados[origen.getPosition()]= false; 
		camino.remove(camino.size()-1); 
		return sigo; 
	}
}
