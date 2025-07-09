package io.github.unlp_oo.ejercicio_14_patrones;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrendaTest {
	
	private Alquiler alquilerEnCurso; 
	private Alquiler alquilerFinalizaHoy; 
	private Alquiler alquilerFinalizaAyer; 
	private Automovil automovilNuevo; 
	private Automovil automovilViejo;
	private Inmueble inmueblePrecio0; 
	private Inmueble inmueblePrecio1000; 
	private Combinada combinada; 
	
	@BeforeEach
	public void setUp() {
		alquilerEnCurso= new Alquiler(LocalDate.now().minusMonths(3), LocalDate.now().plusMonths(2), 1000); 
		alquilerFinalizaHoy= new Alquiler(LocalDate.now().minusMonths(5), LocalDate.now(), 1000 ); 
		alquilerFinalizaAyer = new Alquiler(LocalDate.now().minusMonths(6), LocalDate.now().minusDays(1), 1000); 
		
		automovilNuevo= new Automovil(LocalDate.now().minusMonths(2), 10.0, 100000); 
		automovilViejo= new Automovil(LocalDate.now().minusYears(2) , 1000.0, 100000); 
		
		inmueblePrecio0= new Inmueble("La Plata", 20.0, 0); 
		inmueblePrecio1000 = new Inmueble ("La Plata", 20.0, 1000); 
		
		combinada = new Combinada(); 
		
	}
	
	@Test
	void valorDeAlquilerEnCursoTest() {
		assertEquals(alquilerEnCurso.valor(), 2000.0); 
	}
	
	@Test
	void valorDeALquilerFinalizaHoy() {
		assertEquals(alquilerFinalizaHoy.valor(), 0.0); 
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
