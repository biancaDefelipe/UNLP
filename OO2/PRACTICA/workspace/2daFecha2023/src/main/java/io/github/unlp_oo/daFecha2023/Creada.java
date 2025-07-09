package io.github.unlp_oo.daFecha2023;

public class Creada implements Estado {

	@Override
	public long tiempoUtilizado(TareaSimple tarea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void iniciar(TareaSimple tarea) {
		tarea.setInicio((int) System.currentTimeMillis());
		System.out.println(tarea.getInicio());
		tarea.setEstado(new Iniciada());
	}

	@Override
	public void completar(TareaSimple tarea) {
		// TODO Auto-generated method stub
		
	}


}
