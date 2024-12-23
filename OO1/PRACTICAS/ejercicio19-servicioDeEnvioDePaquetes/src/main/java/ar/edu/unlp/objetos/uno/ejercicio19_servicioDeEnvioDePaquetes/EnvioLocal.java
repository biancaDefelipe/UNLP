package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioLocal extends Envio{
	private boolean entregaRapida;


	public EnvioLocal(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double pesoGramos,
			boolean entregaRapida) {
		super(fechaDespacho, dirOrigen, dirDestino, pesoGramos);
		this.entregaRapida = entregaRapida;
	}

	public boolean isEntregaRapida() {
		return entregaRapida;
	}

	public void setEntregaRapida(boolean entregaRapida) {
		this.entregaRapida = entregaRapida;
	} 
	public double costoAdicional(){
		return this.isEntregaRapida()  ? 500 : 0; 
	}
	public double costoFijo() {
		return 1000; 
	}
	@Override 
	public double costo() {
		return this.costoFijo()+ this.costoAdicional();
	}
}
