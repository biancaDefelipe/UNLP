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
public class MainVisorFigurasModificado {

    /**
     * @param args the command line arguments
     */
    
    //Realice un programa que instancie el visor, guarde dos cuadrados y un rectángulo en el 
    //visor y por último haga que el visor muestre sus figuras almacenadas.
    public static void main(String[] args) {
        // TODO code application logic here
        
        VisorFigurasModificado visor = new VisorFigurasModificado();
        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        visor.guardar(c1);
        Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
        visor.guardar(r);
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        visor.guardar(c2);
        
        
        visor.mostrar();
    }
    
}
