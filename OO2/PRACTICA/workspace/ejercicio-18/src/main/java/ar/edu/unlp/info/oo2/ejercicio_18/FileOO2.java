package ar.edu.unlp.info.oo2.ejercicio_18;

public class FileOO2 implements FileComponent {
	private String nombre; 
	private String extension; 
	private String tamanio; 
	private String fechaCreacion; 
	private String fechaModificacion; 
	private String permisos; 
	
	
	public FileOO2(String nombre, String extension, String tamanio, String fechaCreacion, String fechaModificacion,
			String permisos) {
		super();
		this.nombre = nombre;
		this.extension = extension;
		this.tamanio = tamanio;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permisos = permisos;
	}

	@Override
	public String prettyPrint() {
		// TODO Auto-generated method stub
		return this.getNombre(); 
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public String getExtension() {
		// TODO Auto-generated method stub
		return this.extension; 
	}

	@Override
	public String getTamaño() {
		// TODO Auto-generated method stub
		return this.tamanio;
	}

	@Override
	public String getFechaCreacion() {
		// TODO Auto-generated method stub
		return this.fechaCreacion;
	}

	@Override
	public String getFechaModificacion() {
		// TODO Auto-generated method stub
		return this.fechaModificacion;
	}

	@Override
	public String getPermisos() {
		// TODO Auto-generated method stub
		return this.permisos;
	}
	

}
