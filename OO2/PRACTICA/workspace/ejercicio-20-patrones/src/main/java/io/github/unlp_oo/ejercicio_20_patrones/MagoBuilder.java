package io.github.unlp_oo.ejercicio_20_patrones;

import java.util.Arrays;

public class MagoBuilder extends PersonajeBuilder {
	
	public MagoBuilder() {
		super(); 
	}
	
	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Baston());
		
		
	}

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new Cuero());
	}

	@Override
	public void setHabilidades() {
		this.getPersonaje().setHabilidades(Arrays.asList("Magia", "Combate a distancia"));
		
	}

}
