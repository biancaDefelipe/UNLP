package io.github.unlp_oo.parcicial3raFecha2022;

public class Etiqueta implements Componente {
	private String texto; 
	private String estilo; 
	
	public Etiqueta(String texto, String estilo) {
		super();
		this.texto = texto;
		this.estilo = estilo;
	}
	

	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getEstilo() {
		return estilo;
	}


	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	@Override
	public String imprimir() {
		return "<etiqueta" + "estilo= "+this.estilo + "/>" + this.texto + "</etiqueta>"; 
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo config) {
		this.estilo=config.getEstiloEtiqueta();
	}
}
