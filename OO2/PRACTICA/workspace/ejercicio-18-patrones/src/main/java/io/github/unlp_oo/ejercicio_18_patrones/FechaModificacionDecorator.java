package io.github.unlp_oo.ejercicio_18_patrones;

public class FechaModificacionDecorator extends FileDecorator{

	public FechaModificacionDecorator(FileComponent component) {
		super(component);
	}

	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getFechaModificacion().toString();
	}
}
