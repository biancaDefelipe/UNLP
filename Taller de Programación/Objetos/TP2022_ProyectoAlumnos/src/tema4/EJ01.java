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
public class EJ01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo triangulo= new Triangulo(2, 2.5, 3,"celeste", "azul"); 
        Circulo circulo = new Circulo(2.5, "Rosa", "Rojo"); 
        
        System.out.println(" triangulo: " + triangulo.toString()); 
        System.out.println(" cirulo: "+circulo.toString());
        
        triangulo.despintar();
        circulo.despintar();
        
        System.out.println(" triangulo: " + triangulo.toString()); 
        System.out.println(" cirulo: "+circulo.toString());
        
    }
    
}
