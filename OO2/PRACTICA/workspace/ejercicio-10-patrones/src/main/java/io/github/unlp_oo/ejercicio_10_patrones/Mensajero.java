package io.github.unlp_oo.ejercicio_10_patrones;

public class Mensajero {
	private EstrategiaDeCifrado estrategia; 
	
	public Mensajero() {
		super(); 
	}

	public EstrategiaDeCifrado getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaDeCifrado estrategia) {
		this.estrategia = estrategia;
	}
	
	public void enviarMensaje(String mensaje) {
		String mensajeEncriptado = this.estrategia.cifrar(mensaje);
		//Envia el mensaje.
	}
	
	public void recibirMensaje(String mensaje) {
		String mensajeOriginal = this.estrategia.descifrar(mensaje);
		//Hace lo que quiere con el mensaje original. 
	}
}
