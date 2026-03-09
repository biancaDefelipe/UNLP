package io.github.unlp_oo.ejercicio_18_patrones;

public class ExtensionDecorator extends FileDecorator {
	
	public ExtensionDecorator (FileComponent component) {
		super(component); 
	}
	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getComponent().getExtension(); 
	}
	
}
