package ar.edu.unlp.objetos.uno.ejercicio8_MethodLookup;

public class Empleado {
	private String nombre;

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	} 
	
	public double aportes() {
		return 13500; 
	}
	public double montoBasico() {
		return 35000; 
	}
	public double sueldoBasico() {
		return this.montoBasico()+ this.aportes();
	}
}
