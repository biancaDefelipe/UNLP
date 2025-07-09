package io.github.unlp_oo.daFecha2023;

public abstract class TareaComponent {
	private String descripcion; 
	
	public TareaComponent(String descripcion) {
		this.descripcion= descripcion; 
	}
	public abstract double estimacionTotal(); 
	public abstract long tiempoUtilizadoEnUnaTarea(); 
	public abstract long avanceDeUnaTarea(); 
	public abstract void iniciar(); 
	public abstract void completar(); 
	public abstract void addChild(TareaComponent tarea); 
	public abstract void removeChild(TareaComponent tarea); 
	
	
}
