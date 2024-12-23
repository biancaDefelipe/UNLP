package ar.edu.unlp.objetos.uno.ejercicio9_CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{

	public CajaDeAhorro() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean puedeExtraer(Double monto) {
		//Las cajas de ahorro solo pueden extraer y transferir cuando cuentan con fondos suficientes
		return ((super.getSaldo()>=(monto+monto*0.02) ?true: false)); 
	}
	/*	Las extracciones, los depósitos y las transferencias desde cajas de ahorro tienen un 
	costo adicional de 2% del monto en cuestión 
	(téngalo en cuenta antes de permitir una extracción o transferencia desde caja de ahorro).
	*/
	@Override
	public void depositar(double monto) {
		super.depositar (monto-(monto*0.02));
	} 
	@Override
	protected boolean extraer (double monto) {
		return super.extraer(monto+monto*0.02);
	}
	
	@Override 
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta((monto +monto*0.02), cuentaDestino);
	}
	
}
