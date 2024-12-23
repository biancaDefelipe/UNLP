package ar.edu.unlp.objetos.uno.ejercicio17;

import java.util.List;
import java.util.ArrayList;
public class Propiedad {

	private String direccion; 
	private String nombre;
	private double precioPorNoche;
	private List<Reserva>alquileres;
	public Propiedad(String direccion, String nombre, double precioPorNoche) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.alquileres = new ArrayList<Reserva>();
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	public List<Reserva> getAlquileres() {
		return alquileres;
	}

	
	
	
	public Reserva estaDisponible (DateLapse periodo) {
		//si ninguna reserva retorna true en el overlaps entonces el nonematch es true y estaDisponible es true
		if ( this.alquileres.stream().noneMatch(reserva -> reserva.overlaps(periodo))) {
			Reserva r= new Reserva (periodo, this);
			return r;
		}
		return null; 
	}
	
	

		
	//public boolean existeIngresanteAntesDe(int anio){
	//	  return alumnos.stream()   
	//	 .anyMatch(alumno->alumno.getAnioIngreso()<anio);
	//	}
}
