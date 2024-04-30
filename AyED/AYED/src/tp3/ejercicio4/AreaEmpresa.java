package tp3.ejercicio4;

public class AreaEmpresa {
	private String identificacion; 
	private int tardanza;
	
	
	public AreaEmpresa(String identificacion, int tardanza) {
		/*Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que contiene
		la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
		interna representada con int.*/
		super();
		this.identificacion = identificacion;
		this.tardanza = tardanza;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public int getTardanza() {
		return tardanza;
	}


	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	} 
	
	
	
}
