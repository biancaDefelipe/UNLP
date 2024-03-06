/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author bianc
 */
public class EJ01 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Persona persona = new Persona(); 
        
        System.out.print(" nombre: "); 
        persona.setNombre(Lector.leerString());
        System.out.println(); 
        
        System.out.print(" DNI: "); 
        persona.setDNI(Lector.leerInt());
        System.out.println(); 
        
        System.out.print(" edad: "); 
        persona.setEdad(Lector.leerInt());
        System.out.println(); 
        
        //resultado
        System.out.println(persona.toString());
        
        
        
        
        
        
   
        
    }
    
}
