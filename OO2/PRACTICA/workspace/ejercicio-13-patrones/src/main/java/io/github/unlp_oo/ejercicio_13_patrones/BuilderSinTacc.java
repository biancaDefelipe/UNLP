package io.github.unlp_oo.ejercicio_13_patrones;

public class BuilderSinTacc extends SandwichBuilder{

	@Override 
	public void construirPan() {
		this.getSandwich().setPan("Pan de chipá");
		this.getSandwich().setPrecioPan(150);
	}
	
	@Override 
	public void construirPrincipal() {
		this.getSandwich().setPrincipal("Carne de pollo");
		this.getSandwich().setPrecioPrincipal(250);
	}
	@Override 
	public void construirAderezo() {
		this.getSandwich().setAderezo("Salsa tartara");
		this.getSandwich().setPrecioAderezo(18);
	}
	@Override 
	public void construirAdicional() {
		this.getSandwich().setAdicional("Verduras grilladas");
		this.getSandwich().setPrecioAdicional(200);
	}
}
