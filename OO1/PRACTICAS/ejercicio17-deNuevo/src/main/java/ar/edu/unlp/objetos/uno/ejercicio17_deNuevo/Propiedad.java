package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;
import java.time.LocalDate; 
import java.util.List;
import java.util.ArrayList;

public class Propiedad {
	private String direccion; 
	private String nombreDescriptivo; 
	private double precioPorNoche;
	private Usuario usuario; 
	private List <Reserva>reservas; 
	public Propiedad(String direccion, String nombreDescriptivo, double precioPorNoche, Usuario usuario) {
		super();
		this.direccion = direccion;
		this.nombreDescriptivo = nombreDescriptivo;
		this.precioPorNoche = precioPorNoche;
		this.usuario=usuario; 
		this.reservas= new ArrayList<Reserva>(); 
	}
	public String getDireccion() {
		return direccion;
	}

	public String getNombreDescriptivo() {
		return nombreDescriptivo;
	}
	public void setNombreDescriptivo(String nombreDescriptivo) {
		this.nombreDescriptivo = nombreDescriptivo;
	}
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	private boolean noDisponible (LocalDate ini, LocalDate fin){
		return this.getReservas().stream()
						.anyMatch(r-> r.noDisponible(ini,  fin)); 
	                    
	}
	public boolean reservar(Usuario usuario, LocalDate ini, LocalDate fin){
		if (!this.noDisponible(ini, fin)){
	    	Reserva r= new Reserva(usuario, this, ini,fin); 
	        this.getReservas().add(r); 
	        return true; 
		}
	    return false;        
	}
	public void disponibilizar (Reserva r){
		this.getReservas().remove(r); 
	}  				  
	public double calcularIngresos(LocalDate ini, LocalDate fin){
		return this.getReservas().stream()
	    						  .filter(r -> r.estaEnElPeriodo(ini, fin))
	                              .mapToDouble(r-> r.calcularPrecio())
	                              .sum(); 
	}


	      
	
	
	
	
}
