
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios

import PaqueteLectura.GeneradorAleatorio; 
import PaqueteLectura.Lector; 
public class Ej03Matrices {

    public static void main(String[] args) {
	    //Paso 2. iniciar el generador aleatorio     
	 
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
    	
	int dimF = 5; 
	int [][] matriz = new int[dimF][dimF]; 
	
	int filas; 
	int columnas; 
	
	
	for (filas = 0; filas < dimF; filas ++){
		for (columnas=0; columnas< dimF; columnas ++){
			matriz[filas][columnas]=  GeneradorAleatorio.generarInt(31); 
		}
	}

        //Paso 4. mostrar el contenido de la matriz en consola
        System.out.println("contenido de la matriz");
	for (filas = 0; filas < dimF; filas ++){
                System.out.println("______________________________"); 
		for (columnas =0; columnas < dimF; columnas ++){
			System.out.print("| "+ matriz[filas][columnas]+" "); 
		}
                System.out.println(); 
	}


        //Paso 5. calcular e informar la suma de los elementos de la fila 1
	int totalFila1=0; 
	for (columnas =0; columnas < dimF; columnas ++){
		totalFila1= totalFila1 + matriz [1][columnas]; 
	}
	System.out.println("el total de la suma de los elementos de la fila 1 es de " + totalFila1); 

    
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.

	int [] vector =new  int [5]; 
	for (columnas = 0; columnas < dimF; columnas ++){
		int total=0; 
		for (filas =0; filas < dimF; filas ++){
			total = total + matriz [filas][columnas]; 
		}
		vector[columnas] = total; 
	}
	
	System.out.println("vector resultante: "); 
	for (int i= 0; i< dimF; i ++){
		System.out.print("| " +vector[i]+ " "); 
	}
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".

	System.out.print("ingrese un valor a buscar: "); 
	int num = Lector.leerInt(); 
	filas =0;
	boolean encontre= false;

	while ((filas <dimF) && !(encontre) ){
		columnas =0;	
		while ((columnas <dimF) && (! encontre)){
			if (matriz[filas][columnas] == num) {
				encontre= true; 
			}
			else{
				columnas= columnas +1; 
			}
		}
		if ( !encontre){
			filas = filas +1; 
                }
	}
	if (encontre) {
		System.out.println("el elemento se encuentra en la posicion "+ filas +" | "+ columnas ); 
	}
	else{
		System.out.println("No se encontro el elemento" ); 
	}
	
        }	
    }
    
}