package parcialGrafosCovid.src;

public class Ciudad {
	private String nombre; 
	private int fase;
	public Ciudad(String nombre, int fase) {
		super();
		this.nombre = nombre;
		this.fase = fase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int fase) {
		this.fase = fase;
	} 
	
	
}
