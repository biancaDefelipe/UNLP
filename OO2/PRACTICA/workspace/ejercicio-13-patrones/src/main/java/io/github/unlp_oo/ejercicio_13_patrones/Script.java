package io.github.unlp_oo.ejercicio_13_patrones;

public class Script {

		public static void main(String[] args) {
	        SubteWay subteWay = new SubteWay();

	        // Sándwich Clásico
	        subteWay.setBuilder(new BuilderClasico());
	        Sandwich clasico = subteWay.construirSandwich();
	        System.out.println("Sándwich Clásico - Precio: " + clasico.calcularCosto() + " pesos");

	        // Sándwich Vegetariano
	        subteWay.setBuilder(new BuilderVegetariano());
	        Sandwich vegetariano = subteWay.construirSandwich();
	        System.out.println("Sándwich Vegetariano - Precio: " + vegetariano.calcularCosto() + " pesos");

	        // Sándwich Vegano
	        subteWay.setBuilder(new BuilderVegano());
	        Sandwich vegano = subteWay.construirSandwich();
	        System.out.println("Sándwich Vegano - Precio: " + vegano.calcularCosto() + " pesos");

	        // Sándwich Sin TACC
	        subteWay.setBuilder(new BuilderSinTacc());
	        Sandwich sinTACC = subteWay.construirSandwich();
	        System.out.println("Sándwich Sin TACC - Precio: " + sinTACC.calcularCosto() + " pesos");
		}
	}

