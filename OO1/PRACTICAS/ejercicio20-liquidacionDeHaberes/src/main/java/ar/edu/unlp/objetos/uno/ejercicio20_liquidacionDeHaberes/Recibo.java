package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;
import java.time.LocalDate;

public class Recibo {
	private Empleado empleado; 
	private int antiguedad; 
	private LocalDate fecha;
	private double monto;
	public Recibo(Empleado empleado, int antiguedad, double monto) {
		super();
		this.empleado = empleado;
		this.antiguedad = antiguedad;
		this.fecha = LocalDate.now();
		this.monto = monto;
	} 

	
	

}
