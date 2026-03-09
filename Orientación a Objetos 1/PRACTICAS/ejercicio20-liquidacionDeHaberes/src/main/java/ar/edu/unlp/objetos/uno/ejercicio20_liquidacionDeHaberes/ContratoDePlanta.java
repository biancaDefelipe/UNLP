package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato {
	private double sueldoMensual;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoDePlanta(LocalDate fechaInicio, Empleado emp, double sueldoMensual, double montoConyuge, double montoHijos) {
		super(fechaInicio, emp);
		this.sueldoMensual = sueldoMensual;
		this.montoConyuge = montoConyuge;
		this.montoHijos = montoHijos;
	}
	public double getSueldoMensual() {
		return sueldoMensual;
	}
	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	public double getMontoConyuge() {
		return montoConyuge;
	}
	public void setMontoConyuge(double montoConyuge) {
		this.montoConyuge = montoConyuge;
	}
	public double getMontoHijos() {
		return montoHijos;
	}
	public void setMontoHijos(double montoHijos) {
		this.montoHijos = montoHijos;
	} 
	
	
	@Override
	public boolean estaVigente() {
		return true; 
	}
	@Override 
	public double montoBasico() {
		double base=this.sueldoMensual; 
		if (this.getEmpleado().getCantHijos() ){
			base+=this.getMontoHijos(); 
		}
		if (this.getEmpleado().getConyuge()) {
			base+=this.getMontoConyuge(); 
		}
		return base; 	
				
	}
	
	@Override
	public int getAntiguedad() {
		return (int)this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS); 
				
				
	}
	
}
