package io.github.unlp_oo.ejercicio_18_patrones;

public class NombreDecorator extends FileDecorator  {

	public NombreDecorator (FileComponent component) {
		super(component); 
	}
	public String prettyPrint() {
		return super.prettyPrint(); 
	}
	
}
