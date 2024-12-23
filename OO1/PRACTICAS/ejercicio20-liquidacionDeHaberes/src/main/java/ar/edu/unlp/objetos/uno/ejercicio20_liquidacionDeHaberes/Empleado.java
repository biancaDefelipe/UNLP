package ar.edu.unlp.objetos.uno.ejercicio20_liquidacionDeHaberes;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Empleado {
	private String nombre; 
	private String apellido; 
	private int cuil; 
	private LocalDate fechaNacimiento; 
	private boolean hijos; 
	private boolean conyuge;
	private List<Contrato>contratos;
	public Empleado(String nombre, String apellido, int cuil, LocalDate fechaNacimiento, boolean hijos, boolean conyuge ) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.hijos=hijos; 
		this.conyuge=conyuge; 
		this.contratos = new ArrayList<Contrato>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCuil() {
		return cuil;
	}
	public void setCuil(int cuil) {
		this.cuil = cuil;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean  getCantHijos() {
		return hijos;
	}
	public void setHijos(boolean hijos ) {
		this.hijos = hijos;
	}
	public boolean getConyuge() {
		return this.conyuge; 
	}
	public void setConyuge(boolean conyuge) {
		this.conyuge=conyuge; 
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	} 
	public void añadirContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
		ContratoDePlanta c= new ContratoDePlanta ( fechaInicio, this,  sueldoMensual,  montoConyuge, montoHijos); 
		this.contratos.add(c); 
	}
	public void añadirContratoPorHoras(LocalDate fechaInicio,  int valorPorHora, int horasPorMes, LocalDate fechaFin) {
		ContratoPorHoras c= new ContratoPorHoras (fechaInicio,this, valorPorHora,  horasPorMes, fechaFin); 
		this.contratos.add(c); 
	}
	public int sumaAntiguedad() {
		return this.contratos.stream().mapToInt(c->c.getAntiguedad()).sum();
		
	}
	public double montoPorAntigiguedad() {
		
		if (this.sumaAntiguedad()>=5 && this.sumaAntiguedad()< 10) {
			return 0.3; 
		}
		if (this.sumaAntiguedad()>=10 &&  this.sumaAntiguedad()< 15) {
			return 0.5; 
		}
		if (this.sumaAntiguedad() >=15 && this.sumaAntiguedad()<20) {
			return 0.7; 
		}
		if (this.sumaAntiguedad()>=20 ) {
			return 1; 	
		}
		return 0;
	}
	private Contrato obtenerContratoVigente() {
			return this.getContratos().stream().filter(c->c.estaVigente()).findFirst().orElse(null); 

			}
	
	public double montoTotal() {
		Contrato c=this.obtenerContratoVigente(); 
		return c.montoBasico()+c.montoBasico()*this.montoPorAntigiguedad(); 
		
	}
	
	public Recibo generarRecibo() {
		Recibo r= new Recibo (this, this.sumaAntiguedad(),this.montoTotal()); 
		return r; 
	}
	
	
	
	

}
