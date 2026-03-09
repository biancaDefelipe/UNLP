package parcial15_6;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;
import grafos.adjList.*;
import grafos.Graph;
import grafos.Vertex;


class ParcialTest {

	AdjListGraph<Recinto> sitios;
	Vertex<Recinto> entrada;
	Vertex<Recinto> cebras;
	Vertex<Recinto> tigres;
	Vertex<Recinto> flamencos;
	Vertex<Recinto> murcielagos;
	Vertex<Recinto> wallabies;
	Vertex<Recinto> tortugas;
	Vertex<Recinto> pumas;
	
	@BeforeEach
	public void setUp() throws Exception {
		sitios = new AdjListGraph<>();
		entrada= sitios.createVertex(new Recinto ("Entrada", 15)); 
		cebras= sitios.createVertex(new Recinto("Cebras", 10)); 
		tigres= sitios.createVertex(new Recinto("Cebras", 10)); 
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
		sitios.connect(cebras, tigres, 10);
		sitios.connect(cebras, tortugas, 5);
		
		sitios.connect(tigres, entrada, 15);
		sitios.connect(tigres, cebras, 10);
		
		sitios.connect(flamencos, entrada, 25);
		sitios.connect(flamencos,murcielagos, 25);
		
		sitios.connect(murcielagos, entrada, 20);
		sitios.connect(murcielagos, flamencos, 25);
		sitios.connect(murcielagos,wallabies, 30);
		
		sitios.connect(wallabies, murcielagos, 30);
		sitios.connect(wallabies, tortugas, 10);
		
		sitios.connect(tortugas, cebras, 5);
		sitios.connect(tortugas, wallabies, 10);
		sitios.connect(tortugas, pumas, 15); 
		
		sitios.connect(pumas, tortugas, 15);

	}
	@Test
	void testResolver() {
	int tiempo1= 100; 
	Parcial p= new Parcial(); 
	assertEquals(5, p.resolver(sitios, tiempo1)); 
	


}

}
