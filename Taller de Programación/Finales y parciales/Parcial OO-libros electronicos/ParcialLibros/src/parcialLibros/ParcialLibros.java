/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialLibros;

/**
 *
 * @author bianc
 */
public class ParcialLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Realice un programa que instancie un libro electrónico y un libro impreso. Cargue 3 autores
        //a cada uno. Para finalizar, muestre la representación String de los libros.
        LibroElectronico orgulloYprejuicio = new LibroElectronico("epub", 10, "Orgullo y Prejuicio", 9600); 
        LibroImpreso nuestraParteDeNoche = new LibroImpreso (false, "Nuestra Parte de Noche", 20000); 
       
        orgulloYprejuicio.agregarAutor("Jane Austen"); 
        nuestraParteDeNoche.agregarAutor("Mariana Enriquez"); 
        nuestraParteDeNoche.agregarAutor("Nick Cave"); 
        orgulloYprejuicio.agregarAutor(" mr darcy"); 
        orgulloYprejuicio.agregarAutor("lizzy"); 
        nuestraParteDeNoche.agregarAutor("Rosario"); 
        
        System.out.println(orgulloYprejuicio.toString());
        System.out.println(nuestraParteDeNoche.toString()); 
    }
    
}
