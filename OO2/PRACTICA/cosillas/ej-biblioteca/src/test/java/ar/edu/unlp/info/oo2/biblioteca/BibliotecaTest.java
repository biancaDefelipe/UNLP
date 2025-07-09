package ar.edu.unlp.info.oo2.biblioteca;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class BibliotecaTest {
	 Biblioteca b1;
	 Socio s1;
	 Socio s2;
	 VoorheesExporter v;

	 @BeforeEach
	 void setUp(){
	      b1=new Biblioteca();
	      s1=new Socio("paulo","pali@", "22/");
	      s2=new Socio("bianca","biaki@", "24/");
	      v=new VoorheesExporter();
	 }

	 @Test
	 void testExportarSociosConSocios(){
	       b1.agregarSocio(s1);
	       b1.agregarSocio(s2);
	       String resul=b1.exportarSocios();
	       assertNotEquals(resul,"[]");
	  }

	  @Test
	  void testExportarSociosSinSocios(){
	       String resul=b1.exportarSocios();
	       assertEquals(resul,"[]");
	   }


	}

