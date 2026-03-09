package io.github.unlp_oo.parcicial3raFecha2022;

public class Boton implements Componente{
	private String estilo; 
	private String texto;
	private String referencia; 
	
	public Boton(String estilo, String texto) {
		super();
		this.estilo = estilo;
		this.texto = texto;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	} 
	
	@Override 
	public void aplicarEstilo(ConfiguracionEstilo config) {
		this.estilo= config.getEstiloBoton(); 
	}
	@Override
	public String imprimir() {
		return "<boton" + "estilo= "+this.estilo + " texto= "+ this.texto + " accion= " + this.referencia + "/>"; 
	}
}
