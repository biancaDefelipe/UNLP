package ar.edu.unlp.objetos.uno.ejercicio12_volumenYSuperficie;

public class Esfera extends Pieza {
	private int radio;

	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	public double getVolumen() {
		//Volumen de una esfera: ⁴⁄₃ * π * radio ³
		return (4/3 * Math.PI * Math.pow(this.getRadio(), 3)); 
	}
	public double getSuperficie() {
		//Superficie de una esfera: 4 * π * radio^2
		return (4 * Math.PI * Math.pow(this.getRadio(), 2)); 
	}
}
