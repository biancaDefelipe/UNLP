package ar.edu.unlp.info.oo1.ejercicio3_Presupuesto;

public class Item {
	private String detalle; 
	private int cantidad; 
	private double costoUnitario;
	
	
	public Item(String detalle, int cantidad, double costoUnitario) {
		super();
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	} 
	
	public double costo () {
		return (this.cantidad * this.costoUnitario); 
	}
	
	
}
