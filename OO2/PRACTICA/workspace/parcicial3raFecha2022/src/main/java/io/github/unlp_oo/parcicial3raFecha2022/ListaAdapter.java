package io.github.unlp_oo.parcicial3raFecha2022;

public class ListaAdapter implements Componente {
	private Lista lista;
	@Override
	public String imprimir() {
		return this.lista.print(); 
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo config) {
		this.lista.setStyle(config.getEstiloEtiqueta()); 
		
	}

}
