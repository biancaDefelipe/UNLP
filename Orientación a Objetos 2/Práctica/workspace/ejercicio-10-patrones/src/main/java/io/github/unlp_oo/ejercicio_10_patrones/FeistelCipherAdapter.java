package io.github.unlp_oo.ejercicio_10_patrones;

public class FeistelCipherAdapter implements EstrategiaDeCifrado{
	private FeistelCipher encriptador;
	
	@Override
	public String cifrar(String mensaje) {
		this.encriptador= new FeistelCipher (mensaje); 
		return this.encriptador.encode(mensaje); 
		
	}
	
	@Override 
	public String descifrar (String mensaje) {
		 return this.encriptador.encode(mensaje); 
	}
}
