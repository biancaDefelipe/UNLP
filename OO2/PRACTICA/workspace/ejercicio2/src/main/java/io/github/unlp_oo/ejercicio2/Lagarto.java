package io.github.unlp_oo.ejercicio2;

public class Lagarto implements Jugada{
	public Lagarto() {
		super(); 
	}
	
	@Override
	public String jugarConSpock() {
		return "Gana Lagarto"; 
	}
	@Override
	public String jugarConLagarto() {
		return "Empate"; 
	}
	@Override
	public String jugarConPapel() {
		return "Gana Lagarto"; 
	}
	@Override
	public String jugarConPiedra() {
		return "Gana Piedra"; 
	}
	@Override
	public String jugarConTijera() {
		return "Gana Tijera"; 
	}
	@Override
	public String jugarCon(Jugada otra) {
		return otra.jugarConLagarto(); 
	}
}
