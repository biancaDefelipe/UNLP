package parcialGradosDeSeparacion;

import grafos.*;
import general.Queue;
public class GradosDeSeparacion {

	public int maximoGradoDeSeparacion(Graph<String>grafo) {
		int max=0;
		if(!grafo.isEmpty()) {
			max= this.bfs(grafo); 
		}
		return max; 
	}
	private int bfs(Graph<String>grafo) {
		Queue<Vertex<String>>cola= new Queue<Vertex<String>>(); 
		cola.enqueue(grafo.getVertex(0));
		cola.enqueue(null);
		int nivel=0; int max=Integer.MIN_VALUE;
		int cantVisitados=1; 
		boolean[]visitados= new boolean [grafo.getSize()]; 
		visitados[grafo.getVertex(0).getPosition()]= true; 
		Vertex<String>aux; 	Vertex<String>prox; 
		while (!cola.isEmpty()) {
			aux= cola.dequeue(); 
			
			if (aux != null) {
			
				//visitados[aux.getPosition()]= true; cantVisitados++; 
				
				for (Edge<String>ari: grafo.getEdges(aux)) {
					prox=ari.getTarget(); 
					if (!visitados[prox.getPosition()]) {
						cola.enqueue(prox);
						visitados[prox.getPosition()]= true; 
						cantVisitados++; 
					}
				}
			}
			else {
				if (max<nivel) {
					max= nivel; 
				}
				if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
			}	
		}
		if (cantVisitados != grafo.getSize()) {
			max= 0; 
		}
		return max; 	
	}
}
