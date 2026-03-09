package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Balanza {
	private int cantidadDeProductos; 
	private double precioTotal; 
	private double pesoTotal;
	
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
