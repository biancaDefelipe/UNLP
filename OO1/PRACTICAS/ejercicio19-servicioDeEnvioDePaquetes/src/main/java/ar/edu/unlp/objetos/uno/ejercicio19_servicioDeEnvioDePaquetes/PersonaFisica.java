package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public class PersonaFisica extends Cliente{
	private int dni;

	public PersonaFisica(String nombre, String direccion, int dni) {
		super(nombre, direccion);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	} 
	@Override 
	public double montoEnvios(LocalDate ini, LocalDate fin){
		double subTot= this.getEnvios().stream()
	    						.filter(e-> e.estaEnElPeriodo(ini, fin))
	                            .mapToDouble(e-> e.costo() - e.costo()*0.1)
	                            .sum();
	      
	     return subTot; 
	}



}
