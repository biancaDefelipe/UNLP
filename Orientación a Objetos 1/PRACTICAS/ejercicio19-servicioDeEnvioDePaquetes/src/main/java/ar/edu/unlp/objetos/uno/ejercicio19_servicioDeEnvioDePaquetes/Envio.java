package ar.edu.unlp.objetos.uno.ejercicio19_servicioDeEnvioDePaquetes;

import java.time.LocalDate;

public abstract class Envio {
	private LocalDate fechaDespacho; 
	private String dirOrigen; 
	private String dirDestino; 
	private double pesoGramos;
	public Envio(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double pesoGramos) {
		super();
		this.fechaDespacho = fechaDespacho;
		this.dirOrigen = dirOrigen;
		this.dirDestino = dirDestino;
		this.pesoGramos = pesoGramos;
	}
	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}
	public void setFechaDespacho(LocalDate fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}
	public String getDirOrigen() {
		return dirOrigen;
	}
	public void setDirOrigen(String dirOrigen) {
		this.dirOrigen = dirOrigen;
	}
	public String getDirDestino() {
		return dirDestino;
	}
	public void setDirDestino(String dirDestino) {
		this.dirDestino = dirDestino;
	}
	public double getPesoGramos() {
		return pesoGramos;
	}
	public void setPesoGramos(double pesoGramos) {
		this.pesoGramos = pesoGramos;
	}
	public boolean estaEnElPeriodo(LocalDate ini, LocalDate fin){
		return ( (this.getFechaDespacho().isAfter(ini) || this.getFechaDespacho().isEqual(ini)) &&
	    		(this.getFechaDespacho().isBefore(fin) || this.getFechaDespacho().isEqual(fin)) ); 
	}
	public abstract double  costo(); 
	
	
}
