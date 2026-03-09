package io.github.unlp_oo.ejercicio_18_patrones;

public class PermisosDecorator extends FileDecorator {
	
	public PermisosDecorator (FileComponent component) {
		super(component); 
	}
	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getComponent().getPermisos(); 
	}
	
}
