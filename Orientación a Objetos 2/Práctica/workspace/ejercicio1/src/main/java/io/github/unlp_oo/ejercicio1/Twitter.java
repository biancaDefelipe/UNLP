package io.github.unlp_oo.ejercicio1;

import java.util.ArrayList;

public class Twitter {
 private ArrayList<Usuario> usuarios;   
 public Twitter() {
	this.usuarios= new ArrayList<Usuario>();
	
	
		
	}
	public Usuario agregarUsuario(String name) {
		if (	this.usuarios.stream()
					.anyMatch(user -> user.soyUsuario(name))) {
		 return null; 
		}else {
					
			Usuario user= new Usuario(name); 
			this.usuarios.add(user); 
			return user; 
		}
	}
	public void eliminarUsuario(Usuario user) {
		/*Usuario user= this.usuarios.stream()
				  .filter(usuario -> usuario.soyUsuario(name))
				  .findFirst().orElse(null);*/
		Usuario u= this.usuarios.stream()
						.filter(usuario -> usuario.equals(user))
						.findFirst().orElse(null);
				
		if( user != null) {
			//le digo a todos los usuarios que eliminen retweets de user
			
						 
				
			user.eliminarTodo(); 
			this.usuarios.remove(user); 
		}
		
	}
} 
 
 
 
