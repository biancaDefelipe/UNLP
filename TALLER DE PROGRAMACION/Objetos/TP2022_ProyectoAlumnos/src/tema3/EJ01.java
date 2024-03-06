/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author bianc
 */

import PaqueteLectura.Lector; 
public class EJ01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.*/
        Triangulo tri= new Triangulo(); 
        System.out.print(" lado 1 : "); 
        tri.setLado1(Lector.leerDouble());
        System.out.println(); 
        
        System.out.print(" lado 2 : "); 
        tri.setLado2(Lector.leerDouble());
        System.out.println(); 
        
        System.out.print(" lado 3 : "); 
        tri.setLado3(Lector.leerDouble());
        System.out.println(); 
        
        System.out.print(" color de linea: "); 
        tri.setLinea(Lector.leerString());
        System.out.println(); 
        
        System.out.print(" color de relleno: "); 
        tri.setRelleno(Lector.leerString());
        System.out.println(); 
        
        System.out.println(" perimetro : " +tri.cacularPerimetro());
        System.out.println(" area: " + tri.calcularArea()); 
        
       
      
    }
    
}
