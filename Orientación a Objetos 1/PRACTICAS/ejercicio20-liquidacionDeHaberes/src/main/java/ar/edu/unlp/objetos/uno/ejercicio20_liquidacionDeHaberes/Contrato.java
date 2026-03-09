package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio; 
	private Empleado empleado; 
	public Contrato(LocalDate fechaInicio, Empleado emp) {
		super();
		this.empleado=emp; 
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Empleado getEmpleado() {
		return this.empleado; 
	}

	public abstract boolean estaVigente();
	public abstract double montoBasico(); 
	
	public abstract int getAntiguedad(); 
	
	
	
	
}
