package ar.edu.unlp.objetos.uno.ejercicio11_elInversor;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
	private LocalDate fechaConstitucion; 
	private double montoDepositado; 
	private double porcentajeDeInteresDiario;
	
	
	public PlazoFijo(LocalDate fechaConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		super();
		this.fechaConstitucion = fechaConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}


	public LocalDate getFechaConstitucion() {
		return fechaConstitucion;
	}


	public void setFechaConstitucion(LocalDate fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}


	public double getMontoDepositado() {
		return montoDepositado;
	}


	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}


	protected long obtenerDiasEntre(){
		//devuelve los dias entre la fecha de constitucion y la fecha actual 
		return ChronoUnit.DAYS.between(this.getFechaConstitucion(), LocalDate.now());
	}
	protected double obtenerInteres(double monto){
		//devuelve el valor de interes de un monto en un dia 
		return monto*this.getPorcentajeDeInteresDiario();
	}
	
	public double valorActual(){
	    /*No es necesaria esta implementación !!!!!
	     * double montoFinal= this.getMontoDepositado();
	    int dias = (int) this.obtenerDiasEntre();
	    for (int i=1 ; i<=dias;i++){
			montoFinal+=this.obtenerInteres(montoFinal);
		}
	    return montoFinal;*/
		return (this.montoDepositado* (int)this.obtenerDiasEntre()* this.getPorcentajeDeInteresDiario()); 
}

	
	
}
