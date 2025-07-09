package io.github.unlp_oo.ejercicio_13_patrones;

public class BuilderVegano extends SandwichBuilder{

	@Override 
	public void construirPan() {
		this.getSandwich().setPan("Integral");
		this.getSandwich().setPrecioPan(100);
	}
	
	@Override 
	public void construirPrincipal() {
		this.getSandwich().setPrincipal("Milanesa de girgolas");
		this.getSandwich().setPrecioPrincipal(500);
	}
	@Override 
	public void construirAderezo() {
		this.getSandwich().setAderezo("Salsa criolla");
		this.getSandwich().setPrecioAderezo(20);
	}
	@Override 
	public void construirAdicional() {
		this.getSandwich().setAdicional("");
		this.getSandwich().setPrecioAdicional(0);
	}
}
