package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
 
import org.junit.jupiter.api.BeforeEach;
class EmpleadoTest {

	
	private Empleado emp1; 
	private Empleado empSinContratoVigente; 
	
	private Empleado emp4Anios; 
	private Empleado emp5Anios; 
	private Empleado emp10Anios; 
	private Empleado emp15Anio; 
	private Empleado emp20Anios; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.emp1= new Empleado("pepe", "perez", 1234, LocalDate.of(1980, 10, 10), true, false);
		this.emp1.añadirContratoPorHoras(LocalDate.of(2010, 2, 2), 100, 120, LocalDate.of(2012, 2, 2));
		this.emp1.añadirContratoPorHoras(LocalDate.of(2012, 5, 5), 1000, 120, LocalDate.of(2013, 5, 5));
		this.emp1.añadirContratoDePlanta(LocalDate.of(2013, 12, 9), 1000000, 100000, 300000);
		
		this.empSinContratoVigente= new Empleado ("pedro", "juarez", 4321, LocalDate.of(1964, 9, 9), true, true);
		this.empSinContratoVigente.añadirContratoPorHoras(LocalDate.of(2010, 2, 2), 100, 120, LocalDate.of(2012, 2, 2));
		this.empSinContratoVigente.añadirContratoPorHoras(LocalDate.of(2012, 5, 5), 1000, 120, LocalDate.of(2013, 5, 5));
		
		
		
		this.emp4Anios= new Empleado("lola", "lopez", 2345, LocalDate.of(2004, 11, 11), false, false); 
		this.emp4Anios.añadirContratoPorHoras(LocalDate.of(2020, 11, 11), 10000, 120, LocalDate.of(2024, 11, 11));
		
		
		this.emp5Anios= new Empleado("juan", "gonzalez", 5434, LocalDate.of(1984, 12, 12), false, true); 
		this.emp5Anios.añadirContratoPorHoras(LocalDate.of(2019, 10, 10), 100, 120, LocalDate.of(2024,12,12));
		
		this.emp10Anios= new Empleado ("andrea", "perez", 2345, LocalDate.of(1974, 5, 5), true, true);
		this.emp10Anios.añadirContratoDePlanta(LocalDate.of(2014, 2, 2),7000000, 1000000, 2000000);
		
		
		this.emp15Anio= new Empleado ("sol", "lopez", 2323, LocalDate.of(1984, 12, 11), true, true); 
		
		
		
		this.emp20Anios= new Empleado ("Roberto", "Rodriguez",1111, LocalDate.of(1974, 7, 7), false, true); 
		
		
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
