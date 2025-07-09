package io.github.unlp_oo.ejercicio2;

public class Spock implements Jugada{
	public Spock() {
		super(); 
	}
	
	@Override
	public String jugarConSpock() {
		return "Empate"; 
	}
	@Override
	public String jugarConLagarto() {
		return "Gana Lagarto"; 
	}
	@Override
	public String jugarConPapel() {
		return "Gana Papel"; 
	}
	@Override
	public String jugarConPiedra() {
		return "Gana Spock"; 
	}
	@Override
	public String jugarConTijera() {
		return "Gana Spock"; 
	}
	@Override
	public String jugarCon(Jugada otra) {
		return otra.jugarConSpock();
	}
}
