package io.github.unlp_oo.ejercicio_10_patrones;

public class RC4Adapter implements EstrategiaDeCifrado{
	private RC4 encriptador; 
	private String key;
	
	public RC4Adapter(String key) {
		this.encriptador = new RC4();
		this.key = key;
	}
	
	@Override
	public String cifrar(String mensaje) {
		return this.encriptador.encriptar(mensaje, this.key);
	}

	@Override
	public String descifrar(String mensaje) {
		return this.encriptador.desencriptar(mensaje, this.key);
	}

}
