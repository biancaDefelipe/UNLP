package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;
import java.util.List;
import java.util.ArrayList;

public class Cliente extends Persona {
	private List<Pedido>pedidos;

	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new ArrayList<Pedido>(); 
	}

	public void agregarPedido(Producto prod, int cant, FormaEnvio envio, FormaPago pago){
		if (prod.haySuficienteStock(cant){
	    	this.pedidos.add(new Pedido (this, prod, cant, envio, pago); 
	        prod.descontarUnidades(cant); 
	    }
	}
	
	
	
	
}


