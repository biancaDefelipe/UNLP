package io.github.unlp_oo.parcia082022;

public abstract class   Etapa {
	
	public Etapa() {
		super(); 
	}
	
	public abstract void aprobarEtapa(Proyecto proyecto, double precio); 
	
	public abstract void modificarMargenDeGanacia(Proyecto proyecto, double margenViejo, double margenNuevo);
	
	public void cancelarProyecto(Proyecto proyecto) {
		proyecto.cambiarEtapa(new Cancelado()); 
	}
}
