package io.github.unlp_oo.ejercicio2;

public class Tijera implements Jugada {
	public Tijera() {
		super(); 
	}
	
	@Override
	public String jugarConSpock() {
		return "Gana Spock"; 
	}
	@Override
	public String jugarConLagarto() {
		return "Gana Tijera"; 
	}
	@Override
	public String jugarConPapel() {
		return "Gana Tijera"; 
	}
	@Override
	public String jugarConPiedra() {
		return "Gana Piedra"; 
	}
	@Override
	public String jugarConTijera() {
		return "Empate"; 
	}
	@Override
	public String jugarCon(Jugada otra) {
		return otra.jugarConTijera();
	}
}
