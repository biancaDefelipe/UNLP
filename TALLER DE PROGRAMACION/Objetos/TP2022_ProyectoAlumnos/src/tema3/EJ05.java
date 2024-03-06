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
public class EJ05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circulo circulo = new Circulo(); 
        
        System.out.print(" radio: "); 
        circulo.setRadio(Lector.leerDouble());
        System.out.println(); 
        
         System.out.print(" color de linea: ");
         circulo.setColorLinea(Lector.leerString());
         System.out.println(); 
         
         System.out.print(" color de relleno: ");
         circulo.setColorRelleno(Lector.leerString());
         System.out.println();
         
         System.out.println(circulo.toString());
         System.out.println("_____________________________________________________________");
         
         System.out.println(" area del circulo: "+ circulo.calcularArea()); 
         System.out.println(" perimetro del circulo: "+ circulo.calcularPerimetro()); 
         
         System.out.print(" nuevo color de linea: ");
         circulo.setColorLinea(Lector.leerString());
         System.out.print(" nuevo color de relleno: ");
         circulo.setColorRelleno(Lector.leerString()); 
         
         System.out.println(circulo.toString());
         
         
         }
    }
    

