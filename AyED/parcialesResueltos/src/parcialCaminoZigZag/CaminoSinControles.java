package parcialCaminoZigZag;

import java.util.List;
import parcialMafias.Dato;
import grafos.Graph;
import grafos.Vertex;
import grafos.Edge;
import java.util.LinkedList;

public class CaminoSinControles {
	private Graph<String> mapa; 
	
	
	public List<List<String>> devolverCaminos(String origen, String destino){
		List<List<String>>caminos= new LinkedList<List<String>>(); // consultar; 
		
		if (!this.mapa.isEmpty()) {
			Dato d = this.buscar(this.mapa, origen, destino); 
			if (d.getOrigen() != null && d.getOrigen() != null) {
				this.devolverCaminos(mapa,d.getOrigen(), d.getDestino(), caminos, new LinkedList<String>(), new boolean[mapa.getSize()]); 
			}
		}
		return caminos; 
		
		
	}
	private void devolverCaminos(Graph<String> mapa,Vertex<String>origen,Vertex<String>destino, List<List<String>>caminos, LinkedList<String> camAct,  boolean[]visitados) {
		camAct.add(origen.getData()); 
		visitados[origen.getPosition()]= true; 
		if (origen!= destino) {
			for (Edge<String>ari: mapa.getEdges(origen)) {
				int control= ari.getWeight(); 
				Vertex<String>prox= ari.getTarget(); 
		
				if (control== 0 && !visitados[prox.getPosition()]) {
					devolverCaminos(mapa, prox, destino, caminos, camAct, visitados); 
				}
			}
		}else {
			//caminos.add(camAct); 
			caminos.add(new LinkedList<String>(camAct)); 
		}
		camAct.remove(camAct.size()-1); 
		visitados[origen.getPosition()]= false; 
	}
	private Dato buscar(Graph<String>mapa, String origen, String destino) {
		Dato d= null; 
		for (Vertex<String> v: mapa.getVertices()) {
			if (v.getData().equals(origen)) {
				d.setOrigen(v);
			}else {
				if(v.getData().equals(destino)) {
					d.setDestino(v);
				}
			}
		}return d; 
	}
}
