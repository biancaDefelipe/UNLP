package tp5.ejercicio3;
import ayed2024.src.tp5.ejercicio1.*;
import ayed2024.src.tp5.ejercicio1.adjList.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import tp1.ejercicio8.*;
import tp5.ejercicio4.Dato;
public class Mapa {
	private Graph<String>mapaCiudades; 
	
	
	
	public Mapa(Graph<String>mapa) {
		this.mapaCiudades= mapa;
	}
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		/*
		 Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
		pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
		 */
		List<String> caminoCiudades= new ArrayList<String>();
		boolean[]visitados= new boolean[this.mapaCiudades.getSize()]; 
	
		Dato d= this.buscar(this.mapaCiudades, ciudad1, ciudad2); 

		if ((d.getOrigen()!= null) &&(d.getDestino() != null )){
			devolverCamino(this.mapaCiudades,d.getOrigen(), d.getDestino(), visitados, caminoCiudades); 
		}
		
		
		return caminoCiudades;
		
	}
private Dato buscar (Graph<String>lugares, String origen, String destino) {
		
		Dato dato= new Dato(null, null); 
		Iterator<Vertex<String>>it= lugares.getVertices().iterator(); 
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
	public boolean devolverCamino (Graph<String> grafo,Vertex<String>origen, Vertex<String>destino, boolean[] visitados, List<String>caminoCiudades) {
		visitados[origen.getPosition()]= true; 
		boolean encontre= false; 
		caminoCiudades.add(origen.getData()); 
		if(origen == destino) {
			 encontre=true; 
		}else {
			//
		//le pido todos los ady del origen donde estoy parada
			Iterator<Edge<String>>it= grafo.getEdges(origen).iterator();
			while(it.hasNext() && !encontre) {
				Vertex<String> prox= it.next().getTarget(); 
				if (!visitados[prox.getPosition()]) {
					encontre=devolverCamino(grafo,prox, destino, visitados, caminoCiudades); 
				}
			}
		}
		if (!encontre) {
			caminoCiudades.remove(caminoCiudades.size()-1); 
		}
		
		 visitados[origen.getPosition()] = false; 
	        
		return encontre;  
		
	}
	
	public List<String>devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		/*
		 * 
		 *Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).
		 *
		 */
		List<String> caminoCiudades= new ArrayList<String>();
		if (!this.mapaCiudades.isEmpty()) {
			boolean[]visitados= new boolean[this.mapaCiudades.getSize()]; 
		
			Dato d= buscarYMarcarRestringidos(this.mapaCiudades, ciudad1, ciudad2, visitados, ciudades); 
			
			if ((d.getOrigen() != null )&& (d.getDestino() != null)){
				devolverCamino(this.mapaCiudades, d.getOrigen(), d.getDestino(), visitados, caminoCiudades);
			}
		}
		return caminoCiudades; 
	}
	private Dato buscarYMarcarRestringidos(Graph<String>grafo, String c1, String c2, boolean[]visitados, List<String>ciudades) {
		Dato d= null; 
		Iterator<Vertex<String>>it= grafo.getVertices().iterator(); 
		int cant=0; 
		while (it.hasNext()&&cant<2) {
			Vertex<String>v= it.next(); 
			String nom= v.getData(); 
			if (ciudades.contains(nom)) {
				visitados[v.getPosition()]= true; 
			}
			else {
				if (c1.equals(nom)) {
					d.setOrigen(v);cant++; 
				}else {
					if(c2.equals(nom)) {
						d.setDestino(v);cant++;
					}
				}
			}
		}
		return d; 
		
	}
	/*
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		/*
		 * Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
		 * existe camino retorna la lista vacía. (Las rutas poseen la distancia).
		 
		List<String>caminoMin= new ArrayList<String>(); 
		if (!this.mapaCiudades.isEmpty()) {

			Vertex<String>origen= this.mapaCiudades.search(ciudad1); 
			Vertex<String>destino= this.mapaCiudades.search(ciudad2); 
			
			if ((origen != null )&& (destino != null)){
				boolean sigo= true; 
				Queue<Vertex<String>>cola= new Queue<Vertex<String>>(); 
				boolean []visitados= new boolean[this.mapaCiudades.getSize()]; 
				int [] distancias= new int[this.mapaCiudades.getSize()]; 
				for (int i=0; i< distancias.length;i++) {
					distancias[i]=Integer.MAX_VALUE; 
				}
				distancias[origen.getPosition()]=0; 
				cola.enqueue(origen); 
				//recorrido por niveles?
				while (!cola.isEmpty() && sigo){
					Vertex<String>v= cola.dequeue(); 
					if (v.getData()==destino.getData()) {
						sigo =false; 
					}else {
						
					
					visitados[v.getPosition()]= true; 
					List<Edge<String>>aristas= this.mapaCiudades.getEdges(v);
					Iterator<Edge<String>> it = aristas.iterator();
					for (Edge<String>a: aristas) {
						Vertex<String>aux= a.getTarget(); 
						if (!visitados[a.getTarget().getPosition()]) {
							if ( (distancias[a.getTarget().getPosition()])> (distancias[v.getPosition()]+a.getWeight()) ) {
								distancias[a.getTarget().getPosition()]=distancias[v.getPosition()]+a.getWeight();
								
							}
						}
						
					}
					caminoMin.add(v.getData());
					cola.enqueue(this.mapaCiudades.getVertex(buscarMenor(distancias, visitados))); 
					}
				}
			}
		}
	}
	
	private int buscarMenor(int[] distancias, boolean[] visitados) {
		int pos = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<distancias.length; i++) {
			if((distancias[i]<min) &&(!visitados[i])) {
				pos = i;
				min = distancias[i];
			}
		}
		return pos;
	}    
				
				
	*/
	 public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
	        List<String> caminoMin = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[]visitados= new boolean[this.mapaCiudades.getSize()];
	            														// caminoActual
	                caminoMasCorto(origen, destino,visitados, caminoMin, new LinkedList<String>(), 0,Integer.MAX_VALUE );
	            }
	        }
	        return caminoMin;
	    }
	    
	    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, boolean[] visitados,List<String> caminoMin, List<String> caminoAct,  int total, int min) {
	        visitados[origen.getPosition()] = true;
	        caminoAct.add(origen.getData());
	        
	        if(origen == destino && total < min) {
	            //caminoMinimo.removeAll(caminoMinimo);
	            caminoMin.addAll(caminoAct);
	            min = total;
	        } else {
	            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
	            Iterator<Edge<String>> it = ady.iterator();
	            while(it.hasNext() && total < min) {
	                Edge<String> arista = it.next();
	                int pos = arista.getTarget().getPosition();
	                int aux = total + arista.getWeight();
	                if(!visitados[pos] && aux < min) {
	                    min = caminoMasCorto(arista.getTarget(), destino, visitados,caminoMin, caminoAct, aux, min);
	                }
	            }
	        }
	        visitados[origen.getPosition()] = false;
	        caminoAct.remove(caminoAct.size()-1);
	        return min; 
	    }
	    
	    
	    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	    	List<String>caminoActual= new LinkedList<String>();
	    	if (!this.mapaCiudades.isEmpty()) {
	    		Vertex<String>origen= this.mapaCiudades.search(ciudad1); 
	    		Vertex<String>destino=this.mapaCiudades.search(ciudad2); 
	    		
	    		if (origen != null && destino!= null) {
	    			boolean[] visitados= new boolean[this.mapaCiudades.getSize()];
	    			caminoSinCargarCombustible(origen, destino, visitados,caminoActual, tanqueAuto); 
	    			
	    		}
	    	}
	    	return caminoActual; 
	    	
	    }
	    private boolean caminoSinCargarCombustible (Vertex<String>ori, Vertex<String>dest, boolean[]visitados, List<String>cam, int tanque) {
	    	boolean sigo= true; 
	    	visitados[ori.getPosition()]=true; 
	    	cam.add(ori.getData()); 
	    	if (ori.getData().equals(dest.getData())&& tanque >0) {
	    		sigo = false; 
	    	}else {
	    		List<Edge<String>>aristas= this.mapaCiudades.getEdges(ori);  
	    		Iterator <Edge<String>>it= aristas.iterator(); 
	    		// ant=tanque;
	    		while (it.hasNext() && sigo) {
	    			Edge<String>a= it.next();
	    			Vertex<String>v = a.getTarget();
	    			if (!visitados[v.getPosition()] &&  (tanque- a.getWeight())>0 )  {
	    				
	    				sigo= caminoSinCargarCombustible(v, dest, visitados, cam, tanque-a.getWeight()); 
	    			}
	    		}
	    		visitados[ori.getPosition()] = false;
		        cam.remove(cam.size()-1);
		        //tanque=ant;
		        
	    		
	    	}
	    	return sigo; 
	    }
	    
	    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
	  /*  Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
	    que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
	    medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
	    retorna la lista vacía.
	   */
	    List<String>lista= new LinkedList<String>(); 
	    if (!this.mapaCiudades.isEmpty()) {
	    	Vertex <String>origen= this.mapaCiudades.search(ciudad1);
	    	Vertex <String>destino= this.mapaCiudades.search(ciudad2);
	    	int matriz[][]= int[this.mapaCiudades.getSize()][3];
	    	if (origen!= null && destino != null) {
	    		
	    	}
	    }
	    
}
	    }
	    
						
						
						
						
						
	
	
	
	

	


