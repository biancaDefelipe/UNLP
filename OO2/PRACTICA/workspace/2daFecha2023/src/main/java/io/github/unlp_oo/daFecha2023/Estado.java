package io.github.unlp_oo.daFecha2023;

public interface Estado {
	public long tiempoUtilizado(TareaSimple tarea); 
	public void iniciar(TareaSimple tarea); 
	public void completar(TareaSimple tarea); 
	
}
