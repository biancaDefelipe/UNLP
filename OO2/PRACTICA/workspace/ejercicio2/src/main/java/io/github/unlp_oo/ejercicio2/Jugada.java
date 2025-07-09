package io.github.unlp_oo.ejercicio2;

public interface Jugada {
	
	public String jugarConSpock(); 
	public String jugarConLagarto(); 
	public String jugarConPapel(); 
	public String jugarConPiedra(); 
	public String jugarConTijera(); 
	public String jugarCon(Jugada otra); 
	
}
