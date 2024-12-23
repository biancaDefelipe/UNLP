package ar.edu.unlp.objetos.uno.ejercicio5_FigurasYCuerpos;

public class Circulo extends Figura2D{
	private double radio;

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	public Circulo() {
		super();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	} 
	
	public double getDiametro() {
		return (this.getRadio()*2);
	}
	public void setDiametro(double diametro) {
		this.setRadio(diametro/2);
	}
	public double getPerimetro() {
		return (Math.PI* this.getDiametro()); 
	}
	public double getArea() {
		return (Math.PI*(Math.pow(this.getRadio(), 2))); 
	}
}
