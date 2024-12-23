package ar.edu.unlp.objetos.uno.ejercicio9_CuentaConGanchos;
//test: transferencia, depositar, descubierto
public abstract class Cuenta {
	private double saldo;

	public Cuenta() {
		super();
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double saldo) {
		this.saldo += saldo;
	} 
	public void extrarSinControlar(double monto) {
		this.saldo-=monto; 
	}
	protected boolean extraer (double monto) {
		if (this.puedeExtraer(monto)) {
			this.extrarSinControlar(monto);
			return true; 
		}
		return false; 
	}
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extrarSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true; 
		}
		return false;
	}
	protected abstract boolean puedeExtraer(Double monto); 
	
	
}
