package tp5.ejercicio5;

public abstract class Persona {
	private String nombre; 
	private String domicilio;
	public Persona(String nombre, String domicilio) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	} 
	
	
}
