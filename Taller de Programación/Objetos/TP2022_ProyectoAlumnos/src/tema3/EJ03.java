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
import PaqueteLectura.GeneradorAleatorio; 
public class EJ03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estante estanteLibros= new Estante(); 
       
        GeneradorAleatorio.iniciar();
        System.out.print("titulo del libro: ");
        String titulo= Lector.leerString(); 
        System.out.println(); 
       
        while ((!(titulo.equals("zzz"))) && (!(estanteLibros.estaLleno() ))){
            System.out.println("en el while");
            String editorial = GeneradorAleatorio.generarString(12); 
            System.out.println(" editorial: "+ editorial);
            
            int edicion= GeneradorAleatorio.generarInt(2021);
            System.out.println(" edicion: "+ edicion); 
            
            String isbn = GeneradorAleatorio.generarString(4); 
            System.out.println(" isbn: "+ isbn );
            
            double precio = GeneradorAleatorio.generarDouble(15000);
            System.out.println(" precio: "+ precio);
            
            String nombreAutor = GeneradorAleatorio.generarString(20);
            System.out.println(" autor: "+ nombreAutor);
            
            String biografiaAutor = GeneradorAleatorio.generarString(40); 
            System.out.println(" biografia: "+ biografiaAutor);
            
            String origenAutor= GeneradorAleatorio.generarString(10); 
            System.out.println(" origen del autor: "+ origenAutor);
            
            Autor autor= new Autor(nombreAutor, biografiaAutor, origenAutor); 
            Libro libro = new Libro (titulo, editorial, edicion, autor, isbn, precio); 
            
            estanteLibros.agregarLibro(libro); 
            
            System.out.println("___________________________________________________-");
            
            System.out.print("titulo del libro: ");
            titulo= Lector.leerString(); 
            System.out.println(); 
            
    }
       Libro mujercitas= estanteLibros.buscarLibro("Mujercitas"); 
       if (mujercitas.equals(null)){
           System.out.println(" el libro no se encuentra en el estante"); 
       }
       else{
           System.out.print("el autor del libro 'Mujercitas' es "+ mujercitas.getPrimerAutor().getNombre());
       }
  
    }
    
}
