package io.github.unlp_oo.parcia082022;

public class EnConstruccion extends Etapa{

		
	@Override 
	public void aprobarEtapa(Proyecto proyecto, double precio) {
		if (precio != 0) {
			proyecto.cambiarEtapa(new EnEvaluacion());
		}else {
			throw new RuntimeException("Este es el mensaje de error"); 
		}
		
	}
	
	@Override 
	public void modificarMargenDeGanacia(Proyecto proyecto, double margenViejo, double margenNuevo) {
		if (margenViejo >= 0.08 && margenViejo <=0.1) {
			proyecto.cambiarMargenDeGanancia(margenNuevo);
		}
	}
}
