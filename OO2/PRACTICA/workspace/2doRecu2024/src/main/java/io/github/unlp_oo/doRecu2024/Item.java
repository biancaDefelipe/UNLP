package io.github.unlp_oo.doRecu2024;

public class Item extends Objeto{
	
	public Item(String nombre, int espacio) {
		super(nombre, espacio); 
	}
	
	@Override
	public boolean agregarObjeto(Objeto objeto) {
		return false; 
	}
	
	@Override 
	public Objeto buscarPorNombre(String nombre) {
		return null; 
	}
	
	@Override
	public int espacioMaximoDisponible() {
		return 0; 
	}
	

}
