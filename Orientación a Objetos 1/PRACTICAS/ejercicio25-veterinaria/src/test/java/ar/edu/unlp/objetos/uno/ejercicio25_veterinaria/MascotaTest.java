package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MascotaTest {
	Mascota mascotaConServicios; 
	Veterinario vete;
	Vacunacion v1; 
	Consulta c1; 
	Guarderia g1; 
	@BeforeEach 
	void setUp() {
		mascotaConServicios= new Mascota("lolo", LocalDate.of(2010, 10, 10), "Labrador");  	
		vete= new Veterinario("jose", LocalDate.of(2022, 10, 10), 12000);
		
		v1= mascotaConServicios.añadirServicioVacuna(vete, "rabia", 12000); 
		c1= mascotaConServicios.añadirServicioConsulta(vete); 
		g1= mascotaConServicios.añadirServicioGuarderia(5);  
		
	}
	
	@Test
	void añadirServicioVacunaTest() {
		
		Vacunacion v=mascotaConServicios.añadirServicioVacuna(vete, "vacuna 1", 7000); 
		assertEquals(mascotaConServicios.getServicios().size(), 4); 
	}
	
	@Test
	void añadirServicioConsultaTest() {
		//Veterinario vete, String nom, double costo
		Consulta c= mascotaConServicios.añadirServicioConsulta(vete); 
		assertNotNull(c); 
		assertEquals(mascotaConServicios.getServicios().size(), 4); 
	}
	
	@Test
	void añadirServicioGuarderiaTest() {
		//Veterinario vete, String nom, double costo
		Guarderia g= mascotaConServicios.añadirServicioGuarderia(3); 
		assertNotNull(g); 
		assertEquals(mascotaConServicios.getServicios().size(), 4);	
	}
	@Test
	void voidGetDescuentoTest(){
		
	}
	@Test
	void recaudacionTest() {
		
		//CostoVacuna de la rabia 12000+500+0+12000=24500
		//CostoConsulta 12000+300+0+2*100=12500
		//CostoGuarderia 5*500=2500
		double total1= mascotaConServicios.recaudacion(LocalDate.now()); 
		assertEquals(total1, 39500); 
		

	
	}

}
