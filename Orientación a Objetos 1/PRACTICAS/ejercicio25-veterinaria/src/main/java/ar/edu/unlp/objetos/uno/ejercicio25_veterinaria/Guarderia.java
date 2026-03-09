package ar.edu.unlp.objetos.uno.ejercicio25_veterinaria;
import java.time.LocalDate;
import java.util.Date;


public class Guarderia extends Servicio {
	private int cantDias;
	public Guarderia(Mascota mascota, LocalDate fecha, int cantDias) {
		super(mascota, fecha);
		this.cantDias = cantDias;
	}


	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	} 
	
	/// para implementar 
	
	@Override 
	public double calcularCosto(){
		double total=this.getCantDias()*500; 
		return total - this.getMascota().getDescuento()*total; 
	 }
	
}
