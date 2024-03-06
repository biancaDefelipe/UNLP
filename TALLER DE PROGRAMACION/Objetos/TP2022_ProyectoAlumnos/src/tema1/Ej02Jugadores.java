
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos

import PaqueteLectura.Lector;



public class Ej02Jugadores {

    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        double altura; 
        
        
        //Paso 3: Crear el vector para 15 double 
        int dimF= 15;
        double [] vectorAlturas  = new double [dimF];
        
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i; 
        double alturaPromedio; 
      
        int jugadoresPorEncimaDelPromedio=0 ; 
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i=0; i< 15; i++){
            System.out.println("----------------------"); 
            System.out.print("ingrese una altura: ");
            vectorAlturas[i]= Lector.leerDouble(); 
            System.out.println("----------------------"); 
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        double total =0; 
        for (i=0; i<15; i ++){
            total = total +vectorAlturas[i]; 
        }
        alturaPromedio= total/ dimF; 
        System.out.println("la altura promedio es " + alturaPromedio); 
        
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        for (i=0; i <15; i++){
            if (vectorAlturas[i]> alturaPromedio){
                jugadoresPorEncimaDelPromedio = jugadoresPorEncimaDelPromedio +1;
            }
        }
        
        //Paso 9: Informar la cantidad.
        System.out.println("la cantidad de jugadores con altura por encima del promedio es " + jugadoresPorEncimaDelPromedio);
    }
}
    
