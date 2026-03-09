package io.github.unlp_oo.ejercicio_20_patrones;

import java.util.Arrays;

public class ArqueroBuilder extends PersonajeBuilder{

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Arco());
		
	}

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new Cuero());
		
	}

	@Override
	public void setHabilidades() {
		this.getPersonaje().setHabilidades(Arrays.asList("Combate cuerpo a cuerpo"));
	}

}
