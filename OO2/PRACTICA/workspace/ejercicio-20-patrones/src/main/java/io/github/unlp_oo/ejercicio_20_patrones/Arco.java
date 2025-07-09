package io.github.unlp_oo.ejercicio_20_patrones;

public class Arco implements EstrategiaArma{

	@Override
	public int enfrentarContraAcero() {
		return 2;
	}

	@Override
	public int enfrentarContraCuero() {
		return 5;
	}

	@Override
	public int enfrentarContraHierro() {
		return 3;
	}
}
