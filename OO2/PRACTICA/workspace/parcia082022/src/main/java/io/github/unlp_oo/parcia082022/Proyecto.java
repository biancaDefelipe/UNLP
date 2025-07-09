package io.github.unlp_oo.parcia082022;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Proyecto {
	private LocalDate fechaInicio; 
	private LocalDate fechaFin; 
	private String objetivo; 
	private String nombre; 
	private double margenGanancia; 
	private int numeroIntegrantes; 
	private double montoIntegrante;
	private Etapa etapa; 
	
	
	public Proyecto(LocalDate fechaInicio, LocalDate fechaFin, String ojetivo, String nombre, int numeroIntegrantes,
		double montoIntegrante) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.objetivo = ojetivo;
		this.nombre = nombre;
		this.numeroIntegrantes = numeroIntegrantes;
		this.montoIntegrante = montoIntegrante;
		this.margenGanancia=0.07; 
		this.etapa= new EnConstruccion();
	} 
	

	//preguntar lo de protected
	public  double costoProyecto() {
		long dias= ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
		int precioPersonal= this.numeroIntegrantes* (int)dias; 
		return this.montoIntegrante* (double)precioPersonal; 
	}
	
	public double precioProyecto() {
		return this.costoProyecto() * this.margenGanancia; 
	}
	
	public void aprobarEtapa() {
		this.etapa.aprobarEtapa(this, this.precioProyecto()); 
	}
	
	public void cambiarEtapa(Etapa etapa) {
		this.etapa= etapa; 
	}
	
	public void verificiarModificacionDeMargen(double margenNuevo) {
		this.etapa.modificarMargenDeGanacia(this, this.margenGanancia, margenNuevo); 
	}
	public void cambiarMargenDeGanancia(double margenNuevo) {
		this.margenGanancia= margenNuevo; 
	}
	public void cambiarObjetivo() {
		this.objetivo += "Cancelado"; 
	}
}
