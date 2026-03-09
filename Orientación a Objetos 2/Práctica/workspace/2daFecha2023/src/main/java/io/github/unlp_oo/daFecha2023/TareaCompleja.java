package io.github.unlp_oo.daFecha2023;

import java.util.List;
import java.util.ArrayList;
public class TareaCompleja extends TareaComponent{
	private List<TareaComponent> tareas; 
	
	public TareaCompleja(String descripcion) {
		super(descripcion);
		this.tareas= new ArrayList<TareaComponent>(); 
	}

	@Override
	public double estimacionTotal() {
		return this.tareas.stream()
				   .mapToDouble(t -> t.estimacionTotal())
				   .sum(); 
	}

	@Override
	public int tiempoUtilizadoEnUnaTarea() {
		return this.tareas.stream()
						  .mapToInt(t-> t.tiempoUtilizadoEnUnaTarea())
						  .sum(); 
	}

	@Override
	public double avanceDeUnaTarea() {
		return this.tareas.stream()
						  .mapToDouble(t->t.avanceDeUnaTarea())
						  .sum(); 
		/*return tareas.stream()
				.mapToDouble(Simple::avance)
    .sum();*/
	}

	@Override
	public void iniciar() {
		this.tareas.forEach(t-> t.iniciar());
	}

	@Override
	public void completar() {
		this.tareas.forEach(t->t.completar());
		
	}
	
	@Override 
	public void addChild(TareaComponent tarea) {
		this.tareas.add(tarea); 
	}
	
	@Override
	public void removeChild(TareaComponent tarea) {
		this.tareas.remove(tarea); 
	}
	
}
