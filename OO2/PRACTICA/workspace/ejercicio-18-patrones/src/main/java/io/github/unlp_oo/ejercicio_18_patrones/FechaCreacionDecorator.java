package io.github.unlp_oo.ejercicio_18_patrones;

public class FechaCreacionDecorator extends FileDecorator {
	public FechaCreacionDecorator(FileComponent component) {
		super(component);
	}
	
	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getFechaCreacion().toString();
	}
}
