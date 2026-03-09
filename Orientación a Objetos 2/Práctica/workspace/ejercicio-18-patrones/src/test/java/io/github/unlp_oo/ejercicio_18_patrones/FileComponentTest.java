package io.github.unlp_oo.ejercicio_18_patrones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileComponentTest {
	private FileComponent fileOO2;
	private FileDecorator nombreDecorator;
	private FileDecorator extensionDecorator;
	private FileDecorator tamanioDecorator;
	private FileDecorator fechaCreacionDecorator;
	private FileDecorator fechaModificacionrator;
	private FileDecorator permisosDecorator;
	private FileDecorator todosLosDecoradores;
	private FileDecorator todosLosDecoradores2;

	@BeforeEach
	void setUp() throws Exception {

		this.fileOO2 = new FileOO2("archivo_1",".txt","10MB",LocalDate.of(2024, 12, 13),LocalDate.of(2025, 1, 13),"user");
		this.nombreDecorator = new NombreDecorator(this.fileOO2);
		this.extensionDecorator = new ExtensionDecorator(this.fileOO2);
		this.tamanioDecorator = new TamanioDecorator(this.fileOO2);
		this.fechaCreacionDecorator = new FechaCreacionDecorator(this.fileOO2); 
		this.fechaModificacionrator = new FechaModificacionDecorator(this.fileOO2);
		this.permisosDecorator = new PermisosDecorator(this.fileOO2);
		this.todosLosDecoradores = new PermisosDecorator(new FechaModificacionDecorator(new FechaCreacionDecorator(new TamanioDecorator(new ExtensionDecorator(new NombreDecorator(fileOO2))))));
		this.todosLosDecoradores2 = new NombreDecorator(new FechaModificacionDecorator(new FechaCreacionDecorator(new TamanioDecorator(new ExtensionDecorator(new PermisosDecorator(fileOO2))))));
	}

	@Test
	void testPrettyPrintUnDecorador() {
		//nombre - extension
		assertEquals("archivo_1 - .txt",this.extensionDecorator.prettyPrint());
		//nombre - tamaño 
		assertEquals("archivo_1 - 10MB",this.tamanioDecorator.prettyPrint());
		//nombre - fecha creacion
		assertEquals("archivo_1 - 2024-12-13",this.fechaCreacionDecorator.prettyPrint());
		//nombre - fecha modificacion
		assertEquals("archivo_1 - 2025-01-13",this.fechaModificacionrator.prettyPrint());
		//nombre - permisos
		assertEquals("archivo_1 - user",this.permisosDecorator.prettyPrint());
	}
	
	@Test
	void testPrettyPrintSinDecoraciones() {
		assertEquals("archivo_1",this.fileOO2.prettyPrint());
	}

	@Test
	void testPrettyPrintCompleto() {
		System.out.println(this.todosLosDecoradores.prettyPrint()); 
		assertEquals("archivo_1 - .txt - 10MB - 2024-12-13 - 2025-01-13 - user", this.todosLosDecoradores.prettyPrint());
		assertEquals("archivo_1 - user - .txt - 10MB - 2024-12-13 - 2025-01-13", this.todosLosDecoradores2.prettyPrint());
	}
}
