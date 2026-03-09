package io.github.unlp_oo.daFecha2023;

public class TareaSimple extends TareaComponent{
	private String nombre; 
	private double duracionEstimada; 
	private Estado estado; 
	private long inicio; 
	private long fin; 
	
	public TareaSimple(String descripcion, String nombre, double duracion) {
		super(descripcion); 
		this.nombre=nombre; 
		this.duracionEstimada=duracion; 
		this.estado= new Creada(); 
		
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDuracionEstimada() {
		return duracionEstimada;
	}

	@Override
	public double estimacionTotal() {
		return this.duracionEstimada; 
	}

	@Override
	public long tiempoUtilizadoEnUnaTarea() {
		return this.getEstado().tiempoUtilizado(this); 
	}
	public long calcularTiempoUtilizado() {
		return this.getFin()- this.getInicio(); 
	}
	@Override
	public long avanceDeUnaTarea() {
		return this.tiempoUtilizadoEnUnaTarea() / this.estimacionTotal(); 
	}

	@Override
	public void iniciar() {
		this.getEstado().iniciar(this); 
	}

	@Override
	public void completar() {
		this.getEstado().completar(this); 
		
		
	}

	@Override
	public void addChild(TareaComponent tarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChild(TareaComponent tarea) {
		// TODO Auto-generated method stub
		
	}
}
