package io.github.unlp_oo.ejercicio_13_patrones;

public class BuilderVegetariano extends SandwichBuilder {

	@Override 
	public void construirPan() {
		this.getSandwich().setPan("Con semillas");
		this.getSandwich().setPrecioPan(120);
	}
	
	@Override 
	public void construirPrincipal() {
		this.getSandwich().setPrincipal("Provoleta grillada");
		this.getSandwich().setPrecioPrincipal(200);
	}
	@Override 
	public void construirAderezo() {
		this.getSandwich().setAderezo("");
		this.getSandwich().setPrecioAderezo(0);
	}
	@Override 
	public void construirAdicional() {
		this.getSandwich().setAdicional("Berenjena al escabeche");
		this.getSandwich().setPrecioAdicional(100);
	}
}
