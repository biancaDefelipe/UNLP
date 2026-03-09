package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
public class Usuario {
	private String nombre; 
	private String direccion; 
	private int dni;
	private List<Propiedad>propiedades; 
	public Usuario(String nombre, String direccion, int dni) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades=new ArrayList<Propiedad>(); 
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getDni() {
		return dni;
	}
	
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	public double calcualrIngresos(LocalDate ini, LocalDate fin){
		double tot= this.getPropiedades().stream()
	    								.mapToDouble(p-> p.calcularIngresos(ini, fin))
	                                    .sum(); 
	    return tot*0.75; 
	}                                 
	    						
	
	
}
