package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioInterUrbano extends Envio implements CalculadoraCostoGramos {
	private double distanciaKm;

	public EnvioInterUrbano(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double pesoGramos,
			double distanciaKm) {
		super(fechaDespacho, dirOrigen, dirDestino, pesoGramos);
		this.distanciaKm = distanciaKm;
	} 
	
	
	public double getDistanciaKm() {
		return distanciaKm;
	}

	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}


	public double costoDistancia(){
		double km= this.getDistanciaKm(); 
	    if (km < 100 ) {return 20; }
	    if (km <=500) {return 25; }
	    return 30; 
	}
	public double costoGramos(double gramos){
		double costoKm= this.costoDistancia(); 
	    return gramos*costoDistancia(); 
	}
	@Override 
	public double costo(){
		return  this.costoGramos(this.getPesoGramos()); 
	}

}
