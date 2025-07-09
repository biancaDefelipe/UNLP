package io.github.unlp_oo.ejercicio_20_patrones;

public class Baston implements EstrategiaArma{

	@Override
	public int enfrentarContraAcero() {
		return 1;
	}

	@Override
	public int enfrentarContraCuero() {
		return 2;
	}

	@Override
	public int enfrentarContraHierro() {
		return 1;
	}
}
