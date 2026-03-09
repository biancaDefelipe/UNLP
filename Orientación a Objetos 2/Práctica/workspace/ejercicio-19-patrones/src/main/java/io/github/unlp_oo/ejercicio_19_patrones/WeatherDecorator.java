package io.github.unlp_oo.ejercicio_19_patrones;

import java.util.List;

public abstract class WeatherDecorator implements WeatherData {
	private WeatherData	component; 
	
	public WeatherDecorator(WeatherData component) {
		super(); 
		this.component= component; 
	}
	@Override
	public double getTemperatura() {
		// TODO Auto-generated method stub
		return this.component.getTemperatura(); 
	}

	@Override
	public double getPresion() {
		// TODO Auto-generated method stub
		return this.component.getPresion(); 
	}

	@Override
	public double getRadiacionSolar() {
		// TODO Auto-generated method stub
		return this.component.getRadiacionSolar(); 
	}

	@Override
	public List<Double> getTemperaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayData() {
		// TODO Auto-generated method stub
		return this.component.displayData(); 
	}
	
	protected WeatherData getComponent() {
		return this.component; 
	}
}
