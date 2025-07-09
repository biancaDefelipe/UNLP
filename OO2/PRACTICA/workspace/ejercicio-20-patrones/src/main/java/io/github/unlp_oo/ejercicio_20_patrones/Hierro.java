package io.github.unlp_oo.ejercicio_20_patrones;

public class Hierro implements EstrategiaArmadura {

	@Override
	public int recibirDaño(EstrategiaArma arma) {
		// TODO Auto-generated method stub
		return arma.enfrentarContraHierro(); 
	}

}
