package io.github.unlp_oo.ejercicio_14_patrones;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler  extends Prenda{
	private LocalDate comienzo; 
	private LocalDate  fin; 
	private double mensual;
	
	public Alquiler(LocalDate comienzo, LocalDate fin, double mensual) {
		super();
		this.comienzo = comienzo;
		this.fin = fin;
		this.mensual = mensual;
	}
	@Override
	public double getLiquidez() {
		// TODO Auto-generated method stub
		return 0.9;
	}
	@Override
	public double valor() {
		// TODO Auto-generated method stub
		return this.mensual* (double)this.mesesRestantes();
	} 
	public int mesesRestantes() {
		return (int) ChronoUnit.MONTHS.between(fin, comienzo); 
	}
	@Override
	public void addChild(Prenda prenda) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeChild(Prenda prenda) {
		// TODO Auto-generated method stub
		
	}
	
	
}
