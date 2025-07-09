package io.github.unlp_oo.ejercicio_18_patrones;

public class TamanioDecorator extends FileDecorator{

	public TamanioDecorator (FileComponent component) {
		super(component); 
	}
	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getComponent().getTamanio() ; 
	}
	
}
