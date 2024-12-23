package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class EnvioInternacional extends Envio implements CalculadoraCostoGramos{

	public EnvioInternacional(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double pesoGramos) {
		super(fechaDespacho, dirOrigen, dirDestino, pesoGramos);
		// TODO Auto-generated constructor stub
	}
	private double costoDestino(){
		return 5000; 
	}
	public double costoGramos(double gramos){
		
	    if (gramos <=1000){
	    	return 10*gramos; 
	     }
	     return 12*gramos; 
	}
	@Override
	public double costo() {
	return this.costoDestino() + costoGramos(this.getPesoGramos()); 
	}

}
