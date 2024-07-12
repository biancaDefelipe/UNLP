package parcial15_6;

import java.util.Iterator;
import grafos.Graph;
import grafos.Vertex;
import grafos.Edge;
import grafos.adjList.AdjListGraph;
import grafos.adjList.AdjListVertex;
import grafos.adjList.AdjListEdge;

import java.util.LinkedList; 
import java.util.List;

import grafos.adjList.*;
public class Parcial {

	
public int resolver (Graph<Recinto>sitios, int tiempo) {
		
		Dato d= new Dato(0); 
		if (! sitios.isEmpty() && tiempo >0) {
			Vertex<Recinto>origen= this.buscar(sitios, "Entrada"); 
			if (origen != null) {
				resolver(sitios, origen, new boolean [sitios.getSize()],d,0, tiempo ); 
			}
		}
		return d.getMax(); 
	}
	private Vertex<Recinto>buscar(Graph<Recinto>sitios, String nom){
		Iterator<Vertex<Recinto>>it = sitios.getVertices().iterator(); 
		while (it.hasNext()) {
			Vertex<Recinto>v= it.next(); 
			if (v.getData().getNombre().equals(nom)) {
				return v; 
			}
		}
		return null; 
	}
	private int resolver (Graph<Recinto> sitios, Vertex<Recinto> origen,  boolean []visitados, Dato d,int act, int tiempo) {
		//si tengo tiempo suficiente
		if (tiempo >0) {
			visitados[origen.getPosition()]= true; 
			act++;
			if (origen.getData().getTiempo()<= tiempo) {	
				int subtot= tiempo- origen.getData().getTiempo(); 
				for (Edge<Recinto>ari : sitios.getEdges(origen)) {
					Vertex<Recinto>prox = ari.getTarget(); 
					if (!visitados[prox.getPosition()] && subtot - ari.getWeight()>0) {
						act= resolver(sitios, prox, visitados, d, act, subtot-ari.getWeight());
					}		
				}
			}
		} 
		if (act >d.getMax()) {
			d.setMax(act);
	}
		visitados[origen.getPosition()]= false; 
		act--;
			
		return act; 
	}
			
	
	public static void main (String [] args) {
		AdjListGraph<Recinto> sitios;
		Vertex<Recinto> entrada;
		Vertex<Recinto> cebras;
		Vertex<Recinto> tigres;
		Vertex<Recinto> flamencos;
		Vertex<Recinto> murcielagos;
		Vertex<Recinto> wallabies;
		Vertex<Recinto> tortugas;
		Vertex<Recinto> pumas;
		
		sitios = new AdjListGraph<>();
		entrada= sitios.createVertex(new Recinto ("Entrada", 15)); 
		cebras= sitios.createVertex(new Recinto("Cebras", 10)); 
		tigres= sitios.createVertex(new Recinto("Tigres", 10)); 
		flamencos = sitios.createVertex(new Recinto ("Flamencos", 10)); 
		murcielagos= sitios.createVertex(new Recinto("Murcielagos", 20)); 
		wallabies= sitios.createVertex(new Recinto("Wallabies", 30)); 
		tortugas= sitios.createVertex(new Recinto("Tortuga", 10)); 
		pumas= sitios.createVertex(new Recinto("Pumas", 10)); 
		
		sitios.connect(entrada, cebras,10);
		sitios.connect(entrada, tigres, 15);
		sitios.connect(entrada, murcielagos, 20);
		sitios.connect(entrada, flamencos, 25);
		
		sitios.connect(cebras, entrada,10);
		sitios.connect(cebras, tigres, 8);
		sitios.connect(cebras, tortugas, 5);
		
		sitios.connect(tigres, entrada, 15);
		sitios.connect(tigres, cebras, 8);
		
		sitios.connect(flamencos, entrada, 25);
		sitios.connect(flamencos,murcielagos, 25);
		
		sitios.connect(murcielagos, entrada, 20);
		sitios.connect(murcielagos, flamencos, 25);
		sitios.connect(murcielagos,wallabies, 30);
		
		sitios.connect(wallabies, murcielagos, 10);
		sitios.connect(wallabies, tortugas, 10);
		
		sitios.connect(tortugas, cebras, 5);
		sitios.connect(tortugas, wallabies, 10);
		sitios.connect(tortugas, pumas, 15); 
		
		sitios.connect(pumas, tortugas, 15);
		
		Parcial p= new Parcial(); 
		int cant= p.resolver(sitios, 100); 
		System.out.println("CANTIDAD MAXIMA DE SITIOS "+ (cant)); 
	}

	/*

	public int resolver (Graph<Recinto>sitios, int tiempo) {
		
		Dato d= new Dato(0); 
		if (! sitios.isEmpty() && tiempo >0) {
			Vertex<Recinto>origen= this.buscar(sitios, "Entrada"); 
			if (origen != null) {
				resolver(sitios, origen, new boolean [sitios.getSize()],d,0, tiempo ); 
			}
		}
		return d.getMax(); 
	}
	private Vertex<Recinto>buscar(Graph<Recinto>sitios, String nom){
		Iterator<Vertex<Recinto>>it = sitios.getVertices().iterator(); 
		while (it.hasNext()) {
			Vertex<Recinto>v= it.next(); 
			if (v.getData().getNombre().equals(nom)) {
				return v; 
			}
		}
		return null; 
	}
	private int resolver (Graph<Recinto> sitios, Vertex<Recinto> origen,  boolean []visitados, Dato d,int act, int tiempo) {
		//si tengo tiempo suficiente
		if (tiempo >0) {
			visitados[origen.getPosition()]= true; 
		
			act++;
		
			if (origen.getData().getTiempo()<= tiempo) {
				
				int subtot= tiempo- origen.getData().getTiempo(); 
				for (Edge<Recinto>ari : sitios.getEdges(origen)) {
			
					Vertex<Recinto>prox = ari.getTarget(); 
			
					if (!visitados[prox.getPosition()] && subtot - ari.getWeight()>0) {
		
						act= resolver(sitios, prox, visitados, d, act, subtot-ari.getWeight());
			
					}		
				}
			}
		}

		if (act >d.getMax()) {
			d.setMax(act);
	}
		visitados[origen.getPosition()]= false; 
		act--;
		
		
			
		return act; 
	}*/
}

