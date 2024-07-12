package tp5.ejercicio5;

public class Jubilado extends Persona{
	private int jubilacionRecibida;

	public Jubilado(String nombre, String domicilio) {
		super(nombre, domicilio);
		this.jubilacionRecibida = 0;
	}

	public int getJubilacionRecibida() {
		return jubilacionRecibida;
	}

	public void setJubilacionRecibida(int jubilacionRecibida) {
		this.jubilacionRecibida = jubilacionRecibida;
	} 
	
}
