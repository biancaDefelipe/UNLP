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
public class Catalogo {
    private Artista[] categorias; 

   
        
    public Catalogo() {
        this.categorias= new Artista[15];
        for (int i=0; i<15; i++){
            this.categorias[i]= null; 
        }
    }
    public void agregarArtista(Artista artista, int cate){
        if (cate <=15){
            categorias[cate -1]= artista; 
        }
    }
    //Devolver la cantidad de artistas cuya nacionalidad coincide con una recibida.
    public int artistasDeNacionalidad(String nacionalidad){
        int cant=0; 
        for (int i=0; i < 15; i++){
            if (!(this.categorias[i] == null) && (this.categorias[i].getNacionalidad().equals(nacionalidad))){
                    cant++; 
                }
            }
        
        return cant;
    }
}
