package io.github.unlp_oo.daFecha2023;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TareaTest {
	private TareaSimple simple1; 
	private TareaSimple simple2; 
	private TareaSimple simple3; 
	private TareaCompleja compleja1; 
	private TareaCompleja compleja2; 
	
	@BeforeEach
	public void setUp() {
		simple1= new TareaSimple("desc1", "tarea1", 10.0); 
		simple2= new TareaSimple("desc2", "tarea2", 8.0); 
		simple3= new TareaSimple("desc3", "tarea3", 4.0); 
		compleja1= new TareaCompleja("descCompleja1"); 
		compleja2= new TareaCompleja("descCompleja2"); 
	}
	
	@Test
	void EstimacionTotalConTareasTest() {
		compleja2.addChild(simple3); // estimacion compleja2= 4.0
		
		compleja1.addChild(simple1); 	//estimacion compleja1= 10.0
		compleja1.addChild(compleja2);	//estimacion compleja1= 14.0 (10.0+ 4.0)
		compleja1.addChild(simple2);	//estimacion compleja1= 22.0 (14.0 + 8.0)
		compleja1.addChild(simple3);	//estimacion compleja1= 26.0 (22.0 + 4.0)
		
		assertEquals(compleja1.estimacionTotal(), 26.0); 
		assertEquals(compleja2.estimacionTotal(), 4.0); 
		assertEquals(simple1.estimacionTotal(), 10.0); 
	}
	
	@Test
	void EstimacionTotalSinTareasTest() {
		assertEquals(compleja1.estimacionTotal(), 0.0); 
	}
	
	@Test
	void TiempoUtilizadoConTareasCompletadas() {
		simple1.iniciar(); simple1.completar();
		compleja1.addChild(simple1);
		compleja1.addChild(simple2);
		System.out.println( "en el tiempo con tareas " + simple1.tiempoUtilizadoEnUnaTarea());
		System.out.println( "en el tiempo con tareas " + compleja1.tiempoUtilizadoEnUnaTarea());
		assertTrue(simple1.tiempoUtilizadoEnUnaTarea()>0.0); //no puedo testear el valor exacto porque es un instante desconocido
		assertTrue(compleja1.tiempoUtilizadoEnUnaTarea() >0.0);	
	}

	@Test
	void TiempoUtilizadoSinTareasCompletadas() {
		simple1.iniciar();
		compleja1.addChild(simple1);
		//System.out.print("imprimo" + compleja1.tiempoUtilizadoEnUnaTarea());
		assertFalse(simple1.tiempoUtilizadoEnUnaTarea()>0.0); 
		assertFalse(compleja1.tiempoUtilizadoEnUnaTarea()>0.0); 
	}
}
