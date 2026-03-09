package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.LocalDate;

public abstract class Servicio {
	private Mascota mascota;
	private LocalDate fecha;
	public Servicio(Mascota mascota, LocalDate fecha) {
		super();
		this.mascota = mascota;
		this.fecha = fecha;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	} 
	public abstract double calcularCosto(); 
	

	
	
}
