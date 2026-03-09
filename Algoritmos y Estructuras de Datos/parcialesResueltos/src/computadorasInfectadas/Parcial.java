package computadorasInfectadas;

import grafos.Edge;
import grafos.Graph;
import grafos.Vertex;

import general.Queue;

public class Parcial {
	
	
	public int calcularTiempoDeInfeccion (Graph<String>computadoras, Vertex<String>compuInfectada) {
		/*Un poderoso e inteligente virus de computadora infecta cualquier computadora 
		en 1 minuto, logrando infectar toda la red de una empresa con cientos de 
		computadoras. Dado un grafo que representa las conexiones entre las 
		computadoras de la empresa, y una computadora ya infectada, escriba un 
		programa en Java que permita determinar el tiempo que demora el virus en 
		infectar el resto de las computadoras. Asuma que todas las computadoras 
		pueden ser infectadas, no todas las computadoras tienen conexión directa entre 
		sí, y un mismo virus puede infectar un grupo de computadoras al mismo tiempo 
		sin importar la cantidad.*/
		boolean[]visitados= new boolean[computadoras.getSize()]; 
		Queue<Vertex<String>>cola= new Queue<Vertex<String>>(); 
		int nivelAct= 0; 
		visitados[compuInfectada.getPosition()]= true; 
		cola.enqueue(compuInfectada);cola.enqueue(null);
		while (!cola.isEmpty()) {
			Vertex<String>aux= cola.dequeue(); 
			if (aux!= null) {
				for (Edge<String>ari: computadoras.getEdges(aux)) {
					Vertex<String>prox= ari.getTarget(); 
					if (!visitados[prox.getPosition()]) {
						cola.enqueue(prox);
						visitados[prox.getPosition()]= true; 
					}
				}
			}
			else {
				if (!cola.isEmpty()) {
					nivelAct++; 
					cola.enqueue(null);
					
				}
			}
		}
		return nivelAct; 
		
	}
}
