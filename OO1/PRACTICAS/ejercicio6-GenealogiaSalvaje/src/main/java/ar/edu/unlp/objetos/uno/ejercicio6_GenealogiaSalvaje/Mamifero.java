package ar.edu.unlp.objetos.uno.ejercicio6_GenealogiaSalvaje;

import java.util.Date;

public class Mamifero {
	private String identificador; 
	private String especie; 
	private Date fechaNacimiento; 
	private Mamifero madre; 
	private Mamifero padre;
	public Mamifero(String identificador, String especie, Date fechaNacimiento, Mamifero madre, Mamifero padre) {
		super();
		this.identificador = identificador;
		this.especie = especie;
		this.fechaNacimiento = fechaNacimiento;
		this.madre = madre;
		this.padre = padre;
	}
	public Mamifero() {
		super();
	}
	
	public Mamifero(String identificador) {
		super();
		this.identificador = identificador;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getPadre() {
		return padre; //comprobar si es null?
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	} 
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre(); 
		}else {
			return null; 
		}
	}
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre(); 
		}else {
			return null; 
		}
	}
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre(); 
		}else {
			return null; 
		}
	}
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre(); 
		}else {
			return null; 
		}
		
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		boolean ok= false; 
		if ((this.getPadre() != null && this.getPadre().equals(unMamifero))||(this.getMadre() !=null && this.getMadre().equals(unMamifero))) {
			return true;
		}else {
			
			if ((this.getMadre() != null) ){
				ok= this.getMadre().tieneComoAncestroA(unMamifero); 
			}
			if ((ok==false)&& (this.getPadre() != null)) {
				ok=this.getPadre().tieneComoAncestroA(unMamifero); 
			}
		}
		return ok; 
		
	}
	
	
	
}
