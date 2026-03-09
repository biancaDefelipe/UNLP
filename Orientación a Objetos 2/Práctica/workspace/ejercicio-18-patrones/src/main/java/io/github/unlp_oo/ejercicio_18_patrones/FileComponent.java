package io.github.unlp_oo.ejercicio_18_patrones;

import java.time.LocalDate;

public interface FileComponent {
	
	String prettyPrint(); 
	
	String getNombre(); 
	String getExtension();
	String getTamanio(); 
	LocalDate getFechaCreacion(); 
	LocalDate getFechaModificacion(); 
	String getPermisos(); 
}
