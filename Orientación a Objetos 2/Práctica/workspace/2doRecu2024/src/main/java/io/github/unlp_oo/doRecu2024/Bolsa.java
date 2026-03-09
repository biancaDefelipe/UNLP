package io.github.unlp_oo.doRecu2024;

import java.util.List;

public class Bolsa extends Objeto{
	private int capacidad; 
	private List<Objeto> objetos;
	public Bolsa(String nombre, int espacio, int capacidad) {
		super(nombre, espacio);
		this.capacidad = capacidad;
		this.objetos = new ArrayList<Objeto>(); 
	}
	public int getCapacidad() {
		return capacidad;
	}
	public List<Objeto> getObjetos() {
		return objetos;
	} 
	
	@Override 
	public boolean agregarObjeto(Objeto objeto) {
		if (this.objetos.size() + objeto.getEspacio() <=this.capacidad ) {
			this.objetos.add(objeto); 
			return true; 
		}else {
			return this.objetos.stream()
							   .anyMatch(o-> o.agregarObjeto(objeto)); 
		
		}
	}
	
	@Override 
	public Objeto buscarPorNombre(String nombre) {
		return this.objetos.stream()
						   .filter(o-> o.getNombre().equals(nombre))
						   .findFirst()
						   .orElse(null); 
	}
	
	@Override 
	public int espacioMaximoDisponible() {
		return this.objetos.stream()
						   .
						   
	}
	

	}

