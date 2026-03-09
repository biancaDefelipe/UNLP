package io.github.unlp_oo.parcia082022;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectoTest {
	Proyecto proyecto0Dias; 
	Proyecto proyecto1Dia; 
	Proyecto proyecto0Integrantes; 
	Proyecto proyecto1Integrante; 
	
	Proyecto proyectoVacaciones; 
	
	@BeforeEach
	void setUp() {

	proyecto0Dias = new Proyecto (LocalDate.of(2025,10, 10), LocalDate.of(2025, 10, 10), "Objetivo del proyecto 1", "Proyectito1", 2, 10);
	proyecto1Dia = new Proyecto (LocalDate.of(2025,10, 10), LocalDate.of(2025, 10, 11), "Objetivo del proyecto 2 ", "Proyectito 2", 2, 10);
	proyecto0Integrantes = new Proyecto (LocalDate.of(2025,10, 10), LocalDate.of(2025, 10, 12), "Objetivo del proyecto 3 ", "Proyectito 3", 0, 10);
	proyecto1Integrante = new Proyecto (LocalDate.of(2025,10, 10), LocalDate.of(2025, 10, 12), "Objetivo del proyecto 4 ", "Proyectito 4", 1, 10);
	
	proyectoVacaciones= new Proyecto (LocalDate.of(2025,10, 10), LocalDate.of(2025, 10, 12), "Salir con amigos", "Proyectito <con amigos", 3, 10);
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
