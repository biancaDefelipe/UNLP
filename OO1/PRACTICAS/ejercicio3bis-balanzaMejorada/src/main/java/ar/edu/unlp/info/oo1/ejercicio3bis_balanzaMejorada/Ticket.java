package ar.edu.unlp.info.oo1.ejercicio3bis_balanzaMejorada;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {
	private LocalDate fecha;  
	private int cantidadDeProductos ; 
	private double pesoTotal; 
	private double precioTotal;
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal) {
		super();
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	} 
	
	public double impuesto() {
		//el  impuesto es un 21% del precio total
		return (this.precioTotal += this.precioTotal*0.21); 
	}
}
