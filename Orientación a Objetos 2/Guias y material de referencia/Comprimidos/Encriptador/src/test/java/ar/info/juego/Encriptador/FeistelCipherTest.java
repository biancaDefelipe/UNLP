/**
 * 
 */
package ar.info.juego.Encriptador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.unlp_oo.ejercicio_10_patrones.FeistelCipher;



/**
 * @author gperez
 *
 */
class FeistelCipherTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() throws Exception {
		String password = "clave";
		FeistelCipher feistelCipher = new FeistelCipher(password);
 
        String mensaje = "Hola mundo!";
        assertEquals(mensaje, feistelCipher.encode(feistelCipher.encode(mensaje)));
	}
}
