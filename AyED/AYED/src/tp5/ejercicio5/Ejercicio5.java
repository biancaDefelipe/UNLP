package tp5.ejercicio5;
import tp1.ejercicio8.Queue;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import ayed2024.src.tp5.ejercicio1.Graph;
import ayed2024.src.tp5.ejercicio1.Vertex;
import ayed2024.src.tp5.ejercicio1.Edge;

public class Ejercicio5 {

	
	
	public List<Persona> bfs(Graph<Persona>grafo,Persona empleado, int separacion) throws Exception{
		List<Persona> lista= new LinkedList<Persona>(); 
		
		if (!grafo.isEmpty() && separacion >0) {
			Vertex<Persona>emp= this.buscar(grafo, empleado); 
			if (emp != null) {
				this.bfs(grafo, emp, separacion, new boolean[grafo.getSize()]  ,lista); 
			}
		}
		return lista; 
	}
	//inicializar boolean en also los que ya recibieron jubilacion SOLO EN RECURSIVOS!!!
	/*
	private void marcarRestringidos(Graph<Persona>grafo, boolean[]visitados) {
		List<Vertex<Persona>>vertices= grafo.getVertices(); 
		for (Vertex<Persona> v : vertices) {
			if(v.getData() instanceof Jubilado) {
				Jubilado j= (Jubilado) v.getData(); 
				if (j.getJubilacionRecibida() >0) {
					visitados[v.]
				}
			}
		}
	}*/
	private void bfs (Graph<Persona>grafo,Vertex<Persona> emp, int separacion,boolean[] visitados, List<Persona> lista) throws Exception{
		Queue<Vertex<Persona>>cola= new Queue<Vertex<Persona>>(); 
		cola.enqueue(emp); cola.enqueue(null);
		visitados[emp.getPosition()]=true; 
		
		boolean seguir =true; int nivel =0;
		while (!cola.isEmpty() && seguir) {
			if (lista.size()<40) {
				Vertex<Persona>aux=cola.dequeue(); 
				
				if (aux != null) { 
					if (( aux.getData() instanceof Jubilado )&&(nivel <= separacion) ) {
						Jubilado j= (Jubilado) aux.getData(); 
						if (j.getJubilacionRecibida()==0 && !lista.contains(j)){
								lista.add(j) ; 
						}	
					}
					if (nivel < 2) {
						List<Edge<Persona>>aristas= grafo.getEdges(aux); 
						for (Edge<Persona>a: aristas) {
							Vertex<Persona>prox= a.getTarget(); 
							if (!visitados[prox.getPosition()] ) {
								cola.enqueue(prox);
								visitados[prox.getPosition()]= true; 
							}
						}
					}
				}
				else {// termine de procesar 1 nivel
					if (!cola.isEmpty()) {
						nivel++; 
						cola.enqueue(null);
					}
				}
			}else {
				seguir= false; 
			}
		}
		
	}
	
	
	private Vertex<Persona> buscar(Graph<Persona>grafo, Persona p){
		List <Vertex<Persona>>vertices= grafo.getVertices(); 
		Iterator<Vertex<Persona>>it= vertices.iterator(); 
		while (it.hasNext()) {
			Vertex<Persona>v= it.next(); 
			if (v.getData()== p) {
				return v; 
			}
		}
		return null; 
	}
}
