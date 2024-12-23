package ar.edu.unlp.objetos.uno.ejercicio9_CuentaConGanchos;

public class CuentaCorriente extends Cuenta {
	private double limiteDeDescubierto; 
	
	
	public CuentaCorriente() {
		super();
		this.limiteDeDescubierto = 0;
	}
	public double getLimiteDeDescubierto() {
		return limiteDeDescubierto;
	}


	public void setLimiteDeDescubierto(double limiteDeDescubierto) {
		this.limiteDeDescubierto = limiteDeDescubierto;
	}
	

	/*
	Las cuentas corrientes pueden extraer aún cuando el saldo de la cuenta sea insuficiente.
    Sin embargo, no deben superar cierto límite por debajo del saldo.
	Dicho límite se conoce como límite de descubierto 
	(algo así como el máximo saldo negativo permitido).
	Ese límite es diferente para cada cuenta (lo negocia el cliente con la gente del banco). 
	Cuando se abre una cuenta corriente, 
	su límite descubierto es 0 (no olvide definir el constructor por default).
	*/
	@Override
	protected boolean puedeExtraer(Double monto) {
		// TODO Auto-generated method stub
		if (this.getSaldo()+ monto>= monto ) {
			return true; 
		}return false;
	}

}
