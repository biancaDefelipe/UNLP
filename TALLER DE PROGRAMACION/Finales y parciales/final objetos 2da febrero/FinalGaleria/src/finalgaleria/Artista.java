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
public class Artista {
    private String nombreArtistico; 
    private String nacionalidad; 

    public Artista(String nombreArtistico, String nacionalidad) {
        this.nombreArtistico = nombreArtistico.toLowerCase();
        this.nacionalidad = nacionalidad.toLowerCase();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    
}
