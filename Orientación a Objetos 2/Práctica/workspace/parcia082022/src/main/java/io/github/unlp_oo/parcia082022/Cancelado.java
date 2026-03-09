package io.github.unlp_oo.parcia082022;

public class Cancelado extends Etapa{

	
	@Override 
	public void aprobarEtapa(Proyecto proyecto, double costo) {
		
	}
	@Override 
	public void modificarMargenDeGanacia(Proyecto proyecto, double margenViejo, double margenNuevo) {

	}
	@Override
	public void cancelarProyecto(Proyecto proyecto) {
		proyecto.cambiarObjetivo(); 
	}
}
