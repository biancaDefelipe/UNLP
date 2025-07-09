package io.github.unlp_oo.ejercicio_19_patrones;

public class MaximoDecorator extends WeatherDecorator{

	public MaximoDecorator(WeatherData component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	@Override 
	public String displayData() {
		double maximo= this.getTemperaturas().stream()
											.max(Double::compareTo)
											.orElse(0.0); 
		
		return this.getComponent().displayData() + 
		
	}
}
