package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;
import java.time.LocalDate;
public class Reserva {
	private DateLapse periodo; 
	private Usuario ususario; 
	private Propiedad propiedad;
	
	
	public Reserva(Usuario ususario, Propiedad propiedad, LocalDate ini, LocalDate fin) {
		super();
		this.ususario = ususario;
		this.propiedad = propiedad;
		this.periodo= new DateLapse(ini, fin);
	}


	public DateLapse getPeriodo() {
		return periodo;
	}


	public void setPeriodo(DateLapse periodo) {
		this.periodo = periodo;
	}


	public Usuario getUsusario() {
		return ususario;
	}


	public void setUsusario(Usuario ususario) {
		this.ususario = ususario;
	}


	public Propiedad getPropiedad() {
		return propiedad;
	}


	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	} 
	
	public boolean noDisponible (LocalDate ini, LocalDate fin ){	
		return this.periodo.overlaps(new DateLapse(ini, fin)); 
	}
	public double calcularPrecio(){
		return this.getPeriodo().sizeInDays()* this.getPropiedad().getPrecioPorNoche();
	   }
	   
	public boolean cancelar(){
		if (this.getPeriodo().includesDate(LocalDate.now())){
			return false; 
		}else{
	     	this.getPropiedad().disponibilizar(this);
	      	return true; 
	        
	    }
	}
	public boolean estaEnElPeriodo(LocalDate ini, LocalDate fin){
		return (this.getPeriodo().includesDate(ini) && this.getPeriodo().includesDate(fin)) ? true : false; 
	    
	    
	}
	    

	
	
	
	
}
