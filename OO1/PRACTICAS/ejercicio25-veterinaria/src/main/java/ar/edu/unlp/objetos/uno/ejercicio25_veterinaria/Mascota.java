package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Mascota {
	private String nombre; 
	private LocalDate fechaNacimiento; 
	private String especie;
	private List<Servicio>servicios; 
	
	public Mascota(String nombre, LocalDate fechaNacimiento, String especie) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.especie = especie;
		this.servicios= new ArrayList<Servicio>(); 
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	} 
	
	public List<Servicio>getServicios(){
		return this.servicios; 
	}
	public Consulta añadirServicioConsulta(Veterinario vete){
		Consulta c= new Consulta (this,LocalDate.now(), vete); 
	    this.getServicios().add(c); 
	    return c; 
	}
	
	public Vacunacion añadirServicioVacuna (Veterinario vete, String nom, double costo){
		Vacunacion v= new Vacunacion  (this,LocalDate.now(), vete,  nom, costo); 
	    this.getServicios().add(v); 
	    return v; 
	}
	public Guarderia añadirServicioGuarderia (int cant){
		Guarderia g= new Guarderia (this, LocalDate.now(), cant); 
	    this.servicios.add(g); 
	    return g; 
	}
	public double recaudacion(LocalDate fecha){
		return this.getServicios()
				.stream().filter(s -> s.getFecha().equals(fecha))
				.mapToDouble(s-> s.calcularCosto()).sum(); 

	}
	public double  getDescuento() {
		if( this.getServicios().size() <5) {
			return 0.1; 
		}return 0; 
	}


	
	
}


