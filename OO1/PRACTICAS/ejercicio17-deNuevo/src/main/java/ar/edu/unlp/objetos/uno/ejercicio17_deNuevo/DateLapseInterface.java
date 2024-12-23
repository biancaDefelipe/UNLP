package ar.edu.unlp.objetos.uno.ejercicio17_deNuevo;

import java.time.LocalDate;

public interface DateLapseInterface {
	public int sizeInDays(); 
	public boolean includesDate(LocalDate other); 
	public boolean overlaps(DateLapse other); 
}