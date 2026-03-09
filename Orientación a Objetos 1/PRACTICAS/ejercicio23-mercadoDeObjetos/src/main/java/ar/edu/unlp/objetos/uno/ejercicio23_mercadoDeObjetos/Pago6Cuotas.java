package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class Pago6Cuotas implements FormaPago {

	public Pago6Cuotas() {
		super(); 
	}
	public double precioFinal(double precioProducto){
		return precioProducto *1.20; 
		}
}
