package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato {
	private int valorPorHora; 
	private int horasPorMes;
	private LocalDate fechaFin;
	public ContratoPorHoras(LocalDate fechaInicio,Empleado emp,  int valorPorHora, int horasPorMes, LocalDate fechaFin) {
		super(fechaInicio, emp);
		this.valorPorHora = valorPorHora;
		this.horasPorMes = horasPorMes;
		this.fechaFin = fechaFin;
	}
	public int getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(int valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	public int getHorasPorMes() {
		return horasPorMes;
	}
	public void setHorasPorMes(int horasPorMes) {
		this.horasPorMes = horasPorMes;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	@Override
	public boolean estaVigente() {
		//si se vence hoy?
		return (this.getFechaFin().isAfter(LocalDate.now()));
	}
	@Override
	public double montoBasico() {
		return (this.valorPorHora *this.horasPorMes); 
	}
	
	@Override
	public int getAntiguedad() {
		if (this.estaVigente()) {
			return (int)this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
		}
			return (int) this.getFechaInicio().until(this.fechaFin, ChronoUnit.YEARS); 
	
	}
}
