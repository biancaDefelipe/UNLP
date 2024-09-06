package ar.edu.unlp.info.oo1.ejercicio3_Presupuesto;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public class Presupuesto {
	private LocalDate fecha; 
	private String cliente; 
	private List <Item>items;
	
	public Presupuesto(String cliente) {
		super();
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new ArrayList<Item>();
	} 
	public void agregarItem(Item item) {
		this.items.add(item); 
	}
	public double calcularTotal() {
		return (this.items.stream().mapToDouble(i-> i.costo()).sum()); 
	}
	
}
