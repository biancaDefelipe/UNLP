package parcialCaminoConPresupuesto;
import grafos.*; 
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import 

public class BuscadorDeCamino {

	
	public List<String> caminoConPresupuesto (Graph<String >ciudades, String origen, String destino, int montoMaximo){
		List<String>camino= new LinkedList<String>(); 
		if (!ciudades.isEmpty() && montoMaximo> 0) {
			Dato d= this.buscar(ciudades, origen, destino); 
			if (d.getDestino()!= null && d.getOrigen() != null) {
				this.caminoConPresupuesto(ciudades,camino,new boolean[ciudades.getSize()],  d.getOrigen(), d.getDestino(), montoMaximo); 
			}
			
		}
		return camino; 
	}
	private Dato buscar(Graph<String>ciudades, String origen, String destino) {
		Dato d= null; int cant= 0; 
		Iterator <Vertex<String>>it= ciudades.getVertices().iterator(); 
		while (it.hasNext() && cant <2) {
			Vertex<String> v = it.next(); 
			if (v.getData().equals(origen)) {
				d.setOrigen(v);
				cant++; 
			}else {
				if (v.getData().equals(destino)) {
					d.setDestino(v);
					cant++; 
				}
			}
		}
		return d; 
	}
	private boolean caminoConPresupuesto(Graph<String>ciudades, List<String> camino, boolean[]visitados, Vertex<String>origen, Vertex<String>destino, int montoMaximo) {
		camino.add(origen.getData()); 
		visitados[origen.getPosition()]= true; 
		boolean seguir= true; 
		if (origen == destino) {
			seguir= false; 
		}else {
			for (Edge<String>ari: ciudades.getEdges(origen)) {
				Vertex<String>prox=ari.getTarget(); 
				int costo= ari.getWeight(); 
				if (costo<= montoMaximo && !visitados[prox.getPosition()]) {
					seguir= caminoConPresupuesto(ciudades, camino, visitados, prox, destino, montoMaximo-costo); 
					
				}
			}
		}if (seguir) {
			camino.remove(camino.size()-1); 
			visitados[origen.getPosition()]= false; 
		}return seguir; 
	}
}
