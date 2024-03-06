
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
public class EJ04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //ZONA DE VARIABLES 
      
	int [][] edificio= new int [8][4]; 
	int pisos; 
	int oficinas; 
	//iniciar las oficinas como vacias; 
	for (pisos=0; pisos <8;pisos ++){
		for (oficinas=0; oficinas< 4; oficinas ++){
			edificio[pisos][oficinas]=0; 
		}
	}

      
      
      
	System.out.println("_________________BIENVENIDO_________________"); 
	
	System.out.print(" numero de piso: "); 
	pisos= Lector.leerInt();
	System.out.println(); 
	while (pisos != 9 ) {
		System.out.print(" numero de oficina: "); 
		oficinas= Lector.leerInt(); 
		edificio [pisos-1][oficinas-1] = edificio[pisos-1][oficinas-1] +1; 
		System.out.println("___________________________________________________"); 
		System.out.print(" numero de piso: "); 
		pisos= Lector.leerInt();
		System.out.println(); 
	}

	
	
     //recorro la matriz e imprimo 
	System.out.println("matriz resultante"); 
	for (pisos=0; pisos < 8; pisos ++){
		System.out.println("___________________________________________________"); 
		for (oficinas= 0; oficinas < 4; oficinas ++){
			System.out.print("| "+ edificio[pisos][oficinas] +" "); 
		}
			
   	
          
      }
       
     
        
    }
    
}
