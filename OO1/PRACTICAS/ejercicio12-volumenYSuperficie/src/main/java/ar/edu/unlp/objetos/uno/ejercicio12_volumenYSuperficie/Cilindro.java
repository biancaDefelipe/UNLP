package ar.edu.unlp.objetos.uno.ejercicio12_volumenYSuperficie;

public class Cilindro extends Pieza{
	private int radio; 
	private int altura;
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	} 
	

	public double getVolumen() {
		//Volumen de un cilindro: π * radio^2 * h.
		return (Math.PI* Math.pow(radio, 2) * this.getAltura());
	}
	public double getSuperficie() {
		//Superficie de un cilindro: 2 * π * radio  * h + 2 * π * radio^2
		return (2* Math.PI *this.getRadio()* this.getAltura()* 2 * Math.PI * Math.pow(this.getRadio(), 2));

	}
}
