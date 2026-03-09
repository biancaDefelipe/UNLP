/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author bianc
 */
public class EJ03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Persona persona = new Persona ("jorge", 22222222, 44);
        Trabajador trabajador = new Trabajador (new Persona("pepe", 12345678, 43), "jardinero"); 
        
       System.out.println( persona.toString()); 
       System.out.println(trabajador.toString());
        
    }
    
}
