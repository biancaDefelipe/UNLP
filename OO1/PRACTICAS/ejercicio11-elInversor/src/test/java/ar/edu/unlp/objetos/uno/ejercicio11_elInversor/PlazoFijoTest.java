package ar.edu.unlp.objetos.uno.ejercicio11_elInversor;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
class PlazoFijoTest {
	
	private PlazoFijo inv1;
	private PlazoFijo inv2;
	
	
	@BeforeEach
	void setUp()throws Exception{
		inv1 = new PlazoFijo (LocalDate.of(2024, 10, 1), 50000, 10.5);
		inv2= new PlazoFijo (LocalDate.of(2020, 9, 27), 0, 30.0);
	}
	
	@Test
	void constructorTest() {
		assertEquals(inv1.getFechaConstitucion(), (LocalDate.of(2024, 10, 1)));
		assertEquals(inv1.getMontoDepositado(), 50000); 
		assertEquals(inv1.getPorcentajeDeInteresDiario(), 10.5);   
		
	}
	@Test
	void valorActualTest() {
		fail("Not yet implemented");
	}

	

}
