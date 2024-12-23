package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	Usuario user; 
	Propiedad prop;
	Reserva r1; 
	Reserva r2; 
	Reserva r3; 
	
	@BeforeEach
	void setUp() {
		user= new Usuario("pepe", "calle 1 y 50", 1234); 
		prop= new Propiedad("12 y 54" , "depto", 10, user); 
		r1= new Reserva(user, prop, LocalDate.of(2024, 11, 16), LocalDate.of(2024, 12, 16)); 
		r2= new Reserva(user, prop, LocalDate.of(2024, 10, 15), LocalDate.of(2024, 11, 15));
		r3= new Reserva(user, prop, LocalDate.of(2024, 9, 14), LocalDate.of(2024, 10, 14)); 
		
	}
	//testear el metodo no disponible?
	//reservar
	//disponibilizar
	//calcular ingresos
	//7@Test
	//void testNoDisponible() {
	//	assertEquals (prop.noDisponible(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 11, 15)), true); 
	//}
	@Test 
	void testReservarExitoso() {
		assertEquals(prop.reservar(user, LocalDate.of(2024, 10, 15), LocalDate.of(2024, 11, 15)), false);
	}
	@Test
	void testDisponibilizarExisteReserva(){
		prop.disponibilizar(r1);
		prop.getReservas().contains(r1); 
	}
	@Test
	void testDisponibilizarNoExisteReserva(){
		Reserva r5= new Reserva(user, prop, LocalDate.of(2024, 11, 16), LocalDate.of(2024, 12, 16)); 
		prop.disponibilizar(r5);
		prop.getReservas().contains(r1); 
	}

}
