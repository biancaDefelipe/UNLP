package io.github.unlp_oo.ejercicio_14_patrones;

public abstract class Prenda {


	public Prenda( ) {
		super(); 
	}

	public abstract double  getLiquidez(); 
	
	public abstract double valor(); 
	public double valorPrendario() {
		return this.valor()*this.getLiquidez(); 
	}
	public abstract void addChild(Prenda prenda); 
	public abstract void removeChild(Prenda prenda); 
	
}
