package io.github.unlp_oo.ejercicio_18_patrones;

import java.time.LocalDate;

public abstract class FileDecorator implements FileComponent{
	private FileComponent component;

	public FileDecorator(FileComponent component) {
		super();
		this.component = component;
	} 
	protected FileComponent getComponent() {
		return this.component;
	}
	@Override
	public String prettyPrint() {
		return this.component.prettyPrint(); 
	}
	public String getNombre() {
		return this.component.getNombre();
	}
	public String getExtension() {
		return this.component.getExtension();
	}
	public String getTamanio() {
		return this.component.getTamanio();
	}
	public LocalDate getFechaCreacion() {
		return this.component.getFechaCreacion();		
	}
	public LocalDate getFechaModificacion() {
		return this.component.getFechaModificacion();
	}
	public String getPermisos() {
		return this.component.getPermisos();
	}
}