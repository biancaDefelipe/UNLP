package io.github.unlp_oo.ejercicio2;

public class Piedra implements Jugada {
	public Piedra() {
		super(); 
	}
	
	@Override
	public String jugarConSpock() {
		return "Gana Spock"; 
	}
	@Override
	public String jugarConLagarto() {
		return "Gana Piedra"; 
	}
	@Override
	public String jugarConPapel() {
		return "Gana Papel"; 
	}
	@Override
	public String jugarConPiedra() {
		return "Empate"; 
	}
	@Override
	public String jugarConTijera() {
		return "Gana Piedra"; 
	}
	@Override
	public String jugarCon(Jugada otra) {
		return otra.jugarConPiedra(); 
	}
}
