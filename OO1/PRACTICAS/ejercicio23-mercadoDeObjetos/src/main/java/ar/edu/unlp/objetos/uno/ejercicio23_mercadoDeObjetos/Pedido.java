package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class Pedido {
	private Cliente cli; 
	private int cantidadProducto; 
	private FormaPago pago; 
	private FormaEnvio envio; 
	
	
	public Pedido(Cliente cli, Producto prod, int cant, FormaEnvio envio, FormaPago pago){
		this.Cliente=cli; 
	    this.cantidadProducto=cant; 
	    this.formaPago= pago; 
	    this.formaEnvio=envio; 
	    this.total =this.calcularMontoTotal(cli, prod,cant,  prod.getVendedor,envio, pago)
	    
	    
	}


}
