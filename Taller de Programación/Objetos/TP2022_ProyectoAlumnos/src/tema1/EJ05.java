
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author bianc
 */
import PaqueteLectura.Lector; 
public class EJ05 {
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
	int clientes; 
	int aspectos;  
        double [][] matriz = new double [5][4]; 
	//cargo la matriz 
        
	for (clientes=0; clientes <5; clientes ++){
		System.out.println(" cliente "+ (clientes +1 )+ " : "); 
		for (aspectos=0; aspectos <4; aspectos ++){
			System.out.print("                      aspecto  "+(aspectos +1)+" :  "); 
			matriz [clientes][aspectos]= Lector.leerDouble(); 
			System.out.println(); 
			System.out.println("_________________________________________________"); 
		}
		System.out.println("______________________________________________________________"); 
	}

	//imprimo la matriz
	for (clientes =0; clientes < 5; clientes ++){
		System.out.println(); 
		for (aspectos=0; aspectos <4; aspectos ++){
			System.out.print(" | "+ matriz[clientes][aspectos] +" "); 
		
		}
		System.out.println(); 
		System.out.print("______________________________________________________________"); 
		
	}
	
	System.out.println(); 
	System.out.println("promedio de puntaje por aspectos "); 
	//calculo los promedios por aspecto 
	for (aspectos = 0; aspectos < 4; aspectos ++){
                double total= 0; 
		System.out.print(" aspecto " + aspectos  +" : "); 
		for (clientes =0; clientes< 5; clientes ++){
			total = total + matriz [clientes][aspectos]; 
		}
		System.out.println(total/5); 
	}



    }
}
