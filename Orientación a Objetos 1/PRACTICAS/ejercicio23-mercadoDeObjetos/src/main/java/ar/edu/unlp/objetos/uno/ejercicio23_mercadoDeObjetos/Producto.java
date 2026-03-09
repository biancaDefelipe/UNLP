package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class Producto {
	private String nombre; 
	private double precio; 
	private int unidadesDisp; 
	private String categoria; 
	private Vendedor vendedor;
	public Producto(String nombre, double precio, int unidadesDisp, String categoria, Vendedor vendedor) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.unidadesDisp = unidadesDisp;
		this.categoria = categoria;
		this.vendedor = vendedor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getUnidadesDisp() {
		return unidadesDisp;
	}
	public void setUnidadesDisp(int unidadesDisp) {
		this.unidadesDisp = unidadesDisp;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	} 
	
	public boolean haySuficienteStock(Integer cant){
		return (this.getUnidadesDisp()>=cant ? true : false); 
	}
	public void descontarUnidades(Integer cant){
		this.unidadesDisp -= cant; 
	}
	public double calcularPrecioPorCantidad(int cant){
		return this.getPrecio() * cant; 
	    
	}
}
