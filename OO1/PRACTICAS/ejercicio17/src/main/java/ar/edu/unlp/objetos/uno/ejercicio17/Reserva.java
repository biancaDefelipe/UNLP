package ar.edu.unlp.objetos.uno.ejercicio17;

public class Reserva {
	private DateLapse periodo; 
	private Propiedad propiedad;
	
	
	public Reserva(DateLapse periodo, Propiedad propiedad) {
		super();
		this.periodo = periodo;
		this.propiedad = propiedad;
	}


	public DateLapse getPeriodo() {
		return periodo;
	}


	public void setPeriodo(DateLapse periodo) {
		this.periodo = periodo;
	}


	public Propiedad getPropiedad() {
		return propiedad;
	}


	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	} 
	
	public boolean overlaps (DateLapse other) {
		return periodo.overlaps(other);
	}
}
