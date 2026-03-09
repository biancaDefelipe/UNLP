package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;
import java.util.List;

public abstract class Cliente {
	private String nombre; 
	private String direccion; 
	private List<Envio> envios;
	public Cliente(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	} 
	
	public List<Envio> getEnvios() {
		return envios;
	}

	

	public abstract double montoEnvios(LocalDate inicio, LocalDate fin); 
	
	
}
