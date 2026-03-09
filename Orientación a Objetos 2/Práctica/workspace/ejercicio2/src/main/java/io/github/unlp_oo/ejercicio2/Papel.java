package io.github.unlp_oo.ejercicio2;

public class Papel implements Jugada{
	public Papel() {
		super(); 
	}
	
	@Override
	public String jugarConSpock() {
		return "Gana Papel"; 
	}
	@Override
	public String jugarConLagarto() {
		return "Gana Lagarto"; 
	}
	@Override
	public String jugarConPapel() {
		return "Empate"; 
	}
	@Override
	public String jugarConPiedra() {
		return "Gana Papel"; 
	}
	@Override
	public String jugarConTijera() {
		return "Gana Tijera"; 
	}
	@Override
	public String jugarCon(Jugada otra) {
		return otra.jugarConPapel();
	}
}
