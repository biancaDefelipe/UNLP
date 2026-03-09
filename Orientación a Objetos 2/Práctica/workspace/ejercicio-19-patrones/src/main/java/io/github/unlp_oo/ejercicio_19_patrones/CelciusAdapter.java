package io.github.unlp_oo.ejercicio_19_patrones;

import java.util.List;
import java.util.stream.Collectors;

public class CelciusAdapter implements WeatherData {
	private HomeWeatherStation stationAdaptee;

	public CelciusAdapter(HomeWeatherStation stationAdaptee) {
		super();
		this.stationAdaptee = stationAdaptee;
	} 
	public double getTemperatura() {
		return this.convertirACelcius(this.stationAdaptee.getTemperatura()); 
	}
	private double convertirACelcius(double temperatura) {
		return (temperatura-32.0) /1.8; 
	}
	@Override
	public double getPresion() {
		return this.stationAdaptee.getPresion();
	}
	@Override
	public double getRadiacionSolar() {
		return this.stationAdaptee.getRadiacionSolar(); 
	}
	@Override
	public List<Double> getTemperaturas() {
		return this.stationAdaptee.getTemperaturas().stream()
													.map(t -> this.convertirACelcius(t))
													.collect(Collectors.toList()); 
	}
	@Override
	public String displayData() {
		return "Temperatura C: " + this.convertirACelcius(this.stationAdaptee.getTemperatura())+
			   	  "; Presión atmosf: " + this.stationAdaptee.getPresion()+
			   	  "; Radiación solar: " + this.stationAdaptee.getRadiacionSolar() + ";";
	}
	}

