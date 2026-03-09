package io.github.unlp_oo.ejercicio_20_patrones;

import java.util.List;

public class Personaje {
	private String nombre; 
	private EstrategiaArma arma; 
	private EstrategiaArmadura armadura; 
	private int vida; 
	private List<String>habilidades; 
	
	
	public Personaje() {
		super(); 
	}
	public void setNombre(String nombre) {
		this.nombre= nombre; 
	}
	public void setArma(EstrategiaArma arma) {
		this.arma=arma; 
	}
	public void setArmadura(EstrategiaArmadura armadura) {
		this.armadura=armadura; 
	}
	public void setVida (int vida) {
		this.vida=vida; 
	}
	public void setHabilidades (List<String>habilidades) {
		this.habilidades= habilidades; 
	}
	
	public void enfrentar(Personaje rival) {
		if (this.tengoVida() && rival.tengoVida()) {
			rival.recibirDaño(this.arma); 
		}if(rival.tengoVida()) {
			this.recibirDaño(rival.getArma());
		}
	}
	
	private boolean tengoVida() {
		return this.vida>0; 
	}
	private void recibirDaño(EstrategiaArma arma) {
		int daño = this.armadura.recibirDaño(arma);
		this.vida= Math.max(this.vida-daño, 0);  //para asegurarme que no quede negativo 
		
	}
	public EstrategiaArma getArma() {
		return this.arma; 
	}
	public String getNombre() {
		return nombre;
	}
	public EstrategiaArmadura getArmadura() {
		return armadura;
	}
	public int getVida() {
		return vida;
	}
	public List<String> getHabilidades() {
		return habilidades;
	}
	
}
