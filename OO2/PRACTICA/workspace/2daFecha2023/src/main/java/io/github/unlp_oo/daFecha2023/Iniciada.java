package io.github.unlp_oo.daFecha2023;

public class Iniciada implements Estado{

	@Override
	public long tiempoUtilizado(TareaSimple tarea) {
		return 0; 
	}

	@Override
	public void iniciar(TareaSimple tarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completar(TareaSimple tarea) {
		tarea.setFin (System.currentTimeMillis());
		tarea.setEstado(new Completada());
		
	}

}
