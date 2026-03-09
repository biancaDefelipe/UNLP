package io.github.unlp_oo.ejercicio_13_patrones;

public class Sandwich {
	private String pan; 
	private double precioPan; 
	private String aderezo; 
	private double precioAderezo; 
	private String principal; 
	private double precioPrincipal; 
	private String adicional; 
	private double precioAdicional;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public double getPrecioPan() {
		return precioPan;
	}
	public void setPrecioPan(double precioPan) {
		this.precioPan = precioPan;
	}
	public String getAderezo() {
		return aderezo;
	}
	public void setAderezo(String aderezo) {
		this.aderezo = aderezo;
	}
	public double getPrecioAderezo() {
		return precioAderezo;
	}
	public void setPrecioAderezo(double precioAderezo) {
		this.precioAderezo = precioAderezo;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public double getPrecioPrincipal() {
		return precioPrincipal;
	}
	public void setPrecioPrincipal(double precioPrincipal) {
		this.precioPrincipal = precioPrincipal;
	}
	public String getAdicional() {
		return adicional;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	public double getPrecioAdicional() {
		return precioAdicional;
	}
	public void setPrecioAdicional(double precioAdicional) {
		this.precioAdicional = precioAdicional;
	}

	public double calcularCosto() {
		return (this.precioPan + this.precioPrincipal + this.precioAderezo + this.precioAdicional); 
	}
	
	
	
}
