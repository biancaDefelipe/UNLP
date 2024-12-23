package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class Empresa extends Cliente {
	private int cuit;

	public Empresa(String nombre, String direccion, int cuit) {
		super(nombre, direccion);
		this.cuit = cuit;
	}

	@Override 
	public double montoEnvios(LocalDate ini, LocalDate fin){
		double subTot= this.getEnvios().stream()
	    						.filter(e-> e.estaEnElPeriodo(ini, fin))
	                            .mapToDouble(e-> e.costo() )
	                            .sum();
	      
	     return subTot; 
	}
}
