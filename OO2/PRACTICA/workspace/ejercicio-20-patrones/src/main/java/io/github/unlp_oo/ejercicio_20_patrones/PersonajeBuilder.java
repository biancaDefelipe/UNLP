package io.github.unlp_oo.ejercicio_20_patrones;

public abstract class PersonajeBuilder {
	private Personaje personaje; 
	private static final int vidaInicial=100; 
	public PersonajeBuilder () {
		this.reset(); 
	}
	public void reset() {
		this.personaje = new Personaje(); 
	}
	public void setNombre(String nom) {
		this.personaje.setNombre(nom); 
	}
	public void setVida() {
		this.personaje.setVida(this.vidaInicial); 
	}
	public abstract void setArma(); 
	
	public abstract void setArmadura(); 
	
	public abstract void setHabilidades(); 
	
	public Personaje getPersonaje() {
		return this.personaje; 
	}
	
}
