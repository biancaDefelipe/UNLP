package ar.edu.unlp.objetos.uno.ejercicio12_volumenYSuperficie;

import java.util.List;
import java.util.LinkedList;
public class ReporteDeConstruccion {
	
	private List<Pieza>piezas; 
	
	
	public ReporteDeConstruccion() {
		super();
		this.piezas= new LinkedList<Pieza>(); 
	}
	public void agregarPieza(Pieza pieza) {
		//chequear que no este agregada ya?
		this.piezas.add(pieza);
	}
	
	public List<Pieza> getPiezas() {
		return piezas;
	}
	
	public double getvolumenDeMaterial(String material) {
		//"Recibe como parámetro un nombre de material 
		//(un string, por ejemplo 'Hierro'). 
		//Retorna la suma de los volúmenes de todas las piezas hechas en ese material"
		return this.getPiezas().stream().filter(p -> p.getMaterial().equals(material))
				.mapToDouble(p-> p.getVolumen()).sum();

	}
	public double superficieDeColor (String color) {
		//"Recibe como parámetro un color (un string, por ejemplo 'Rojo').
		//Retorna la suma de las superficies externas de todas las piezas pintadas con ese color".
		return this.getPiezas().stream().filter(p->p.getColor().equals(color))
				.mapToDouble(p-> p.getSuperficie()).sum(); 
	}
}
