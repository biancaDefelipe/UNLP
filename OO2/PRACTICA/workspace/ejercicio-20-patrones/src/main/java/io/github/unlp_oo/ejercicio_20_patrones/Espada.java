package io.github.unlp_oo.ejercicio_20_patrones;

public class Espada implements EstrategiaArma{

	@Override
	public int enfrentarContraAcero() {
		return 3;
	}

	@Override
	public int enfrentarContraCuero() {
		return 8;
	}

	@Override
	public int enfrentarContraHierro() {
		return 5;
	}

	
}
