package ar.edu.unlp.objetos.uno.ejercicio23_mercadoDeObjetos;

public class EnvioADomicilio implements FormaEnvio{
	private CalculadoraDeDistancia calculadora; 
	
	public EnvioADomicilio() {
		this.calculadora= new CalculadoraDeDistancia(); 
		
	}
	public double costoEnvio(String origen, String destino){
		return this.calculadora.distanciaEntre(origen, destino) * 0.5; 

		}
}
