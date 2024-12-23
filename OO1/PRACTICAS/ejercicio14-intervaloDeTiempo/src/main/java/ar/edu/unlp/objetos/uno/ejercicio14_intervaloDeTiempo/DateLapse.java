package ar.edu.unlp.objetos.uno.ejercicio14_intervaloDeTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DateLapse {
	private LocalDate from; 
	private LocalDate to; 
	
	public LocalDate getFrom() {
	//“Retorna la fecha de inicio del rango”
		return this.from; 
	}
	public LocalDate getTo() {
	//“Retorna la fecha de fin del rango”
		return this.to; 
	}
	public int sizeInDays() {
	//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		return (int) (this.getFrom().until(this.getTo(), ChronoUnit.DAYS)); 
	}
	public boolean includesDate(LocalDate other) {
	//“recibe un objeto LocalDate y retorna true si la fecha está entre 
	//el from y el to del receptor y false en caso contrario”.
		return  (other.isAfter(this.getFrom()) && other.isBefore(this.getTo()) )? true : false; 
		
}	
}
