package io.github.unlp_oo.ejercicio_13_patrones;

public class SubteWay {
	private SandwichBuilder builder;

	public SubteWay () {
		super(); 
	}
	public SubteWay(SandwichBuilder builder) {
		super();
		this.builder = builder;
	}

	public SandwichBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(SandwichBuilder builder) {
		this.builder = builder;
	} 
	public Sandwich construirSandwich() {
		this.builder.reset();
		this.builder.construirPan();
		this.builder.construirAderezo();
		this.builder.construirPrincipal();
		this.builder.construirAdicional();
		
		return this.builder.getSandwich(); 
	}
	

	
	
}
