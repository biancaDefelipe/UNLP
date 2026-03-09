package ar.edu.unlp.objetos.uno.ejercicio5_FigurasYCuerpos;

public class Cuerpo3D {
	private Figura2D caraBasal; 
	private double altura;
	
	
	
	public Cuerpo3D(Figura2D caraBasal, double altura) {
		super();
		this.caraBasal = caraBasal;
		this.altura = altura;
	}

	

	public Cuerpo3D() {
		super();
	}



	public Figura2D getCaraBasal() {
		return caraBasal;
	}



	public void setCaraBasal(Figura2D caraBasal) {
		this.caraBasal = caraBasal;
	}
	public double getSuperficieExterior() {
//		El área o superficie exterior de un cuerpo es: 
//	2* área-cara-basal + perímetro-cara-basal * altura-del-cuerpo
	return (2*this.getCaraBasal().getArea() + this.caraBasal.getPerimetro()* this.getAltura());

	}

	public double getVolumen() {
		//El volumen de un cuerpo es: área-cara-basal * altura
		return (this.getCaraBasal().getArea()*this.getAltura()); 
	}
	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	
}
