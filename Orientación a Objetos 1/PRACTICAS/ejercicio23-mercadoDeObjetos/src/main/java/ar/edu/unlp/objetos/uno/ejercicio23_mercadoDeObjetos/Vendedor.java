package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;
import java.util.List;
import java.util.ArrayList;

public class Vendedor extends Persona {
	private List<Producto>productos;

	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new ArrayList<Producto>(); 
	} 
	
	public void agregarProducto(String nombre, double precio, int unidadesDisp, String categoria) {
		this.productos.add(new Producto (nombre, precio, unidadesDisp, categoria, this)); 
	}
	public List<Producto>getProductos(){
		return this.productos; 
		
	}
	
}
