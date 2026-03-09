package ar.edu.unlp.info.oo2.ejercicio_18;

public abstract class FileDecorator implements FileComponent{
	FileComponent component;

	public FileDecorator(FileComponent component) {
		super();
		this.component = component;
	} 
	
	@Override
	public String prettyPrint() {
		return this.component.prettyPrint(); 
	}
	
	@Override
	public String getNombre() {
		return this.component.getNombre(); 
	}
	
	@Override
	public String getExtension() {
		return this.component.getExtension();
	}
	
	@Override
	public String getTamaño() {
		return this.component.getTamaño();
	}
	
	@Override
	public String getFechaCreacion() {
		return this.component.getFechaCreacion(); 
	}
	
	@Override 
	public String getFechaModificacion() {
		return this.getFechaModificacion(); 
	}
	
	@Override
	public String getPermisos() {
		return this.getPermisos(); 
	}
}
