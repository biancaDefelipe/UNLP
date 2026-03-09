/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgaleria;

/**
 *
 * @author bianc
 */
public class FinalGaleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //- Implemente un programa que instancie un catálogo y agreguele dos artistas. A partir del catálogo: obtenga y
        //muestre la cantidad de artistas de nacionalidad “argentino”.
        Catalogo c= new Catalogo(); 
        c.agregarArtista(new Artista ("el flaco", "argentina"), 1);
        c.agregarArtista(new Artista ("taylooor taylorr", "yanki"), 3);
        c.agregarArtista(new Artista("la joaqui", "argentina"), 2);
        
        System.out.print("Artistas argentinos: "+ c.artistasDeNacionalidad("argentina"));
    }
    
}
