package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class PagoContado implements FormaPago {

	
	public PagoContado() {
		
	}
	@Override
	public double precioFinal(double precioProducto){
		return precioProducto; 
		}
}
