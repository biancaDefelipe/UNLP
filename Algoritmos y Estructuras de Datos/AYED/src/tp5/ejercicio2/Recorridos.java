package tp5.ejercicio2;
import java.util.List;
import java.util.LinkedList;
import ayed2024.src.tp5.ejercicio1.*;
import ayed2024.src.tp5.ejercicio1.adjList.*;
import tp1.ejercicio8.*;

public class Recorridos<T> {
	
	public Recorridos() {
		
	}

	public List<T> dfs(Graph<T> grafo){
		List<T>lista= new LinkedList<T>(); 
		boolean[] visitados = new boolean[grafo.getSize()]; 
		for (int i=1 ; i<= visitados.length; i++) {
			if (!visitados[i]) {
				this.dfs(i, grafo, visitados, lista); 
			}
		}
		return lista; 
		
	}
	private void dfs(int i, Graph<T> grafo, boolean[] visitados, List<T>lista) {
		//marco el vertice como visitado
		visitados[i]=true; 
		Vertex<T>v= grafo.getVertex(i); 
		//agrego el dato del vertice a la lista
		lista.add(v.getData()); 
		//tomo todos los adyacentes de v 
		List<Edge<T>> adyacentes= grafo.getEdges(v); 
		for (Edge<T> e: adyacentes) {
			 	Vertex<T>destino=e.getTarget(); 
			 	int pos= destino.getPosition(); 
			 	if (!visitados [pos]) {
			 		//si no esta visitado le aplico el bfs
			 		this.dfs(pos, grafo, visitados, lista); 
			 	}
		}
		
		
	}
	
	public List<T> bfs(Graph<T> grafo) throws Exception{
	// Retorna una lista con los datos de vértices, con el recorrido en amplitud del grafo recibido como parámetro
		boolean[]visitados= new boolean [grafo.getSize()]; 
		List<T>lista= new LinkedList<T>(); 
		for (int i=1; i<= visitados.length ; i++) {
			 if (!visitados[i]) {
				 this.bfs(i, grafo, visitados, lista); 
			 }
			
		}
		return lista; 
	}
	private void bfs(int i, Graph<T>grafo,boolean visitados[], List<T>lista ) throws Exception {
		visitados[i]= true; 
		Queue<Vertex<T>> cola= new Queue<Vertex<T>>();
		cola.enqueue(grafo.getVertex(i));
		while (!cola.isEmpty()) {
			Vertex<T>v= cola.dequeue(); 
			lista.add(v.getData()); 
			List<Edge<T>>adyacentes= grafo.getEdges(v); 
			for (Edge<T>e: adyacentes) {
				int pos= e.getTarget().getPosition(); 
				if (!visitados[i]) {
					visitados[i]= true; 
					cola.enqueue(e.getTarget());
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
