package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	Usuario user; 
	Propiedad prop;
	Reserva r1; 
	Reserva r2; 
	
	@BeforeEach
	void setUp() {
		user= new Usuario("pepe", "calle 1 y 50", 1234); 
		prop= new Propiedad("12 y 54" , "depto", 10, user); 
		r1= new Reserva(user, prop, LocalDate.of(2024, 11, 16), LocalDate.of(2024, 12, 16)); 
		
	}
	@Test
	void testEstaEnElPeriodoTrue() {
		//15/11 16/11 16/12 17/12
		
		assertEquals( r1.estaEnElPeriodo(LocalDate.of(2024, 11, 16), LocalDate.of(2024, 12, 16)), true); 
	}
	@Test
	void testEstaEnElPeriodoAntes() {
		//15/11 16/11 16/12 17/12
		assertEquals( r1.estaEnElPeriodo(LocalDate.of(2024, 11, 10), LocalDate.of(2024, 11, 15)),false ); 
	}
	@Test
	void testEstaEnElPeriodoDespues() {
		//15/11 16/11 16/12 17/12
		assertEquals( r1.estaEnElPeriodo(LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 20)),false ); 
	}
	@Test 
	void  testCalularPrecioCorrecto() {
		assertEquals(r1.calcularPrecio(), 300); 
	}
	@Test 
	void  testCalularPrecioSuperior() {
		assertNotEquals(r1.calcularPrecio(), 310); 
	}
	@Test 
	void  testCalularPrecioInferior() {
		assertNotEquals(r1.calcularPrecio(), 290); 
	}
	@Test 
	void testNoDisponibleFalsoAntes() {
		assertEquals(r1.noDisponible(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 11, 15)), false); 
	}
	@Test 
	void testNoDisponibleFalsoDespues() {
		assertEquals(r1.noDisponible(LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 31)), false); 
	}
	@Test 
	void testNoDisponibleVerdadero() {
		assertEquals(r1.noDisponible(LocalDate.of(2024, 11, 16), LocalDate.of(2024, 12, 16)), true); 
	}
}
