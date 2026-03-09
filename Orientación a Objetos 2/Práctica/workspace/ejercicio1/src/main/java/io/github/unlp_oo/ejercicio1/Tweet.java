package io.github.unlp_oo.ejercicio1;

public class Tweet implements Publicacion{
	private String texto;
	private Usuario usuario; 
	
	public Tweet(String texto, Usuario user) {
		super();
		this.texto = texto;
		this.usuario= user; 
	} 

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override 
	public String getTexto() {
		return this.texto; 
	}
	@Override
	public Usuario getUsuario() {
		return this.usuario; 
	}
	
}
