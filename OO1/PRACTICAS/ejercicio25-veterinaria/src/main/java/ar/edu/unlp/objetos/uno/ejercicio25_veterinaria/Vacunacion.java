package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.LocalDate;

public class Vacunacion extends ServicioMedico {
	private String nombreVacuna; 
	private double costoVacuna;
	
	public Vacunacion(Mascota mascota, LocalDate fecha, Veterinario veterinario, String nombreVacuna,
			double costoVacuna) {
		super(mascota, fecha, veterinario);
		this.nombreVacuna = nombreVacuna;
		this.costoVacuna = costoVacuna;
	}
	public String getNombreVacuna() {
		return nombreVacuna;
	}
	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}
	public double getCostoVacuna() {
		return costoVacuna;
	}
	public void setCostoVacuna(double costoVacuna) {
		this.costoVacuna = costoVacuna;
	} 
	
	@Override
	public double adicionalMateriales() {
		return 500; 
	}
	@Override
	public double calcularCosto() {
		return super.getVeterinario().getPrecioHonorarios()+this.adicionalMateriales() + this.adicionalDomingo() + this.getCostoVacuna(); 
	}
}
