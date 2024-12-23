package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DateLapse implements DateLapseInterface{

	private LocalDate from; 
	private LocalDate to; 
	
	public DateLapse(LocalDate from, LocalDate to) {
		super();
		this.from = from;
		this.to = to;
	}
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
		
		
		return  (other.isAfter(this.getFrom()) || this.getFrom().isEqual(other)) 
			&& (other.isBefore(this.getTo())   || this.getTo().isEqual(other) )? true : false; 
		
	}
	public boolean overlaps(DateLapse other){
		return (this.includesDate(other.getFrom()) || (this.includesDate(other.getTo())) ? true : false); 
	}
		
}	

