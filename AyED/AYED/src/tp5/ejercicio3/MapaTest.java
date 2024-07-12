package tp5.ejercicio3;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;
import ayed2024.src.tp5.ejercicio1.Graph;
import ayed2024.src.tp5.ejercicio1.Vertex;

class MapaTest {
	
		AdjListGraph<String> map;
		Vertex<String> c1;
		Vertex<String> c2;
		Vertex<String> c3;
		Vertex<String> c4;
		Vertex<String> c5;
		Vertex<String> c6;
		Vertex<String> c7;
		Vertex<String> c8;

		@BeforeEach
		public void setUp() throws Exception {
			map = new AdjListGraph<>();
			// Grafo inicial
			// (c1) -> c4, c2 
			// (c2) -> c5, c8, c1
			// (c3) -> c4, c6 
			// (c4) -> c3
			// (c5) -> c7, c6
			// (c6) -> c5, c7
			// (c7) ->c8, 
			// (c8) lista vacia 
		
			c1= map.createVertex("c1"); 
			c2= map.createVertex("c2");
			c3= map.createVertex("c3");
			c4= map.createVertex("c4");
			c5= map.createVertex("c5");
			c6= map.createVertex("c6");
			c7= map.createVertex("c7");
			c8= map.createVertex("c8");
			
			map.connect(c1, c4,1);
			map.connect(c1, c2,2);
			
			map.connect(c2, c5,4);
			map.connect(c2, c8,3);
			map.connect(c2, c1,2);
			
			map.connect(c3, c4,1);
			map.connect(c3, c6,12);
			
			map.connect(c4, c3,1);
			
			map.connect(c5, c7,18);
			map.connect(c5, c6,6);
	
			map.connect(c6, c5,6);
			map.connect(c6, c7,8);
			
			map.connect(c7, c8,1);
		}

	@Test
	public void testCreateAndRemoveVertex() {
		Graph<String> emptyGraph = new AdjListGraph<>();
		assertEquals(0, emptyGraph.getVertices().size());
		assertEquals(8, map.getVertices().size());
		
		assertEquals(0, c1.getPosition());
		assertEquals(1, c2.getPosition());
		assertEquals(7, c8.getPosition());

		assertEquals(2, map.getEdges(c1).size());
		assertEquals(0, map.getEdges(c8).size());

		Vertex<String> c9 = map.createVertex("c9");
		assertEquals(9, map.getVertices().size());
		assertEquals(8, c9.getPosition());
		
		map.removeVertex(c8);
		assertEquals(8, map.getVertices().size());
		assertEquals(7, c9.getPosition());
	

		map.connect(c2, c9);
		assertTrue(map.getEdges(c9).isEmpty());

	}
	public void testDevolverCamino() {
		List<String>list= new LinkedList<String>(); 
		list.add("c1"); 
		list.add("c4"); 
		list.add("c3");
		list.add("c6");
		list.add("c5");
		list.add("c7");
		
		Mapa mapObj= new Mapa(map); 
		List<String>list2=mapObj.devolverCamino("c1", "c7"); 
		assertEquals(list, list2);
		
		Vertex<String> c9 = map.createVertex("c9");
		assertEquals(9, map.getVertices().size());
		assertEquals(8, c9.getPosition());
		
		List<String>list3=mapObj.devolverCamino("c1", "c9"); 
		assertTrue(list3.isEmpty());
	}
	public void testDevolverCaminoExceptuando () {
		List<String>list= new LinkedList<String>(); 
		list.add("c1"); 
		list.add("c2"); 
		list.add("c5");
		list.add("c7"); 
		
		Mapa mapObj= new Mapa(map); 
		List<String> avoidList=new LinkedList<String>(); 
		avoidList.add("c3");
		avoidList.add("c6"); 
		
		List<String>list2= mapObj.devolverCaminoExceptuando("c1", "c7", avoidList); 
		assertEquals(list, list2); 
		
		Vertex<String> c9 = map.createVertex("c9");
		assertEquals(9, map.getVertices().size());
		assertEquals(8, c9.getPosition());
		
		List<String>list3=mapObj.devolverCamino("c1", "c9"); 
		assertTrue(list3.isEmpty());
		
		
	}
	public void testCaminoMasCorto() {
		List<String>list= new LinkedList<String>(); 
		list.add("c1"); 
		list.add("c2"); 
		list.add("c5");
		list.add("c7"); 
		Mapa mapObj= new Mapa(map); 
		
		List<String> min= mapObj.caminoMasCorto("c1", "c7"); 
		assertEquals(list, min);
		

		Vertex<String> c9 = map.createVertex("c9");
		assertEquals(9, map.getVertices().size());
		assertEquals(8, c9.getPosition());
		
		List<String>list3=mapObj.caminoMasCorto ("c1", "c9"); 
		assertTrue(list3.isEmpty());
		
		
		
	}
	public void testCaminoSinCargarCombustible() {
		List<String>list= new LinkedList<String>(); 
		list.add("c1"); 
		list.add("c2"); 
		list.add("c5");
		list.add("c6");
		list.add("c7");
	
		Mapa mapObj= new Mapa(map); 
		
		List<String> min= mapObj.caminoSinCargarCombustible("c1", "c7", 22);
		assertEquals(list, min); 
		

		Vertex<String> c9 = map.createVertex("c9");
		assertEquals(9, map.getVertices().size());
		assertEquals(8, c9.getPosition());
		map.connect(c3, c9, 70);
		
		List<String>list3=mapObj.caminoMasCorto ("c1", "c9"); 
		assertTrue(list3.isEmpty());
		
	}



}

	