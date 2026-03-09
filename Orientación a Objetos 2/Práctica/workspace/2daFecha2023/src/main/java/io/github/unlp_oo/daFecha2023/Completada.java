package io.github.unlp_oo.daFecha2023;

public class Completada implements Estado {

	@Override
	public long tiempoUtilizado(TareaSimple tarea) {
		return tarea.calcularTiempoUtilizado();
	}

	@Override
	public void iniciar(TareaSimple tarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completar(TareaSimple tarea) {
		// TODO Auto-generated method stub
		
	}
	

}
