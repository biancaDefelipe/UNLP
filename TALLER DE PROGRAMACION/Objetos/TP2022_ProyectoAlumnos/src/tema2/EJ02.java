/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector; 
/**
 *
 * @author bianc
 */
public class EJ02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
          15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta 
          obtener edad 0. Luego de almacenar la información:
           - Informe la cantidad de personas mayores de 65 años.
           - Muestre la representación de la persona con menor  DNI
          */
        
        
        
        int dimF= 15;
        Persona [] vectorPersonas = new Persona[15]; 
        
        int dimL=0; 
        
        int edad; 
        System.out.print(" edad: "); 
        edad= Lector.leerInt();
        while (edad != 0 ) {
            Persona persona = new Persona (); 
            persona.setEdad(edad);
            System.out.println();
            System.out.print(" nombre: "); 
            persona.setNombre(Lector.leerString());
            System.out.println();
             
            System.out.print(" DNI: "); 
            persona.setDNI(Lector.leerInt());
            System.out.println();
           
            vectorPersonas[dimL]= persona; 
            dimL = dimL +1; 
            System.out.println("______________________________"); 
            
            System.out.print(" edad: "); 
            edad= Lector.leerInt();
        }
        
        //recorro el vector buscando cant de personas mayores a 65 y el min dni
        int cantMayores65=0; 
        int min= 9999; 
        int indiceMin=0; 
        for (int i =0; i< dimL; i ++){
            if (vectorPersonas[i].getEdad()>65 ){
                cantMayores65 = cantMayores65 +1; 
            }
            if (vectorPersonas[i].getDNI()<min){
                min= vectorPersonas[i].getDNI(); 
                indiceMin= i; 
            }
        }
        //informo
        System.out.println("la cantidad de personas mayores de 65 es: "+ cantMayores65); 
        System.out.print("representacion de la persona con menor dni: ");
        System.out.println(vectorPersonas[indiceMin].toString()); 
    }
        
        
        
        
        
        
      
        
    }



