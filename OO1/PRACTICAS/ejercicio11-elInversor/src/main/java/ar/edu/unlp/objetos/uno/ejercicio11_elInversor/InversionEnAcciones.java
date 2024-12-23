package ar.edu.unlp.objetos.uno.ejercicio11_elInversor;

public class InversionEnAcciones {
	private String nombre; 
	private int cantidad; 
	private double valorUnitario;
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}
	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public double valorActual() {
		return this.getCantidad()*this.getValorUnitario();
	}
	
	
}
