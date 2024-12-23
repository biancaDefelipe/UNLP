package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class ServicioMedico extends Servicio  {
	public Veterinario veterinario;

	public ServicioMedico(Mascota mascota, LocalDate fecha, Veterinario veterinario) {
		super(mascota, fecha);
		this.veterinario = veterinario;
	} 
	
	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	protected double adicionalDomingo() {
		return this.getFecha().getDayOfWeek()== DayOfWeek.SUNDAY ? 200: 0; 
		
	}
	public abstract double adicionalMateriales() ; 
	
	
}
