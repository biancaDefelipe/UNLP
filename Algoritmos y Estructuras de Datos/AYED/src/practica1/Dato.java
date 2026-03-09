package practica1;

public class Dato {
	private int max;
	private int min;
	private double prom;
	public Dato(int max, int min, double prom) {
		this.max = max;
		this.min = min;
		this.prom = prom;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public double getProm() {
		return prom;
	}
	public void setProm(double prom) {
		this.prom = prom;
	}
	public Dato() {
		super();
	} 
	
	public void calcular(int[]numeros) {
		double total=0; 
		int min=99999; 
		int max=0; 
		for (int i=0; i <numeros.length; i++) {
			if (numeros[i]> max) {
				this.max= numeros[i]; 
				max= numeros[i]; 
			}
			if (numeros[i]<min) {
				this.min= numeros[i]; 
				min= numeros[i];
			}
			total= total+ numeros[i]; 
		}
		this.prom= (total/ numeros.length); 
		
	}
	
}
