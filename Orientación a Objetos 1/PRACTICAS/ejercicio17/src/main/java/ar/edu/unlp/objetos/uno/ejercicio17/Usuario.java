package ar.edu.unlp.objetos.uno.ejercicio17;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre; 
	private int dni; 
	private String direccion;
	private List<Reserva>reservas; 
	//private List<Reserva>alquileres; 
	private List<Propiedad>propiedades; 
	
	public Usuario(String nombre, int dni, String direccion) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		
		this.propiedades= new ArrayList<Propiedad>(); 
		this.reservas= new ArrayList<Reserva>(); 
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}


	public List<Reserva> getAlquileres() {
		return alquileres;
	}


	public List<Propiedad> getPropiedades() {
		return propiedades;
	}


	public void agregarPropiedad(Propiedad prop) {
		this.propiedades.add(prop);
	}
	public boolean crearReserva(Propiedad prop, DateLapse periodo) {
		if (prop.estaDisponible(periodo)) {
			
		}
	}
	
	
	
	
	
}
