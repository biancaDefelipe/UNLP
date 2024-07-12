package parcial15_6_T2;
import grafos.Graph;
import grafos.Vertex;
import java.util.LinkedList;
import java.util.Iterator;

import grafos.Edge;
import parcial15_6.Recinto;
public class Parcial {
	
	
	public String resolver(Graph <Recinto> sitios, int tiempo) {
		boolean pude= false; 
		
		if (!sitios.isEmpty() && tiempo > 0) {
			Vertex<Recinto>origen= this.buscar(sitios, "Entrada"); 
			if (origen != null) {
				pude= resolver(sitios, origen, new LinkedList<String>(),tiempo, new boolean[sitios.getSize()]); 
			}
		}
		return (pude== true ? "Alcanzable": "No alcanzable"); 
		
	}
	public boolean resolver(Graph <Recinto>sitios, Vertex<Recinto>origen, LinkedList<String>cam,int tiempo,boolean[]visitados){
		boolean termine=false; 
		int tiempoRestante= tiempo-origen.getData().getTiempo(); 
		if (tiempoRestante>=0) {
			visitados[origen.getPosition()]= true; 
			cam.add(origen.getData().getNombre());
			
			if (tiempoRestante>0) {
				Iterator<Edge<Recinto>>it= sitios.getEdges(origen).iterator(); 
				while (it.hasNext()&& !termine) {
					Edge< Recinto>ari= it.next(); 
					int peso= ari.getWeight(); 
					Vertex<Recinto>prox= ari.getTarget(); 
					if (tiempoRestante>=peso && !visitados[prox.getPosition()]) {
						termine= resolver(sitios, origen, cam, tiempoRestante-peso, visitados); 
					}
				}
			}
			if (cam.size()!= sitios.getSize()) {
				visitados[origen.getPosition()]= false; 
				cam.remove(cam.size()-1); 
				
			}else {
				termine=true; 
			}
		}
		return termine; 
		
	}
	private Vertex<Recinto>buscar (Graph<Recinto>sitios, String nom){
		Iterator<Vertex<Recinto>>it= sitios.getVertices().iterator();
		while (it.hasNext()) {
			Vertex<Recinto>v= it.next(); 
			if (v.getData().getNombre().equals(nom)) {
				return v; 
			}
		}
		return null; 
	}
}
