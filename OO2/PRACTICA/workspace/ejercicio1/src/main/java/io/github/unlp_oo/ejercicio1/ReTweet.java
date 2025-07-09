package io.github.unlp_oo.ejercicio1;

public class ReTweet implements Publicacion {
	private Tweet tweetOrigen;


	public ReTweet(Tweet tweetOrigen) {
		
		this.tweetOrigen = tweetOrigen;
	} 
	
	@Override
	public String getTexto() {
		return this.tweetOrigen.getTexto(); 
	}
	
	@Override
	public Usuario getUsuario() {
		return this.tweetOrigen.getUsuario(); 
	}
	
	//public boolean esDuenio (Usuario user) {
	//	return this.getUsuario().equals(user) ? true : false; 
	//	
	//}
}
