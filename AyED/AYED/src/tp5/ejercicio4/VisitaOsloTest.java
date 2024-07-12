package tp5.ejercicio4;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ayed2024.src.tp5.ejercicio1.Graph;
import ayed2024.src.tp5.ejercicio1.Vertex;
import ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;

class VisitaOsloTest {
	AdjListGraph<String> lugares;
	Vertex<String> ayuntamiento;
	Vertex<String> elTigre;
	Vertex<String> museoMunich;
	Vertex<String> parqueBotanico;
	Vertex<String> galeriaNacional;
	Vertex<String> parqueVigeland;
	Vertex<String> folkMuseum;
	Vertex<String> museoFram;
	Vertex<String> museoDelBarcoPolar;
	Vertex<String> museoVikingo;
	Vertex<String>fortalezaAkershus; 
	Vertex<String>laOpera; 
	Vertex<String>akkerBrigge; 
	Vertex<String>palacioReal; 
	Vertex<String>holmenkollen; 
	
	@BeforeEach
	public void setUp() throws Exception {
		lugares = new AdjListGraph<>();
		// Grafo inicial
		// (ayuntamiento) -> elTigre,parqueBotanico, palacioReal, akkerBrigge
		// (elTigre) ->laOpera, ayuntamiento, museoMunich
		// (museoMunich) -> elTigre, parqueBotanico
		// (parqueBotanico) -> ayuntamiento, museoMunich, galeriaNacional
		// (galeriaNacional) -> parqueBotanico, parqueVigeland
		// (parqueVigeland) -> holmenkollen, folkMuseum, galeriaNacional
		// (folkMuseum) -> parqueVigeland, palacioReal, akkerBrigge, museoFram
		// (museoFram)  -> museoDelBarcoPolar, folkMuseum
		// (museoDelBarcoPolar)-> museoVikingo, museoFram
		// (museoVikingo)-> akkerBrigge, museoDelBarcoPolar
		// (fortalezaAkershus)-> laOpera
		// (laOpera)-> fortalezaAkershus, elTigre
		// (akkerBrigge)->museoVikingo, folMuseum, ayuntamiento
		// (palacioReal)->folkMuseum, ayuntamiento
		// (holmenkollen)->parqueVigeland
		
		ayuntamiento= lugares.createVertex("Ayuntamiento"); 
		elTigre= lugares.createVertex("El Tigre"); 
		museoMunich= lugares.createVertex("Museo Munich"); 
		parqueBotanico= lugares.createVertex("Parque Botanico");
		galeriaNacional= lugares.createVertex("Galeria Nacional");
		parqueVigeland= lugares.createVertex("Parque Vigeland");
		folkMuseum= lugares.createVertex("Folk Museum");
		museoFram= lugares.createVertex("Museo Fram");
		museoDelBarcoPolar=lugares.createVertex("Museo del Barco Polar");
		museoVikingo= lugares.createVertex("Museo Vikingo"); 
		fortalezaAkershus= lugares.createVertex("Fortaleza Akershus"); 
		laOpera= lugares.createVertex("La Opera"); 
		akkerBrigge= lugares.createVertex("Akker Brigge"); 
		palacioReal= lugares.createVertex("Palacio Real"); 
		holmenkollen= lugares.createVertex("Holmenkollen"); 
		
	
		lugares.connect(ayuntamiento, elTigre,15);
		lugares.connect(ayuntamiento, parqueBotanico,10);
		lugares.connect(ayuntamiento, palacioReal, 5);
		lugares.connect(ayuntamiento, akkerBrigge,20);
		
		lugares.connect(elTigre, laOpera,5);
		lugares.connect(elTigre, ayuntamiento, 15);
		lugares.connect(elTigre, museoMunich, 15);
		
		lugares.connect(museoMunich, elTigre, 15);
		lugares.connect(museoMunich, parqueBotanico,1);
		
		lugares.connect(parqueBotanico, ayuntamiento,10);
		lugares.connect(parqueBotanico, museoMunich, 1);
		lugares.connect(parqueBotanico, galeriaNacional, 15);
		
		lugares.connect(galeriaNacional, parqueBotanico,15);
		lugares.connect(galeriaNacional, parqueVigeland, 10);
		
		lugares.connect(parqueVigeland, holmenkollen, 30);
		lugares.connect(parqueVigeland, folkMuseum, 20);
		lugares.connect(parqueVigeland, galeriaNacional, 10);
		
		lugares.connect(folkMuseum, parqueVigeland, 20);
		lugares.connect(folkMuseum, palacioReal, 5);
		lugares.connect(folkMuseum, akkerBrigge,30);
		lugares.connect(folkMuseum, museoFram, 5);
		
		lugares.connect(museoFram, museoDelBarcoPolar,5);
		lugares.connect(museoFram, folkMuseum,5);
		
		lugares.connect(museoDelBarcoPolar, museoVikingo, 5);
		lugares.connect(museoDelBarcoPolar, museoFram,5);
		
	
		lugares.connect(museoVikingo, akkerBrigge,30);
		lugares.connect(museoVikingo, museoDelBarcoPolar, 5);
		
		lugares.connect(fortalezaAkershus, laOpera,10);
		
		lugares.connect(laOpera, fortalezaAkershus, 10);
		lugares.connect(laOpera, elTigre, 5);
		
		lugares.connect(akkerBrigge, museoVikingo, 30);
		lugares.connect(akkerBrigge, folkMuseum,30);
		lugares.connect(akkerBrigge, ayuntamiento, 20);
		
		lugares.connect(palacioReal, folkMuseum, 5);
		lugares.connect(palacioReal, ayuntamiento,5);
		
		lugares.connect(holmenkollen, parqueVigeland, 30);
		
		
	}
	@Test

	public void test1() {
		Graph<String> emptyGraph = new AdjListGraph<>();
		assertEquals(0, emptyGraph.getVertices().size());
		assertEquals(15, lugares.getVertices().size());
		
		assertEquals(0, ayuntamiento.getPosition());
		assertEquals(4, galeriaNacional.getPosition());
		assertEquals(14, holmenkollen.getPosition());

		assertEquals(4, lugares.getEdges(ayuntamiento).size());
		assertEquals(1, lugares.getEdges(fortalezaAkershus).size());



	}
	public void testPaseoEnBici() {
		VisitaOslo vO= new VisitaOslo(); 
		LinkedList<String>lista= new LinkedList<String>(); 
		//Ayuntamiento, El Tigre, Museo Munch, Parque Botánico, Galería Nacional, Parque Vigeland, 
		//FolkMuseum, Museo Fram, Museo del Barco Polar, Museo Vikingo. El recorrido se hace en 91 minutos.
		lista.add("Ayuntamiendto"); 
		lista.add("El Tigre"); 
		lista.add("Museo Munch"); 
		lista.add("Parque Botanico"); 
		lista.add("Galeria Nacional"); 
		lista.add("Parque Vigeland"); 
		lista.add("Folk Museum"); 
		lista.add("Museo Fram"); 
		lista.add("Museo del Barco Polar"); 
		lista.add("Museo Vikingo"); 
	
		LinkedList<String>restringidos = new LinkedList<String>(); 
		restringidos.add("Palacio Real"); restringidos.add("Akker Brigge"); 
		List<String>res= vO.paseoEnBici(lugares, "Museo Vikingo", 120, restringidos); 
		assertEquals(10, res.size());
		assertTrue(res.contains("El Tigre")); 
		assertTrue(res.containsAll(lista)); 
		assertFalse(res.containsAll(restringidos)); 
		
	
	}

}
