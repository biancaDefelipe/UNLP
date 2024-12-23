package ar.edu.unlp.objetos.uno.ejercicio12_volumenYSuperficie;

public class PrismaRectangular extends Pieza {
	private int ladoMayor;
	private int ladoMenor; 
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	public int getLadoMayor() {
		return ladoMayor;
	}
	public void setLadoMayor(int ladoMator) {
		this.ladoMayor = ladoMator;
	}
	public int getLadoMenor() {
		return ladoMenor;
	}
	public void setLadoMenor(int ladoMenor) {
		this.ladoMenor = ladoMenor;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	} 
	
	
	public double getVolumen() {
		//Volumen del prisma: ladoMayor * ladoMenor * altura
		return (this.getLadoMayor()*this.getLadoMenor()*this.getAltura());

	}
	public double getSuperficie() {
		//Superficie del prisma: 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura)
		return (2 * (this.getLadoMayor()*this.getLadoMenor()+this.getLadoMayor()*this.getAltura()+this.ladoMenor*this.getAltura()));
	}
}
