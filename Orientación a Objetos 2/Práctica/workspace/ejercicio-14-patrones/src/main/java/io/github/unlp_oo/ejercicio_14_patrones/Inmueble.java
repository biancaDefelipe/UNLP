package io.github.unlp_oo.ejercicio_14_patrones;

public class Inmueble extends Prenda {
	private String direccion; 
	private double superficie; 
	private double costoMetros2; 
	
	
	
	public Inmueble(String direccion, double superficie, double metros2) {
		super();
		this.direccion = direccion;
		this.superficie = superficie;
		this.costoMetros2 = metros2;
	}

	@Override
	public double getLiquidez() {
		// TODO Auto-generated method stub
		return 0.2;
	}

	@Override
	public double valor() {
		// TODO Auto-generated method stub
		return this.superficie* this.costoMetros2;
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
