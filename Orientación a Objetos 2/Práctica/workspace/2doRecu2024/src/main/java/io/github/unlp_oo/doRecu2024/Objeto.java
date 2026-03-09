package io.github.unlp_oo.doRecu2024;

public abstract class Objeto {
	private String nombre; 
	private int espacio;
	public Objeto(String nombre, int espacio) {
		super();
		this.nombre = nombre;
		this.espacio = espacio;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEspacio() {
		return espacio;
	} 
	
	public abstract boolean agregarObjeto(Objeto objeto); 
	public abstract Objeto buscarPorNombre(String nombre); 
	public abstract int espacioMaximoDisponible(); 
	public abstract int capacidadDisponible(); 
	
}
