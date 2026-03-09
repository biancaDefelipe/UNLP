package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Veterinario {
	private String nombre; 
	private LocalDate fechaIngreso; 
	private double precioHonorarios;
	public Veterinario(String nombre, LocalDate fechaIngreso, double precioHonorarios) {
		super();
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.precioHonorarios = precioHonorarios;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public double getPrecioHonorarios() {
		return precioHonorarios;
	}
	public void setPrecioHonorarios(double precioHonorarios) {
		this.precioHonorarios = precioHonorarios;
	} 
	
	private int getAntguedad() {
		//int anos = Period.between(fechaInicio, fechaFin).getYears();
		long cant = ChronoUnit.YEARS.between(this.getFechaIngreso(), LocalDate.now());
		return (int)cant; 
	}
	public double adicionalPorAntiguedad() {
		return this.getAntguedad()*100; 
	}
	
}
