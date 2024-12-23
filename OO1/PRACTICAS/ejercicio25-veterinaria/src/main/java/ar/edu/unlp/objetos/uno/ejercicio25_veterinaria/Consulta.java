package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;

import java.time.LocalDate;

public class Consulta extends ServicioMedico{

	public Consulta(Mascota mascota, LocalDate fecha, Veterinario veterinario) {
		super(mascota, fecha, veterinario);
		// TODO Auto-generated constructor stub
	}
	@Override 
	public double calcularCosto(){
		return super.getVeterinario().getPrecioHonorarios()+ this.adicionalMateriales()+ this.getVeterinario().adicionalPorAntiguedad();
	 

	}
	@Override
	public double adicionalMateriales(){
	return 300 ;
	}
}
