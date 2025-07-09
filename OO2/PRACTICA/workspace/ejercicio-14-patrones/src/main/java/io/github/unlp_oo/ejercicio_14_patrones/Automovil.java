package io.github.unlp_oo.ejercicio_14_patrones;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil extends Prenda{
	private LocalDate modelo;
	private double kilometraje; 
	private double costo0km; 
	

	public Automovil( LocalDate modelo, double kilometraje, double costo0km) {
		super();
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo0km = costo0km;
	}

	@Override
	public double valor() {
		// TODO Auto-generated method stub
		return this.costo0km *(0.1 *this.getAntiguedad());
	}

	public int getAntiguedad() {
		return (int) ChronoUnit.YEARS.between(modelo, LocalDate.now()) ;
	}

	@Override
	public double getLiquidez() {
		// TODO Auto-generated method stub
		return 0.7;
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
