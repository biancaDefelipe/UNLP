package io.github.unlp_oo.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	private String screenName; 
	private ArrayList<Publicacion> publicaciones;
	
	public Usuario(String screenName) {
		this.screenName = screenName;
		this.publicaciones = new ArrayList<>(); 
		
	} 
	
	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Tweet agregarTweet(String texto) {
		if (texto.length()<= 280 && texto.length()>=1) {
			 return this.publicarTweet(texto); 
		}
		return null; 
	}
	
	private Tweet publicarTweet(String texto) {
		Tweet tweet= new Tweet (texto); 
		this.publicaciones.add(tweet); 
		return tweet; 
	}
	public ReTweet agregarReTweet(Tweet tweet) {
		ReTweet rt= new ReTweet (tweet); 
		this.publicaciones.add(rt); 
		return rt; 
		
	
	}
	public boolean soyUsuario( String name) {
		return this.screenName.equals(name); 
	}
	public void eliminarTodo() {
		this.publicaciones.stream();
			
		this.publicaciones.clear(); 
	}
	
	
	public void eliminarReTweets(Usuario user) {
		this.publicaciones.forEach(pu-> pu.getUsuario().equals(user));
		
		//List <Publicacion>publis = this.publicaciones.stream()
		//				  .filter(pu-> pu.getUsuario().equals(user))
		//				  .collect(Collectors.toList()); 
		
		for (Publicacion pu: publicaciones) {
			if (pu.getUsuario().equals(user)) {
				this.publicaciones.remove(pu); 
			}
		}
						
	}
	
	
}
