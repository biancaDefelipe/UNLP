package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class RetiroEnCorreo implements FormaEnvio {

	public RetiroEnCorreo() {
		super(); 
		
	}
	@Override
	public double  costoEnvio(String origen, String destino){
		return 3000; 
		}
}
