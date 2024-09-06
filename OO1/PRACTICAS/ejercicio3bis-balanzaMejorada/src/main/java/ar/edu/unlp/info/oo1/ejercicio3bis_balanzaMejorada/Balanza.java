package ar.edu.unlp.info.oo1.ejercicio3bis_balanzaMejorada;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
	private int cantidadDeProductos; 
	private double precioTotal; 
	private double pesoTotal;
	private List<Producto>productos; 
	public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
		super();
		this.cantidadDeProductos = cantidadDeProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
	} 
	
	
	public void ponerEnCero() {
		this.cantidadDeProductos=0;
		this.precioTotal=0; 
		this.pesoTotal=0; 
		this.productos.clear();
	}
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++; 
		this.precioTotal+= producto.getPrecio(); 
		this.pesoTotal+=producto.getPeso(); 
	}
	public Ticket emitirTicket() {
		return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal); 
		
	}
}
