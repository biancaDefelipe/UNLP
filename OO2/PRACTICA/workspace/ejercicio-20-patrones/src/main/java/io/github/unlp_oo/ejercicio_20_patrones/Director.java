package io.github.unlp_oo.ejercicio_20_patrones;

public class Director {
	private PersonajeBuilder builder;

	public Director(PersonajeBuilder builder) {
		super();
		this.builder = builder;
	} 
	public Personaje build (String nombre) {
		this.builder.reset(); 
		this.builder.setNombre(nombre); 
		this.builder.setArma(); 
		this.builder.setArmadura(); 
		this.builder.setHabilidades(); 
		this.builder.setVida(); 
		return this.builder.getPersonaje(); 
	}
	
	public void setBuilder(PersonajeBuilder builder) {
		this.builder=builder; 
		
	}
	
}
