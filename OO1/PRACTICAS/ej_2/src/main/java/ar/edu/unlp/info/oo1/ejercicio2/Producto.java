package ar.edu.unlp.info.oo1.ejercicio2;

public class Producto {
	private double peso; 
	private double precioPorKilo;
	private String descripcion; 
	
	
	public double getPrecio() {
		return this.peso * this.precioPorKilo; 
	}
	
	public void setPrecioPorKilo (double precioPorKilo) {
		this.precioPorKilo= precioPorKilo;
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
