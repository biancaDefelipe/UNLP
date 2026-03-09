package io.github.unlp_oo.parcia082022;

public class EnEvaluacion extends Etapa {

	
	
	
	@Override 
	public void aprobarEtapa(Proyecto proyecto, double costo) {
		proyecto.cambiarEtapa(new EnEvaluacion());
	}
	@Override 
	public void modificarMargenDeGanacia(Proyecto proyecto, double margenViejo, double margenNuevo) {
		if (margenViejo >= 0.11 && margenViejo <=0.15) {
			proyecto.cambiarMargenDeGanancia(margenNuevo);
		}
	}
}
