package io.github.unlp_oo.ejercicio_20_patrones;

public class Cuero implements EstrategiaArmadura {

	@Override
	public int recibirDaño(EstrategiaArma arma) {
		// TODO Auto-generated method stub
		return arma.enfrentarContraCuero(); 
	}

}
