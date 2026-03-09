package ar.edu.unlp.objetos.uno.ejercicio5_FigurasYCuerpos;

public class Cuadrado extends Figura2D{
	private double  lado;

	public Cuadrado(int lado) {
		super();
		this.lado = lado;
	}

	public Cuadrado() {
		super();
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	} 
	
	
	public double getPerimetro() {
		return this.getLado()*4; //consultar 
	}
	public double getArea() {
		return (Math.pow(this.getLado(), 2)); 
	}
}
